package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class StudyProgramLstFacade{

	private String schemaName;
	private Connection con;

	public StudyProgramLstFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentStudyProgramLst getTheStudyProgramLst() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdPrgrmLstFacade.getTheStdPrgrmLst; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentStudyProgramLst)PersistentProxi.createProxi(id, 207);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public StudyProgramLst getStudyProgramLst(long StudyProgramLstId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdPrgrmLstFacade.getStdPrgrmLst(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudyProgramLstId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentStudyProgramLst This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentStudyProgramLst)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            StudyProgramLst result = new StudyProgramLst(This,
                                                         StudyProgramLstId);
            obj.close();
            callable.close();
            StudyProgramLstICProxi inCache = (StudyProgramLstICProxi)Cache.getTheCache().put(result);
            StudyProgramLst objectInCache = (StudyProgramLst)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdPrgrmLstFacade.getClass(?); end;");
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
    public long studyProgramsAdd(long StudyProgramLstId, StudyProgram4Public studyProgramsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdPrgrmLstFacade.stdPrgrmsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, StudyProgramLstId);
            callable.setLong(3, studyProgramsVal.getId());
            callable.setLong(4, studyProgramsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void studyProgramsRem(long studyProgramsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdPrgrmLstFacade.stdPrgrmsRem(?); end;");
            callable.setLong(1, studyProgramsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public StudyProgramList studyProgramsGet(long StudyProgramLstId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdPrgrmLstFacade.stdPrgrmsGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudyProgramLstId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            StudyProgramList result = new StudyProgramList();
            while (list.next()) {
                result.add((PersistentStudyProgram)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long StudyProgramLstId, StudyProgramLst4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdPrgrmLstFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, StudyProgramLstId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

