package persistence;



import model.visitor.*;

public class ErrorDisplayProxi extends PersistentProxi implements PersistentErrorDisplay{
    
    public ErrorDisplayProxi(long objectId) {
        super(objectId);
    }
    public ErrorDisplayProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return -104;
    }
    
    public String getMessage() throws PersistenceException {
        return ((PersistentErrorDisplay)this.getTheObject()).getMessage();
    }
    public void setMessage(String newValue) throws PersistenceException {
        ((PersistentErrorDisplay)this.getTheObject()).setMessage(newValue);
    }
    public PersistentErrorDisplay getThis() throws PersistenceException {
        return ((PersistentErrorDisplay)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleErrorDisplay(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleErrorDisplay(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleErrorDisplay(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleErrorDisplay(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentErrorDisplay)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentErrorDisplay)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentErrorDisplay)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentErrorDisplay)this.getTheObject()).initializeOnInstantiation();
    }

    
}
