package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ModuleWithoutUnitsFacade{

	private String schemaName;
	private Connection con;

	public ModuleWithoutUnitsFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentModuleWithoutUnits newModuleWithoutUnits(String name,common.Fraction creditPoints,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlWthtUntsFacade.newMdlWthtUnts(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setString(3, creditPoints.toString());
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ModuleWithoutUnits result = new ModuleWithoutUnits(null,null,name,creditPoints,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentModuleWithoutUnits)PersistentProxi.createProxi(id, 108);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentModuleWithoutUnits newDelayedModuleWithoutUnits(String name,common.Fraction creditPoints) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlWthtUntsFacade.newDelayedMdlWthtUnts(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ModuleWithoutUnits result = new ModuleWithoutUnits(null,null,name,creditPoints,null,id);
            Cache.getTheCache().put(result);
            return (PersistentModuleWithoutUnits)PersistentProxi.createProxi(id, 108);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ModuleWithoutUnits getModuleWithoutUnits(long ModuleWithoutUnitsId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MdlWthtUntsFacade.getMdlWthtUnts(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ModuleWithoutUnitsId);
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
            Mark markType = null;
            if (obj.getLong(8) != 0)
                markType = (Mark)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            ModuleWithoutUnits result = new ModuleWithoutUnits(prototypeObservee,
                                                               This,
                                                               obj.getString(6) == null ? "" : obj.getString(6) /* In Oracle "" = null !!! */,
                                                               (obj.getString(7) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(7))),
                                                               markType,
                                                               ModuleWithoutUnitsId);
            obj.close();
            callable.close();
            ModuleWithoutUnitsICProxi inCache = (ModuleWithoutUnitsICProxi)Cache.getTheCache().put(result);
            ModuleWithoutUnits objectInCache = (ModuleWithoutUnits)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void markTypeSet(long ModuleWithoutUnitsId, Mark markTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MdlWthtUntsFacade.mrkTpSet(?, ?, ?); end;");
            callable.setLong(1, ModuleWithoutUnitsId);
            callable.setLong(2, markTypeVal.getId());
            callable.setLong(3, markTypeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

