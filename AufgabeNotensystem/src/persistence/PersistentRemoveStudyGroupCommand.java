package persistence;


public interface PersistentRemoveStudyGroupCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, RemoveStudyGroupCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

