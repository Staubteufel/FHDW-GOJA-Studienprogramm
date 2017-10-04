
package model.visitor;
import persistence.*;

public interface BooleanMarkExceptionVisitor<E extends model.UserException> {
    
    public void handleFailed(Failed4Public failed) throws PersistenceException, E;
    public void handlePassed(Passed4Public passed) throws PersistenceException, E;
    public void handleBooleanMark(BooleanMark4Public booleanMark) throws PersistenceException, E;
    
}
