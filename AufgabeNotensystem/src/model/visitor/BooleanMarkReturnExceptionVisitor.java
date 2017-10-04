
package model.visitor;
import persistence.*;

public interface BooleanMarkReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleFailed(Failed4Public failed) throws PersistenceException, E;
    public R handlePassed(Passed4Public passed) throws PersistenceException, E;
    public R handleBooleanMark(BooleanMark4Public booleanMark) throws PersistenceException, E;
    
}
