
package model;

import java.util.Iterator;

import persistence.*;


/* Additional import section end */

public abstract class Prototype extends PersistentObject implements PersistentPrototype{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static Prototype4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().thePrototypeFacade.getClass(objectId);
        return (Prototype4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    @SuppressWarnings("unchecked")
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, boolean inDerived) throws PersistenceException {
        java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf){
                result = (java.util.HashMap<String,Object>)allResults.get(uniqueKey);
                if (result != null) return result;
            }
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, inDerived);
            if (leaf) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract Prototype provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentPrototype prototypeObservee;
    protected Prototype_PrototypeObserverProxi prototypeObserver;
    protected PersistentPrototype This;
    
    public Prototype(PersistentPrototype prototypeObservee,PersistentPrototype This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.prototypeObservee = prototypeObservee;
        this.prototypeObserver = new Prototype_PrototypeObserverProxi(this);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 101;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(this.getPrototypeObservee() != null){
            this.getPrototypeObservee().store();
            ConnectionHandler.getTheConnectionHandler().thePrototypeFacade.prototypeObserveeSet(this.getId(), getPrototypeObservee());
        }
        this.getPrototypeObserver().store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().thePrototypeFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public Prototype4Public getPrototypeObservee() throws PersistenceException {
        return this.prototypeObservee;
    }
    public void setPrototypeObservee(Prototype4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.prototypeObservee)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.prototypeObservee = (PersistentPrototype)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().thePrototypeFacade.prototypeObserveeSet(this.getId(), newValue);
        }
    }
    public Prototype_PrototypeObserverProxi getPrototypeObserver() throws PersistenceException {
        return this.prototypeObserver;
    }
    protected void setThis(PersistentPrototype newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentPrototype)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().thePrototypeFacade.ThisSet(this.getId(), newValue);
        }
    }
    public abstract PersistentPrototype getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentPrototype)This);
		if(this.isTheSameAs(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{

        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    
    
    // Start of section that contains overridden operations only.
    
    public void deregisterPrototypeObserver(final Prototype4Public observer) 
				throws PersistenceException{
        	getThis().getPrototypeObserver().removeAll(observer);
    	}
    public void notifyPrototypeObservers() 
				throws PersistenceException{
        	Iterator<Prototype4Public> i = getThis().getPrototypeObserver().iterator();
        	while(i.hasNext()) {
        		i.next().updatePrototypeObserver();
        	}
    	}
    public void registerProtypeObserver(final Prototype4Public observer) 
				throws PersistenceException{
        	getThis().getPrototypeObserver().add(observer);	
        	observer.setPrototypeObservee(getThis());
    	}

    /* Start of protected part that is not overridden by persistence generator */
    
        
        
    /* End of protected part that is not overridden by persistence generator */
    
}
