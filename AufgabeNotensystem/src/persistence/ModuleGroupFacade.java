package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ModuleGroupFacade{

	private String schemaName;
	private Connection con;

	public ModuleGroupFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentModuleGroup newModuleGroup(String name,common.Fraction creditPoints,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlGrpFacade.newMdlGrp(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setString(3, creditPoints.toString());
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ModuleGroup result = new ModuleGroup(null,null,name,creditPoints,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentModuleGroup)PersistentProxi.createProxi(id, 105);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentModuleGroup newDelayedModuleGroup(String name,common.Fraction creditPoints) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlGrpFacade.newDelayedMdlGrp(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ModuleGroup result = new ModuleGroup(null,null,name,creditPoints,id);
            Cache.getTheCache().put(result);
            return (PersistentModuleGroup)PersistentProxi.createProxi(id, 105);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ModuleGroup getModuleGroup(long ModuleGroupId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlGrpFacade.getMdlGrp(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ModuleGroupId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentPrototype prototypeObservee = null;
            if (obj.getLong(2) != 0)
                prototypeObservee = (PersistentPrototype)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentPrototype This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentPrototype)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            ModuleGroup result = new ModuleGroup(prototypeObservee,
                                                 This,
                                                 obj.getString(6) == null ? "" : obj.getString(6) /* In Oracle "" = null !!! */,
                                                 (obj.getString(7) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(7))),
                                                 ModuleGroupId);
            obj.close();
            callable.close();
            ModuleGroupICProxi inCache = (ModuleGroupICProxi)Cache.getTheCache().put(result);
            ModuleGroup objectInCache = (ModuleGroup)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long moduleGroupsAdd(long ModuleGroupId, ModuleGroup4Public moduleGroupsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlGrpFacade.mdlGrpsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, ModuleGroupId);
            callable.setLong(3, moduleGroupsVal.getId());
            callable.setLong(4, moduleGroupsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void moduleGroupsRem(long moduleGroupsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MdlGrpFacade.mdlGrpsRem(?); end;");
            callable.setLong(1, moduleGroupsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ModuleGroupList moduleGroupsGet(long ModuleGroupId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlGrpFacade.mdlGrpsGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ModuleGroupId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            ModuleGroupList result = new ModuleGroupList();
            while (list.next()) {
                result.add((PersistentModuleGroup)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long moduleWithUnitsAdd(long ModuleGroupId, ModuleWithUnits4Public moduleWithUnitsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlGrpFacade.mdlWthUntsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, ModuleGroupId);
            callable.setLong(3, moduleWithUnitsVal.getId());
            callable.setLong(4, moduleWithUnitsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void moduleWithUnitsRem(long moduleWithUnitsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MdlGrpFacade.mdlWthUntsRem(?); end;");
            callable.setLong(1, moduleWithUnitsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ModuleWithUnitsList moduleWithUnitsGet(long ModuleGroupId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlGrpFacade.mdlWthUntsGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ModuleGroupId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            ModuleWithUnitsList result = new ModuleWithUnitsList();
            while (list.next()) {
                result.add((PersistentModuleWithUnits)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long moduleWithoutUnitsAdd(long ModuleGroupId, ModuleWithoutUnits4Public moduleWithoutUnitsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlGrpFacade.mdlWthtUntsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, ModuleGroupId);
            callable.setLong(3, moduleWithoutUnitsVal.getId());
            callable.setLong(4, moduleWithoutUnitsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void moduleWithoutUnitsRem(long moduleWithoutUnitsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MdlGrpFacade.mdlWthtUntsRem(?); end;");
            callable.setLong(1, moduleWithoutUnitsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ModuleWithoutUnitsList moduleWithoutUnitsGet(long ModuleGroupId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlGrpFacade.mdlWthtUntsGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ModuleGroupId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            ModuleWithoutUnitsList result = new ModuleWithoutUnitsList();
            while (list.next()) {
                result.add((PersistentModuleWithoutUnits)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

