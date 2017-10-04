package persistence;


public interface PersistentMarkHistoryEntry extends Anything, AbstractPersistentProxi, MarkHistoryEntry4Public {
    
    public void setMark(Mark newValue) throws PersistenceException ;
    public void setComment(String newValue) throws PersistenceException ;
    public void setTimestamp(java.sql.Timestamp newValue) throws PersistenceException ;
    public PersistentMarkHistoryEntry getThis() throws PersistenceException ;
    
    

}

