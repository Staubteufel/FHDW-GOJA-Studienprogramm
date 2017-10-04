package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class MarkFactoryFacade{

	private String schemaName;
	private Connection con;

	public MarkFactoryFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentMarkFactory getTheMarkFactory() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MrkFctrFacade.getTheMrkFctr; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentMarkFactory)PersistentProxi.createProxi(id, 247);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MarkFactory getMarkFactory(long MarkFactoryId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MrkFctrFacade.getMrkFctr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, MarkFactoryId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMarkFactory This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentMarkFactory)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            MarkFactory result = new MarkFactory(This,
                                                 MarkFactoryId);
            obj.close();
            callable.close();
            MarkFactoryICProxi inCache = (MarkFactoryICProxi)Cache.getTheCache().put(result);
            MarkFactory objectInCache = (MarkFactory)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MrkFctrFacade.getClass(?); end;");
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
    public void ThisSet(long MarkFactoryId, MarkFactory4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MrkFctrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, MarkFactoryId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

