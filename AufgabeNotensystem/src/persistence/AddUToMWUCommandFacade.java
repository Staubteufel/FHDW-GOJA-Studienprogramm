package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class AddUToMWUCommandFacade{

	private String schemaName;
	private Connection con;

	public AddUToMWUCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAddUToMWUCommand newAddUToMWUCommand(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddUTMWUCMDFacade.newAddUTMWUCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddUToMWUCommand result = new AddUToMWUCommand(null,null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentAddUToMWUCommand)PersistentProxi.createProxi(id, 183);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentAddUToMWUCommand newDelayedAddUToMWUCommand() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddUTMWUCMDFacade.newDelayedAddUTMWUCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddUToMWUCommand result = new AddUToMWUCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentAddUToMWUCommand)PersistentProxi.createProxi(id, 183);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddUToMWUCommand getAddUToMWUCommand(long AddUToMWUCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddUTMWUCMDFacade.getAddUTMWUCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AddUToMWUCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentModuleWithUnits moduleWithUnits = null;
            if (obj.getLong(2) != 0)
                moduleWithUnits = (PersistentModuleWithUnits)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentUnit unit = null;
            if (obj.getLong(4) != 0)
                unit = (PersistentUnit)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(6) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentAdminServer commandReceiver = null;
            if (obj.getLong(8) != 0)
                commandReceiver = (PersistentAdminServer)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            AddUToMWUCommand result = new AddUToMWUCommand(moduleWithUnits,
                                                           unit,
                                                           invoker,
                                                           commandReceiver,
                                                           myCommonDate,
                                                           AddUToMWUCommandId);
            obj.close();
            callable.close();
            AddUToMWUCommandICProxi inCache = (AddUToMWUCommandICProxi)Cache.getTheCache().put(result);
            AddUToMWUCommand objectInCache = (AddUToMWUCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddUTMWUCMDFacade.getClass(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, objectId);
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void moduleWithUnitsSet(long AddUToMWUCommandId, ModuleWithUnits4Public moduleWithUnitsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddUTMWUCMDFacade.mdlWthUntsSet(?, ?, ?); end;");
            callable.setLong(1, AddUToMWUCommandId);
            callable.setLong(2, moduleWithUnitsVal.getId());
            callable.setLong(3, moduleWithUnitsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void unitSet(long AddUToMWUCommandId, Unit4Public unitVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddUTMWUCMDFacade.untSet(?, ?, ?); end;");
            callable.setLong(1, AddUToMWUCommandId);
            callable.setLong(2, unitVal.getId());
            callable.setLong(3, unitVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long AddUToMWUCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddUTMWUCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, AddUToMWUCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long AddUToMWUCommandId, AdminServer4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddUTMWUCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, AddUToMWUCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long AddUToMWUCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddUTMWUCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, AddUToMWUCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

