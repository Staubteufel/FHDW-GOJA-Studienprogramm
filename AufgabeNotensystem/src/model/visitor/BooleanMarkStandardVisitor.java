
package model.visitor;

import persistence.*;

public abstract class BooleanMarkStandardVisitor implements BooleanMarkVisitor {
    
    public void handlePassed(Passed4Public passed) throws PersistenceException{
        this.standardHandling(passed);
    }
    public void handleBooleanMark(BooleanMark4Public booleanMark) throws PersistenceException{
        this.standardHandling(booleanMark);
    }
    public void handleFailed(Failed4Public failed) throws PersistenceException{
        this.standardHandling(failed);
    }
    protected abstract void standardHandling(BooleanMark4Public booleanMark) throws PersistenceException;
}
