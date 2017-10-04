package persistence;


import model.visitor.*;

public interface CreateStudentCommand4Public extends Anything, AdminServerCommand, CommonDate4Public, AbstractPersistentProxi {
    
    public String getMatricalNumber() throws PersistenceException ;
    public void setMatricalNumber(String newValue) throws PersistenceException ;
    public String getPassword() throws PersistenceException ;
    public void setPassword(String newValue) throws PersistenceException ;
    public String getForename() throws PersistenceException ;
    public void setForename(String newValue) throws PersistenceException ;
    public String getSurname() throws PersistenceException ;
    public void setSurname(String newValue) throws PersistenceException ;
    public java.sql.Date getDateOfBirth() throws PersistenceException ;
    public void setDateOfBirth(java.sql.Date newValue) throws PersistenceException ;
    public StudyGroup4Public getStudyGroup() throws PersistenceException ;
    public void setStudyGroup(StudyGroup4Public newValue) throws PersistenceException ;
    public Invoker getInvoker() throws PersistenceException ;
    public void setInvoker(Invoker newValue) throws PersistenceException ;
    public AdminServer4Public getCommandReceiver() throws PersistenceException ;
    public void setCommandReceiver(AdminServer4Public newValue) throws PersistenceException ;
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException;
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(CommandVisitor visitor) throws PersistenceException;
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AdminServerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(AdminServerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AdminServerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AdminServerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void checkException() 
				throws model.UserException, PersistenceException;
    public void execute() 
				throws PersistenceException;
    public void sendException(final PersistenceException exception) 
				throws PersistenceException;
    public void sendResult() 
				throws PersistenceException;

}

