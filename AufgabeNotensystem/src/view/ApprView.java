package view;

import view.visitor.*;

public interface ApprView extends PrototypeView {
    
    public String getName()throws ModelException;
    public void setName(String newValue) throws ModelException ;
    public java.util.Vector<MarkHistoryEntryView> getMarkHistory()throws ModelException;
    public void setMarkHistory(java.util.Vector<MarkHistoryEntryView> newValue) throws ModelException ;
    public common.Fraction getCreditPoints()throws ModelException;
    public void setCreditPoints(common.Fraction newValue) throws ModelException ;
    
    public void accept(ApprVisitor visitor) throws ModelException;
    public <R> R accept(ApprReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(ApprExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(ApprReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

