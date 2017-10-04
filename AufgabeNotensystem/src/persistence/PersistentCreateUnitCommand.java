package persistence;


public interface PersistentCreateUnitCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, CreateUnitCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

