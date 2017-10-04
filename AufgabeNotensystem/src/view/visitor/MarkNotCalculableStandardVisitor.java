
package view.visitor;

import view.*;

public abstract class MarkNotCalculableStandardVisitor implements MarkNotCalculableVisitor {
    
    public void handlePassed(PassedView passed) throws ModelException{
        this.standardHandling(passed);
    }
    public void handleBooleanMark(BooleanMarkView booleanMark) throws ModelException{
        this.standardHandling(booleanMark);
    }
    public void handleFailed(FailedView failed) throws ModelException{
        this.standardHandling(failed);
    }
    public void handleNoneMark(NoneMarkView noneMark) throws ModelException{
        this.standardHandling(noneMark);
    }
    protected abstract void standardHandling(MarkNotCalculableView markNotCalculable) throws ModelException;
}
