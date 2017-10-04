package view;

import view.visitor.*;

public interface StudyGroupView extends PrototypeView {
    
    public String getName()throws ModelException;
    public void setName(String newValue) throws ModelException ;
    public java.util.Vector<StudentServerView> getStudents()throws ModelException;
    public void setStudents(java.util.Vector<StudentServerView> newValue) throws ModelException ;
    public StudyProgramView getAssignedTo()throws ModelException;
    public void setAssignedTo(StudyProgramView newValue) throws ModelException ;
    
    public void accept(PrototypeVisitor visitor) throws ModelException;
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

