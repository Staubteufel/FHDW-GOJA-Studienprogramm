package persistence;



import model.visitor.*;

public class ModuleWithUnitsLstProxi extends PersistentProxi implements PersistentModuleWithUnitsLst{
    
    public ModuleWithUnitsLstProxi(long objectId) {
        super(objectId);
    }
    public ModuleWithUnitsLstProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 206;
    }
    
    public ModuleWithUnitsLst_ModuleWithUnitsProxi getModuleWithUnits() throws PersistenceException {
        return ((PersistentModuleWithUnitsLst)this.getTheObject()).getModuleWithUnits();
    }
    public PersistentModuleWithUnitsLst getThis() throws PersistenceException {
        return ((PersistentModuleWithUnitsLst)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnitsLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnitsLst(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnitsLst(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnitsLst(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleWithUnitsLst)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentModuleWithUnitsLst)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentModuleWithUnitsLst)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentModuleWithUnitsLst)this.getTheObject()).initializeOnInstantiation();
    }

    
}
