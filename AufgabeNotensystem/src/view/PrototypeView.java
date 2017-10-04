package view;

import view.objects.*;

import view.visitor.*;

public interface PrototypeView extends Anything, AbstractViewRoot {
    
    
    public void accept(PrototypeVisitor visitor) throws ModelException;
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

