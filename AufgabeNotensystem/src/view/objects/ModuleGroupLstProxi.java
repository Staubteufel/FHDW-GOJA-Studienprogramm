package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ModuleGroupLstProxi extends ViewProxi implements ModuleGroupLstView{
    
    public ModuleGroupLstProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ModuleGroupLstView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> moduleGroups_string = (java.util.Vector<String>)resultTable.get("moduleGroups");
        java.util.Vector<ModuleGroupView> moduleGroups = ViewProxi.getProxiVector(moduleGroups_string, connectionKey);
        ModuleGroupLstView result$$ = new ModuleGroupLst(moduleGroups, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getModuleGroups().size()) return new ModuleGroupsModuleGroupLstWrapper(this, originalIndex, (ViewRoot)this.getModuleGroups().get(index));
        index = index - this.getModuleGroups().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getModuleGroups().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getModuleGroups().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getModuleGroupsIterator = this.getModuleGroups().iterator();
        while(getModuleGroupsIterator.hasNext()){
            if(getModuleGroupsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<ModuleGroupView> getModuleGroups()throws ModelException{
        return ((ModuleGroupLst)this.getTheObject()).getModuleGroups();
    }
    public void setModuleGroups(java.util.Vector<ModuleGroupView> newValue) throws ModelException {
        ((ModuleGroupLst)this.getTheObject()).setModuleGroups(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleModuleGroupLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleGroupLst(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleGroupLst(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleGroupLst(this);
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
