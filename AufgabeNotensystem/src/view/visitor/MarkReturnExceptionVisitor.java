
package view.visitor;
public interface MarkReturnExceptionVisitor<R, E extends view.UserException> extends MarkCalculableReturnExceptionVisitor<R, E> ,MarkNotCalculableReturnExceptionVisitor<R, E> {
    
    
}
