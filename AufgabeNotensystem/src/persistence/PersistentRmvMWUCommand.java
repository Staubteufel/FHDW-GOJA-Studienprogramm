package persistence;


public interface PersistentRmvMWUCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, RmvMWUCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

