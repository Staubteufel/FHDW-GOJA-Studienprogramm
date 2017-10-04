
package model.visitor;

import persistence.*;

public abstract class MarkNotCalculableDirectVisitor implements MarkNotCalculableVisitor {
    
    public abstract void handleBooleanMark(BooleanMark4Public booleanMark) throws PersistenceException;
    
    public void handlePassed(Passed4Public passed) throws PersistenceException{
        this.handleBooleanMark(passed);
    }
    public void handleFailed(Failed4Public failed) throws PersistenceException{
        this.handleBooleanMark(failed);
    }
    public abstract void handleNoneMark(NoneMark4Public noneMark) throws PersistenceException;
    
    
}
