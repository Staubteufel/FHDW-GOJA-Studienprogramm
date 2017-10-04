package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ModuleWithUnitsLstFacade{

	private String schemaName;
	private Connection con;

	public ModuleWithUnitsLstFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentModuleWithUnitsLst getTheModuleWithUnitsLst() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MWULstFacade.getTheMWULst; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentModuleWithUnitsLst)PersistentProxi.createProxi(id, 206);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ModuleWithUnitsLst getModuleWithUnitsLst(long ModuleWithUnitsLstId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MWULstFacade.getMWULst(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ModuleWithUnitsLstId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentModuleWithUnitsLst This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentModuleWithUnitsLst)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            ModuleWithUnitsLst result = new ModuleWithUnitsLst(This,
                                                               ModuleWithUnitsLstId);
            obj.close();
            callable.close();
            ModuleWithUnitsLstICProxi inCache = (ModuleWithUnitsLstICProxi)Cache.getTheCache().put(result);
            ModuleWithUnitsLst objectInCache = (ModuleWithUnitsLst)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MWULstFacade.getClass(?); end;");
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
    public long moduleWithUnitsAdd(long ModuleWithUnitsLstId, ModuleWithUnits4Public moduleWithUnitsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MWULstFacade.mdlWthUntsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, ModuleWithUnitsLstId);
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
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MWULstFacade.mdlWthUntsRem(?); end;");
            callable.setLong(1, moduleWithUnitsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ModuleWithUnitsList moduleWithUnitsGet(long ModuleWithUnitsLstId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MWULstFacade.mdlWthUntsGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ModuleWithUnitsLstId);
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
    public void ThisSet(long ModuleWithUnitsLstId, ModuleWithUnitsLst4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MWULstFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, ModuleWithUnitsLstId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

