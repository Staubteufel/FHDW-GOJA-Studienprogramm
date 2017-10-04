package persistence;


import model.visitor.*;

public interface ModuleWithUnits4Public extends ModuleGroupsHIERARCHY, Appr4Public {
    
    public ModuleWithUnits_ConsistsOfProxi getConsistsOf() throws PersistenceException ;
    
    public void accept(ApprVisitor visitor) throws PersistenceException;
    public <R> R accept(ApprReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ApprExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ApprReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(PrototypeVisitor visitor) throws PersistenceException;
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(ModuleGroupsHIERARCHYVisitor visitor) throws PersistenceException;
    public <R> R accept(ModuleGroupsHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ModuleGroupsHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ModuleGroupsHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public boolean containsModuleGroups(final ModuleGroupsHIERARCHY part) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public <T> T strategyModuleGroups(final ModuleGroupsHIERARCHYStrategy<T> strategy) 
				throws PersistenceException;
    public void addUnit(final Unit4Public unit) 
				throws model.UnitIsAlreadyPartOfAModuleWithUnitsException, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public Boolean isConsistent() 
				throws PersistenceException;
    public void removeUnit(final Unit4Public unit) 
				throws PersistenceException;

}

