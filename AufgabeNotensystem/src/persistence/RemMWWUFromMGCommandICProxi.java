package persistence;



import model.visitor.*;

public class RemMWWUFromMGCommandICProxi extends PersistentInCacheProxi implements PersistentRemMWWUFromMGCommand{
    
    public RemMWWUFromMGCommandICProxi(long objectId) {
        super(objectId);
    }
    public RemMWWUFromMGCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theRemMWWUFromMGCommandFacade
            .getRemMWWUFromMGCommand(this.getId());
    }
    
    public long getClassId() {
        return 170;
    }
    
    public ModuleGroup4Public getModuleGroup() throws PersistenceException {
        return ((PersistentRemMWWUFromMGCommand)this.getTheObject()).getModuleGroup();
    }
    public void setModuleGroup(ModuleGroup4Public newValue) throws PersistenceException {
        ((PersistentRemMWWUFromMGCommand)this.getTheObject()).setModuleGroup(newValue);
    }
    public ModuleWithoutUnits4Public getModuleWithoutUnits() throws PersistenceException {
        return ((PersistentRemMWWUFromMGCommand)this.getTheObject()).getModuleWithoutUnits();
    }
    public void setModuleWithoutUnits(ModuleWithoutUnits4Public newValue) throws PersistenceException {
        ((PersistentRemMWWUFromMGCommand)this.getTheObject()).setModuleWithoutUnits(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentRemMWWUFromMGCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentRemMWWUFromMGCommand)this.getTheObject()).setInvoker(newValue);
    }
    public AdminServer4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentRemMWWUFromMGCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(AdminServer4Public newValue) throws PersistenceException {
        ((PersistentRemMWWUFromMGCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentRemMWWUFromMGCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentRemMWWUFromMGCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentRemMWWUFromMGCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentRemMWWUFromMGCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentRemMWWUFromMGCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentRemMWWUFromMGCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleRemMWWUFromMGCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemMWWUFromMGCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemMWWUFromMGCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemMWWUFromMGCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleRemMWWUFromMGCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemMWWUFromMGCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemMWWUFromMGCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemMWWUFromMGCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleRemMWWUFromMGCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemMWWUFromMGCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemMWWUFromMGCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemMWWUFromMGCommand(this);
    }
    public void accept(AdminServerCommandVisitor visitor) throws PersistenceException {
        visitor.handleRemMWWUFromMGCommand(this);
    }
    public <R> R accept(AdminServerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemMWWUFromMGCommand(this);
    }
    public <E extends model.UserException>  void accept(AdminServerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemMWWUFromMGCommand(this);
    }
    public <R, E extends model.UserException> R accept(AdminServerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemMWWUFromMGCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentRemMWWUFromMGCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentRemMWWUFromMGCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentRemMWWUFromMGCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentRemMWWUFromMGCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentRemMWWUFromMGCommand)this.getTheObject()).sendResult();
    }

    
}
