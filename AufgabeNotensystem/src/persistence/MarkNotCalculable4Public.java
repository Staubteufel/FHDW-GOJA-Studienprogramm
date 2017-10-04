package persistence;


import model.visitor.*;

public interface MarkNotCalculable4Public extends Anything, Mark, AbstractPersistentProxi {
    
    
    public void accept(MarkNotCalculableVisitor visitor) throws PersistenceException;
    public <R> R accept(MarkNotCalculableReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(MarkNotCalculableExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(MarkNotCalculableReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

