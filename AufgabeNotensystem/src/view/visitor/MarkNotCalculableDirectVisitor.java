
package view.visitor;

import view.*;

public abstract class MarkNotCalculableDirectVisitor implements MarkNotCalculableVisitor {
    
    public abstract void handleBooleanMark(BooleanMarkView booleanMark) throws ModelException;
    
    public void handlePassed(PassedView passed) throws ModelException{
        this.handleBooleanMark(passed);
    }
    public void handleFailed(FailedView failed) throws ModelException{
        this.handleBooleanMark(failed);
    }
    public abstract void handleNoneMark(NoneMarkView noneMark) throws ModelException;
    
    
}
