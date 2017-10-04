package persistence;



import model.visitor.*;

public class ModuleWithUnitsICProxi extends ApprICProxi implements PersistentModuleWithUnits{
    
    public ModuleWithUnitsICProxi(long objectId) {
        super(objectId);
    }
    public ModuleWithUnitsICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsFacade
            .getModuleWithUnits(this.getId());
    }
    
    public long getClassId() {
        return 114;
    }
    
    public ModuleWithUnits_ConsistsOfProxi getConsistsOf() throws PersistenceException {
        return ((PersistentModuleWithUnits)this.getTheObject()).getConsistsOf();
    }
    public PersistentModuleWithUnits getThis() throws PersistenceException {
        return ((PersistentModuleWithUnits)this.getTheObject()).getThis();
    }
    
    public void accept(ApprVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnits(this);
    }
    public <R> R accept(ApprReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnits(this);
    }
    public <E extends model.UserException>  void accept(ApprExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnits(this);
    }
    public <R, E extends model.UserException> R accept(ApprReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnits(this);
    }
    public void accept(PrototypeVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnits(this);
    }
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnits(this);
    }
    public <E extends model.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnits(this);
    }
    public <R, E extends model.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnits(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnits(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnits(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnits(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnits(this);
    }
    public void accept(ModuleGroupsHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnits(this);
    }
    public <R> R accept(ModuleGroupsHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnits(this);
    }
    public <E extends model.UserException>  void accept(ModuleGroupsHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnits(this);
    }
    public <R, E extends model.UserException> R accept(ModuleGroupsHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnits(this);
    }
    
    
    public boolean containsModuleGroups(final ModuleGroupsHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentModuleWithUnits)this.getTheObject()).containsModuleGroups(part);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleWithUnits)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyModuleGroups(final ModuleGroupsHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentModuleWithUnits)this.getTheObject()).strategyModuleGroups(strategy);
    }
    public void addUnit(final Unit4Public unit) 
				throws model.UnitIsAlreadyPartOfAModuleWithUnitsException, PersistenceException{
        ((PersistentModuleWithUnits)this.getTheObject()).addUnit(unit);
    }
    public Prototype4Public clonePrototype() 
				throws PersistenceException{
        return ((PersistentModuleWithUnits)this.getTheObject()).clonePrototype();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentModuleWithUnits)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void deregisterPrototypeObserver(final Prototype4Public observer) 
				throws PersistenceException{
        ((PersistentModuleWithUnits)this.getTheObject()).deregisterPrototypeObserver(observer);
    }
    public Mark fetchMark() 
				throws PersistenceException{
        return ((PersistentModuleWithUnits)this.getTheObject()).fetchMark();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentModuleWithUnits)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentModuleWithUnits)this.getTheObject()).initializeOnInstantiation();
    }
    public Boolean isConsistent() 
				throws PersistenceException{
        return ((PersistentModuleWithUnits)this.getTheObject()).isConsistent();
    }
    public void notifyPrototypeObservers() 
				throws PersistenceException{
        ((PersistentModuleWithUnits)this.getTheObject()).notifyPrototypeObservers();
    }
    public void registerProtypeObserver(final Prototype4Public observer) 
				throws PersistenceException{
        ((PersistentModuleWithUnits)this.getTheObject()).registerProtypeObserver(observer);
    }
    public void removeUnit(final Unit4Public unit) 
				throws PersistenceException{
        ((PersistentModuleWithUnits)this.getTheObject()).removeUnit(unit);
    }
    public void updatePrototypeObserver() 
				throws PersistenceException{
        ((PersistentModuleWithUnits)this.getTheObject()).updatePrototypeObserver();
    }

    
}
