package persistence;



import model.visitor.*;

public class CreateStudentCommandProxi extends PersistentProxi implements PersistentCreateStudentCommand{
    
    public CreateStudentCommandProxi(long objectId) {
        super(objectId);
    }
    public CreateStudentCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 166;
    }
    
    public String getMatricalNumber() throws PersistenceException {
        return ((PersistentCreateStudentCommand)this.getTheObject()).getMatricalNumber();
    }
    public void setMatricalNumber(String newValue) throws PersistenceException {
        ((PersistentCreateStudentCommand)this.getTheObject()).setMatricalNumber(newValue);
    }
    public String getPassword() throws PersistenceException {
        return ((PersistentCreateStudentCommand)this.getTheObject()).getPassword();
    }
    public void setPassword(String newValue) throws PersistenceException {
        ((PersistentCreateStudentCommand)this.getTheObject()).setPassword(newValue);
    }
    public String getForename() throws PersistenceException {
        return ((PersistentCreateStudentCommand)this.getTheObject()).getForename();
    }
    public void setForename(String newValue) throws PersistenceException {
        ((PersistentCreateStudentCommand)this.getTheObject()).setForename(newValue);
    }
    public String getSurname() throws PersistenceException {
        return ((PersistentCreateStudentCommand)this.getTheObject()).getSurname();
    }
    public void setSurname(String newValue) throws PersistenceException {
        ((PersistentCreateStudentCommand)this.getTheObject()).setSurname(newValue);
    }
    public java.sql.Date getDateOfBirth() throws PersistenceException {
        return ((PersistentCreateStudentCommand)this.getTheObject()).getDateOfBirth();
    }
    public void setDateOfBirth(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateStudentCommand)this.getTheObject()).setDateOfBirth(newValue);
    }
    public StudyGroup4Public getStudyGroup() throws PersistenceException {
        return ((PersistentCreateStudentCommand)this.getTheObject()).getStudyGroup();
    }
    public void setStudyGroup(StudyGroup4Public newValue) throws PersistenceException {
        ((PersistentCreateStudentCommand)this.getTheObject()).setStudyGroup(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateStudentCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateStudentCommand)this.getTheObject()).setInvoker(newValue);
    }
    public AdminServer4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateStudentCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(AdminServer4Public newValue) throws PersistenceException {
        ((PersistentCreateStudentCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateStudentCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateStudentCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateStudentCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateStudentCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateStudentCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateStudentCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateStudentCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateStudentCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateStudentCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateStudentCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateStudentCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateStudentCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateStudentCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateStudentCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateStudentCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateStudentCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateStudentCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateStudentCommand(this);
    }
    public void accept(AdminServerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateStudentCommand(this);
    }
    public <R> R accept(AdminServerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateStudentCommand(this);
    }
    public <E extends model.UserException>  void accept(AdminServerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateStudentCommand(this);
    }
    public <R, E extends model.UserException> R accept(AdminServerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateStudentCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentCreateStudentCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateStudentCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateStudentCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateStudentCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateStudentCommand)this.getTheObject()).sendResult();
    }

    
}
