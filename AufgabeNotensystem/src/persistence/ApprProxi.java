package persistence;



public abstract class ApprProxi extends PrototypeProxi implements PersistentAppr{
    
    public ApprProxi(long objectId) {
        super(objectId);
    }
    public ApprProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public String getName() throws PersistenceException {
        return ((PersistentAppr)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentAppr)this.getTheObject()).setName(newValue);
    }
    public Appr_MarkHistoryProxi getMarkHistory() throws PersistenceException {
        return ((PersistentAppr)this.getTheObject()).getMarkHistory();
    }
    public common.Fraction getCreditPoints() throws PersistenceException {
        return ((PersistentAppr)this.getTheObject()).getCreditPoints();
    }
    public void setCreditPoints(common.Fraction newValue) throws PersistenceException {
        ((PersistentAppr)this.getTheObject()).setCreditPoints(newValue);
    }
    public abstract PersistentAppr getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAppr)this.getTheObject()).initialize(This, final$$Fields);
    }
    public Prototype4Public clonePrototype() 
				throws PersistenceException{
        return ((PersistentAppr)this.getTheObject()).clonePrototype();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAppr)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void deregisterPrototypeObserver(final Prototype4Public observer) 
				throws PersistenceException{
        ((PersistentAppr)this.getTheObject()).deregisterPrototypeObserver(observer);
    }
    public Mark fetchMark() 
				throws PersistenceException{
        return ((PersistentAppr)this.getTheObject()).fetchMark();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAppr)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAppr)this.getTheObject()).initializeOnInstantiation();
    }
    public void notifyPrototypeObservers() 
				throws PersistenceException{
        ((PersistentAppr)this.getTheObject()).notifyPrototypeObservers();
    }
    public void registerProtypeObserver(final Prototype4Public observer) 
				throws PersistenceException{
        ((PersistentAppr)this.getTheObject()).registerProtypeObserver(observer);
    }
    public void updatePrototypeObserver() 
				throws PersistenceException{
        ((PersistentAppr)this.getTheObject()).updatePrototypeObserver();
    }

    
}
