
package view.visitor;
import view.*;

public interface MarkNotCalculableExceptionVisitor<E extends view.UserException> extends BooleanMarkExceptionVisitor<E>{
    
    public void handleBooleanMark(BooleanMarkView booleanMark) throws ModelException, E;
    public void handleNoneMark(NoneMarkView noneMark) throws ModelException, E;
    
}
