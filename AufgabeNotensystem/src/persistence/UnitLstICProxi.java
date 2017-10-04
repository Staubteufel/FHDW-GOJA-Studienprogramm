package persistence;



import model.visitor.*;

public class UnitLstICProxi extends PersistentInCacheProxiOptimistic implements PersistentUnitLst{
    
    public UnitLstICProxi(long objectId) {
        super(objectId);
    }
    public UnitLstICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theUnitLstFacade
            .getUnitLst(this.getId());
    }
    
    public long getClassId() {
        return 203;
    }
    
    public UnitLst_UnitsProxi getUnits() throws PersistenceException {
        return ((PersistentUnitLst)this.getTheObject()).getUnits();
    }
    public PersistentUnitLst getThis() throws PersistenceException {
        return ((PersistentUnitLst)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnitLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitLst(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitLst(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitLst(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentUnitLst)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentUnitLst)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentUnitLst)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentUnitLst)this.getTheObject()).initializeOnInstantiation();
    }

    
}
