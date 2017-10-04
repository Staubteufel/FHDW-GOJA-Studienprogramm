package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class StudentServerFacade{

	private String schemaName;
	private Connection con;

	public StudentServerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentStudentServer newStudentServer(String matriculationNumber,String forename,String surname,java.sql.Date dateOfBirth,String activeStudyGroupName,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StdntSrvrFacade.newStdntSrvr(?,?,?,?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, matriculationNumber);
            callable.setString(3, forename);
            callable.setString(4, surname);
            callable.setDate(5, dateOfBirth);
            callable.setString(6, activeStudyGroupName);
            callable.setLong(7, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            StudentServer result = new StudentServer(null,matriculationNumber,forename,surname,dateOfBirth,activeStudyGroupName,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentStudentServer)PersistentProxi.createProxi(id, -200);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentStudentServer newDelayedStudentServer(String matriculationNumber,String forename,String surname,java.sql.Date dateOfBirth,String activeStudyGroupName) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StdntSrvrFacade.newDelayedStdntSrvr(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            StudentServer result = new StudentServer(null,matriculationNumber,forename,surname,dateOfBirth,activeStudyGroupName,null,id);
            Cache.getTheCache().put(result);
            return (PersistentStudentServer)PersistentProxi.createProxi(id, -200);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public StudentServer getStudentServer(long StudentServerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdntSrvrFacade.getStdntSrvr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudentServerId);
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
            PersistentStudyGroup activeStudyGroup = null;
            if (obj.getLong(9) != 0)
                activeStudyGroup = (PersistentStudyGroup)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            StudentServer result = new StudentServer(This,
                                                     obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                     obj.getString(5) == null ? "" : obj.getString(5) /* In Oracle "" = null !!! */,
                                                     obj.getString(6) == null ? "" : obj.getString(6) /* In Oracle "" = null !!! */,
                                                     obj.getDate(7),
                                                     obj.getString(8) == null ? "" : obj.getString(8) /* In Oracle "" = null !!! */,
                                                     activeStudyGroup,
                                                     StudentServerId);
            obj.close();
            callable.close();
            StudentServerICProxi inCache = (StudentServerICProxi)Cache.getTheCache().put(result);
            StudentServer objectInCache = (StudentServer)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void matriculationNumberSet(long StudentServerId, String matriculationNumberVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdntSrvrFacade.mtrcltnNmbrSet(?, ?); end;");
            callable.setLong(1, StudentServerId);
            callable.setString(2, matriculationNumberVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void forenameSet(long StudentServerId, String forenameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdntSrvrFacade.frnmSet(?, ?); end;");
            callable.setLong(1, StudentServerId);
            callable.setString(2, forenameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void surnameSet(long StudentServerId, String surnameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdntSrvrFacade.srnmSet(?, ?); end;");
            callable.setLong(1, StudentServerId);
            callable.setString(2, surnameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void dateOfBirthSet(long StudentServerId, java.sql.Date dateOfBirthVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdntSrvrFacade.dtOfBrthSet(?, ?); end;");
            callable.setLong(1, StudentServerId);
            callable.setDate(2, dateOfBirthVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void activeStudyGroupNameSet(long StudentServerId, String activeStudyGroupNameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdntSrvrFacade.actStdyGrpNSet(?, ?); end;");
            callable.setLong(1, StudentServerId);
            callable.setString(2, activeStudyGroupNameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long studyGroupsAttendedAdd(long StudentServerId, StudyGroup4Public studyGroupsAttendedVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdntSrvrFacade.stdyGrpsAttAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, StudentServerId);
            callable.setLong(3, studyGroupsAttendedVal.getId());
            callable.setLong(4, studyGroupsAttendedVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void studyGroupsAttendedRem(long studyGroupsAttendedId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdntSrvrFacade.stdyGrpsAttRem(?); end;");
            callable.setLong(1, studyGroupsAttendedId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public StudyGroupList studyGroupsAttendedGet(long StudentServerId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdntSrvrFacade.stdyGrpsAttGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudentServerId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            StudyGroupList result = new StudyGroupList();
            while (list.next()) {
                result.add((PersistentStudyGroup)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void activeStudyGroupSet(long StudentServerId, StudyGroup4Public activeStudyGroupVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdntSrvrFacade.actvStdGrpSet(?, ?, ?); end;");
            callable.setLong(1, StudentServerId);
            callable.setLong(2, activeStudyGroupVal.getId());
            callable.setLong(3, activeStudyGroupVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

