package view;

import view.objects.*;

import view.visitor.*;

public interface MarkNotCalculableView extends Anything, Mark, AbstractViewRoot {
    
    
    public void accept(MarkNotCalculableVisitor visitor) throws ModelException;
    public <R> R accept(MarkNotCalculableReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(MarkNotCalculableExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(MarkNotCalculableReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

