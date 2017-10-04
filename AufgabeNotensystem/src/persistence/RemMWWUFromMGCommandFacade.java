package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class RemMWWUFromMGCommandFacade{

	private String schemaName;
	private Connection con;

	public RemMWWUFromMGCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentRemMWWUFromMGCommand newRemMWWUFromMGCommand(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmMWWUFrmMGCMDFacade.newRmMWWUFrmMGCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemMWWUFromMGCommand result = new RemMWWUFromMGCommand(null,null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentRemMWWUFromMGCommand)PersistentProxi.createProxi(id, 170);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentRemMWWUFromMGCommand newDelayedRemMWWUFromMGCommand() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmMWWUFrmMGCMDFacade.newDelayedRmMWWUFrmMGCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemMWWUFromMGCommand result = new RemMWWUFromMGCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentRemMWWUFromMGCommand)PersistentProxi.createProxi(id, 170);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RemMWWUFromMGCommand getRemMWWUFromMGCommand(long RemMWWUFromMGCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmMWWUFrmMGCMDFacade.getRmMWWUFrmMGCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, RemMWWUFromMGCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentModuleGroup moduleGroup = null;
            if (obj.getLong(2) != 0)
                moduleGroup = (PersistentModuleGroup)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentModuleWithoutUnits moduleWithoutUnits = null;
            if (obj.getLong(4) != 0)
                moduleWithoutUnits = (PersistentModuleWithoutUnits)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(6) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentAdminServer commandReceiver = null;
            if (obj.getLong(8) != 0)
                commandReceiver = (PersistentAdminServer)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            RemMWWUFromMGCommand result = new RemMWWUFromMGCommand(moduleGroup,
                                                                   moduleWithoutUnits,
                                                                   invoker,
                                                                   commandReceiver,
                                                                   myCommonDate,
                                                                   RemMWWUFromMGCommandId);
            obj.close();
            callable.close();
            RemMWWUFromMGCommandICProxi inCache = (RemMWWUFromMGCommandICProxi)Cache.getTheCache().put(result);
            RemMWWUFromMGCommand objectInCache = (RemMWWUFromMGCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmMWWUFrmMGCMDFacade.getClass(?); end;");
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
    public void moduleGroupSet(long RemMWWUFromMGCommandId, ModuleGroup4Public moduleGroupVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmMWWUFrmMGCMDFacade.mdlGrpSet(?, ?, ?); end;");
            callable.setLong(1, RemMWWUFromMGCommandId);
            callable.setLong(2, moduleGroupVal.getId());
            callable.setLong(3, moduleGroupVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void moduleWithoutUnitsSet(long RemMWWUFromMGCommandId, ModuleWithoutUnits4Public moduleWithoutUnitsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmMWWUFrmMGCMDFacade.mdlWthtUntsSet(?, ?, ?); end;");
            callable.setLong(1, RemMWWUFromMGCommandId);
            callable.setLong(2, moduleWithoutUnitsVal.getId());
            callable.setLong(3, moduleWithoutUnitsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long RemMWWUFromMGCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmMWWUFrmMGCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, RemMWWUFromMGCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long RemMWWUFromMGCommandId, AdminServer4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmMWWUFrmMGCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, RemMWWUFromMGCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long RemMWWUFromMGCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmMWWUFrmMGCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, RemMWWUFromMGCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

