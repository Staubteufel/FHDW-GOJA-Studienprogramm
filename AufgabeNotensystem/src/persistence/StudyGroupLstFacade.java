package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class StudyGroupLstFacade{

	private String schemaName;
	private Connection con;

	public StudyGroupLstFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentStudyGroupLst getTheStudyGroupLst() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpLstFacade.getTheStdGrpLst; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentStudyGroupLst)PersistentProxi.createProxi(id, 204);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public StudyGroupLst getStudyGroupLst(long StudyGroupLstId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpLstFacade.getStdGrpLst(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudyGroupLstId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentStudyGroupLst This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentStudyGroupLst)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            StudyGroupLst result = new StudyGroupLst(This,
                                                     StudyGroupLstId);
            obj.close();
            callable.close();
            StudyGroupLstICProxi inCache = (StudyGroupLstICProxi)Cache.getTheCache().put(result);
            StudyGroupLst objectInCache = (StudyGroupLst)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpLstFacade.getClass(?); end;");
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
    public long studyGroupsAdd(long StudyGroupLstId, StudyGroup4Public studyGroupsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpLstFacade.stdGrpsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, StudyGroupLstId);
            callable.setLong(3, studyGroupsVal.getId());
            callable.setLong(4, studyGroupsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void studyGroupsRem(long studyGroupsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdGrpLstFacade.stdGrpsRem(?); end;");
            callable.setLong(1, studyGroupsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public StudyGroupList studyGroupsGet(long StudyGroupLstId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpLstFacade.stdGrpsGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudyGroupLstId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            StudyGroupList result = new StudyGroupList();
            while (list.next()) {
                result.add((PersistentStudyGroup)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long StudyGroupLstId, StudyGroupLst4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdGrpLstFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, StudyGroupLstId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

