package view;

import viewClient.*;

import view.visitor.*;

public interface AdminServerView extends ServiceView {
    
    public UnitLstView getUnits()throws ModelException;
    public void setUnits(UnitLstView newValue) throws ModelException ;
    public ModuleWithUnitsLstView getModuleWithUnits()throws ModelException;
    public void setModuleWithUnits(ModuleWithUnitsLstView newValue) throws ModelException ;
    public ModuleWithoutUnitsLstView getModuleWithoutUnits()throws ModelException;
    public void setModuleWithoutUnits(ModuleWithoutUnitsLstView newValue) throws ModelException ;
    public ModuleGroupLstView getModuleGroups()throws ModelException;
    public void setModuleGroups(ModuleGroupLstView newValue) throws ModelException ;
    public StudyProgramLstView getStudyPrograms()throws ModelException;
    public void setStudyPrograms(StudyProgramLstView newValue) throws ModelException ;
    public StudyGroupLstView getStudyGroups()throws ModelException;
    public void setStudyGroups(StudyGroupLstView newValue) throws ModelException ;
    public StudentServerLstView getStudents()throws ModelException;
    public void setStudents(StudentServerLstView newValue) throws ModelException ;
    
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
    
    public AdminServerConnection connectAdminServer(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException;
}

