package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class UnitFacade{

	private String schemaName;
	private Connection con;

	public UnitFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentUnit newUnit(String name,common.Fraction creditPoints,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".UntFacade.newUnt(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setString(3, creditPoints.toString());
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Unit result = new Unit(null,null,name,creditPoints,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentUnit)PersistentProxi.createProxi(id, 106);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentUnit newDelayedUnit(String name,common.Fraction creditPoints) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".UntFacade.newDelayedUnt(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Unit result = new Unit(null,null,name,creditPoints,id);
            Cache.getTheCache().put(result);
            return (PersistentUnit)PersistentProxi.createProxi(id, 106);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Unit getUnit(long UnitId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".UntFacade.getUnt(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, UnitId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentPrototype prototypeObservee = null;
            if (obj.getLong(2) != 0)
                prototypeObservee = (PersistentPrototype)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentPrototype This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentPrototype)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Unit result = new Unit(prototypeObservee,
                                   This,
                                   obj.getString(6) == null ? "" : obj.getString(6) /* In Oracle "" = null !!! */,
                                   (obj.getString(7) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(7))),
                                   UnitId);
            obj.close();
            callable.close();
            UnitICProxi inCache = (UnitICProxi)Cache.getTheCache().put(result);
            Unit objectInCache = (Unit)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

