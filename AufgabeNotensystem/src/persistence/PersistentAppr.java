package persistence;


public interface PersistentAppr extends PersistentPrototype, Appr4Public {
    
    public void setName(String newValue) throws PersistenceException ;
    public abstract PersistentAppr getThis() throws PersistenceException ;
    
    

}

