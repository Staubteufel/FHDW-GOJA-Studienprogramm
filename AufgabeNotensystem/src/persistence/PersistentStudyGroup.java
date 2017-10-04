package persistence;


public interface PersistentStudyGroup extends PersistentPrototype, StudyGroup4Public {
    
    public void setName(String newValue) throws PersistenceException ;
    public PersistentStudyGroup getThis() throws PersistenceException ;
    
    

}

