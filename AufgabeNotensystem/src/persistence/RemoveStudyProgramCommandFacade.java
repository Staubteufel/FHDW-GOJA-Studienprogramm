package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class RemoveStudyProgramCommandFacade{

	private String schemaName;
	private Connection con;

	public RemoveStudyProgramCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentRemoveStudyProgramCommand newRemoveStudyProgramCommand(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvStdPrgrmCMDFacade.newRmvStdPrgrmCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemoveStudyProgramCommand result = new RemoveStudyProgramCommand(null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentRemoveStudyProgramCommand)PersistentProxi.createProxi(id, 241);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentRemoveStudyProgramCommand newDelayedRemoveStudyProgramCommand() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvStdPrgrmCMDFacade.newDelayedRmvStdPrgrmCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemoveStudyProgramCommand result = new RemoveStudyProgramCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentRemoveStudyProgramCommand)PersistentProxi.createProxi(id, 241);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RemoveStudyProgramCommand getRemoveStudyProgramCommand(long RemoveStudyProgramCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvStdPrgrmCMDFacade.getRmvStdPrgrmCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, RemoveStudyProgramCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentStudyProgram studyProgram = null;
            if (obj.getLong(2) != 0)
                studyProgram = (PersistentStudyProgram)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(4) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentAdminServer commandReceiver = null;
            if (obj.getLong(6) != 0)
                commandReceiver = (PersistentAdminServer)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(8) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            RemoveStudyProgramCommand result = new RemoveStudyProgramCommand(studyProgram,
                                                                             invoker,
                                                                             commandReceiver,
                                                                             myCommonDate,
                                                                             RemoveStudyProgramCommandId);
            obj.close();
            callable.close();
            RemoveStudyProgramCommandICProxi inCache = (RemoveStudyProgramCommandICProxi)Cache.getTheCache().put(result);
            RemoveStudyProgramCommand objectInCache = (RemoveStudyProgramCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmvStdPrgrmCMDFacade.getClass(?); end;");
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
    public void studyProgramSet(long RemoveStudyProgramCommandId, StudyProgram4Public studyProgramVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvStdPrgrmCMDFacade.stdPrgrmSet(?, ?, ?); end;");
            callable.setLong(1, RemoveStudyProgramCommandId);
            callable.setLong(2, studyProgramVal.getId());
            callable.setLong(3, studyProgramVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long RemoveStudyProgramCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvStdPrgrmCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, RemoveStudyProgramCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long RemoveStudyProgramCommandId, AdminServer4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvStdPrgrmCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, RemoveStudyProgramCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long RemoveStudyProgramCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmvStdPrgrmCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, RemoveStudyProgramCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

