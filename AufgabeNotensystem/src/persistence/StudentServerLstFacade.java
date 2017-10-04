package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class StudentServerLstFacade{

	private String schemaName;
	private Connection con;

	public StudentServerLstFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentStudentServerLst getTheStudentServerLst() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdntSrvLstFacade.getTheStdntSrvLst; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentStudentServerLst)PersistentProxi.createProxi(id, 228);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public StudentServerLst getStudentServerLst(long StudentServerLstId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdntSrvLstFacade.getStdntSrvLst(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudentServerLstId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentStudentServerLst This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentStudentServerLst)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            StudentServerLst result = new StudentServerLst(This,
                                                           StudentServerLstId);
            obj.close();
            callable.close();
            StudentServerLstICProxi inCache = (StudentServerLstICProxi)Cache.getTheCache().put(result);
            StudentServerLst objectInCache = (StudentServerLst)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdntSrvLstFacade.getClass(?); end;");
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
    public PersistentStudentServer studentServersAdd(long StudentServerLstId, String indxxVal, StudentServer4Public studentServersVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdntSrvLstFacade.stdntSrvrsAdd(?, ?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudentServerLstId);
            callable.setString(3, indxxVal);
            callable.setLong(4, studentServersVal.getId());
            callable.setLong(5, studentServersVal.getClassId());
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            PersistentStudentServer result = null;
            if (list.next()) result = (PersistentStudentServer)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3));
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public PersistentStudentServer studentServersRem(long StudentServerLstId, String indxxVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdntSrvLstFacade.stdntSrvrsRem(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudentServerLstId);
            callable.setString(3, indxxVal);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            PersistentStudentServer result = null;
            if (list.next()) result = (PersistentStudentServer)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3));
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void studentServersRemEntr(long studentServersId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdntSrvLstFacade.stdntSrvrsRemEntr(?); end;");
            callable.setLong(1, studentServersId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public PersistentStudentServer studentServersGet(long StudentServerLstId, String indxxVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdntSrvLstFacade.stdntSrvrsGet(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudentServerLstId);
            callable.setString(3, indxxVal);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            PersistentStudentServer result = null;
            if (list.next()) result = (PersistentStudentServer)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3));
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public java.util.Hashtable<String,StudentServer4Public> studentServersGetValues(long StudentServerLstId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdntSrvLstFacade.stdntSrvrsGetValues(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudentServerLstId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            java.util.Hashtable<String,StudentServer4Public> result = new java.util.Hashtable<String,StudentServer4Public>();
            while (list.next()) {
                StudentServer4Public value = (StudentServer4Public)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3));
                String key = list.getString(4);
                result.put(key,value);
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long StudentServerLstId, StudentServerLst4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdntSrvLstFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, StudentServerLstId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

