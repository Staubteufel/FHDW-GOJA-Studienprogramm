package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class FourZeroFacade{

	private String schemaName;
	private Connection con;

	public FourZeroFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentFourZero getTheFourZero() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FrZrFacade.getTheFrZr; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentFourZero)PersistentProxi.createProxi(id, 224);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public FourZero getFourZero(long FourZeroId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FrZrFacade.getFrZr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, FourZeroId);
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
            FourZero result = new FourZero((obj.getString(2) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(2))),
                                           This,
                                           FourZeroId);
            obj.close();
            callable.close();
            FourZeroICProxi inCache = (FourZeroICProxi)Cache.getTheCache().put(result);
            FourZero objectInCache = (FourZero)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

