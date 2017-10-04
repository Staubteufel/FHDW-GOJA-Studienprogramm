package persistence;


import model.visitor.*;

public interface MarkCalculable4Public extends Anything, Mark, AbstractPersistentProxi {
    
    public common.Fraction getValue() throws PersistenceException ;
    
    public void accept(MarkCalculableVisitor visitor) throws PersistenceException;
    public <R> R accept(MarkCalculableReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(MarkCalculableExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(MarkCalculableReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

