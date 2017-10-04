package persistence;


public interface PersistentCreateMWUCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, CreateMWUCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

