
package model.visitor;
import persistence.*;

public interface StudentServerCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleFetchStudentMCommand(FetchStudentMCommand4Public fetchStudentMCommand) throws PersistenceException, E;
    
}
