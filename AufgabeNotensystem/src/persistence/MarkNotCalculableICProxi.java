package persistence;



public abstract class MarkNotCalculableICProxi extends PersistentInCacheProxiOptimistic implements PersistentMarkNotCalculable{
    
    public MarkNotCalculableICProxi(long objectId) {
        super(objectId);
    }
    public MarkNotCalculableICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public abstract PersistentMarkNotCalculable getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMarkNotCalculable)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMarkNotCalculable)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public Boolean fetchIsCalculable() 
				throws PersistenceException{
        return ((PersistentMarkNotCalculable)this.getTheObject()).fetchIsCalculable();
    }
    public common.Fraction fetchMarkValue() 
				throws PersistenceException{
        return ((PersistentMarkNotCalculable)this.getTheObject()).fetchMarkValue();
    }
    public String fetchTypeAsString() 
				throws PersistenceException{
        return ((PersistentMarkNotCalculable)this.getTheObject()).fetchTypeAsString();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMarkNotCalculable)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMarkNotCalculable)this.getTheObject()).initializeOnInstantiation();
    }

    
}
