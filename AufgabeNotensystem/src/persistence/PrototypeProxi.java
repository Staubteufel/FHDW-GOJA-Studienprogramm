package persistence;



public abstract class PrototypeProxi extends PersistentProxi implements PersistentPrototype{
    
    public PrototypeProxi(long objectId) {
        super(objectId);
    }
    public PrototypeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public Prototype4Public getPrototypeObservee() throws PersistenceException {
        return ((PersistentPrototype)this.getTheObject()).getPrototypeObservee();
    }
    public void setPrototypeObservee(Prototype4Public newValue) throws PersistenceException {
        ((PersistentPrototype)this.getTheObject()).setPrototypeObservee(newValue);
    }
    public Prototype_PrototypeObserverProxi getPrototypeObserver() throws PersistenceException {
        return ((PersistentPrototype)this.getTheObject()).getPrototypeObserver();
    }
    public abstract PersistentPrototype getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentPrototype)this.getTheObject()).initialize(This, final$$Fields);
    }
    public Prototype4Public clonePrototype() 
				throws PersistenceException{
        return ((PersistentPrototype)this.getTheObject()).clonePrototype();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentPrototype)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void deregisterPrototypeObserver(final Prototype4Public observer) 
				throws PersistenceException{
        ((PersistentPrototype)this.getTheObject()).deregisterPrototypeObserver(observer);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentPrototype)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentPrototype)this.getTheObject()).initializeOnInstantiation();
    }
    public void notifyPrototypeObservers() 
				throws PersistenceException{
        ((PersistentPrototype)this.getTheObject()).notifyPrototypeObservers();
    }
    public void registerProtypeObserver(final Prototype4Public observer) 
				throws PersistenceException{
        ((PersistentPrototype)this.getTheObject()).registerProtypeObserver(observer);
    }
    public void updatePrototypeObserver() 
				throws PersistenceException{
        ((PersistentPrototype)this.getTheObject()).updatePrototypeObserver();
    }

    
}
