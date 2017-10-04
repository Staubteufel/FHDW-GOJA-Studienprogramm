
package model.visitor;
import persistence.*;

public interface BooleanMarkReturnVisitor<R> {
    
    public R handleFailed(Failed4Public failed) throws PersistenceException;
    public R handlePassed(Passed4Public passed) throws PersistenceException;
    public R handleBooleanMark(BooleanMark4Public booleanMark) throws PersistenceException;
    
}
