package persistence;


import model.visitor.*;

public interface Prototype4Public extends Anything, AbstractPersistentProxi {
    
    public Prototype4Public getPrototypeObservee() throws PersistenceException ;
    public void setPrototypeObservee(Prototype4Public newValue) throws PersistenceException ;
    public Prototype_PrototypeObserverProxi getPrototypeObserver() throws PersistenceException ;
    
    public void accept(PrototypeVisitor visitor) throws PersistenceException;
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public Prototype4Public clonePrototype() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void deregisterPrototypeObserver(final Prototype4Public observer) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void notifyPrototypeObservers() 
				throws PersistenceException;
    public void registerProtypeObserver(final Prototype4Public observer) 
				throws PersistenceException;
    public void updatePrototypeObserver() 
				throws PersistenceException;

}

