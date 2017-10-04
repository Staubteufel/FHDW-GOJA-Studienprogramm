package persistence;


public interface PersistentCreateStudyGroupCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, CreateStudyGroupCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

