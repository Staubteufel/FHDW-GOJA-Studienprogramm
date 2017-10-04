
package model.visitor;
import persistence.*;

public interface StudentServerCommandVisitor {
    
    public void handleFetchStudentMCommand(FetchStudentMCommand4Public fetchStudentMCommand) throws PersistenceException;
    
}
