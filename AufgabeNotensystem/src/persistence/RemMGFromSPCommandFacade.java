package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class RemMGFromSPCommandFacade{

	private String schemaName;
	private Connection con;

	public RemMGFromSPCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentRemMGFromSPCommand newRemMGFromSPCommand(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmMGFrmSPCMDFacade.newRmMGFrmSPCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemMGFromSPCommand result = new RemMGFromSPCommand(null,null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentRemMGFromSPCommand)PersistentProxi.createProxi(id, 167);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentRemMGFromSPCommand newDelayedRemMGFromSPCommand() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".RmMGFrmSPCMDFacade.newDelayedRmMGFrmSPCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            RemMGFromSPCommand result = new RemMGFromSPCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentRemMGFromSPCommand)PersistentProxi.createProxi(id, 167);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RemMGFromSPCommand getRemMGFromSPCommand(long RemMGFromSPCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmMGFrmSPCMDFacade.getRmMGFrmSPCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, RemMGFromSPCommandId);
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
            PersistentModuleGroup moduleGroup = null;
            if (obj.getLong(4) != 0)
                moduleGroup = (PersistentModuleGroup)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(6) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentAdminServer commandReceiver = null;
            if (obj.getLong(8) != 0)
                commandReceiver = (PersistentAdminServer)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            RemMGFromSPCommand result = new RemMGFromSPCommand(studyProgram,
                                                               moduleGroup,
                                                               invoker,
                                                               commandReceiver,
                                                               myCommonDate,
                                                               RemMGFromSPCommandId);
            obj.close();
            callable.close();
            RemMGFromSPCommandICProxi inCache = (RemMGFromSPCommandICProxi)Cache.getTheCache().put(result);
            RemMGFromSPCommand objectInCache = (RemMGFromSPCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RmMGFrmSPCMDFacade.getClass(?); end;");
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
    public void studyProgramSet(long RemMGFromSPCommandId, StudyProgram4Public studyProgramVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmMGFrmSPCMDFacade.stdPrgrmSet(?, ?, ?); end;");
            callable.setLong(1, RemMGFromSPCommandId);
            callable.setLong(2, studyProgramVal.getId());
            callable.setLong(3, studyProgramVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void moduleGroupSet(long RemMGFromSPCommandId, ModuleGroup4Public moduleGroupVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmMGFrmSPCMDFacade.mdlGrpSet(?, ?, ?); end;");
            callable.setLong(1, RemMGFromSPCommandId);
            callable.setLong(2, moduleGroupVal.getId());
            callable.setLong(3, moduleGroupVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long RemMGFromSPCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmMGFrmSPCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, RemMGFromSPCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long RemMGFromSPCommandId, AdminServer4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmMGFrmSPCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, RemMGFromSPCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long RemMGFromSPCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".RmMGFrmSPCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, RemMGFromSPCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

