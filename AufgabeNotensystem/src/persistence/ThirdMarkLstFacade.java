package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ThirdMarkLstFacade{

	private String schemaName;
	private Connection con;

	public ThirdMarkLstFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentThirdMarkLst getTheThirdMarkLst() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ThrdMrkLstFacade.getTheThrdMrkLst; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentThirdMarkLst)PersistentProxi.createProxi(id, 229);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ThirdMarkLst getThirdMarkLst(long ThirdMarkLstId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ThrdMrkLstFacade.getThrdMrkLst(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ThirdMarkLstId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentThirdMarkLst This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentThirdMarkLst)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            ThirdMarkLst result = new ThirdMarkLst(This,
                                                   ThirdMarkLstId);
            obj.close();
            callable.close();
            ThirdMarkLstICProxi inCache = (ThirdMarkLstICProxi)Cache.getTheCache().put(result);
            ThirdMarkLst objectInCache = (ThirdMarkLst)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ThrdMrkLstFacade.getClass(?); end;");
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
    public long thirdMarksAdd(long ThirdMarkLstId, ThirdMark4Public thirdMarksVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ThrdMrkLstFacade.thrdMrksAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, ThirdMarkLstId);
            callable.setLong(3, thirdMarksVal.getId());
            callable.setLong(4, thirdMarksVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void thirdMarksRem(long thirdMarksId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ThrdMrkLstFacade.thrdMrksRem(?); end;");
            callable.setLong(1, thirdMarksId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ThirdMarkList thirdMarksGet(long ThirdMarkLstId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ThrdMrkLstFacade.thrdMrksGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ThirdMarkLstId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            ThirdMarkList result = new ThirdMarkList();
            while (list.next()) {
                result.add((PersistentThirdMark)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long ThirdMarkLstId, ThirdMarkLst4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ThrdMrkLstFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, ThirdMarkLstId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

