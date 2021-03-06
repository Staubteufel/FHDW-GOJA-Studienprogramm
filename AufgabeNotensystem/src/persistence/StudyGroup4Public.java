package persistence;


import model.visitor.*;

public interface StudyGroup4Public extends Prototype4Public {
    
    public String getName() throws PersistenceException ;
    public StudyGroup_StudentsProxi getStudents() throws PersistenceException ;
    public StudyProgram4Public getAssignedTo() throws PersistenceException ;
    public void setAssignedTo(StudyProgram4Public newValue) throws PersistenceException ;
    
    public void accept(PrototypeVisitor visitor) throws PersistenceException;
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void addStudent(final StudentServer4Public student) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

