package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ModuleGroupProxi extends ApprProxi implements ModuleGroupView{
    
    public ModuleGroupProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ModuleGroupView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        java.util.Vector<String> markHistory_string = (java.util.Vector<String>)resultTable.get("markHistory");
        java.util.Vector<MarkHistoryEntryView> markHistory = ViewProxi.getProxiVector(markHistory_string, connectionKey);
        common.Fraction creditPoints = common.Fraction.parse((String)resultTable.get("creditPoints"));
        java.util.Vector<String> moduleGroups_string = (java.util.Vector<String>)resultTable.get("moduleGroups");
        java.util.Vector<ModuleGroupView> moduleGroups = ViewProxi.getProxiVector(moduleGroups_string, connectionKey);
        java.util.Vector<String> moduleWithUnits_string = (java.util.Vector<String>)resultTable.get("moduleWithUnits");
        java.util.Vector<ModuleWithUnitsView> moduleWithUnits = ViewProxi.getProxiVector(moduleWithUnits_string, connectionKey);
        java.util.Vector<String> moduleWithoutUnits_string = (java.util.Vector<String>)resultTable.get("moduleWithoutUnits");
        java.util.Vector<ModuleWithoutUnitsView> moduleWithoutUnits = ViewProxi.getProxiVector(moduleWithoutUnits_string, connectionKey);
        ModuleGroupView result$$ = new ModuleGroup((String)name,markHistory,(common.Fraction)creditPoints,moduleGroups,moduleWithUnits,moduleWithoutUnits, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getMarkHistory().size()) return new MarkHistoryApprWrapper(this, originalIndex, (ViewRoot)this.getMarkHistory().get(index));
        index = index - this.getMarkHistory().size();
        if(index < this.getModuleGroups().size()) return new ModuleGroupsModuleGroupWrapper(this, originalIndex, (ViewRoot)this.getModuleGroups().get(index));
        index = index - this.getModuleGroups().size();
        if(index < this.getModuleWithUnits().size()) return new ModuleWithUnitsModuleGroupWrapper(this, originalIndex, (ViewRoot)this.getModuleWithUnits().get(index));
        index = index - this.getModuleWithUnits().size();
        if(index < this.getModuleWithoutUnits().size()) return new ModuleWithoutUnitsModuleGroupWrapper(this, originalIndex, (ViewRoot)this.getModuleWithoutUnits().get(index));
        index = index - this.getModuleWithoutUnits().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMarkHistory().size())
            + (this.getModuleGroups().size())
            + (this.getModuleWithUnits().size())
            + (this.getModuleWithoutUnits().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getMarkHistory().size() == 0)
            && (this.getModuleGroups().size() == 0)
            && (this.getModuleWithUnits().size() == 0)
            && (this.getModuleWithoutUnits().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getMarkHistoryIterator = this.getMarkHistory().iterator();
        while(getMarkHistoryIterator.hasNext()){
            if(getMarkHistoryIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getModuleGroupsIterator = this.getModuleGroups().iterator();
        while(getModuleGroupsIterator.hasNext()){
            if(getModuleGroupsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getModuleWithUnitsIterator = this.getModuleWithUnits().iterator();
        while(getModuleWithUnitsIterator.hasNext()){
            if(getModuleWithUnitsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getModuleWithoutUnitsIterator = this.getModuleWithoutUnits().iterator();
        while(getModuleWithoutUnitsIterator.hasNext()){
            if(getModuleWithoutUnitsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<ModuleGroupView> getModuleGroups()throws ModelException{
        return ((ModuleGroup)this.getTheObject()).getModuleGroups();
    }
    public void setModuleGroups(java.util.Vector<ModuleGroupView> newValue) throws ModelException {
        ((ModuleGroup)this.getTheObject()).setModuleGroups(newValue);
    }
    public java.util.Vector<ModuleWithUnitsView> getModuleWithUnits()throws ModelException{
        return ((ModuleGroup)this.getTheObject()).getModuleWithUnits();
    }
    public void setModuleWithUnits(java.util.Vector<ModuleWithUnitsView> newValue) throws ModelException {
        ((ModuleGroup)this.getTheObject()).setModuleWithUnits(newValue);
    }
    public java.util.Vector<ModuleWithoutUnitsView> getModuleWithoutUnits()throws ModelException{
        return ((ModuleGroup)this.getTheObject()).getModuleWithoutUnits();
    }
    public void setModuleWithoutUnits(java.util.Vector<ModuleWithoutUnitsView> newValue) throws ModelException {
        ((ModuleGroup)this.getTheObject()).setModuleWithoutUnits(newValue);
    }
    
    public void accept(ApprVisitor visitor) throws ModelException {
        visitor.handleModuleGroup(this);
    }
    public <R> R accept(ApprReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleGroup(this);
    }
    public <E extends view.UserException>  void accept(ApprExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleGroup(this);
    }
    public <R, E extends view.UserException> R accept(ApprReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleGroup(this);
    }
    public void accept(PrototypeVisitor visitor) throws ModelException {
        visitor.handleModuleGroup(this);
    }
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleGroup(this);
    }
    public <E extends view.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleGroup(this);
    }
    public <R, E extends view.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleModuleGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleGroup(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleGroup(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleGroup(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
