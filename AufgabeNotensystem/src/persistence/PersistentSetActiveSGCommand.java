package persistence;


public interface PersistentSetActiveSGCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, SetActiveSGCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

