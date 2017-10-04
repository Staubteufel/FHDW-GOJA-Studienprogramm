package persistence;


public interface PersistentAddMGToMGCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, AddMGToMGCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

