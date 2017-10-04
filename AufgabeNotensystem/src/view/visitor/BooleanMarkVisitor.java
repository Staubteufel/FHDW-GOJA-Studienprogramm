
package view.visitor;
import view.*;

public interface BooleanMarkVisitor {
    
    public void handleFailed(FailedView failed) throws ModelException;
    public void handlePassed(PassedView passed) throws ModelException;
    public void handleBooleanMark(BooleanMarkView booleanMark) throws ModelException;
    
}
