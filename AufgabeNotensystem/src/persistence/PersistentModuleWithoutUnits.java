package persistence;


public interface PersistentModuleWithoutUnits extends ModuleGroupsHIERARCHY, PersistentAppr, ModuleWithoutUnits4Public {
    
    public void setMarkType(Mark newValue) throws PersistenceException ;
    public PersistentModuleWithoutUnits getThis() throws PersistenceException ;
    
    

}

