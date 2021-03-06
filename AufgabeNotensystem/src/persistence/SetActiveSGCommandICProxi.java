package persistence;



import model.visitor.*;

public class SetActiveSGCommandICProxi extends PersistentInCacheProxi implements PersistentSetActiveSGCommand{
    
    public SetActiveSGCommandICProxi(long objectId) {
        super(objectId);
    }
    public SetActiveSGCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theSetActiveSGCommandFacade
            .getSetActiveSGCommand(this.getId());
    }
    
    public long getClassId() {
        return 176;
    }
    
    public StudentServer4Public getStudent() throws PersistenceException {
        return ((PersistentSetActiveSGCommand)this.getTheObject()).getStudent();
    }
    public void setStudent(StudentServer4Public newValue) throws PersistenceException {
        ((PersistentSetActiveSGCommand)this.getTheObject()).setStudent(newValue);
    }
    public StudyGroup4Public getStudyGroup() throws PersistenceException {
        return ((PersistentSetActiveSGCommand)this.getTheObject()).getStudyGroup();
    }
    public void setStudyGroup(StudyGroup4Public newValue) throws PersistenceException {
        ((PersistentSetActiveSGCommand)this.getTheObject()).setStudyGroup(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentSetActiveSGCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentSetActiveSGCommand)this.getTheObject()).setInvoker(newValue);
    }
    public AdminServer4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentSetActiveSGCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(AdminServer4Public newValue) throws PersistenceException {
        ((PersistentSetActiveSGCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentSetActiveSGCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentSetActiveSGCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentSetActiveSGCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentSetActiveSGCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentSetActiveSGCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentSetActiveSGCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleSetActiveSGCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSetActiveSGCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSetActiveSGCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSetActiveSGCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleSetActiveSGCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSetActiveSGCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSetActiveSGCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSetActiveSGCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleSetActiveSGCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSetActiveSGCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSetActiveSGCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSetActiveSGCommand(this);
    }
    public void accept(AdminServerCommandVisitor visitor) throws PersistenceException {
        visitor.handleSetActiveSGCommand(this);
    }
    public <R> R accept(AdminServerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSetActiveSGCommand(this);
    }
    public <E extends model.UserException>  void accept(AdminServerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSetActiveSGCommand(this);
    }
    public <R, E extends model.UserException> R accept(AdminServerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSetActiveSGCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentSetActiveSGCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentSetActiveSGCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentSetActiveSGCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentSetActiveSGCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentSetActiveSGCommand)this.getTheObject()).sendResult();
    }

    
}
