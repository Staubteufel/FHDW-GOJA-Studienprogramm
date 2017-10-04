package persistence;



import model.visitor.*;

public class SorcMTSWiUCommandProxi extends PersistentProxi implements PersistentSorcMTSWiUCommand{
    
    public SorcMTSWiUCommandProxi(long objectId) {
        super(objectId);
    }
    public SorcMTSWiUCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 177;
    }
    
    public Unit4Public getUnit() throws PersistenceException {
        return ((PersistentSorcMTSWiUCommand)this.getTheObject()).getUnit();
    }
    public void setUnit(Unit4Public newValue) throws PersistenceException {
        ((PersistentSorcMTSWiUCommand)this.getTheObject()).setUnit(newValue);
    }
    public ThirdMark4Public getMark() throws PersistenceException {
        return ((PersistentSorcMTSWiUCommand)this.getTheObject()).getMark();
    }
    public void setMark(ThirdMark4Public newValue) throws PersistenceException {
        ((PersistentSorcMTSWiUCommand)this.getTheObject()).setMark(newValue);
    }
    public String getComment() throws PersistenceException {
        return ((PersistentSorcMTSWiUCommand)this.getTheObject()).getComment();
    }
    public void setComment(String newValue) throws PersistenceException {
        ((PersistentSorcMTSWiUCommand)this.getTheObject()).setComment(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentSorcMTSWiUCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentSorcMTSWiUCommand)this.getTheObject()).setInvoker(newValue);
    }
    public AdminServer4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentSorcMTSWiUCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(AdminServer4Public newValue) throws PersistenceException {
        ((PersistentSorcMTSWiUCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentSorcMTSWiUCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentSorcMTSWiUCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentSorcMTSWiUCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentSorcMTSWiUCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentSorcMTSWiUCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentSorcMTSWiUCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleSorcMTSWiUCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSorcMTSWiUCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSorcMTSWiUCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSorcMTSWiUCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleSorcMTSWiUCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSorcMTSWiUCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSorcMTSWiUCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSorcMTSWiUCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleSorcMTSWiUCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSorcMTSWiUCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSorcMTSWiUCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSorcMTSWiUCommand(this);
    }
    public void accept(AdminServerCommandVisitor visitor) throws PersistenceException {
        visitor.handleSorcMTSWiUCommand(this);
    }
    public <R> R accept(AdminServerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSorcMTSWiUCommand(this);
    }
    public <E extends model.UserException>  void accept(AdminServerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSorcMTSWiUCommand(this);
    }
    public <R, E extends model.UserException> R accept(AdminServerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSorcMTSWiUCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentSorcMTSWiUCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentSorcMTSWiUCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentSorcMTSWiUCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentSorcMTSWiUCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentSorcMTSWiUCommand)this.getTheObject()).sendResult();
    }

    
}
