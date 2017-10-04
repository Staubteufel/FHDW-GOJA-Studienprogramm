package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class FetchStudentMCommandFacade{

	private String schemaName;
	private Connection con;

	public FetchStudentMCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentFetchStudentMCommand newFetchStudentMCommand(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".FtchStdntMCMDFacade.newFtchStdntMCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            FetchStudentMCommand result = new FetchStudentMCommand(null,null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentFetchStudentMCommand)PersistentProxi.createProxi(id, 211);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentFetchStudentMCommand newDelayedFetchStudentMCommand() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".FtchStdntMCMDFacade.newDelayedFtchStdntMCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            FetchStudentMCommand result = new FetchStudentMCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentFetchStudentMCommand)PersistentProxi.createProxi(id, 211);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public FetchStudentMCommand getFetchStudentMCommand(long FetchStudentMCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FtchStdntMCMDFacade.getFtchStdntMCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, FetchStudentMCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAppr appr = null;
            if (obj.getLong(2) != 0)
                appr = (PersistentAppr)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(4) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentStudentServer commandReceiver = null;
            if (obj.getLong(6) != 0)
                commandReceiver = (PersistentStudentServer)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            Mark commandResult = null;
            if (obj.getLong(8) != 0)
                commandResult = (Mark)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            FetchStudentMCommand result = new FetchStudentMCommand(appr,
                                                                   invoker,
                                                                   commandReceiver,
                                                                   commandResult,
                                                                   myCommonDate,
                                                                   FetchStudentMCommandId);
            obj.close();
            callable.close();
            FetchStudentMCommandICProxi inCache = (FetchStudentMCommandICProxi)Cache.getTheCache().put(result);
            FetchStudentMCommand objectInCache = (FetchStudentMCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FtchStdntMCMDFacade.getClass(?); end;");
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
    public void apprSet(long FetchStudentMCommandId, Appr4Public apprVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FtchStdntMCMDFacade.apprSet(?, ?, ?); end;");
            callable.setLong(1, FetchStudentMCommandId);
            callable.setLong(2, apprVal.getId());
            callable.setLong(3, apprVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long FetchStudentMCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FtchStdntMCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, FetchStudentMCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long FetchStudentMCommandId, StudentServer4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FtchStdntMCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, FetchStudentMCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandResultSet(long FetchStudentMCommandId, Mark commandResultVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FtchStdntMCMDFacade.cResultSet(?, ?, ?); end;");
            callable.setLong(1, FetchStudentMCommandId);
            callable.setLong(2, commandResultVal.getId());
            callable.setLong(3, commandResultVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long FetchStudentMCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FtchStdntMCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, FetchStudentMCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

