package persistence;


public interface PersistentRmvMWOUCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, RmvMWOUCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

