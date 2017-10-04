package persistence;


public interface PersistentAddMWWUToMGCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, AddMWWUToMGCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

