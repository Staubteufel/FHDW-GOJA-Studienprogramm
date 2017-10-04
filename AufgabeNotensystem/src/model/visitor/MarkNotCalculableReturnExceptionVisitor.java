
package model.visitor;
import persistence.*;

public interface MarkNotCalculableReturnExceptionVisitor<R, E extends model.UserException> extends BooleanMarkReturnExceptionVisitor<R, E> {
    
    public R handleBooleanMark(BooleanMark4Public booleanMark) throws PersistenceException, E;
    public R handleNoneMark(NoneMark4Public noneMark) throws PersistenceException, E;
    
}
