package persistence;


public interface PersistentRemUFromMWUCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, RemUFromMWUCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

