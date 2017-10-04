package persistence;


public interface PersistentCreateModuleGroupCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, CreateModuleGroupCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

