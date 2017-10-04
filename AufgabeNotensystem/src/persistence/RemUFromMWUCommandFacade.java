package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class RemUFromMWUCommandFacade{

	private String schemaName;
	private Connection con;

	public RemUFromMWUCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentRemUFromMWUCommand newRemUFromMWUCommand(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmUFrmMWUCMDFacade.newRmUFrmMWUCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemUFromMWUCommand result = new RemUFromMWUCommand(null,null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentRemUFromMWUCommand)PersistentProxi.createProxi(id, 162);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentRemUFromMWUCommand newDelayedRemUFromMWUCommand() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmUFrmMWUCMDFacade.newDelayedRmUFrmMWUCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemUFromMWUCommand result = new RemUFromMWUCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentRemUFromMWUCommand)PersistentProxi.createProxi(id, 162);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RemUFromMWUCommand getRemUFromMWUCommand(long RemUFromMWUCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmUFrmMWUCMDFacade.getRmUFrmMWUCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, RemUFromMWUCommandId);
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
            RemUFromMWUCommand result = new RemUFromMWUCommand(moduleWithUnits,
                                                               unit,
                                                               invoker,
                                                               commandReceiver,
                                                               myCommonDate,
                                                               RemUFromMWUCommandId);
            obj.close();
            callable.close();
            RemUFromMWUCommandICProxi inCache = (RemUFromMWUCommandICProxi)Cache.getTheCache().put(result);
            RemUFromMWUCommand objectInCache = (RemUFromMWUCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmUFrmMWUCMDFacade.getClass(?); end;");
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
    public void moduleWithUnitsSet(long RemUFromMWUCommandId, ModuleWithUnits4Public moduleWithUnitsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmUFrmMWUCMDFacade.mdlWthUntsSet(?, ?, ?); end;");
            callable.setLong(1, RemUFromMWUCommandId);
            callable.setLong(2, moduleWithUnitsVal.getId());
            callable.setLong(3, moduleWithUnitsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void unitSet(long RemUFromMWUCommandId, Unit4Public unitVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmUFrmMWUCMDFacade.untSet(?, ?, ?); end;");
            callable.setLong(1, RemUFromMWUCommandId);
            callable.setLong(2, unitVal.getId());
            callable.setLong(3, unitVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long RemUFromMWUCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmUFrmMWUCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, RemUFromMWUCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long RemUFromMWUCommandId, AdminServer4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmUFrmMWUCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, RemUFromMWUCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long RemUFromMWUCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmUFrmMWUCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, RemUFromMWUCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

