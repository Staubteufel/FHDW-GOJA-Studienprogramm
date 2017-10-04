package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class SorcMTSWiMWuUCommandFacade{

	private String schemaName;
	private Connection con;

	public SorcMTSWiMWuUCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentSorcMTSWiMWuUCommand newSorcMTSWiMWuUCommand(String comment,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".SrcMTSWMWUCMDFacade.newSrcMTSWMWUCMD(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, comment);
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            SorcMTSWiMWuUCommand result = new SorcMTSWiMWuUCommand(null,null,comment,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentSorcMTSWiMWuUCommand)PersistentProxi.createProxi(id, 173);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentSorcMTSWiMWuUCommand newDelayedSorcMTSWiMWuUCommand(String comment) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".SrcMTSWMWUCMDFacade.newDelayedSrcMTSWMWUCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            SorcMTSWiMWuUCommand result = new SorcMTSWiMWuUCommand(null,null,comment,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentSorcMTSWiMWuUCommand)PersistentProxi.createProxi(id, 173);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public SorcMTSWiMWuUCommand getSorcMTSWiMWuUCommand(long SorcMTSWiMWuUCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SrcMTSWMWUCMDFacade.getSrcMTSWMWUCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, SorcMTSWiMWuUCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentModuleWithoutUnits moduleWithoutUnits = null;
            if (obj.getLong(2) != 0)
                moduleWithoutUnits = (PersistentModuleWithoutUnits)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Mark mark = null;
            if (obj.getLong(4) != 0)
                mark = (Mark)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(7) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentAdminServer commandReceiver = null;
            if (obj.getLong(9) != 0)
                commandReceiver = (PersistentAdminServer)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(11) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            SorcMTSWiMWuUCommand result = new SorcMTSWiMWuUCommand(moduleWithoutUnits,
                                                                   mark,
                                                                   obj.getString(6) == null ? "" : obj.getString(6) /* In Oracle "" = null !!! */,
                                                                   invoker,
                                                                   commandReceiver,
                                                                   myCommonDate,
                                                                   SorcMTSWiMWuUCommandId);
            obj.close();
            callable.close();
            SorcMTSWiMWuUCommandICProxi inCache = (SorcMTSWiMWuUCommandICProxi)Cache.getTheCache().put(result);
            SorcMTSWiMWuUCommand objectInCache = (SorcMTSWiMWuUCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SrcMTSWMWUCMDFacade.getClass(?); end;");
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
    public void moduleWithoutUnitsSet(long SorcMTSWiMWuUCommandId, ModuleWithoutUnits4Public moduleWithoutUnitsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrcMTSWMWUCMDFacade.mdlWthtUntsSet(?, ?, ?); end;");
            callable.setLong(1, SorcMTSWiMWuUCommandId);
            callable.setLong(2, moduleWithoutUnitsVal.getId());
            callable.setLong(3, moduleWithoutUnitsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void markSet(long SorcMTSWiMWuUCommandId, Mark markVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrcMTSWMWUCMDFacade.mrkSet(?, ?, ?); end;");
            callable.setLong(1, SorcMTSWiMWuUCommandId);
            callable.setLong(2, markVal.getId());
            callable.setLong(3, markVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commentSet(long SorcMTSWiMWuUCommandId, String commentVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrcMTSWMWUCMDFacade.cmmntSet(?, ?); end;");
            callable.setLong(1, SorcMTSWiMWuUCommandId);
            callable.setString(2, commentVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long SorcMTSWiMWuUCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrcMTSWMWUCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, SorcMTSWiMWuUCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long SorcMTSWiMWuUCommandId, AdminServer4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrcMTSWMWUCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, SorcMTSWiMWuUCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long SorcMTSWiMWuUCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrcMTSWMWUCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, SorcMTSWiMWuUCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

