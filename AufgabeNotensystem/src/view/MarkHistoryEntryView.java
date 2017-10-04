package view;

import view.objects.*;

import view.visitor.*;

public interface MarkHistoryEntryView extends Anything, AbstractViewRoot {
    
    public Mark getMark()throws ModelException;
    public void setMark(Mark newValue) throws ModelException ;
    public String getComment()throws ModelException;
    public void setComment(String newValue) throws ModelException ;
    public java.util.Date getTimestamp()throws ModelException;
    public void setTimestamp(java.util.Date newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

