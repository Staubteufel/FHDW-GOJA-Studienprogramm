package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class CreateStudentCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateStudentCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentCreateStudentCommand newCreateStudentCommand(String matricalNumber,String password,String forename,String surname,java.sql.Date dateOfBirth,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtStdntCMDFacade.newCrtStdntCMD(?,?,?,?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, matricalNumber);
            callable.setString(3, password);
            callable.setString(4, forename);
            callable.setString(5, surname);
            callable.setDate(6, dateOfBirth);
            callable.setLong(7, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateStudentCommand result = new CreateStudentCommand(matricalNumber,password,forename,surname,dateOfBirth,null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentCreateStudentCommand)PersistentProxi.createProxi(id, 166);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentCreateStudentCommand newDelayedCreateStudentCommand(String matricalNumber,String password,String forename,String surname,java.sql.Date dateOfBirth) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtStdntCMDFacade.newDelayedCrtStdntCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateStudentCommand result = new CreateStudentCommand(matricalNumber,password,forename,surname,dateOfBirth,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentCreateStudentCommand)PersistentProxi.createProxi(id, 166);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateStudentCommand getCreateStudentCommand(long CreateStudentCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtStdntCMDFacade.getCrtStdntCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, CreateStudentCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentStudyGroup studyGroup = null;
            if (obj.getLong(7) != 0)
                studyGroup = (PersistentStudyGroup)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            Invoker invoker = null;
            if (obj.getLong(9) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentAdminServer commandReceiver = null;
            if (obj.getLong(11) != 0)
                commandReceiver = (PersistentAdminServer)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(13) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(13), obj.getLong(14));
            CreateStudentCommand result = new CreateStudentCommand(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                                   obj.getString(3) == null ? "" : obj.getString(3) /* In Oracle "" = null !!! */,
                                                                   obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                                   obj.getString(5) == null ? "" : obj.getString(5) /* In Oracle "" = null !!! */,
                                                                   obj.getDate(6),
                                                                   studyGroup,
                                                                   invoker,
                                                                   commandReceiver,
                                                                   myCommonDate,
                                                                   CreateStudentCommandId);
            obj.close();
            callable.close();
            CreateStudentCommandICProxi inCache = (CreateStudentCommandICProxi)Cache.getTheCache().put(result);
            CreateStudentCommand objectInCache = (CreateStudentCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtStdntCMDFacade.getClass(?); end;");
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
    public void matricalNumberSet(long CreateStudentCommandId, String matricalNumberVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtStdntCMDFacade.mtrclNmbrSet(?, ?); end;");
            callable.setLong(1, CreateStudentCommandId);
            callable.setString(2, matricalNumberVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void passwordSet(long CreateStudentCommandId, String passwordVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtStdntCMDFacade.psswrdSet(?, ?); end;");
            callable.setLong(1, CreateStudentCommandId);
            callable.setString(2, passwordVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void forenameSet(long CreateStudentCommandId, String forenameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtStdntCMDFacade.frnmSet(?, ?); end;");
            callable.setLong(1, CreateStudentCommandId);
            callable.setString(2, forenameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void surnameSet(long CreateStudentCommandId, String surnameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtStdntCMDFacade.srnmSet(?, ?); end;");
            callable.setLong(1, CreateStudentCommandId);
            callable.setString(2, surnameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void dateOfBirthSet(long CreateStudentCommandId, java.sql.Date dateOfBirthVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtStdntCMDFacade.dtOfBrthSet(?, ?); end;");
            callable.setLong(1, CreateStudentCommandId);
            callable.setDate(2, dateOfBirthVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void studyGroupSet(long CreateStudentCommandId, StudyGroup4Public studyGroupVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtStdntCMDFacade.stdGrpSet(?, ?, ?); end;");
            callable.setLong(1, CreateStudentCommandId);
            callable.setLong(2, studyGroupVal.getId());
            callable.setLong(3, studyGroupVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateStudentCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtStdntCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateStudentCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateStudentCommandId, AdminServer4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtStdntCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateStudentCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateStudentCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtStdntCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateStudentCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

