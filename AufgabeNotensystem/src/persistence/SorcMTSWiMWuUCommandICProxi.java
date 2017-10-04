package persistence;



import model.visitor.*;

public class SorcMTSWiMWuUCommandICProxi extends PersistentInCacheProxi implements PersistentSorcMTSWiMWuUCommand{
    
    public SorcMTSWiMWuUCommandICProxi(long objectId) {
        super(objectId);
    }
    public SorcMTSWiMWuUCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theSorcMTSWiMWuUCommandFacade
            .getSorcMTSWiMWuUCommand(this.getId());
    }
    
    public long getClassId() {
        return 173;
    }
    
    public ModuleWithoutUnits4Public getModuleWithoutUnits() throws PersistenceException {
        return ((PersistentSorcMTSWiMWuUCommand)this.getTheObject()).getModuleWithoutUnits();
    }
    public void setModuleWithoutUnits(ModuleWithoutUnits4Public newValue) throws PersistenceException {
        ((PersistentSorcMTSWiMWuUCommand)this.getTheObject()).setModuleWithoutUnits(newValue);
    }
    public Mark getMark() throws PersistenceException {
        return ((PersistentSorcMTSWiMWuUCommand)this.getTheObject()).getMark();
    }
    public void setMark(Mark newValue) throws PersistenceException {
        ((PersistentSorcMTSWiMWuUCommand)this.getTheObject()).setMark(newValue);
    }
    public String getComment() throws PersistenceException {
        return ((PersistentSorcMTSWiMWuUCommand)this.getTheObject()).getComment();
    }
    public void setComment(String newValue) throws PersistenceException {
        ((PersistentSorcMTSWiMWuUCommand)this.getTheObject()).setComment(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentSorcMTSWiMWuUCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentSorcMTSWiMWuUCommand)this.getTheObject()).setInvoker(newValue);
    }
    public AdminServer4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentSorcMTSWiMWuUCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(AdminServer4Public newValue) throws PersistenceException {
        ((PersistentSorcMTSWiMWuUCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentSorcMTSWiMWuUCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentSorcMTSWiMWuUCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentSorcMTSWiMWuUCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentSorcMTSWiMWuUCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentSorcMTSWiMWuUCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentSorcMTSWiMWuUCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleSorcMTSWiMWuUCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSorcMTSWiMWuUCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSorcMTSWiMWuUCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSorcMTSWiMWuUCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleSorcMTSWiMWuUCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSorcMTSWiMWuUCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSorcMTSWiMWuUCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSorcMTSWiMWuUCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleSorcMTSWiMWuUCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSorcMTSWiMWuUCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSorcMTSWiMWuUCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSorcMTSWiMWuUCommand(this);
    }
    public void accept(AdminServerCommandVisitor visitor) throws PersistenceException {
        visitor.handleSorcMTSWiMWuUCommand(this);
    }
    public <R> R accept(AdminServerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSorcMTSWiMWuUCommand(this);
    }
    public <E extends model.UserException>  void accept(AdminServerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSorcMTSWiMWuUCommand(this);
    }
    public <R, E extends model.UserException> R accept(AdminServerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSorcMTSWiMWuUCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentSorcMTSWiMWuUCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentSorcMTSWiMWuUCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentSorcMTSWiMWuUCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentSorcMTSWiMWuUCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentSorcMTSWiMWuUCommand)this.getTheObject()).sendResult();
    }

    
}
