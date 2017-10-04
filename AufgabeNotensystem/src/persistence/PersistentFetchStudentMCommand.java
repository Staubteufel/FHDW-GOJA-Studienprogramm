package persistence;


public interface PersistentFetchStudentMCommand extends StudentServerCommand, Anything, PersistentCommonDate, AbstractPersistentProxi, FetchStudentMCommand4Public {
    
    public void setCommandResult(Mark newValue) throws PersistenceException ;
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

