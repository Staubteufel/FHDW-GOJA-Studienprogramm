package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class TwoThreeFacade{

	private String schemaName;
	private Connection con;

	public TwoThreeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentTwoThree getTheTwoThree() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TwThrFacade.getTheTwThr; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentTwoThree)PersistentProxi.createProxi(id, 223);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public TwoThree getTwoThree(long TwoThreeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TwThrFacade.getTwThr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, TwoThreeId);
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
            TwoThree result = new TwoThree((obj.getString(2) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(2))),
                                           This,
                                           TwoThreeId);
            obj.close();
            callable.close();
            TwoThreeICProxi inCache = (TwoThreeICProxi)Cache.getTheCache().put(result);
            TwoThree objectInCache = (TwoThree)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

