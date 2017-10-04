package persistence;


public interface PersistentChangeCPCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, ChangeCPCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

