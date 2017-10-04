
package view.visitor;
import view.*;

public interface BooleanMarkReturnVisitor<R> {
    
    public R handleFailed(FailedView failed) throws ModelException;
    public R handlePassed(PassedView passed) throws ModelException;
    public R handleBooleanMark(BooleanMarkView booleanMark) throws ModelException;
    
}
