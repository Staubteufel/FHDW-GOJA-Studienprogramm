package persistence;


public interface PersistentRemoveUnitCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, RemoveUnitCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

