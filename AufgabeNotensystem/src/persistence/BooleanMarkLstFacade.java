package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class BooleanMarkLstFacade{

	private String schemaName;
	private Connection con;

	public BooleanMarkLstFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentBooleanMarkLst getTheBooleanMarkLst() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BlnMrkLstFacade.getTheBlnMrkLst; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentBooleanMarkLst)PersistentProxi.createProxi(id, 233);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public BooleanMarkLst getBooleanMarkLst(long BooleanMarkLstId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BlnMrkLstFacade.getBlnMrkLst(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, BooleanMarkLstId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentBooleanMarkLst This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentBooleanMarkLst)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            BooleanMarkLst result = new BooleanMarkLst(This,
                                                       BooleanMarkLstId);
            obj.close();
            callable.close();
            BooleanMarkLstICProxi inCache = (BooleanMarkLstICProxi)Cache.getTheCache().put(result);
            BooleanMarkLst objectInCache = (BooleanMarkLst)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BlnMrkLstFacade.getClass(?); end;");
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
    public long booleanMarksAdd(long BooleanMarkLstId, BooleanMark4Public booleanMarksVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BlnMrkLstFacade.blnMrksAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, BooleanMarkLstId);
            callable.setLong(3, booleanMarksVal.getId());
            callable.setLong(4, booleanMarksVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void booleanMarksRem(long booleanMarksId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BlnMrkLstFacade.blnMrksRem(?); end;");
            callable.setLong(1, booleanMarksId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public BooleanMarkList booleanMarksGet(long BooleanMarkLstId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BlnMrkLstFacade.blnMrksGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, BooleanMarkLstId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            BooleanMarkList result = new BooleanMarkList();
            while (list.next()) {
                result.add((PersistentBooleanMark)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long BooleanMarkLstId, BooleanMarkLst4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BlnMrkLstFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, BooleanMarkLstId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

