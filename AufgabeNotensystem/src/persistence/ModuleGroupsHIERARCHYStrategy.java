package persistence;


/* Additional import section end */

public interface ModuleGroupsHIERARCHYStrategy<T> {
    
    
    public T ModuleGroup$$finalize(final ModuleGroup4Public ths, final T moduleGroups, final T moduleWithUnits, final T moduleWithoutUnits) 
				throws PersistenceException;
    public T ModuleGroup$$moduleGroups$$$initialize(final ModuleGroup4Public ths) 
				throws PersistenceException;
    public T ModuleGroup$$moduleGroups$$consolidate(final ModuleGroup4Public ths, final T result, final T current) 
				throws PersistenceException;
    public T ModuleGroup$$moduleWithUnits$$$initialize(final ModuleGroup4Public ths) 
				throws PersistenceException;
    public T ModuleGroup$$moduleWithUnits$$consolidate(final ModuleGroup4Public ths, final T result, final T current) 
				throws PersistenceException;
    public T ModuleGroup$$moduleWithoutUnits$$$initialize(final ModuleGroup4Public ths) 
				throws PersistenceException;
    public T ModuleGroup$$moduleWithoutUnits$$consolidate(final ModuleGroup4Public ths, final T result, final T current) 
				throws PersistenceException;
    public T ModuleWithUnits$$finalize(final ModuleWithUnits4Public ths) 
				throws PersistenceException;
    public T ModuleWithoutUnits$$finalize(final ModuleWithoutUnits4Public ths) 
				throws PersistenceException;

    
}

