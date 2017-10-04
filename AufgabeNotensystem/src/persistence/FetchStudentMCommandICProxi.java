package persistence;



import model.visitor.*;

public class FetchStudentMCommandICProxi extends PersistentInCacheProxi implements PersistentFetchStudentMCommand{
    
    public FetchStudentMCommandICProxi(long objectId) {
        super(objectId);
    }
    public FetchStudentMCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theFetchStudentMCommandFacade
            .getFetchStudentMCommand(this.getId());
    }
    
    public long getClassId() {
        return 211;
    }
    
    public Appr4Public getAppr() throws PersistenceException {
        return ((PersistentFetchStudentMCommand)this.getTheObject()).getAppr();
    }
    public void setAppr(Appr4Public newValue) throws PersistenceException {
        ((PersistentFetchStudentMCommand)this.getTheObject()).setAppr(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentFetchStudentMCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentFetchStudentMCommand)this.getTheObject()).setInvoker(newValue);
    }
    public StudentServer4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentFetchStudentMCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(StudentServer4Public newValue) throws PersistenceException {
        ((PersistentFetchStudentMCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public Mark getCommandResult() throws PersistenceException {
        return ((PersistentFetchStudentMCommand)this.getTheObject()).getCommandResult();
    }
    public void setCommandResult(Mark newValue) throws PersistenceException {
        ((PersistentFetchStudentMCommand)this.getTheObject()).setCommandResult(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentFetchStudentMCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentFetchStudentMCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentFetchStudentMCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentFetchStudentMCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentFetchStudentMCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentFetchStudentMCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleFetchStudentMCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFetchStudentMCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFetchStudentMCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFetchStudentMCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFetchStudentMCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFetchStudentMCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFetchStudentMCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFetchStudentMCommand(this);
    }
    public void accept(StudentServerCommandVisitor visitor) throws PersistenceException {
        visitor.handleFetchStudentMCommand(this);
    }
    public <R> R accept(StudentServerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFetchStudentMCommand(this);
    }
    public <E extends model.UserException>  void accept(StudentServerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFetchStudentMCommand(this);
    }
    public <R, E extends model.UserException> R accept(StudentServerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFetchStudentMCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleFetchStudentMCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFetchStudentMCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFetchStudentMCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFetchStudentMCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentFetchStudentMCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentFetchStudentMCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentFetchStudentMCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentFetchStudentMCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentFetchStudentMCommand)this.getTheObject()).sendResult();
    }

    
}
