package persistence;


public interface PersistentRemMGFromMGCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, RemMGFromMGCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

