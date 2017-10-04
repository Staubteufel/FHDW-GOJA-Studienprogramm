
package model.visitor;
import persistence.*;

public interface StudentServerCommandReturnVisitor<R> {
    
    public R handleFetchStudentMCommand(FetchStudentMCommand4Public fetchStudentMCommand) throws PersistenceException;
    
}
