package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class SetActiveSGCommandFacade{

	private String schemaName;
	private Connection con;

	public SetActiveSGCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentSetActiveSGCommand newSetActiveSGCommand(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StActvSGCMDFacade.newStActvSGCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            SetActiveSGCommand result = new SetActiveSGCommand(null,null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentSetActiveSGCommand)PersistentProxi.createProxi(id, 176);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentSetActiveSGCommand newDelayedSetActiveSGCommand() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StActvSGCMDFacade.newDelayedStActvSGCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            SetActiveSGCommand result = new SetActiveSGCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentSetActiveSGCommand)PersistentProxi.createProxi(id, 176);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public SetActiveSGCommand getSetActiveSGCommand(long SetActiveSGCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StActvSGCMDFacade.getStActvSGCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, SetActiveSGCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentStudentServer student = null;
            if (obj.getLong(2) != 0)
                student = (PersistentStudentServer)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentStudyGroup studyGroup = null;
            if (obj.getLong(4) != 0)
                studyGroup = (PersistentStudyGroup)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(6) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentAdminServer commandReceiver = null;
            if (obj.getLong(8) != 0)
                commandReceiver = (PersistentAdminServer)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            SetActiveSGCommand result = new SetActiveSGCommand(student,
                                                               studyGroup,
                                                               invoker,
                                                               commandReceiver,
                                                               myCommonDate,
                                                               SetActiveSGCommandId);
            obj.close();
            callable.close();
            SetActiveSGCommandICProxi inCache = (SetActiveSGCommandICProxi)Cache.getTheCache().put(result);
            SetActiveSGCommand objectInCache = (SetActiveSGCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StActvSGCMDFacade.getClass(?); end;");
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
    public void studentSet(long SetActiveSGCommandId, StudentServer4Public studentVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StActvSGCMDFacade.stdntSet(?, ?, ?); end;");
            callable.setLong(1, SetActiveSGCommandId);
            callable.setLong(2, studentVal.getId());
            callable.setLong(3, studentVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void studyGroupSet(long SetActiveSGCommandId, StudyGroup4Public studyGroupVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StActvSGCMDFacade.stdGrpSet(?, ?, ?); end;");
            callable.setLong(1, SetActiveSGCommandId);
            callable.setLong(2, studyGroupVal.getId());
            callable.setLong(3, studyGroupVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long SetActiveSGCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StActvSGCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, SetActiveSGCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long SetActiveSGCommandId, AdminServer4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StActvSGCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, SetActiveSGCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long SetActiveSGCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StActvSGCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, SetActiveSGCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

