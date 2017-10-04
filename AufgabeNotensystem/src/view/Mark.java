package view;

import view.objects.*;

import view.visitor.*;

public interface Mark extends AbstractViewRoot {
    
    
    public void accept(MarkVisitor visitor) throws ModelException;
    public <R> R accept(MarkReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(MarkExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(MarkReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
}

