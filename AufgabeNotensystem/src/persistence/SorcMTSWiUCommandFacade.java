package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class SorcMTSWiUCommandFacade{

	private String schemaName;
	private Connection con;

	public SorcMTSWiUCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentSorcMTSWiUCommand newSorcMTSWiUCommand(String comment,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".SrcMTSWUCMDFacade.newSrcMTSWUCMD(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, comment);
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            SorcMTSWiUCommand result = new SorcMTSWiUCommand(null,null,comment,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentSorcMTSWiUCommand)PersistentProxi.createProxi(id, 177);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentSorcMTSWiUCommand newDelayedSorcMTSWiUCommand(String comment) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".SrcMTSWUCMDFacade.newDelayedSrcMTSWUCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            SorcMTSWiUCommand result = new SorcMTSWiUCommand(null,null,comment,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentSorcMTSWiUCommand)PersistentProxi.createProxi(id, 177);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public SorcMTSWiUCommand getSorcMTSWiUCommand(long SorcMTSWiUCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SrcMTSWUCMDFacade.getSrcMTSWUCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, SorcMTSWiUCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentUnit unit = null;
            if (obj.getLong(2) != 0)
                unit = (PersistentUnit)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentThirdMark mark = null;
            if (obj.getLong(4) != 0)
                mark = (PersistentThirdMark)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(7) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentAdminServer commandReceiver = null;
            if (obj.getLong(9) != 0)
                commandReceiver = (PersistentAdminServer)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(11) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            SorcMTSWiUCommand result = new SorcMTSWiUCommand(unit,
                                                             mark,
                                                             obj.getString(6) == null ? "" : obj.getString(6) /* In Oracle "" = null !!! */,
                                                             invoker,
                                                             commandReceiver,
                                                             myCommonDate,
                                                             SorcMTSWiUCommandId);
            obj.close();
            callable.close();
            SorcMTSWiUCommandICProxi inCache = (SorcMTSWiUCommandICProxi)Cache.getTheCache().put(result);
            SorcMTSWiUCommand objectInCache = (SorcMTSWiUCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SrcMTSWUCMDFacade.getClass(?); end;");
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
    public void unitSet(long SorcMTSWiUCommandId, Unit4Public unitVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrcMTSWUCMDFacade.untSet(?, ?, ?); end;");
            callable.setLong(1, SorcMTSWiUCommandId);
            callable.setLong(2, unitVal.getId());
            callable.setLong(3, unitVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void markSet(long SorcMTSWiUCommandId, ThirdMark4Public markVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrcMTSWUCMDFacade.mrkSet(?, ?, ?); end;");
            callable.setLong(1, SorcMTSWiUCommandId);
            callable.setLong(2, markVal.getId());
            callable.setLong(3, markVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commentSet(long SorcMTSWiUCommandId, String commentVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrcMTSWUCMDFacade.cmmntSet(?, ?); end;");
            callable.setLong(1, SorcMTSWiUCommandId);
            callable.setString(2, commentVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long SorcMTSWiUCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrcMTSWUCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, SorcMTSWiUCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long SorcMTSWiUCommandId, AdminServer4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrcMTSWUCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, SorcMTSWiUCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long SorcMTSWiUCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrcMTSWUCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, SorcMTSWiUCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

