package persistence;


public interface PersistentFetchMCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, FetchMCommand4Public {
    
    public void setCommandResult(Mark newValue) throws PersistenceException ;
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

