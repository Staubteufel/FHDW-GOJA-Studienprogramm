package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ModuleWithoutUnitsLstProxi extends ViewProxi implements ModuleWithoutUnitsLstView{
    
    public ModuleWithoutUnitsLstProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ModuleWithoutUnitsLstView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> moduleWithoutUnits_string = (java.util.Vector<String>)resultTable.get("moduleWithoutUnits");
        java.util.Vector<ModuleWithoutUnitsView> moduleWithoutUnits = ViewProxi.getProxiVector(moduleWithoutUnits_string, connectionKey);
        ModuleWithoutUnitsLstView result$$ = new ModuleWithoutUnitsLst(moduleWithoutUnits, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getModuleWithoutUnits().size()) return new ModuleWithoutUnitsModuleWithoutUnitsLstWrapper(this, originalIndex, (ViewRoot)this.getModuleWithoutUnits().get(index));
        index = index - this.getModuleWithoutUnits().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getModuleWithoutUnits().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getModuleWithoutUnits().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getModuleWithoutUnitsIterator = this.getModuleWithoutUnits().iterator();
        while(getModuleWithoutUnitsIterator.hasNext()){
            if(getModuleWithoutUnitsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<ModuleWithoutUnitsView> getModuleWithoutUnits()throws ModelException{
        return ((ModuleWithoutUnitsLst)this.getTheObject()).getModuleWithoutUnits();
    }
    public void setModuleWithoutUnits(java.util.Vector<ModuleWithoutUnitsView> newValue) throws ModelException {
        ((ModuleWithoutUnitsLst)this.getTheObject()).setModuleWithoutUnits(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleModuleWithoutUnitsLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleWithoutUnitsLst(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleWithoutUnitsLst(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleWithoutUnitsLst(this);
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
