
package model.visitor;
public interface CommandExceptionVisitor<E extends model.UserException> extends AdminServerCommandExceptionVisitor<E>,StudentServerCommandExceptionVisitor<E>{
    
    
}
