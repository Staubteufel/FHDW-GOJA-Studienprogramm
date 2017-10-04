package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class AddMWUToMGCommandFacade{

	private String schemaName;
	private Connection con;

	public AddMWUToMGCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAddMWUToMGCommand newAddMWUToMGCommand(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddMWUTMGCMDFacade.newAddMWUTMGCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddMWUToMGCommand result = new AddMWUToMGCommand(null,null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentAddMWUToMGCommand)PersistentProxi.createProxi(id, 171);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentAddMWUToMGCommand newDelayedAddMWUToMGCommand() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddMWUTMGCMDFacade.newDelayedAddMWUTMGCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddMWUToMGCommand result = new AddMWUToMGCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentAddMWUToMGCommand)PersistentProxi.createProxi(id, 171);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddMWUToMGCommand getAddMWUToMGCommand(long AddMWUToMGCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddMWUTMGCMDFacade.getAddMWUTMGCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AddMWUToMGCommandId);
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
            PersistentModuleWithUnits moduleWithUnits = null;
            if (obj.getLong(4) != 0)
                moduleWithUnits = (PersistentModuleWithUnits)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(6) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentAdminServer commandReceiver = null;
            if (obj.getLong(8) != 0)
                commandReceiver = (PersistentAdminServer)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            AddMWUToMGCommand result = new AddMWUToMGCommand(moduleGroup,
                                                             moduleWithUnits,
                                                             invoker,
                                                             commandReceiver,
                                                             myCommonDate,
                                                             AddMWUToMGCommandId);
            obj.close();
            callable.close();
            AddMWUToMGCommandICProxi inCache = (AddMWUToMGCommandICProxi)Cache.getTheCache().put(result);
            AddMWUToMGCommand objectInCache = (AddMWUToMGCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddMWUTMGCMDFacade.getClass(?); end;");
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
    public void moduleGroupSet(long AddMWUToMGCommandId, ModuleGroup4Public moduleGroupVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddMWUTMGCMDFacade.mdlGrpSet(?, ?, ?); end;");
            callable.setLong(1, AddMWUToMGCommandId);
            callable.setLong(2, moduleGroupVal.getId());
            callable.setLong(3, moduleGroupVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void moduleWithUnitsSet(long AddMWUToMGCommandId, ModuleWithUnits4Public moduleWithUnitsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddMWUTMGCMDFacade.mdlWthUntsSet(?, ?, ?); end;");
            callable.setLong(1, AddMWUToMGCommandId);
            callable.setLong(2, moduleWithUnitsVal.getId());
            callable.setLong(3, moduleWithUnitsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long AddMWUToMGCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddMWUTMGCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, AddMWUToMGCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long AddMWUToMGCommandId, AdminServer4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddMWUTMGCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, AddMWUToMGCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long AddMWUToMGCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddMWUTMGCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, AddMWUToMGCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

