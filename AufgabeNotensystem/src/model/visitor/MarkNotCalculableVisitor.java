
package model.visitor;
import persistence.*;

public interface MarkNotCalculableVisitor extends BooleanMarkVisitor{
    
    public void handleBooleanMark(BooleanMark4Public booleanMark) throws PersistenceException;
    public void handleNoneMark(NoneMark4Public noneMark) throws PersistenceException;
    
}
