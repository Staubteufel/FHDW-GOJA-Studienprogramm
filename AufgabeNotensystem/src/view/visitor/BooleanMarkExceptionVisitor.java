
package view.visitor;
import view.*;

public interface BooleanMarkExceptionVisitor<E extends view.UserException> {
    
    public void handleFailed(FailedView failed) throws ModelException, E;
    public void handlePassed(PassedView passed) throws ModelException, E;
    public void handleBooleanMark(BooleanMarkView booleanMark) throws ModelException, E;
    
}
