package persistence;


public interface PersistentAddUToMWUCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, AddUToMWUCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

