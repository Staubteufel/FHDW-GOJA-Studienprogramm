package persistence;



import model.visitor.*;

public class ModuleWithoutUnitsLstICProxi extends PersistentInCacheProxiOptimistic implements PersistentModuleWithoutUnitsLst{
    
    public ModuleWithoutUnitsLstICProxi(long objectId) {
        super(objectId);
    }
    public ModuleWithoutUnitsLstICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theModuleWithoutUnitsLstFacade
            .getModuleWithoutUnitsLst(this.getId());
    }
    
    public long getClassId() {
        return 209;
    }
    
    public ModuleWithoutUnitsLst_ModuleWithoutUnitsProxi getModuleWithoutUnits() throws PersistenceException {
        return ((PersistentModuleWithoutUnitsLst)this.getTheObject()).getModuleWithoutUnits();
    }
    public PersistentModuleWithoutUnitsLst getThis() throws PersistenceException {
        return ((PersistentModuleWithoutUnitsLst)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithoutUnitsLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithoutUnitsLst(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithoutUnitsLst(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithoutUnitsLst(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleWithoutUnitsLst)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentModuleWithoutUnitsLst)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentModuleWithoutUnitsLst)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentModuleWithoutUnitsLst)this.getTheObject()).initializeOnInstantiation();
    }

    
}
