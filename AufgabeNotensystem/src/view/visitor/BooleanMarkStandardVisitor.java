
package view.visitor;

import view.*;

public abstract class BooleanMarkStandardVisitor implements BooleanMarkVisitor {
    
    public void handlePassed(PassedView passed) throws ModelException{
        this.standardHandling(passed);
    }
    public void handleBooleanMark(BooleanMarkView booleanMark) throws ModelException{
        this.standardHandling(booleanMark);
    }
    public void handleFailed(FailedView failed) throws ModelException{
        this.standardHandling(failed);
    }
    protected abstract void standardHandling(BooleanMarkView booleanMark) throws ModelException;
}
