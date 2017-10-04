package persistence;



import model.visitor.*;

public class UnitICProxi extends ApprICProxi implements PersistentUnit{
    
    public UnitICProxi(long objectId) {
        super(objectId);
    }
    public UnitICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theUnitFacade
            .getUnit(this.getId());
    }
    
    public long getClassId() {
        return 106;
    }
    
    public PersistentUnit getThis() throws PersistenceException {
        return ((PersistentUnit)this.getTheObject()).getThis();
    }
    
    public void accept(ApprVisitor visitor) throws PersistenceException {
        visitor.handleUnit(this);
    }
    public <R> R accept(ApprReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnit(this);
    }
    public <E extends model.UserException>  void accept(ApprExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends model.UserException> R accept(ApprReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnit(this);
    }
    public void accept(PrototypeVisitor visitor) throws PersistenceException {
        visitor.handleUnit(this);
    }
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnit(this);
    }
    public <E extends model.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends model.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnit(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnit(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnit(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).initialize(This, final$$Fields);
    }
    public Prototype4Public clonePrototype() 
				throws PersistenceException{
        return ((PersistentUnit)this.getTheObject()).clonePrototype();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void deregisterPrototypeObserver(final Prototype4Public observer) 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).deregisterPrototypeObserver(observer);
    }
    public Mark fetchMark() 
				throws PersistenceException{
        return ((PersistentUnit)this.getTheObject()).fetchMark();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).initializeOnInstantiation();
    }
    public void notifyPrototypeObservers() 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).notifyPrototypeObservers();
    }
    public void registerProtypeObserver(final Prototype4Public observer) 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).registerProtypeObserver(observer);
    }
    public void setMark(final ThirdMark4Public mark, final String comment) 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).setMark(mark, comment);
    }
    public void updatePrototypeObserver() 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).updatePrototypeObserver();
    }

    
}
