package persistence;


public interface PersistentAddSToSGCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, AddSToSGCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

