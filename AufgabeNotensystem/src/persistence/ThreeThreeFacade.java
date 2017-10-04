package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ThreeThreeFacade{

	private String schemaName;
	private Connection con;

	public ThreeThreeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentThreeThree getTheThreeThree() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ThrThrFacade.getTheThrThr; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentThreeThree)PersistentProxi.createProxi(id, 221);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ThreeThree getThreeThree(long ThreeThreeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ThrThrFacade.getThrThr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ThreeThreeId);
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
            ThreeThree result = new ThreeThree((obj.getString(2) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(2))),
                                               This,
                                               ThreeThreeId);
            obj.close();
            callable.close();
            ThreeThreeICProxi inCache = (ThreeThreeICProxi)Cache.getTheCache().put(result);
            ThreeThree objectInCache = (ThreeThree)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

