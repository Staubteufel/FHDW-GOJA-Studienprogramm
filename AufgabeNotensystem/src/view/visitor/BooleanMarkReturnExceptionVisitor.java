
package view.visitor;
import view.*;

public interface BooleanMarkReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleFailed(FailedView failed) throws ModelException, E;
    public R handlePassed(PassedView passed) throws ModelException, E;
    public R handleBooleanMark(BooleanMarkView booleanMark) throws ModelException, E;
    
}
