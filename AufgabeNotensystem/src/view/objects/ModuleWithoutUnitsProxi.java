package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ModuleWithoutUnitsProxi extends ApprProxi implements ModuleWithoutUnitsView{
    
    public ModuleWithoutUnitsProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ModuleWithoutUnitsView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        java.util.Vector<String> markHistory_string = (java.util.Vector<String>)resultTable.get("markHistory");
        java.util.Vector<MarkHistoryEntryView> markHistory = ViewProxi.getProxiVector(markHistory_string, connectionKey);
        common.Fraction creditPoints = common.Fraction.parse((String)resultTable.get("creditPoints"));
        ModuleWithoutUnitsView result$$ = new ModuleWithoutUnits((String)name,markHistory,(common.Fraction)creditPoints, this.getId(), this.getClassId());
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
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMarkHistory().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getMarkHistory().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getMarkHistoryIterator = this.getMarkHistory().iterator();
        while(getMarkHistoryIterator.hasNext()){
            if(getMarkHistoryIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    
    public void accept(ApprVisitor visitor) throws ModelException {
        visitor.handleModuleWithoutUnits(this);
    }
    public <R> R accept(ApprReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleWithoutUnits(this);
    }
    public <E extends view.UserException>  void accept(ApprExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleWithoutUnits(this);
    }
    public <R, E extends view.UserException> R accept(ApprReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleWithoutUnits(this);
    }
    public void accept(PrototypeVisitor visitor) throws ModelException {
        visitor.handleModuleWithoutUnits(this);
    }
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleWithoutUnits(this);
    }
    public <E extends view.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleWithoutUnits(this);
    }
    public <R, E extends view.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleWithoutUnits(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleModuleWithoutUnits(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleWithoutUnits(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleWithoutUnits(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleWithoutUnits(this);
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
