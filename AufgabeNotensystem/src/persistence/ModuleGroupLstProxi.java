package persistence;



import model.visitor.*;

public class ModuleGroupLstProxi extends PersistentProxi implements PersistentModuleGroupLst{
    
    public ModuleGroupLstProxi(long objectId) {
        super(objectId);
    }
    public ModuleGroupLstProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 205;
    }
    
    public ModuleGroupLst_ModuleGroupsProxi getModuleGroups() throws PersistenceException {
        return ((PersistentModuleGroupLst)this.getTheObject()).getModuleGroups();
    }
    public PersistentModuleGroupLst getThis() throws PersistenceException {
        return ((PersistentModuleGroupLst)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroupLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroupLst(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroupLst(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroupLst(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleGroupLst)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentModuleGroupLst)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentModuleGroupLst)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentModuleGroupLst)this.getTheObject()).initializeOnInstantiation();
    }

    
}
