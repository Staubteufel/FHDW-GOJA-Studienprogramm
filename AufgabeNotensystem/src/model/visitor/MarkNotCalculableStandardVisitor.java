
package model.visitor;

import persistence.*;

public abstract class MarkNotCalculableStandardVisitor implements MarkNotCalculableVisitor {
    
    public void handlePassed(Passed4Public passed) throws PersistenceException{
        this.standardHandling(passed);
    }
    public void handleBooleanMark(BooleanMark4Public booleanMark) throws PersistenceException{
        this.standardHandling(booleanMark);
    }
    public void handleFailed(Failed4Public failed) throws PersistenceException{
        this.standardHandling(failed);
    }
    public void handleNoneMark(NoneMark4Public noneMark) throws PersistenceException{
        this.standardHandling(noneMark);
    }
    protected abstract void standardHandling(MarkNotCalculable4Public markNotCalculable) throws PersistenceException;
}
