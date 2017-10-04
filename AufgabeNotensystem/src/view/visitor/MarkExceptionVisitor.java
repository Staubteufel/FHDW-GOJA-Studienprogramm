
package view.visitor;
public interface MarkExceptionVisitor<E extends view.UserException> extends MarkCalculableExceptionVisitor<E>,MarkNotCalculableExceptionVisitor<E>{
    
    
}
