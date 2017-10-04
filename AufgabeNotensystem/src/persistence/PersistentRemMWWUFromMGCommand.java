package persistence;


public interface PersistentRemMWWUFromMGCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, RemMWWUFromMGCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

