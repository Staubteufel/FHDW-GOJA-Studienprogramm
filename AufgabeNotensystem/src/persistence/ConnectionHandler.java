package persistence;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.CallableStatement;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

public class ConnectionHandler {

	private static final String AutoCommitName = "AUTO COMMIT (DEFAULT)";
	
	private static Hashtable<Thread,CommitConnectionHandler> connections = new Hashtable<Thread,CommitConnectionHandler>();
	
	private static ConnectionHandler theConnectionHandler;

	public static String openFile(File file) throws IOException {
		int size = (int) file.length();
		int chars_read = 0;
		FileReader in = new FileReader(file);
		char[] data = new char[size];
		while (in.ready()) {
			chars_read += in.read(data, chars_read, size - chars_read);
		}
		in.close();
		String raw = new String(data, 0, chars_read);
		return raw;
	}

	public static Vector<ConnectionHandler> getConnections(){
		Vector<ConnectionHandler> result = new Vector<ConnectionHandler>();
		Iterator<CommitConnectionHandler> committers = connections.values().iterator();
		while (committers.hasNext())result.add(committers.next());
		result.add(theConnectionHandler);
		return result;
	}
	public static void reinitialise() {
		connections = new Hashtable<Thread,CommitConnectionHandler>();
		theConnectionHandler = null;
	}
	
	public static void disconnect() throws PersistenceException{
		Iterator<CommitConnectionHandler> connectionIterator = connections.values().iterator();
		try {
			while (connectionIterator.hasNext()){
				ConnectionHandler current = (ConnectionHandler)connectionIterator.next();
				if(!current.con.isClosed())current.con.close();
			}
			if (theConnectionHandler != null && theConnectionHandler.con != null && !theConnectionHandler.con.isClosed()){
				theConnectionHandler.con.close();
			}
		}catch (SQLException sqlExc) {
			throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
		}
	}

	public static CommitConnectionHandler getNewConnection(Thread thread) throws PersistenceException {
		CommitConnectionHandler result = new CommitConnectionHandler(thread.getName());
		connections.put(thread, result);
		return result;
	}

	public static void releaseConnection() throws PersistenceException {
		try {
			CommitConnectionHandler connection = connections.get(Thread.currentThread());
			if (connection != null && !connection.con.isClosed()){
				connection.con.close();
				connections.remove(Thread.currentThread());
			}
		}catch (SQLException sqlExc) {
			throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
		}
	}
	public static boolean isCommitConnectionHandler() {
		CommitConnectionHandler handler = connections.get(Thread.currentThread());
		return handler != null && handler.isInTransaction();
	}

	public static ConnectionHandler getTheConnectionHandler() throws PersistenceException {
		ConnectionHandler result;
		CommitConnectionHandler commitHandler = connections.get(Thread.currentThread());
		if (commitHandler == null){
			if (theConnectionHandler == null) theConnectionHandler = new ConnectionHandler(AutoCommitName);
			result = theConnectionHandler;
		}else{
			result = commitHandler;
		}
		return result;
	}
	
	public static String asString (char[] pw) {
		String result = "";
		for (int i = 0; i < pw.length; i++) {
			result = result + pw[i];
		}
		return result;
	}

	public static final String DatabaseProtocol = "jdbc:oracle:thin:@";

	private String schemaName;
	protected Connection con;
	private String name;

    public PassedFacade thePassedFacade;
    public MarkNotCalculableFacade theMarkNotCalculableFacade;
    public AddMGToMGCommandFacade theAddMGToMGCommandFacade;
    public ServerFacade theServerFacade;
    public CreateUnitCommandFacade theCreateUnitCommandFacade;
    public MarkFactoryFacade theMarkFactoryFacade;
    public ThirdMarkLstFacade theThirdMarkLstFacade;
    public ErrorDisplayFacade theErrorDisplayFacade;
    public StudyGroupLstFacade theStudyGroupLstFacade;
    public ModuleGroupLstFacade theModuleGroupLstFacade;
    public ModuleGroupFacade theModuleGroupFacade;
    public UnitFacade theUnitFacade;
    public FiveZeroFacade theFiveZeroFacade;
    public ApprFacade theApprFacade;
    public FetchMCommandFacade theFetchMCommandFacade;
    public RemUFromMWUCommandFacade theRemUFromMWUCommandFacade;
    public CommandCoordinatorFacade theCommandCoordinatorFacade;
    public RemMGFromMGCommandFacade theRemMGFromMGCommandFacade;
    public StudentServerFacade theStudentServerFacade;
    public StudyGroupFacade theStudyGroupFacade;
    public TenthMarkFacade theTenthMarkFacade;
    public TwoZeroFacade theTwoZeroFacade;
    public RmvMWUCommandFacade theRmvMWUCommandFacade;
    public CreateMWWUCommandFacade theCreateMWWUCommandFacade;
    public NoneMarkFacade theNoneMarkFacade;
    public RemoveUnitCommandFacade theRemoveUnitCommandFacade;
    public StudyProgramFacade theStudyProgramFacade;
    public FailedFacade theFailedFacade;
    public CreateStudentCommandFacade theCreateStudentCommandFacade;
    public FetchStudentMCommandFacade theFetchStudentMCommandFacade;
    public UnitLstFacade theUnitLstFacade;
    public ThreeSevenFacade theThreeSevenFacade;
    public ModuleWithUnitsLstFacade theModuleWithUnitsLstFacade;
    public RemMGFromSPCommandFacade theRemMGFromSPCommandFacade;
    public MarkHistoryEntryFacade theMarkHistoryEntryFacade;
    public StudentServerLstFacade theStudentServerLstFacade;
    public CommonDateFacade theCommonDateFacade;
    public ThirdMarkFacade theThirdMarkFacade;
    public CreateMWUCommandFacade theCreateMWUCommandFacade;
    public PrototypeFacade thePrototypeFacade;
    public RemoveStudyProgramCommandFacade theRemoveStudyProgramCommandFacade;
    public AdminServerFacade theAdminServerFacade;
    public ModuleWithoutUnitsFacade theModuleWithoutUnitsFacade;
    public ThreeZeroFacade theThreeZeroFacade;
    public MarkCalculableFacade theMarkCalculableFacade;
    public TwoSevenFacade theTwoSevenFacade;
    public RemoveModuleGroupCommandFacade theRemoveModuleGroupCommandFacade;
    public RemMWWUFromMGCommandFacade theRemMWWUFromMGCommandFacade;
    public AddMWUToMGCommandFacade theAddMWUToMGCommandFacade;
    public ModuleWithUnitsFacade theModuleWithUnitsFacade;
    public RemoveStudyGroupCommandFacade theRemoveStudyGroupCommandFacade;
    public OneSevenFacade theOneSevenFacade;
    public SorcMTSWiMWuUCommandFacade theSorcMTSWiMWuUCommandFacade;
    public AddMGToSPCommandFacade theAddMGToSPCommandFacade;
    public AddMWWUToMGCommandFacade theAddMWWUToMGCommandFacade;
    public ServiceFacade theServiceFacade;
    public SetActiveSGCommandFacade theSetActiveSGCommandFacade;
    public SorcMTSWiUCommandFacade theSorcMTSWiUCommandFacade;
    public ChangeCPCommandFacade theChangeCPCommandFacade;
    public ThreeThreeFacade theThreeThreeFacade;
    public OneThreeFacade theOneThreeFacade;
    public CreateStudyProgramCommandFacade theCreateStudyProgramCommandFacade;
    public AddSToSGCommandFacade theAddSToSGCommandFacade;
    public CreateStudyGroupCommandFacade theCreateStudyGroupCommandFacade;
    public TwoThreeFacade theTwoThreeFacade;
    public BooleanMarkFacade theBooleanMarkFacade;
    public FourZeroFacade theFourZeroFacade;
    public OneZeroFacade theOneZeroFacade;
    public RmvMWOUCommandFacade theRmvMWOUCommandFacade;
    public StudyProgramLstFacade theStudyProgramLstFacade;
    public RemMWUFromMGCommandFacade theRemMWUFromMGCommandFacade;
    public CreateModuleGroupCommandFacade theCreateModuleGroupCommandFacade;
    public ModuleWithoutUnitsLstFacade theModuleWithoutUnitsLstFacade;
    public AddUToMWUCommandFacade theAddUToMWUCommandFacade;
    public CommandExecuterFacade theCommandExecuterFacade;
    public BooleanMarkLstFacade theBooleanMarkLstFacade;

	protected ConnectionHandler(String name) throws PersistenceException {
		this.name = name;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException sqlExc) {
			throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
		}
	}
	public String getName(){
		return this.name;
	}
	
	public void connect(String databaseName, String currentSchemaName, String user, char[] pw, boolean autoCommit) throws PersistenceException {
		try {
			this.schemaName = currentSchemaName;
			oracle.jdbc.driver.OracleConnection oracleConnection = (oracle.jdbc.driver.OracleConnection) DriverManager.getConnection(DatabaseProtocol + databaseName, user, asString(pw));
//			oracleConnection.setStatementCacheSize(1000);
//			oracleConnection.setImplicitCachingEnabled(true);
			this.con = new Connection(oracleConnection);
			this.con.setAutoCommit(autoCommit);
			CallableStatement callable = this.con.prepareCall("Begin " + this.schemaName + ".ClassFacade.initialize; end;");
			callable.execute();
			callable.close();
            this.thePassedFacade= new PassedFacade(this.schemaName, this.con);
            this.theMarkNotCalculableFacade= new MarkNotCalculableFacade(this.schemaName, this.con);
            this.theAddMGToMGCommandFacade= new AddMGToMGCommandFacade(this.schemaName, this.con);
            this.theServerFacade= new ServerFacade(this.schemaName, this.con);
            this.theCreateUnitCommandFacade= new CreateUnitCommandFacade(this.schemaName, this.con);
            this.theMarkFactoryFacade= new MarkFactoryFacade(this.schemaName, this.con);
            this.theThirdMarkLstFacade= new ThirdMarkLstFacade(this.schemaName, this.con);
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theStudyGroupLstFacade= new StudyGroupLstFacade(this.schemaName, this.con);
            this.theModuleGroupLstFacade= new ModuleGroupLstFacade(this.schemaName, this.con);
            this.theModuleGroupFacade= new ModuleGroupFacade(this.schemaName, this.con);
            this.theUnitFacade= new UnitFacade(this.schemaName, this.con);
            this.theFiveZeroFacade= new FiveZeroFacade(this.schemaName, this.con);
            this.theApprFacade= new ApprFacade(this.schemaName, this.con);
            this.theFetchMCommandFacade= new FetchMCommandFacade(this.schemaName, this.con);
            this.theRemUFromMWUCommandFacade= new RemUFromMWUCommandFacade(this.schemaName, this.con);
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade(this.schemaName, this.con);
            this.theRemMGFromMGCommandFacade= new RemMGFromMGCommandFacade(this.schemaName, this.con);
            this.theStudentServerFacade= new StudentServerFacade(this.schemaName, this.con);
            this.theStudyGroupFacade= new StudyGroupFacade(this.schemaName, this.con);
            this.theTenthMarkFacade= new TenthMarkFacade(this.schemaName, this.con);
            this.theTwoZeroFacade= new TwoZeroFacade(this.schemaName, this.con);
            this.theRmvMWUCommandFacade= new RmvMWUCommandFacade(this.schemaName, this.con);
            this.theCreateMWWUCommandFacade= new CreateMWWUCommandFacade(this.schemaName, this.con);
            this.theNoneMarkFacade= new NoneMarkFacade(this.schemaName, this.con);
            this.theRemoveUnitCommandFacade= new RemoveUnitCommandFacade(this.schemaName, this.con);
            this.theStudyProgramFacade= new StudyProgramFacade(this.schemaName, this.con);
            this.theFailedFacade= new FailedFacade(this.schemaName, this.con);
            this.theCreateStudentCommandFacade= new CreateStudentCommandFacade(this.schemaName, this.con);
            this.theFetchStudentMCommandFacade= new FetchStudentMCommandFacade(this.schemaName, this.con);
            this.theUnitLstFacade= new UnitLstFacade(this.schemaName, this.con);
            this.theThreeSevenFacade= new ThreeSevenFacade(this.schemaName, this.con);
            this.theModuleWithUnitsLstFacade= new ModuleWithUnitsLstFacade(this.schemaName, this.con);
            this.theRemMGFromSPCommandFacade= new RemMGFromSPCommandFacade(this.schemaName, this.con);
            this.theMarkHistoryEntryFacade= new MarkHistoryEntryFacade(this.schemaName, this.con);
            this.theStudentServerLstFacade= new StudentServerLstFacade(this.schemaName, this.con);
            this.theCommonDateFacade= new CommonDateFacade(this.schemaName, this.con);
            this.theThirdMarkFacade= new ThirdMarkFacade(this.schemaName, this.con);
            this.theCreateMWUCommandFacade= new CreateMWUCommandFacade(this.schemaName, this.con);
            this.thePrototypeFacade= new PrototypeFacade(this.schemaName, this.con);
            this.theRemoveStudyProgramCommandFacade= new RemoveStudyProgramCommandFacade(this.schemaName, this.con);
            this.theAdminServerFacade= new AdminServerFacade(this.schemaName, this.con);
            this.theModuleWithoutUnitsFacade= new ModuleWithoutUnitsFacade(this.schemaName, this.con);
            this.theThreeZeroFacade= new ThreeZeroFacade(this.schemaName, this.con);
            this.theMarkCalculableFacade= new MarkCalculableFacade(this.schemaName, this.con);
            this.theTwoSevenFacade= new TwoSevenFacade(this.schemaName, this.con);
            this.theRemoveModuleGroupCommandFacade= new RemoveModuleGroupCommandFacade(this.schemaName, this.con);
            this.theRemMWWUFromMGCommandFacade= new RemMWWUFromMGCommandFacade(this.schemaName, this.con);
            this.theAddMWUToMGCommandFacade= new AddMWUToMGCommandFacade(this.schemaName, this.con);
            this.theModuleWithUnitsFacade= new ModuleWithUnitsFacade(this.schemaName, this.con);
            this.theRemoveStudyGroupCommandFacade= new RemoveStudyGroupCommandFacade(this.schemaName, this.con);
            this.theOneSevenFacade= new OneSevenFacade(this.schemaName, this.con);
            this.theSorcMTSWiMWuUCommandFacade= new SorcMTSWiMWuUCommandFacade(this.schemaName, this.con);
            this.theAddMGToSPCommandFacade= new AddMGToSPCommandFacade(this.schemaName, this.con);
            this.theAddMWWUToMGCommandFacade= new AddMWWUToMGCommandFacade(this.schemaName, this.con);
            this.theServiceFacade= new ServiceFacade(this.schemaName, this.con);
            this.theSetActiveSGCommandFacade= new SetActiveSGCommandFacade(this.schemaName, this.con);
            this.theSorcMTSWiUCommandFacade= new SorcMTSWiUCommandFacade(this.schemaName, this.con);
            this.theChangeCPCommandFacade= new ChangeCPCommandFacade(this.schemaName, this.con);
            this.theThreeThreeFacade= new ThreeThreeFacade(this.schemaName, this.con);
            this.theOneThreeFacade= new OneThreeFacade(this.schemaName, this.con);
            this.theCreateStudyProgramCommandFacade= new CreateStudyProgramCommandFacade(this.schemaName, this.con);
            this.theAddSToSGCommandFacade= new AddSToSGCommandFacade(this.schemaName, this.con);
            this.theCreateStudyGroupCommandFacade= new CreateStudyGroupCommandFacade(this.schemaName, this.con);
            this.theTwoThreeFacade= new TwoThreeFacade(this.schemaName, this.con);
            this.theBooleanMarkFacade= new BooleanMarkFacade(this.schemaName, this.con);
            this.theFourZeroFacade= new FourZeroFacade(this.schemaName, this.con);
            this.theOneZeroFacade= new OneZeroFacade(this.schemaName, this.con);
            this.theRmvMWOUCommandFacade= new RmvMWOUCommandFacade(this.schemaName, this.con);
            this.theStudyProgramLstFacade= new StudyProgramLstFacade(this.schemaName, this.con);
            this.theRemMWUFromMGCommandFacade= new RemMWUFromMGCommandFacade(this.schemaName, this.con);
            this.theCreateModuleGroupCommandFacade= new CreateModuleGroupCommandFacade(this.schemaName, this.con);
            this.theModuleWithoutUnitsLstFacade= new ModuleWithoutUnitsLstFacade(this.schemaName, this.con);
            this.theAddUToMWUCommandFacade= new AddUToMWUCommandFacade(this.schemaName, this.con);
            this.theCommandExecuterFacade= new CommandExecuterFacade(this.schemaName, this.con);
            this.theBooleanMarkLstFacade= new BooleanMarkLstFacade(this.schemaName, this.con);
		} catch (SQLException sqlExc) {
			throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
		}
	}
	public static void initializeMapsForMappedFields() throws PersistenceException {
		
	}
	
	public void dltObjct(PersistentRoot object) throws PersistenceException{
		Connection con = this.getConnection();
		CallableStatement callable;
		try {
			callable = con.prepareCall("Begin " + this.schemaName + ".ClassFacade.deleteObject(?,?); end;");
            callable.setLong(1, object.getId());
            callable.setLong(2, object.getClassId());
			callable.execute();
			callable.close();
		} catch (SQLException se) {
	           throw new PersistenceException(se.getMessage(), se.getErrorCode());
	    }
	}

	
	public Connection getConnection(){
		return this.con;
	}
	
}
