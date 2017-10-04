package persistence;

import model.visitor.*;

/* Additional import section end */

public interface StudentServerCommand extends  Command {
    
    

    public void accept(StudentServerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(StudentServerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(StudentServerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(StudentServerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

