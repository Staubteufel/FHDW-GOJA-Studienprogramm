
package model.visitor;
import persistence.*;

public interface StudentServerCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleFetchStudentMCommand(FetchStudentMCommand4Public fetchStudentMCommand) throws PersistenceException, E;
    
}
