
package view.visitor;
import view.*;

public interface MarkNotCalculableVisitor extends BooleanMarkVisitor{
    
    public void handleBooleanMark(BooleanMarkView booleanMark) throws ModelException;
    public void handleNoneMark(NoneMarkView noneMark) throws ModelException;
    
}
