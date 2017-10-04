package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class StudyProgramFacade{

	private String schemaName;
	private Connection con;

	public StudyProgramFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentStudyProgram newStudyProgram(String name,common.Fraction creditPoints,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StdPrgrmFacade.newStdPrgrm(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setString(3, creditPoints.toString());
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            StudyProgram result = new StudyProgram(null,null,name,creditPoints,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentStudyProgram)PersistentProxi.createProxi(id, 116);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentStudyProgram newDelayedStudyProgram(String name,common.Fraction creditPoints) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StdPrgrmFacade.newDelayedStdPrgrm(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            StudyProgram result = new StudyProgram(null,null,name,creditPoints,id);
            Cache.getTheCache().put(result);
            return (PersistentStudyProgram)PersistentProxi.createProxi(id, 116);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public StudyProgram getStudyProgram(long StudyProgramId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdPrgrmFacade.getStdPrgrm(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudyProgramId);
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
            StudyProgram result = new StudyProgram(prototypeObservee,
                                                   This,
                                                   obj.getString(6) == null ? "" : obj.getString(6) /* In Oracle "" = null !!! */,
                                                   (obj.getString(7) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(7))),
                                                   StudyProgramId);
            obj.close();
            callable.close();
            StudyProgramICProxi inCache = (StudyProgramICProxi)Cache.getTheCache().put(result);
            StudyProgram objectInCache = (StudyProgram)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long moduleGroupsAdd(long StudyProgramId, ModuleGroup4Public moduleGroupsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdPrgrmFacade.mdlGrpsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, StudyProgramId);
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
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdPrgrmFacade.mdlGrpsRem(?); end;");
            callable.setLong(1, moduleGroupsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ModuleGroupList moduleGroupsGet(long StudyProgramId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdPrgrmFacade.mdlGrpsGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudyProgramId);
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

}

