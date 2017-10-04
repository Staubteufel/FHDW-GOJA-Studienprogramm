package persistence;



public abstract class MarkCalculableICProxi extends PersistentInCacheProxiOptimistic implements PersistentMarkCalculable{
    
    public MarkCalculableICProxi(long objectId) {
        super(objectId);
    }
    public MarkCalculableICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public common.Fraction getValue() throws PersistenceException {
        return ((PersistentMarkCalculable)this.getTheObject()).getValue();
    }
    public void setValue(common.Fraction newValue) throws PersistenceException {
        ((PersistentMarkCalculable)this.getTheObject()).setValue(newValue);
    }
    public abstract PersistentMarkCalculable getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMarkCalculable)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMarkCalculable)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public Boolean fetchIsCalculable() 
				throws PersistenceException{
        return ((PersistentMarkCalculable)this.getTheObject()).fetchIsCalculable();
    }
    public common.Fraction fetchMarkValue() 
				throws PersistenceException{
        return ((PersistentMarkCalculable)this.getTheObject()).fetchMarkValue();
    }
    public String fetchTypeAsString() 
				throws PersistenceException{
        return ((PersistentMarkCalculable)this.getTheObject()).fetchTypeAsString();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMarkCalculable)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMarkCalculable)this.getTheObject()).initializeOnInstantiation();
    }

    
}
