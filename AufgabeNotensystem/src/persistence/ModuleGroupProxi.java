package persistence;



import model.visitor.*;

public class ModuleGroupProxi extends ApprProxi implements PersistentModuleGroup{
    
    public ModuleGroupProxi(long objectId) {
        super(objectId);
    }
    public ModuleGroupProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 105;
    }
    
    public ModuleGroup_ModuleGroupsProxi getModuleGroups() throws PersistenceException {
        return ((PersistentModuleGroup)this.getTheObject()).getModuleGroups();
    }
    public ModuleGroup_ModuleWithUnitsProxi getModuleWithUnits() throws PersistenceException {
        return ((PersistentModuleGroup)this.getTheObject()).getModuleWithUnits();
    }
    public ModuleGroup_ModuleWithoutUnitsProxi getModuleWithoutUnits() throws PersistenceException {
        return ((PersistentModuleGroup)this.getTheObject()).getModuleWithoutUnits();
    }
    public PersistentModuleGroup getThis() throws PersistenceException {
        return ((PersistentModuleGroup)this.getTheObject()).getThis();
    }
    
    public void accept(ApprVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroup(this);
    }
    public <R> R accept(ApprReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroup(this);
    }
    public <E extends model.UserException>  void accept(ApprExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroup(this);
    }
    public <R, E extends model.UserException> R accept(ApprReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroup(this);
    }
    public void accept(PrototypeVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroup(this);
    }
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroup(this);
    }
    public <E extends model.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroup(this);
    }
    public <R, E extends model.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroup(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroup(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroup(this);
    }
    public void accept(ModuleGroupsHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroup(this);
    }
    public <R> R accept(ModuleGroupsHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroup(this);
    }
    public <E extends model.UserException>  void accept(ModuleGroupsHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroup(this);
    }
    public <R, E extends model.UserException> R accept(ModuleGroupsHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroup(this);
    }
    
    
    public boolean containsModuleGroups(final ModuleGroupsHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentModuleGroup)this.getTheObject()).containsModuleGroups(part);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleGroup)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyModuleGroups(final ModuleGroupsHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentModuleGroup)this.getTheObject()).strategyModuleGroups(strategy);
    }
    public void addModuleGroup(final ModuleGroup4Public moduleGroup) 
				throws model.CycleException, PersistenceException{
        ((PersistentModuleGroup)this.getTheObject()).addModuleGroup(moduleGroup);
    }
    public void addModuleWithUnits(final ModuleWithUnits4Public moduleWithUnits) 
				throws model.CycleException, PersistenceException{
        ((PersistentModuleGroup)this.getTheObject()).addModuleWithUnits(moduleWithUnits);
    }
    public void addModuleWithoutUnits(final ModuleWithoutUnits4Public moduleWithoutUnits) 
				throws model.CycleException, PersistenceException{
        ((PersistentModuleGroup)this.getTheObject()).addModuleWithoutUnits(moduleWithoutUnits);
    }
    public Prototype4Public clonePrototype() 
				throws PersistenceException{
        return ((PersistentModuleGroup)this.getTheObject()).clonePrototype();
    }
    public Boolean containsModulGroup(final ModuleGroup4Public moduleGroup) 
				throws PersistenceException{
        return ((PersistentModuleGroup)this.getTheObject()).containsModulGroup(moduleGroup);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentModuleGroup)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void deregisterPrototypeObserver(final Prototype4Public observer) 
				throws PersistenceException{
        ((PersistentModuleGroup)this.getTheObject()).deregisterPrototypeObserver(observer);
    }
    public Mark fetchMark() 
				throws PersistenceException{
        return ((PersistentModuleGroup)this.getTheObject()).fetchMark();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentModuleGroup)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentModuleGroup)this.getTheObject()).initializeOnInstantiation();
    }
    public Boolean isConsistent() 
				throws PersistenceException{
        return ((PersistentModuleGroup)this.getTheObject()).isConsistent();
    }
    public void notifyPrototypeObservers() 
				throws PersistenceException{
        ((PersistentModuleGroup)this.getTheObject()).notifyPrototypeObservers();
    }
    public void registerProtypeObserver(final Prototype4Public observer) 
				throws PersistenceException{
        ((PersistentModuleGroup)this.getTheObject()).registerProtypeObserver(observer);
    }
    public void removeModuleGroup(final ModuleGroup4Public moduleGroup) 
				throws PersistenceException{
        ((PersistentModuleGroup)this.getTheObject()).removeModuleGroup(moduleGroup);
    }
    public void removeModuleWithUnits(final ModuleWithUnits4Public moduleWithUnits) 
				throws PersistenceException{
        ((PersistentModuleGroup)this.getTheObject()).removeModuleWithUnits(moduleWithUnits);
    }
    public void removeModuleWithoutUnits(final ModuleWithoutUnits4Public moduleWithoutUnits) 
				throws PersistenceException{
        ((PersistentModuleGroup)this.getTheObject()).removeModuleWithoutUnits(moduleWithoutUnits);
    }
    public void updatePrototypeObserver() 
				throws PersistenceException{
        ((PersistentModuleGroup)this.getTheObject()).updatePrototypeObserver();
    }

    
}
