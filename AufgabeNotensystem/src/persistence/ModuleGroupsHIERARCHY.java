package persistence;

import model.visitor.*;

/* Additional import section end */

public interface ModuleGroupsHIERARCHY extends AbstractPersistentProxi {
    
    
    public boolean containsModuleGroups(final ModuleGroupsHIERARCHY part) 
				throws PersistenceException;
    public <T> T strategyModuleGroups(final ModuleGroupsHIERARCHYStrategy<T> strategy) 
				throws PersistenceException;

    public void accept(ModuleGroupsHIERARCHYVisitor visitor) throws PersistenceException;
    public <R> R accept(ModuleGroupsHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ModuleGroupsHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ModuleGroupsHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

