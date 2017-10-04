package persistence;



import java.sql.*;
//import oracle.jdbc.*;

public class ApprFacade{

	private String schemaName;
	private Connection con;

	public ApprFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public void nameSet(long ApprId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ApprFacade.nmSet(?, ?); end;");
            callable.setLong(1, ApprId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long markHistoryAdd(long ApprId, MarkHistoryEntry4Public markHistoryVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ApprFacade.mrkHstrAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, ApprId);
            callable.setLong(3, markHistoryVal.getId());
            callable.setLong(4, markHistoryVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void markHistoryRem(long markHistoryId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ApprFacade.mrkHstrRem(?); end;");
            callable.setLong(1, markHistoryId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MarkHistoryEntryList markHistoryGet(long ApprId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ApprFacade.mrkHstrGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ApprId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            MarkHistoryEntryList result = new MarkHistoryEntryList();
            while (list.next()) {
                result.add((PersistentMarkHistoryEntry)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void creditPointsSet(long ApprId, common.Fraction creditPointsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ApprFacade.crdtPntsSet(?, ?); end;");
            callable.setLong(1, ApprId);
            callable.setString(2, creditPointsVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

