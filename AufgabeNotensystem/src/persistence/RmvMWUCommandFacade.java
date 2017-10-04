package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class RmvMWUCommandFacade{

	private String schemaName;
	private Connection con;

	public RmvMWUCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentRmvMWUCommand newRmvMWUCommand(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvMWUCMDFacade.newRmvMWUCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RmvMWUCommand result = new RmvMWUCommand(null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentRmvMWUCommand)PersistentProxi.createProxi(id, 238);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentRmvMWUCommand newDelayedRmvMWUCommand() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvMWUCMDFacade.newDelayedRmvMWUCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RmvMWUCommand result = new RmvMWUCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentRmvMWUCommand)PersistentProxi.createProxi(id, 238);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RmvMWUCommand getRmvMWUCommand(long RmvMWUCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvMWUCMDFacade.getRmvMWUCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, RmvMWUCommandId);
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
            Invoker invoker = null;
            if (obj.getLong(4) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentAdminServer commandReceiver = null;
            if (obj.getLong(6) != 0)
                commandReceiver = (PersistentAdminServer)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(8) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            RmvMWUCommand result = new RmvMWUCommand(moduleWithUnits,
                                                     invoker,
                                                     commandReceiver,
                                                     myCommonDate,
                                                     RmvMWUCommandId);
            obj.close();
            callable.close();
            RmvMWUCommandICProxi inCache = (RmvMWUCommandICProxi)Cache.getTheCache().put(result);
            RmvMWUCommand objectInCache = (RmvMWUCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvMWUCMDFacade.getClass(?); end;");
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
    public void moduleWithUnitsSet(long RmvMWUCommandId, ModuleWithUnits4Public moduleWithUnitsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvMWUCMDFacade.mdlWthUntsSet(?, ?, ?); end;");
            callable.setLong(1, RmvMWUCommandId);
            callable.setLong(2, moduleWithUnitsVal.getId());
            callable.setLong(3, moduleWithUnitsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long RmvMWUCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvMWUCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, RmvMWUCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long RmvMWUCommandId, AdminServer4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvMWUCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, RmvMWUCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long RmvMWUCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvMWUCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, RmvMWUCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

