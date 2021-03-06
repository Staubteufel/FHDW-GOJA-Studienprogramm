package view;

import view.visitor.*;

public interface TenthMarkView extends MarkCalculableView {
    
    
    public void accept(MarkCalculableVisitor visitor) throws ModelException;
    public <R> R accept(MarkCalculableReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(MarkCalculableExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(MarkCalculableReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(MarkVisitor visitor) throws ModelException;
    public <R> R accept(MarkReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(MarkExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(MarkReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

