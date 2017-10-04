package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class NoneMarkFacade{

	private String schemaName;
	private Connection con;

	public NoneMarkFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentNoneMark newNoneMark(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".NnMrkFacade.newNnMrk(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            NoneMark result = new NoneMark(null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentNoneMark)PersistentProxi.createProxi(id, 115);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentNoneMark newDelayedNoneMark() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".NnMrkFacade.newDelayedNnMrk(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            NoneMark result = new NoneMark(null,id);
            Cache.getTheCache().put(result);
            return (PersistentNoneMark)PersistentProxi.createProxi(id, 115);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NoneMark getNoneMark(long NoneMarkId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NnMrkFacade.getNnMrk(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, NoneMarkId);
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
            NoneMark result = new NoneMark(This,
                                           NoneMarkId);
            obj.close();
            callable.close();
            NoneMarkICProxi inCache = (NoneMarkICProxi)Cache.getTheCache().put(result);
            NoneMark objectInCache = (NoneMark)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

