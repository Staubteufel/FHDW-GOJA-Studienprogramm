package persistence;


public interface PersistentRemMGFromSPCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, RemMGFromSPCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

