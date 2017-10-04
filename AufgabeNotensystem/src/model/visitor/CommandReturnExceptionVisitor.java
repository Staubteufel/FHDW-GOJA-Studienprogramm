
package model.visitor;
public interface CommandReturnExceptionVisitor<R, E extends model.UserException> extends AdminServerCommandReturnExceptionVisitor<R, E> ,StudentServerCommandReturnExceptionVisitor<R, E> {
    
    
}
