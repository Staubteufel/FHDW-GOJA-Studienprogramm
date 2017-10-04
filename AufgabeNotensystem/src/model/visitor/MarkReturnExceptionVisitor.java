
package model.visitor;
public interface MarkReturnExceptionVisitor<R, E extends model.UserException> extends MarkCalculableReturnExceptionVisitor<R, E> ,MarkNotCalculableReturnExceptionVisitor<R, E> {
    
    
}
