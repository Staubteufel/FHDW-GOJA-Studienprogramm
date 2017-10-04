package persistence;


public interface PersistentRemMWUFromMGCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, RemMWUFromMGCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

