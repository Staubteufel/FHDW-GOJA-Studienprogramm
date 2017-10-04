package persistence;


import model.visitor.*;

public interface BooleanMark4Public extends MarkNotCalculable4Public {
    
    
    public void accept(BooleanMarkVisitor visitor) throws PersistenceException;
    public <R> R accept(BooleanMarkReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(BooleanMarkExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(BooleanMarkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(MarkNotCalculableVisitor visitor) throws PersistenceException;
    public <R> R accept(MarkNotCalculableReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(MarkNotCalculableExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(MarkNotCalculableReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(MarkVisitor visitor) throws PersistenceException;
    public <R> R accept(MarkReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(MarkExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(MarkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

