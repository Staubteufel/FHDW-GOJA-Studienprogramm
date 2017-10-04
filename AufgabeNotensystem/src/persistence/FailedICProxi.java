package persistence;



import model.visitor.*;

public class FailedICProxi extends BooleanMarkICProxi implements PersistentFailed{
    
    public FailedICProxi(long objectId) {
        super(objectId);
    }
    public FailedICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theFailedFacade
            .getFailed(this.getId());
    }
    
    public long getClassId() {
        return 227;
    }
    
    public PersistentFailed getThis() throws PersistenceException {
        return ((PersistentFailed)this.getTheObject()).getThis();
    }
    
    public void accept(BooleanMarkVisitor visitor) throws PersistenceException {
        visitor.handleFailed(this);
    }
    public <R> R accept(BooleanMarkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFailed(this);
    }
    public <E extends model.UserException>  void accept(BooleanMarkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFailed(this);
    }
    public <R, E extends model.UserException> R accept(BooleanMarkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFailed(this);
    }
    public void accept(MarkNotCalculableVisitor visitor) throws PersistenceException {
        visitor.handleFailed(this);
    }
    public <R> R accept(MarkNotCalculableReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFailed(this);
    }
    public <E extends model.UserException>  void accept(MarkNotCalculableExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFailed(this);
    }
    public <R, E extends model.UserException> R accept(MarkNotCalculableReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFailed(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFailed(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFailed(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFailed(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFailed(this);
    }
    public void accept(MarkVisitor visitor) throws PersistenceException {
        visitor.handleFailed(this);
    }
    public <R> R accept(MarkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFailed(this);
    }
    public <E extends model.UserException>  void accept(MarkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFailed(this);
    }
    public <R, E extends model.UserException> R accept(MarkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFailed(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentFailed)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentFailed)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public Boolean fetchIsCalculable() 
				throws PersistenceException{
        return ((PersistentFailed)this.getTheObject()).fetchIsCalculable();
    }
    public common.Fraction fetchMarkValue() 
				throws PersistenceException{
        return ((PersistentFailed)this.getTheObject()).fetchMarkValue();
    }
    public String fetchTypeAsString() 
				throws PersistenceException{
        return ((PersistentFailed)this.getTheObject()).fetchTypeAsString();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentFailed)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentFailed)this.getTheObject()).initializeOnInstantiation();
    }

    
}
