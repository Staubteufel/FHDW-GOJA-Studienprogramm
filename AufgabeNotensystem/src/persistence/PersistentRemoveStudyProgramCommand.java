package persistence;


public interface PersistentRemoveStudyProgramCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, RemoveStudyProgramCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

