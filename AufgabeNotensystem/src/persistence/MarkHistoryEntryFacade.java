package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class MarkHistoryEntryFacade{

	private String schemaName;
	private Connection con;

	public MarkHistoryEntryFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentMarkHistoryEntry newMarkHistoryEntry(String comment,java.sql.Timestamp timestamp,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MrkHstrEntrFacade.newMrkHstrEntr(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, comment);
            callable.setTimestamp(3, timestamp);
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MarkHistoryEntry result = new MarkHistoryEntry(null,comment,timestamp,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentMarkHistoryEntry)PersistentProxi.createProxi(id, 121);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentMarkHistoryEntry newDelayedMarkHistoryEntry(String comment,java.sql.Timestamp timestamp) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MrkHstrEntrFacade.newDelayedMrkHstrEntr(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MarkHistoryEntry result = new MarkHistoryEntry(null,comment,timestamp,null,id);
            Cache.getTheCache().put(result);
            return (PersistentMarkHistoryEntry)PersistentProxi.createProxi(id, 121);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MarkHistoryEntry getMarkHistoryEntry(long MarkHistoryEntryId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MrkHstrEntrFacade.getMrkHstrEntr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, MarkHistoryEntryId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            Mark mark = null;
            if (obj.getLong(2) != 0)
                mark = (Mark)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentMarkHistoryEntry This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentMarkHistoryEntry)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            MarkHistoryEntry result = new MarkHistoryEntry(mark,
                                                           obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                           obj.getTimestamp(5),
                                                           This,
                                                           MarkHistoryEntryId);
            obj.close();
            callable.close();
            MarkHistoryEntryICProxi inCache = (MarkHistoryEntryICProxi)Cache.getTheCache().put(result);
            MarkHistoryEntry objectInCache = (MarkHistoryEntry)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MrkHstrEntrFacade.getClass(?); end;");
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
    public void markSet(long MarkHistoryEntryId, Mark markVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MrkHstrEntrFacade.mrkSet(?, ?, ?); end;");
            callable.setLong(1, MarkHistoryEntryId);
            callable.setLong(2, markVal.getId());
            callable.setLong(3, markVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commentSet(long MarkHistoryEntryId, String commentVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MrkHstrEntrFacade.cmmntSet(?, ?); end;");
            callable.setLong(1, MarkHistoryEntryId);
            callable.setString(2, commentVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void timestampSet(long MarkHistoryEntryId, java.sql.Timestamp timestampVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MrkHstrEntrFacade.tmstmpSet(?, ?); end;");
            callable.setLong(1, MarkHistoryEntryId);
            callable.setTimestamp(2, timestampVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long MarkHistoryEntryId, MarkHistoryEntry4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MrkHstrEntrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, MarkHistoryEntryId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

