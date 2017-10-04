
package model.visitor;

import persistence.*;

public abstract class StudentServerCommandStandardVisitor implements StudentServerCommandVisitor {
    
    public void handleFetchStudentMCommand(FetchStudentMCommand4Public fetchStudentMCommand) throws PersistenceException{
        this.standardHandling(fetchStudentMCommand);
    }
    protected abstract void standardHandling(StudentServerCommand studentServerCommand) throws PersistenceException;
}
