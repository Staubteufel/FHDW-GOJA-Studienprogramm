package persistence;



import model.visitor.*;

public class AddMGToSPCommandICProxi extends PersistentInCacheProxi implements PersistentAddMGToSPCommand{
    
    public AddMGToSPCommandICProxi(long objectId) {
        super(objectId);
    }
    public AddMGToSPCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAddMGToSPCommandFacade
            .getAddMGToSPCommand(this.getId());
    }
    
    public long getClassId() {
        return 174;
    }
    
    public StudyProgram4Public getStudyProgram() throws PersistenceException {
        return ((PersistentAddMGToSPCommand)this.getTheObject()).getStudyProgram();
    }
    public void setStudyProgram(StudyProgram4Public newValue) throws PersistenceException {
        ((PersistentAddMGToSPCommand)this.getTheObject()).setStudyProgram(newValue);
    }
    public ModuleGroup4Public getModuleGroup() throws PersistenceException {
        return ((PersistentAddMGToSPCommand)this.getTheObject()).getModuleGroup();
    }
    public void setModuleGroup(ModuleGroup4Public newValue) throws PersistenceException {
        ((PersistentAddMGToSPCommand)this.getTheObject()).setModuleGroup(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentAddMGToSPCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentAddMGToSPCommand)this.getTheObject()).setInvoker(newValue);
    }
    public AdminServer4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentAddMGToSPCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(AdminServer4Public newValue) throws PersistenceException {
        ((PersistentAddMGToSPCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentAddMGToSPCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentAddMGToSPCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentAddMGToSPCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddMGToSPCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentAddMGToSPCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddMGToSPCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleAddMGToSPCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddMGToSPCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddMGToSPCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddMGToSPCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAddMGToSPCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddMGToSPCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddMGToSPCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddMGToSPCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleAddMGToSPCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddMGToSPCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddMGToSPCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddMGToSPCommand(this);
    }
    public void accept(AdminServerCommandVisitor visitor) throws PersistenceException {
        visitor.handleAddMGToSPCommand(this);
    }
    public <R> R accept(AdminServerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddMGToSPCommand(this);
    }
    public <E extends model.UserException>  void accept(AdminServerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddMGToSPCommand(this);
    }
    public <R, E extends model.UserException> R accept(AdminServerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddMGToSPCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentAddMGToSPCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentAddMGToSPCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentAddMGToSPCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentAddMGToSPCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentAddMGToSPCommand)this.getTheObject()).sendResult();
    }

    
}
