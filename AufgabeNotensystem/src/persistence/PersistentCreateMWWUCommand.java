package persistence;


public interface PersistentCreateMWWUCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, CreateMWWUCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

