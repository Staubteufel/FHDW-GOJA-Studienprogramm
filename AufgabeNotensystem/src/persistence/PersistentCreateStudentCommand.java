package persistence;


public interface PersistentCreateStudentCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, CreateStudentCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

