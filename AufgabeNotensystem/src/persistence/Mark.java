package persistence;

import model.visitor.*;

/* Additional import section end */

public interface Mark extends AbstractPersistentProxi {
    
    
    public Boolean fetchIsCalculable() 
				throws PersistenceException;
    public common.Fraction fetchMarkValue() 
				throws PersistenceException;
    public String fetchTypeAsString() 
				throws PersistenceException;

    public void accept(MarkVisitor visitor) throws PersistenceException;
    public <R> R accept(MarkReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(MarkExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(MarkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

