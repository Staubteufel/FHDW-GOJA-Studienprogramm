package persistence;


public interface PersistentModuleGroup extends ModuleGroupsHIERARCHY, PersistentAppr, ModuleGroup4Public {
    
    public PersistentModuleGroup getThis() throws PersistenceException ;
    
    

}

