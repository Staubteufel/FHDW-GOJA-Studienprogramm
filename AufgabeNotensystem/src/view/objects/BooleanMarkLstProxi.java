package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class BooleanMarkLstProxi extends ViewProxi implements BooleanMarkLstView{
    
    public BooleanMarkLstProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public BooleanMarkLstView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> booleanMarks_string = (java.util.Vector<String>)resultTable.get("booleanMarks");
        java.util.Vector<BooleanMarkView> booleanMarks = ViewProxi.getProxiVector(booleanMarks_string, connectionKey);
        BooleanMarkLstView result$$ = new BooleanMarkLst(booleanMarks, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getBooleanMarks().size()) return new BooleanMarksBooleanMarkLstWrapper(this, originalIndex, (ViewRoot)this.getBooleanMarks().get(index));
        index = index - this.getBooleanMarks().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getBooleanMarks().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getBooleanMarks().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getBooleanMarksIterator = this.getBooleanMarks().iterator();
        while(getBooleanMarksIterator.hasNext()){
            if(getBooleanMarksIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<BooleanMarkView> getBooleanMarks()throws ModelException{
        return ((BooleanMarkLst)this.getTheObject()).getBooleanMarks();
    }
    public void setBooleanMarks(java.util.Vector<BooleanMarkView> newValue) throws ModelException {
        ((BooleanMarkLst)this.getTheObject()).setBooleanMarks(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleBooleanMarkLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleBooleanMarkLst(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleBooleanMarkLst(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleBooleanMarkLst(this);
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
