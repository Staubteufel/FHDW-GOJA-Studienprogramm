package persistence;



import model.visitor.*;

public class ModuleWithoutUnitsProxi extends ApprProxi implements PersistentModuleWithoutUnits{
    
    public ModuleWithoutUnitsProxi(long objectId) {
        super(objectId);
    }
    public ModuleWithoutUnitsProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 108;
    }
    
    public Mark getMarkType() throws PersistenceException {
        return ((PersistentModuleWithoutUnits)this.getTheObject()).getMarkType();
    }
    public void setMarkType(Mark newValue) throws PersistenceException {
        ((PersistentModuleWithoutUnits)this.getTheObject()).setMarkType(newValue);
    }
    public PersistentModuleWithoutUnits getThis() throws PersistenceException {
        return ((PersistentModuleWithoutUnits)this.getTheObject()).getThis();
    }
    
    public void accept(ApprVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithoutUnits(this);
    }
    public <R> R accept(ApprReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithoutUnits(this);
    }
    public <E extends model.UserException>  void accept(ApprExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithoutUnits(this);
    }
    public <R, E extends model.UserException> R accept(ApprReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithoutUnits(this);
    }
    public void accept(PrototypeVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithoutUnits(this);
    }
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithoutUnits(this);
    }
    public <E extends model.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithoutUnits(this);
    }
    public <R, E extends model.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithoutUnits(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithoutUnits(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithoutUnits(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithoutUnits(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithoutUnits(this);
    }
    public void accept(ModuleGroupsHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithoutUnits(this);
    }
    public <R> R accept(ModuleGroupsHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithoutUnits(this);
    }
    public <E extends model.UserException>  void accept(ModuleGroupsHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithoutUnits(this);
    }
    public <R, E extends model.UserException> R accept(ModuleGroupsHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithoutUnits(this);
    }
    
    
    public boolean containsModuleGroups(final ModuleGroupsHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentModuleWithoutUnits)this.getTheObject()).containsModuleGroups(part);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleWithoutUnits)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyModuleGroups(final ModuleGroupsHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentModuleWithoutUnits)this.getTheObject()).strategyModuleGroups(strategy);
    }
    public Prototype4Public clonePrototype() 
				throws PersistenceException{
        return ((PersistentModuleWithoutUnits)this.getTheObject()).clonePrototype();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentModuleWithoutUnits)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void deregisterPrototypeObserver(final Prototype4Public observer) 
				throws PersistenceException{
        ((PersistentModuleWithoutUnits)this.getTheObject()).deregisterPrototypeObserver(observer);
    }
    public Mark fetchMark() 
				throws PersistenceException{
        return ((PersistentModuleWithoutUnits)this.getTheObject()).fetchMark();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentModuleWithoutUnits)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentModuleWithoutUnits)this.getTheObject()).initializeOnInstantiation();
    }
    public void notifyPrototypeObservers() 
				throws PersistenceException{
        ((PersistentModuleWithoutUnits)this.getTheObject()).notifyPrototypeObservers();
    }
    public void registerProtypeObserver(final Prototype4Public observer) 
				throws PersistenceException{
        ((PersistentModuleWithoutUnits)this.getTheObject()).registerProtypeObserver(observer);
    }
    public void setMark(final Mark mark, final String comment) 
				throws model.OtherTypeThanSettedException, PersistenceException{
        ((PersistentModuleWithoutUnits)this.getTheObject()).setMark(mark, comment);
    }
    public void updatePrototypeObserver() 
				throws PersistenceException{
        ((PersistentModuleWithoutUnits)this.getTheObject()).updatePrototypeObserver();
    }

    
}
