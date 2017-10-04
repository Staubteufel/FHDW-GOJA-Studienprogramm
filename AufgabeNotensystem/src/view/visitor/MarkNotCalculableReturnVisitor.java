
package view.visitor;
import view.*;

public interface MarkNotCalculableReturnVisitor<R> extends BooleanMarkReturnVisitor<R> {
    
    public R handleBooleanMark(BooleanMarkView booleanMark) throws ModelException;
    public R handleNoneMark(NoneMarkView noneMark) throws ModelException;
    
}
