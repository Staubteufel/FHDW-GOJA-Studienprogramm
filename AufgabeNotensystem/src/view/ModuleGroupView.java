package view;

import view.visitor.*;

public interface ModuleGroupView extends ApprView {
    
    public java.util.Vector<ModuleGroupView> getModuleGroups()throws ModelException;
    public void setModuleGroups(java.util.Vector<ModuleGroupView> newValue) throws ModelException ;
    public java.util.Vector<ModuleWithUnitsView> getModuleWithUnits()throws ModelException;
    public void setModuleWithUnits(java.util.Vector<ModuleWithUnitsView> newValue) throws ModelException ;
    public java.util.Vector<ModuleWithoutUnitsView> getModuleWithoutUnits()throws ModelException;
    public void setModuleWithoutUnits(java.util.Vector<ModuleWithoutUnitsView> newValue) throws ModelException ;
    
    public void accept(ApprVisitor visitor) throws ModelException;
    public <R> R accept(ApprReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(ApprExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(ApprReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(PrototypeVisitor visitor) throws ModelException;
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}
