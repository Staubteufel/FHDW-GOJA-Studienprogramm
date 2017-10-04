package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class FailedFacade{

	private String schemaName;
	private Connection con;

	public FailedFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentFailed getTheFailed() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FldFacade.getTheFld; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentFailed)PersistentProxi.createProxi(id, 227);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Failed getFailed(long FailedId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FldFacade.getFld(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, FailedId);
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
            Failed result = new Failed(This,
                                       FailedId);
            obj.close();
            callable.close();
            FailedICProxi inCache = (FailedICProxi)Cache.getTheCache().put(result);
            Failed objectInCache = (Failed)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

