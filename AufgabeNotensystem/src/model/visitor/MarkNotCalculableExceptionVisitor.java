
package model.visitor;
import persistence.*;

public interface MarkNotCalculableExceptionVisitor<E extends model.UserException> extends BooleanMarkExceptionVisitor<E>{
    
    public void handleBooleanMark(BooleanMark4Public booleanMark) throws PersistenceException, E;
    public void handleNoneMark(NoneMark4Public noneMark) throws PersistenceException, E;
    
}
