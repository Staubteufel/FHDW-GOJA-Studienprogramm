package persistence;


public interface PersistentRemoveModuleGroupCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, RemoveModuleGroupCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

