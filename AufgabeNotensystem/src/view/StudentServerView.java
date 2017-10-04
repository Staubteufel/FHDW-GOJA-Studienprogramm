package view;

import viewClient.*;

import view.visitor.*;

public interface StudentServerView extends ServiceView {
    
    public String getMatriculationNumber()throws ModelException;
    public void setMatriculationNumber(String newValue) throws ModelException ;
    public String getForename()throws ModelException;
    public void setForename(String newValue) throws ModelException ;
    public String getSurname()throws ModelException;
    public void setSurname(String newValue) throws ModelException ;
    public java.util.Date getDateOfBirth()throws ModelException;
    public void setDateOfBirth(java.util.Date newValue) throws ModelException ;
    public String getActiveStudyGroupName()throws ModelException;
    public void setActiveStudyGroupName(String newValue) throws ModelException ;
    public java.util.Vector<StudyGroupView> getStudyGroupsAttended()throws ModelException;
    public void setStudyGroupsAttended(java.util.Vector<StudyGroupView> newValue) throws ModelException ;
    
    public void accept(ServiceVisitor visitor) throws ModelException;
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(RemoteVisitor visitor) throws ModelException;
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
    public StudentServerConnection connectStudentServer(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException;
}

