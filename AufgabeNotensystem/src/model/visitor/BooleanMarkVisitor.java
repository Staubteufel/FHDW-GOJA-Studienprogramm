
package model.visitor;
import persistence.*;

public interface BooleanMarkVisitor {
    
    public void handleFailed(Failed4Public failed) throws PersistenceException;
    public void handlePassed(Passed4Public passed) throws PersistenceException;
    public void handleBooleanMark(BooleanMark4Public booleanMark) throws PersistenceException;
    
}
