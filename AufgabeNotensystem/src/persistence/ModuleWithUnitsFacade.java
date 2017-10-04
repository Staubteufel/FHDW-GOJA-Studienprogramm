package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ModuleWithUnitsFacade{

	private String schemaName;
	private Connection con;

	public ModuleWithUnitsFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentModuleWithUnits newModuleWithUnits(String name,common.Fraction creditPoints,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlWthUntsFacade.newMdlWthUnts(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setString(3, creditPoints.toString());
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ModuleWithUnits result = new ModuleWithUnits(null,null,name,creditPoints,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentModuleWithUnits)PersistentProxi.createProxi(id, 114);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentModuleWithUnits newDelayedModuleWithUnits(String name,common.Fraction creditPoints) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlWthUntsFacade.newDelayedMdlWthUnts(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ModuleWithUnits result = new ModuleWithUnits(null,null,name,creditPoints,id);
            Cache.getTheCache().put(result);
            return (PersistentModuleWithUnits)PersistentProxi.createProxi(id, 114);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ModuleWithUnits getModuleWithUnits(long ModuleWithUnitsId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlWthUntsFacade.getMdlWthUnts(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ModuleWithUnitsId);
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
            ModuleWithUnits result = new ModuleWithUnits(prototypeObservee,
                                                         This,
                                                         obj.getString(6) == null ? "" : obj.getString(6) /* In Oracle "" = null !!! */,
                                                         (obj.getString(7) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(7))),
                                                         ModuleWithUnitsId);
            obj.close();
            callable.close();
            ModuleWithUnitsICProxi inCache = (ModuleWithUnitsICProxi)Cache.getTheCache().put(result);
            ModuleWithUnits objectInCache = (ModuleWithUnits)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long consistsOfAdd(long ModuleWithUnitsId, Unit4Public consistsOfVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlWthUntsFacade.cnsstsOfAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, ModuleWithUnitsId);
            callable.setLong(3, consistsOfVal.getId());
            callable.setLong(4, consistsOfVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void consistsOfRem(long consistsOfId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MdlWthUntsFacade.cnsstsOfRem(?); end;");
            callable.setLong(1, consistsOfId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public UnitList consistsOfGet(long ModuleWithUnitsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlWthUntsFacade.cnsstsOfGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ModuleWithUnitsId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            UnitList result = new UnitList();
            while (list.next()) {
                result.add((PersistentUnit)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

