package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class TenthMarkFacade{

	private String schemaName;
	private Connection con;

	public TenthMarkFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentTenthMark newTenthMark(common.Fraction value,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TnthMrkFacade.newTnthMrk(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, value.toString());
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            TenthMark result = new TenthMark(value,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentTenthMark)PersistentProxi.createProxi(id, 112);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentTenthMark newDelayedTenthMark(common.Fraction value) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TnthMrkFacade.newDelayedTnthMrk(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            TenthMark result = new TenthMark(value,null,id);
            Cache.getTheCache().put(result);
            return (PersistentTenthMark)PersistentProxi.createProxi(id, 112);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public TenthMark getTenthMark(long TenthMarkId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TnthMrkFacade.getTnthMrk(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, TenthMarkId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMarkCalculable This = null;
            if (obj.getLong(3) != 0)
                This = (PersistentMarkCalculable)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            TenthMark result = new TenthMark((obj.getString(2) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(2))),
                                             This,
                                             TenthMarkId);
            obj.close();
            callable.close();
            TenthMarkICProxi inCache = (TenthMarkICProxi)Cache.getTheCache().put(result);
            TenthMark objectInCache = (TenthMark)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

