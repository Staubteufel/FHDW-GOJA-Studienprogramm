
package model.visitor;
import persistence.*;

public interface MarkNotCalculableReturnVisitor<R> extends BooleanMarkReturnVisitor<R> {
    
    public R handleBooleanMark(BooleanMark4Public booleanMark) throws PersistenceException;
    public R handleNoneMark(NoneMark4Public noneMark) throws PersistenceException;
    
}
