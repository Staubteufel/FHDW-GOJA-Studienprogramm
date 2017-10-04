package view;

import view.objects.*;

import view.visitor.*;

public interface MarkCalculableView extends Anything, Mark, AbstractViewRoot {
    
    
    public void accept(MarkCalculableVisitor visitor) throws ModelException;
    public <R> R accept(MarkCalculableReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(MarkCalculableExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(MarkCalculableReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

