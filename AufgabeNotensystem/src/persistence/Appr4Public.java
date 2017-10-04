package persistence;


import model.visitor.*;

public interface Appr4Public extends Prototype4Public {
    
    public String getName() throws PersistenceException ;
    public Appr_MarkHistoryProxi getMarkHistory() throws PersistenceException ;
    public common.Fraction getCreditPoints() throws PersistenceException ;
    public void setCreditPoints(common.Fraction newValue) throws PersistenceException ;
    
    public void accept(ApprVisitor visitor) throws PersistenceException;
    public <R> R accept(ApprReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ApprExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ApprReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public Mark fetchMark() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

