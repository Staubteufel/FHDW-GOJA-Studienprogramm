package modelServer;

import java.util.Date;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Iterator;

import javax.crypto.SecretKey;

import persistence.PersistentProxi;
import persistence.PersistenceException;
import persistence.AbstractPersistentRoot;
import persistence.Remote;

import persistence.PersistentServer;
import persistence.Server4Public;
import persistence.PersistentStudentServer;
import persistence.StudentServer4Public;
import persistence.PersistentAdminServer;
import persistence.AdminServer4Public;


import common.RPCConstantsAndServices;


import model.*;

public class ConnectionServer extends RemoteServerMaster {

	private static final long AllowedDelayInMilliSeconds = 100000;

	private static final int Port = RPCConstantsAndServices.ServerPort;
	protected static final int RefreshInterval = RPCConstantsAndServices.ServerRefreshInterval;
	protected static final int NotUsedInterval = RPCConstantsAndServices.NotUsedInterval;
	private static final String ConnectionHandlerName = RPCConstantsAndServices.ConnectionHandlerName;

	public static final String AdministratorName = common.RPCConstantsAndServices.AdministratorName;
	
	private static final long MaximalNumberOfWrongPasswordInputs = 5;
	private static final long HackerDelayInMilliSeconds = 3600000;
	
	private static final String Public = common.RPCConstantsAndServices.Public;

	private static ConnectionServer theConnectionServer;

	public static void startTheConnectionServer(ServerReporter reporter){
		if (theConnectionServer == null) theConnectionServer = new ConnectionServer(reporter);
	}
	public static void stopTheConnectionServer() {
		if(theConnectionServer != null)theConnectionServer.shutDown();
	}
	public static void switchOffTheConnectionServer(String until) {
		if(theConnectionServer != null)theConnectionServer.switchOff(until);
	}

	

	public RemoteServerMaster createRemoteServer(String connectionName, String userName, long objectId, long classId){
		try {
			if(classId == -141)return new RemoteServer(connectionName, userName, (PersistentServer)PersistentProxi.createProxi(objectId, classId));
			if(classId == -200)return new RemoteStudentServer(connectionName, userName, (PersistentStudentServer)PersistentProxi.createProxi(objectId, classId));
			if(classId == -201)return new RemoteAdminServer(connectionName, userName, (PersistentAdminServer)PersistentProxi.createProxi(objectId, classId));
			
		}catch(PersistenceException pe){
			return null;
		}
    	return null;
    }
	private int nextConnectionNumber = 0;

	private org.apache.xmlrpc.WebServer server;
	private Hashtable<String,RemoteServerMaster> connections;
	private final int maximalNumberOfConnections = 500;
	private ServerReporter reporter;

	public ConnectionServer(ServerReporter reporter){
		super(ConnectionHandlerName, ConnectionHandlerName);
		if (reporter == null) this.reporter = new NoReporter();
		else this.reporter = reporter;
		this.server = new org.apache.xmlrpc.WebServer(Port);
		this.server.addHandler(ConnectionHandlerName, new ConnectionDistributor(this));
		
		this.server.start();
		this.connections = new Hashtable<String,RemoteServerMaster>();
		this.connections.put(ConnectionHandlerName, this);
		new Thread(new ConnectionGarbageCollector(this)).start();
	}
	private void shutDown(){
		Iterator<String> connectionIterator = this.connections.keySet().iterator();
		while (connectionIterator.hasNext()){
			String connectionName = (String) connectionIterator.next();
			if(!connectionName.equals(ConnectionHandlerName)){
				RemoteServerMaster connection = this.connections.get(connectionName);
				connectionIterator.remove();
				this.reporter.reportCancelledConnection(connection);
				try {
					connection.getServer().disconnected();
				}catch (PersistenceException pe){
					throw new Error(pe.getMessage());
				}
			}
		}
		if (this.server != null) this.server.shutdown();
		ConnectionServer.theConnectionServer = null;
	}
	private void switchOff(String until){
		Iterator<String> connectionIterator = this.connections.keySet().iterator();
		while (connectionIterator.hasNext()){
			String connectionName = (String) connectionIterator.next();
			RemoteServerMaster connection = this.connections.get(connectionName);
			connection.setDown(until);
		}
	}

	public Object execute(String connection, byte[] command){
		try {
			RemoteServerMaster server = this.connections.get(connection);
			if(server != null)return server.execute(command);
			return "Connection " + connection + " not found!";
		} catch (PersistenceException e) {
			return e.getMessage();
		}
	}
	public synchronized HashMap<String,Object> fork(String user, String oldConnection, String objectId, String classId){
		return createExceptionResult(new PersistenceException("Bitte neue Version der Software von der �blichen Stelle laden!",0));
	}
	public synchronized HashMap<String,Object> fork(String user, String oldConnection, String objectId, String classId, java.util.Date date){
		if (this.connections.size() >= this.maximalNumberOfConnections) 
			return createExceptionResult(new PersistenceException("!Maximal number of connections exceeded!",0));
		if (this.userNotConnected(user)) 
			return createExceptionResult(new PersistenceException("User " + user + " not connected!",0));
		String connectionName = new Integer(this.nextConnectionNumber).toString();
		RemoteServerMaster server = createRemoteServer(connectionName, user, new Long(objectId).longValue(), new Long(classId).longValue());
		if (server == null)
			return createExceptionResult(new PersistenceException("!Server of class " + classId + " cannot be created!",0));
		server.lastUsedDate = date;
		try {
			this.registerServer(server, connectionName, null, oldConnection);
		}catch(PersistenceException pe){
			return createExceptionResult(pe);
		}
		try {
			return createOKResult(connectionName + RPCConstantsAndServices.ConnectSeparator 
					  + RPCConstantsAndServices.createProxiRepresentation(server.getServer().getClassId(), 
							  													 server.getServer().getId(), 
							  													 ((AbstractPersistentRoot)server.getServer()).getIconInfo(), 
							  													 ((AbstractPersistentRoot)server.getServer()).getLeafInfo(), 
							  													 server.getServer().toString()));
		} catch (PersistenceException e) {
			return createExceptionResult(e);
		}
	}
	private boolean userNotConnected(String user){
		Iterator<RemoteServerMaster> cons = this.connections.values().iterator();
		while (cons.hasNext()){
			RemoteServerMaster current = (RemoteServerMaster)cons.next();
			if (current.getUserName().equals(user)) return false;
		}
		return true;
	}
	
	public synchronized HashMap<String,Object> connect(String user, String password, boolean createUserIfNotPresent, byte[] keyBytes){
		return createExceptionResult(new PersistenceException("Bitte neue Version der Software von der �blichen Stelle laden!",0));
	}
	
	public synchronized HashMap<String,Object> connect(String user, String password, boolean createUserIfNotPresent, byte[] keyBytes, java.util.Date date, int version){
		final java.util.Date earliest = new java.util.Date(java.lang.System.currentTimeMillis() - AllowedDelayInMilliSeconds);
		final java.util.Date latest = new java.util.Date(java.lang.System.currentTimeMillis() + AllowedDelayInMilliSeconds);
		if (date.before(earliest) || date.after(latest))
			return createExceptionResult(new PersistenceException("Bitte Systemzeit einstellen: Ihre Zeit: " + date.toString() + ". Unsere Zeit: " + new java.util.Date().toString(),0));
		if (this.connections.size() >= this.maximalNumberOfConnections)
			return createExceptionResult(new PersistenceException("!Maximale Anzahl der Verbindungen �berschritten! Sp�ter nochmals versuchen!",0));
		if (version < RPCConstantsAndServices.CurrentVersion)
			return createExceptionResult(new PersistenceException(RPCConstantsAndServices.VersionErrorText,0));
		Iterator<Server4Public> serverIterator;
		try {
			PersistentServer server;
			if (user.equals(Public) && password.equals("")) {
				do {
					int publicNo = new java.util.Random().nextInt();
					user = Public + publicNo;
				} while (Server.getServerByUser(user).iterator().hasNext());
				server = (PersistentServer) Server.createServer(password, user, 0, new java.sql.Timestamp(0), false);
				user = Public; 
			} else {
				serverIterator = Server.getServerByUser(user).iterator();
				if (!serverIterator.hasNext()){
					if (user.equals(AdministratorName) || createUserIfNotPresent){
						if (password.length() <= 1)
							return createExceptionResult(new PersistenceException("Password is too short!",0));											
						server = (PersistentServer) Server.createServer(password, user, 0, new java.sql.Timestamp(0), false);
					}else{
						return createExceptionResult(new PersistenceException("Unknown user!",0));
					}
				}else{
					server = (PersistentServer) serverIterator.next();
					if (server.getHackDelay().after(new java.sql.Timestamp(System.currentTimeMillis()))){
						return createExceptionResult(new PersistenceException("Account locked !",0));
					}
					String hashedPassword = password;
					
					if (!server.getPassword().equals(hashedPassword)){
						server.setHackCount(server.getHackCount() + 1);
						if (server.getHackCount() >= MaximalNumberOfWrongPasswordInputs){
							server.setHackCount(0);
							server.setHackDelay(new java.sql.Timestamp(System.currentTimeMillis() + HackerDelayInMilliSeconds));
							return createExceptionResult(new PersistenceException("!Wrong password! Account has been locked for 60 minutes!",0));
						}else {
							return createExceptionResult(new PersistenceException("!Wrong password!",0));
						}
					}else{
						server.setHackCount(0);					
					}
				}
			}
			RemoteServer connection = null;
			String connectionName = new Integer(this.nextConnectionNumber).toString();
			connection = new RemoteServer(connectionName, user, server);
			SecretKey key = null;
			
			this.registerServer(connection, connectionName, key, null);
			return  createOKResult(connectionName + RPCConstantsAndServices.ConnectSeparator 
								  + RPCConstantsAndServices.createProxiRepresentation(server.getClassId(), server.getId(), server.getIconInfo(), server.getLeafInfo(), server.toString()));
		} catch (PersistenceException e) {
			return createExceptionResult(e);
		}
	}

	private void registerServer(RemoteServerMaster server, String connectionName, SecretKey key, String forkedFrom) throws PersistenceException {
		server.getServer().connected(forkedFrom == null ? server.getUserName() : connections.get(forkedFrom).getUserName());
		this.releaseFormerConnection(server);
		
		this.connections.put(connectionName, server);
		this.reporter.reportNewConnection(server);
		this.nextConnectionNumber = this.nextConnectionNumber + 1;
	}
	private void releaseFormerConnection(RemoteServerMaster server) throws PersistenceException {
		Remote remote = server.getServer();
		Iterator<String> connectionIterator = this.connections.keySet().iterator();
		while (connectionIterator.hasNext()){
			String connectionName = (String) connectionIterator.next();
			if(!connectionName.equals(ConnectionHandlerName)){
				RemoteServerMaster connection = this.connections.get(connectionName);
				if (remote.getId() == connection.getServerId() && remote.getClassId() == connection.getServerClassId()){
					if (!connection.lastUsedDate.before(server.lastUsedDate)) {
						long difference = (connection.lastUsedDate.getTime() - server.lastUsedDate.getTime())/1000;
						throw new PersistenceException("Do not hack!" + (difference > 0 ? "(Your local clock seems to be at least " + difference + " seconds late!)":""),0);
					}
					connectionIterator.remove();
					this.reporter.reportCancelledConnection(connection);
					connection.getServer().disconnected();
				}
			}
		}
	}
	protected synchronized void tryCollectGarbage() {
		Date now = new Date();
		Iterator<String> connectionIterator = this.connections.keySet().iterator();
		while (connectionIterator.hasNext()){
			String connectionName = (String) connectionIterator.next();
			if(!connectionName.equals(ConnectionHandlerName)){
				RemoteServerMaster connection = this.connections.get(connectionName);
				if (connection.isNotUsed(now)){
					connectionIterator.remove();
					this.reporter.reportCancelledConnection(connection);
					try {
						connection.getServer().disconnected();
					}catch (PersistenceException pe){
						throw new Error(pe.getMessage());
					}
				}
			}
		}
	}
	protected synchronized void stop() {
		Iterator<String> connectionIterator = this.connections.keySet().iterator();
		while (connectionIterator.hasNext()){
			String connectionName = (String) connectionIterator.next();
			if(!connectionName.equals(ConnectionHandlerName)){
				RemoteServerMaster connection = this.connections.get(connectionName);
				connectionIterator.remove();
				this.reporter.reportCancelledConnection(connection);
				try {
					connection.getServer().disconnected();
				}catch (PersistenceException pe){
					throw new Error(pe.getMessage());
				}
			}
		}
	}
	@Override
	protected Remote getServer() {
		return null;
	}

}

class ConnectionGarbageCollector implements Runnable {

	ConnectionServer server;

	protected ConnectionGarbageCollector(ConnectionServer server){
		this.server = server;
	}


	public void run(){
		while (true) {
			synchronized(this){
				try {
					this.wait(ConnectionServer.RefreshInterval / 4);
				}catch (InterruptedException e){
					return;
				}
			}
			server.tryCollectGarbage();
		}

	}
}
class NoReporter implements ServerReporter{
	public void reportCancelledConnection(RemoteServerMaster server) {}
	public void reportNewConnection(RemoteServerMaster server) {}
	public void reportCurrentCacheSize(int size, long recycledICProxies) {}
}