package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ModuleWithoutUnitsLstFacade{

	private String schemaName;
	private Connection con;

	public ModuleWithoutUnitsLstFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentModuleWithoutUnitsLst getTheModuleWithoutUnitsLst() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MWUOLstFacade.getTheMWUOLst; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentModuleWithoutUnitsLst)PersistentProxi.createProxi(id, 209);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ModuleWithoutUnitsLst getModuleWithoutUnitsLst(long ModuleWithoutUnitsLstId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MWUOLstFacade.getMWUOLst(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ModuleWithoutUnitsLstId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentModuleWithoutUnitsLst This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentModuleWithoutUnitsLst)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            ModuleWithoutUnitsLst result = new ModuleWithoutUnitsLst(This,
                                                                     ModuleWithoutUnitsLstId);
            obj.close();
            callable.close();
            ModuleWithoutUnitsLstICProxi inCache = (ModuleWithoutUnitsLstICProxi)Cache.getTheCache().put(result);
            ModuleWithoutUnitsLst objectInCache = (ModuleWithoutUnitsLst)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MWUOLstFacade.getClass(?); end;");
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
    public long moduleWithoutUnitsAdd(long ModuleWithoutUnitsLstId, ModuleWithoutUnits4Public moduleWithoutUnitsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MWUOLstFacade.mdlWthtUntsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, ModuleWithoutUnitsLstId);
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
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MWUOLstFacade.mdlWthtUntsRem(?); end;");
            callable.setLong(1, moduleWithoutUnitsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ModuleWithoutUnitsList moduleWithoutUnitsGet(long ModuleWithoutUnitsLstId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MWUOLstFacade.mdlWthtUntsGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ModuleWithoutUnitsLstId);
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
    public void ThisSet(long ModuleWithoutUnitsLstId, ModuleWithoutUnitsLst4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MWUOLstFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, ModuleWithoutUnitsLstId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

