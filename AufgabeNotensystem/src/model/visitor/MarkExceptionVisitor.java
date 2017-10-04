
package model.visitor;
public interface MarkExceptionVisitor<E extends model.UserException> extends MarkCalculableExceptionVisitor<E>,MarkNotCalculableExceptionVisitor<E>{
    
    
}
