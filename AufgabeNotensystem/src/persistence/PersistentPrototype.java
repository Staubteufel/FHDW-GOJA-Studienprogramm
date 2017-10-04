package persistence;


public interface PersistentPrototype extends Anything, AbstractPersistentProxi, Prototype4Public {
    
    public abstract PersistentPrototype getThis() throws PersistenceException ;
    
    

}

