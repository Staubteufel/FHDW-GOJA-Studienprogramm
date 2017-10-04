package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class AddSToSGCommandFacade{

	private String schemaName;
	private Connection con;

	public AddSToSGCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAddSToSGCommand newAddSToSGCommand(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddSTSGCMDFacade.newAddSTSGCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddSToSGCommand result = new AddSToSGCommand(null,null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentAddSToSGCommand)PersistentProxi.createProxi(id, 179);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentAddSToSGCommand newDelayedAddSToSGCommand() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddSTSGCMDFacade.newDelayedAddSTSGCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddSToSGCommand result = new AddSToSGCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentAddSToSGCommand)PersistentProxi.createProxi(id, 179);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddSToSGCommand getAddSToSGCommand(long AddSToSGCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddSTSGCMDFacade.getAddSTSGCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AddSToSGCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentStudyGroup studyGroup = null;
            if (obj.getLong(2) != 0)
                studyGroup = (PersistentStudyGroup)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentStudentServer student = null;
            if (obj.getLong(4) != 0)
                student = (PersistentStudentServer)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(6) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentAdminServer commandReceiver = null;
            if (obj.getLong(8) != 0)
                commandReceiver = (PersistentAdminServer)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            AddSToSGCommand result = new AddSToSGCommand(studyGroup,
                                                         student,
                                                         invoker,
                                                         commandReceiver,
                                                         myCommonDate,
                                                         AddSToSGCommandId);
            obj.close();
            callable.close();
            AddSToSGCommandICProxi inCache = (AddSToSGCommandICProxi)Cache.getTheCache().put(result);
            AddSToSGCommand objectInCache = (AddSToSGCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddSTSGCMDFacade.getClass(?); end;");
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
    public void studyGroupSet(long AddSToSGCommandId, StudyGroup4Public studyGroupVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddSTSGCMDFacade.stdGrpSet(?, ?, ?); end;");
            callable.setLong(1, AddSToSGCommandId);
            callable.setLong(2, studyGroupVal.getId());
            callable.setLong(3, studyGroupVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void studentSet(long AddSToSGCommandId, StudentServer4Public studentVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddSTSGCMDFacade.stdntSet(?, ?, ?); end;");
            callable.setLong(1, AddSToSGCommandId);
            callable.setLong(2, studentVal.getId());
            callable.setLong(3, studentVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long AddSToSGCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddSTSGCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, AddSToSGCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long AddSToSGCommandId, AdminServer4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddSTSGCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, AddSToSGCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long AddSToSGCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddSTSGCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, AddSToSGCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

