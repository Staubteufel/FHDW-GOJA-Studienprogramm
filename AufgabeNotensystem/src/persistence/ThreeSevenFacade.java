package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ThreeSevenFacade{

	private String schemaName;
	private Connection con;

	public ThreeSevenFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentThreeSeven getTheThreeSeven() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ThrSvnFacade.getTheThrSvn; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentThreeSeven)PersistentProxi.createProxi(id, 217);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ThreeSeven getThreeSeven(long ThreeSevenId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ThrSvnFacade.getThrSvn(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ThreeSevenId);
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
            ThreeSeven result = new ThreeSeven((obj.getString(2) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(2))),
                                               This,
                                               ThreeSevenId);
            obj.close();
            callable.close();
            ThreeSevenICProxi inCache = (ThreeSevenICProxi)Cache.getTheCache().put(result);
            ThreeSeven objectInCache = (ThreeSeven)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

