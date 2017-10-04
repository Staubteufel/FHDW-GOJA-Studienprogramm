package persistence;


public interface PersistentCreateStudyProgramCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, CreateStudyProgramCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

