package persistence;



import model.visitor.*;

public class MarkFactoryICProxi extends PersistentInCacheProxiOptimistic implements PersistentMarkFactory{
    
    public MarkFactoryICProxi(long objectId) {
        super(objectId);
    }
    public MarkFactoryICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMarkFactoryFacade
            .getMarkFactory(this.getId());
    }
    
    public long getClassId() {
        return 247;
    }
    
    public PersistentMarkFactory getThis() throws PersistenceException {
        return ((PersistentMarkFactory)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMarkFactory(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMarkFactory(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMarkFactory(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMarkFactory(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMarkFactory)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMarkFactory)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public TenthMark4Public createTenthMark(final common.Fraction f) 
				throws PersistenceException{
        return ((PersistentMarkFactory)this.getTheObject()).createTenthMark(f);
    }
    public ThirdMark4Public createThirdMark(final common.Fraction f) 
				throws PersistenceException{
        return ((PersistentMarkFactory)this.getTheObject()).createThirdMark(f);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMarkFactory)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMarkFactory)this.getTheObject()).initializeOnInstantiation();
    }

    
}
