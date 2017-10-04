package persistence;


public interface PersistentAddMGToSPCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, AddMGToSPCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

