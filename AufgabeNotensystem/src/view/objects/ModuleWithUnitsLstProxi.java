package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ModuleWithUnitsLstProxi extends ViewProxi implements ModuleWithUnitsLstView{
    
    public ModuleWithUnitsLstProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ModuleWithUnitsLstView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> moduleWithUnits_string = (java.util.Vector<String>)resultTable.get("moduleWithUnits");
        java.util.Vector<ModuleWithUnitsView> moduleWithUnits = ViewProxi.getProxiVector(moduleWithUnits_string, connectionKey);
        ModuleWithUnitsLstView result$$ = new ModuleWithUnitsLst(moduleWithUnits, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getModuleWithUnits().size()) return new ModuleWithUnitsModuleWithUnitsLstWrapper(this, originalIndex, (ViewRoot)this.getModuleWithUnits().get(index));
        index = index - this.getModuleWithUnits().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getModuleWithUnits().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getModuleWithUnits().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getModuleWithUnitsIterator = this.getModuleWithUnits().iterator();
        while(getModuleWithUnitsIterator.hasNext()){
            if(getModuleWithUnitsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<ModuleWithUnitsView> getModuleWithUnits()throws ModelException{
        return ((ModuleWithUnitsLst)this.getTheObject()).getModuleWithUnits();
    }
    public void setModuleWithUnits(java.util.Vector<ModuleWithUnitsView> newValue) throws ModelException {
        ((ModuleWithUnitsLst)this.getTheObject()).setModuleWithUnits(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleModuleWithUnitsLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleWithUnitsLst(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleWithUnitsLst(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleWithUnitsLst(this);
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
