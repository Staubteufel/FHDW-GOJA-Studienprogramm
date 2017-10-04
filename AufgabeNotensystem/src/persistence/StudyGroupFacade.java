package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class StudyGroupFacade{

	private String schemaName;
	private Connection con;

	public StudyGroupFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentStudyGroup newStudyGroup(String name,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpFacade.newStdGrp(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            StudyGroup result = new StudyGroup(null,null,name,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentStudyGroup)PersistentProxi.createProxi(id, 111);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentStudyGroup newDelayedStudyGroup(String name) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpFacade.newDelayedStdGrp(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            StudyGroup result = new StudyGroup(null,null,name,null,id);
            Cache.getTheCache().put(result);
            return (PersistentStudyGroup)PersistentProxi.createProxi(id, 111);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public StudyGroup getStudyGroup(long StudyGroupId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpFacade.getStdGrp(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudyGroupId);
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
            PersistentStudyProgram assignedTo = null;
            if (obj.getLong(7) != 0)
                assignedTo = (PersistentStudyProgram)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            StudyGroup result = new StudyGroup(prototypeObservee,
                                               This,
                                               obj.getString(6) == null ? "" : obj.getString(6) /* In Oracle "" = null !!! */,
                                               assignedTo,
                                               StudyGroupId);
            obj.close();
            callable.close();
            StudyGroupICProxi inCache = (StudyGroupICProxi)Cache.getTheCache().put(result);
            StudyGroup objectInCache = (StudyGroup)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nameSet(long StudyGroupId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdGrpFacade.nmSet(?, ?); end;");
            callable.setLong(1, StudyGroupId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public PersistentStudentServer studentsAdd(long StudyGroupId, String indxxVal, StudentServer4Public studentsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpFacade.stdntsAdd(?, ?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudyGroupId);
            callable.setString(3, indxxVal);
            callable.setLong(4, studentsVal.getId());
            callable.setLong(5, studentsVal.getClassId());
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
    public PersistentStudentServer studentsRem(long StudyGroupId, String indxxVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpFacade.stdntsRem(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudyGroupId);
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
    public void studentsRemEntr(long studentsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdGrpFacade.stdntsRemEntr(?); end;");
            callable.setLong(1, studentsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public PersistentStudentServer studentsGet(long StudyGroupId, String indxxVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpFacade.stdntsGet(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudyGroupId);
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
    public java.util.Hashtable<String,StudentServer4Public> studentsGetValues(long StudyGroupId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpFacade.stdntsGetValues(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudyGroupId);
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
    public void assignedToSet(long StudyGroupId, StudyProgram4Public assignedToVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdGrpFacade.assgndTSet(?, ?, ?); end;");
            callable.setLong(1, StudyGroupId);
            callable.setLong(2, assignedToVal.getId());
            callable.setLong(3, assignedToVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

