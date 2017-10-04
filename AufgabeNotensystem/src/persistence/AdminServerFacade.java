package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class AdminServerFacade{

	private String schemaName;
	private Connection con;

	public AdminServerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAdminServer newAdminServer(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnSrvrFacade.newAdmnSrvr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AdminServer result = new AdminServer(null,null,null,null,null,null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentAdminServer)PersistentProxi.createProxi(id, -201);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentAdminServer newDelayedAdminServer() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnSrvrFacade.newDelayedAdmnSrvr(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AdminServer result = new AdminServer(null,null,null,null,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentAdminServer)PersistentProxi.createProxi(id, -201);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AdminServer getAdminServer(long AdminServerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnSrvrFacade.getAdmnSrvr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AdminServerId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentService This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentService)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentUnitLst units = null;
            if (obj.getLong(4) != 0)
                units = (PersistentUnitLst)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentModuleWithUnitsLst moduleWithUnits = null;
            if (obj.getLong(6) != 0)
                moduleWithUnits = (PersistentModuleWithUnitsLst)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentModuleWithoutUnitsLst moduleWithoutUnits = null;
            if (obj.getLong(8) != 0)
                moduleWithoutUnits = (PersistentModuleWithoutUnitsLst)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentModuleGroupLst moduleGroups = null;
            if (obj.getLong(10) != 0)
                moduleGroups = (PersistentModuleGroupLst)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            PersistentStudyProgramLst studyPrograms = null;
            if (obj.getLong(12) != 0)
                studyPrograms = (PersistentStudyProgramLst)PersistentProxi.createProxi(obj.getLong(12), obj.getLong(13));
            PersistentStudyGroupLst studyGroups = null;
            if (obj.getLong(14) != 0)
                studyGroups = (PersistentStudyGroupLst)PersistentProxi.createProxi(obj.getLong(14), obj.getLong(15));
            PersistentStudentServerLst students = null;
            if (obj.getLong(16) != 0)
                students = (PersistentStudentServerLst)PersistentProxi.createProxi(obj.getLong(16), obj.getLong(17));
            PersistentThirdMarkLst thirdMarks = null;
            if (obj.getLong(18) != 0)
                thirdMarks = (PersistentThirdMarkLst)PersistentProxi.createProxi(obj.getLong(18), obj.getLong(19));
            AdminServer result = new AdminServer(This,
                                                 units,
                                                 moduleWithUnits,
                                                 moduleWithoutUnits,
                                                 moduleGroups,
                                                 studyPrograms,
                                                 studyGroups,
                                                 students,
                                                 thirdMarks,
                                                 AdminServerId);
            obj.close();
            callable.close();
            AdminServerICProxi inCache = (AdminServerICProxi)Cache.getTheCache().put(result);
            AdminServer objectInCache = (AdminServer)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void unitsSet(long AdminServerId, UnitLst4Public unitsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AdmnSrvrFacade.untsSet(?, ?, ?); end;");
            callable.setLong(1, AdminServerId);
            callable.setLong(2, unitsVal.getId());
            callable.setLong(3, unitsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void moduleWithUnitsSet(long AdminServerId, ModuleWithUnitsLst4Public moduleWithUnitsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AdmnSrvrFacade.mdlWthUntsSet(?, ?, ?); end;");
            callable.setLong(1, AdminServerId);
            callable.setLong(2, moduleWithUnitsVal.getId());
            callable.setLong(3, moduleWithUnitsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void moduleWithoutUnitsSet(long AdminServerId, ModuleWithoutUnitsLst4Public moduleWithoutUnitsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AdmnSrvrFacade.mdlWthtUntsSet(?, ?, ?); end;");
            callable.setLong(1, AdminServerId);
            callable.setLong(2, moduleWithoutUnitsVal.getId());
            callable.setLong(3, moduleWithoutUnitsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void moduleGroupsSet(long AdminServerId, ModuleGroupLst4Public moduleGroupsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AdmnSrvrFacade.mdlGrpsSet(?, ?, ?); end;");
            callable.setLong(1, AdminServerId);
            callable.setLong(2, moduleGroupsVal.getId());
            callable.setLong(3, moduleGroupsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void studyProgramsSet(long AdminServerId, StudyProgramLst4Public studyProgramsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AdmnSrvrFacade.stdPrgrmsSet(?, ?, ?); end;");
            callable.setLong(1, AdminServerId);
            callable.setLong(2, studyProgramsVal.getId());
            callable.setLong(3, studyProgramsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void studyGroupsSet(long AdminServerId, StudyGroupLst4Public studyGroupsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AdmnSrvrFacade.stdGrpsSet(?, ?, ?); end;");
            callable.setLong(1, AdminServerId);
            callable.setLong(2, studyGroupsVal.getId());
            callable.setLong(3, studyGroupsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void studentsSet(long AdminServerId, StudentServerLst4Public studentsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AdmnSrvrFacade.stdntsSet(?, ?, ?); end;");
            callable.setLong(1, AdminServerId);
            callable.setLong(2, studentsVal.getId());
            callable.setLong(3, studentsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long ModuleWithoutUnitsMarkTypesAdd(long AdminServerId, Mark ModuleWithoutUnitsMarkTypesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnSrvrFacade.MWUMTypsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, AdminServerId);
            callable.setLong(3, ModuleWithoutUnitsMarkTypesVal.getId());
            callable.setLong(4, ModuleWithoutUnitsMarkTypesVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ModuleWithoutUnitsMarkTypesRem(long ModuleWithoutUnitsMarkTypesId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AdmnSrvrFacade.MWUMTypsRem(?); end;");
            callable.setLong(1, ModuleWithoutUnitsMarkTypesId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MarkList ModuleWithoutUnitsMarkTypesGet(long AdminServerId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnSrvrFacade.MWUMTypsGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AdminServerId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            MarkList result = new MarkList();
            while (list.next()) {
                result.add((Mark)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void thirdMarksSet(long AdminServerId, ThirdMarkLst4Public thirdMarksVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AdmnSrvrFacade.thrdMrksSet(?, ?, ?); end;");
            callable.setLong(1, AdminServerId);
            callable.setLong(2, thirdMarksVal.getId());
            callable.setLong(3, thirdMarksVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long ModuleWithoutUnitsMarksAdd(long AdminServerId, Anything ModuleWithoutUnitsMarksVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnSrvrFacade.MWUMarksAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, AdminServerId);
            callable.setLong(3, ModuleWithoutUnitsMarksVal.getId());
            callable.setLong(4, ModuleWithoutUnitsMarksVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ModuleWithoutUnitsMarksRem(long ModuleWithoutUnitsMarksId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AdmnSrvrFacade.MWUMarksRem(?); end;");
            callable.setLong(1, ModuleWithoutUnitsMarksId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public AnythingList ModuleWithoutUnitsMarksGet(long AdminServerId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnSrvrFacade.MWUMarksGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AdminServerId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            AnythingList result = new AnythingList();
            while (list.next()) {
                result.add((Anything)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

