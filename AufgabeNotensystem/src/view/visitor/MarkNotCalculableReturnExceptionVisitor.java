
package view.visitor;
import view.*;

public interface MarkNotCalculableReturnExceptionVisitor<R, E extends view.UserException> extends BooleanMarkReturnExceptionVisitor<R, E> {
    
    public R handleBooleanMark(BooleanMarkView booleanMark) throws ModelException, E;
    public R handleNoneMark(NoneMarkView noneMark) throws ModelException, E;
    
}
