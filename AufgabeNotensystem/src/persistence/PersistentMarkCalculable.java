package persistence;


public interface PersistentMarkCalculable extends Anything, Mark, AbstractPersistentProxi, MarkCalculable4Public {
    
    public void setValue(common.Fraction newValue) throws PersistenceException ;
    public abstract PersistentMarkCalculable getThis() throws PersistenceException ;
    
    

}

