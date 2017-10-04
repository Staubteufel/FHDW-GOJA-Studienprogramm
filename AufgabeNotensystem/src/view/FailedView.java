package view;

import view.visitor.*;

public interface FailedView extends BooleanMarkView {
    
    
    public void accept(BooleanMarkVisitor visitor) throws ModelException;
    public <R> R accept(BooleanMarkReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(BooleanMarkExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(BooleanMarkReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(MarkNotCalculableVisitor visitor) throws ModelException;
    public <R> R accept(MarkNotCalculableReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(MarkNotCalculableExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(MarkNotCalculableReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(MarkVisitor visitor) throws ModelException;
    public <R> R accept(MarkReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(MarkExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(MarkReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

