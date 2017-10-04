package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class BooleanMarkFacade{

	private String schemaName;
	private Connection con;

	public BooleanMarkFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentBooleanMark newBooleanMark(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".BlnMrkFacade.newBlnMrk(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            BooleanMark result = new BooleanMark(null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentBooleanMark)PersistentProxi.createProxi(id, 119);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentBooleanMark newDelayedBooleanMark() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".BlnMrkFacade.newDelayedBlnMrk(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            BooleanMark result = new BooleanMark(null,id);
            Cache.getTheCache().put(result);
            return (PersistentBooleanMark)PersistentProxi.createProxi(id, 119);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public BooleanMark getBooleanMark(long BooleanMarkId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BlnMrkFacade.getBlnMrk(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, BooleanMarkId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMarkNotCalculable This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentMarkNotCalculable)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            BooleanMark result = new BooleanMark(This,
                                                 BooleanMarkId);
            obj.close();
            callable.close();
            BooleanMarkICProxi inCache = (BooleanMarkICProxi)Cache.getTheCache().put(result);
            BooleanMark objectInCache = (BooleanMark)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

