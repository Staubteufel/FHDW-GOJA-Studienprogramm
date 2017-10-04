package persistence;


public interface PersistentAddMWUToMGCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, AddMWUToMGCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

