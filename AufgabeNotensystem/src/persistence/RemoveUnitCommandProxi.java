package persistence;



import model.visitor.*;

public class RemoveUnitCommandProxi extends PersistentProxi implements PersistentRemoveUnitCommand{
    
    public RemoveUnitCommandProxi(long objectId) {
        super(objectId);
    }
    public RemoveUnitCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 239;
    }
    
    public Unit4Public getUnit() throws PersistenceException {
        return ((PersistentRemoveUnitCommand)this.getTheObject()).getUnit();
    }
    public void setUnit(Unit4Public newValue) throws PersistenceException {
        ((PersistentRemoveUnitCommand)this.getTheObject()).setUnit(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentRemoveUnitCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentRemoveUnitCommand)this.getTheObject()).setInvoker(newValue);
    }
    public AdminServer4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentRemoveUnitCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(AdminServer4Public newValue) throws PersistenceException {
        ((PersistentRemoveUnitCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentRemoveUnitCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentRemoveUnitCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentRemoveUnitCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentRemoveUnitCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentRemoveUnitCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentRemoveUnitCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleRemoveUnitCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemoveUnitCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemoveUnitCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemoveUnitCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleRemoveUnitCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemoveUnitCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemoveUnitCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemoveUnitCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleRemoveUnitCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemoveUnitCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemoveUnitCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemoveUnitCommand(this);
    }
    public void accept(AdminServerCommandVisitor visitor) throws PersistenceException {
        visitor.handleRemoveUnitCommand(this);
    }
    public <R> R accept(AdminServerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemoveUnitCommand(this);
    }
    public <E extends model.UserException>  void accept(AdminServerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemoveUnitCommand(this);
    }
    public <R, E extends model.UserException> R accept(AdminServerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemoveUnitCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentRemoveUnitCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentRemoveUnitCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentRemoveUnitCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentRemoveUnitCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentRemoveUnitCommand)this.getTheObject()).sendResult();
    }

    
}
