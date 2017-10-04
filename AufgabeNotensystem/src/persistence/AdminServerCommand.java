package persistence;

import model.visitor.*;

/* Additional import section end */

public interface AdminServerCommand extends  Command {
    
    

    public void accept(AdminServerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(AdminServerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AdminServerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AdminServerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

