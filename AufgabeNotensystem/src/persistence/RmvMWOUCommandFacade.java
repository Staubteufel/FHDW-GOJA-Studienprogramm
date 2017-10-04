package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class RmvMWOUCommandFacade{

	private String schemaName;
	private Connection con;

	public RmvMWOUCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentRmvMWOUCommand newRmvMWOUCommand(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvMWOUCMDFacade.newRmvMWOUCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RmvMWOUCommand result = new RmvMWOUCommand(null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentRmvMWOUCommand)PersistentProxi.createProxi(id, 240);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentRmvMWOUCommand newDelayedRmvMWOUCommand() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvMWOUCMDFacade.newDelayedRmvMWOUCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RmvMWOUCommand result = new RmvMWOUCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentRmvMWOUCommand)PersistentProxi.createProxi(id, 240);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RmvMWOUCommand getRmvMWOUCommand(long RmvMWOUCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvMWOUCMDFacade.getRmvMWOUCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, RmvMWOUCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentModuleWithoutUnits moduleWithoutUnits = null;
            if (obj.getLong(2) != 0)
                moduleWithoutUnits = (PersistentModuleWithoutUnits)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(4) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentAdminServer commandReceiver = null;
            if (obj.getLong(6) != 0)
                commandReceiver = (PersistentAdminServer)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(8) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            RmvMWOUCommand result = new RmvMWOUCommand(moduleWithoutUnits,
                                                       invoker,
                                                       commandReceiver,
                                                       myCommonDate,
                                                       RmvMWOUCommandId);
            obj.close();
            callable.close();
            RmvMWOUCommandICProxi inCache = (RmvMWOUCommandICProxi)Cache.getTheCache().put(result);
            RmvMWOUCommand objectInCache = (RmvMWOUCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvMWOUCMDFacade.getClass(?); end;");
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
    public void moduleWithoutUnitsSet(long RmvMWOUCommandId, ModuleWithoutUnits4Public moduleWithoutUnitsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvMWOUCMDFacade.mdlWthtUntsSet(?, ?, ?); end;");
            callable.setLong(1, RmvMWOUCommandId);
            callable.setLong(2, moduleWithoutUnitsVal.getId());
            callable.setLong(3, moduleWithoutUnitsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long RmvMWOUCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvMWOUCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, RmvMWOUCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long RmvMWOUCommandId, AdminServer4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvMWOUCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, RmvMWOUCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long RmvMWOUCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvMWOUCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, RmvMWOUCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

