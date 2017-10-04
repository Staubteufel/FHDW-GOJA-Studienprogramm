
package model;

import common.Fraction;
import persistence.*;


/* Additional import section end */

public abstract class MarkCalculable extends PersistentObject implements PersistentMarkCalculable{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static MarkCalculable4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theMarkCalculableFacade.getClass(objectId);
        return (MarkCalculable4Public)PersistentProxi.createProxi(objectId, classId);
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
    
    public abstract MarkCalculable provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected common.Fraction value;
    protected PersistentMarkCalculable This;
    
    public MarkCalculable(common.Fraction value,PersistentMarkCalculable This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.value = value;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 214;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theMarkCalculableFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public common.Fraction getValue() throws PersistenceException {
        return this.value;
    }
    public void setValue(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theMarkCalculableFacade.valueSet(this.getId(), newValue);
        this.value = newValue;
    }
    protected void setThis(PersistentMarkCalculable newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentMarkCalculable)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMarkCalculableFacade.ThisSet(this.getId(), newValue);
        }
    }
    public abstract PersistentMarkCalculable getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMarkCalculable)This);
		if(this.isTheSameAs(This)){
			this.setValue((common.Fraction)final$$Fields.get("value"));
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
    
    public Boolean fetchIsCalculable() 
				throws PersistenceException{
	   return true;
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    public Fraction fetchMarkValue() throws PersistenceException {
    	return getThis().getValue();
    }
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
