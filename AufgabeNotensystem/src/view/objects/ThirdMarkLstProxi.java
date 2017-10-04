package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ThirdMarkLstProxi extends ViewProxi implements ThirdMarkLstView{
    
    public ThirdMarkLstProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ThirdMarkLstView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> thirdMarks_string = (java.util.Vector<String>)resultTable.get("thirdMarks");
        java.util.Vector<ThirdMarkView> thirdMarks = ViewProxi.getProxiVector(thirdMarks_string, connectionKey);
        ThirdMarkLstView result$$ = new ThirdMarkLst(thirdMarks, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getThirdMarks().size()) return new ThirdMarksThirdMarkLstWrapper(this, originalIndex, (ViewRoot)this.getThirdMarks().get(index));
        index = index - this.getThirdMarks().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getThirdMarks().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getThirdMarks().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getThirdMarksIterator = this.getThirdMarks().iterator();
        while(getThirdMarksIterator.hasNext()){
            if(getThirdMarksIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<ThirdMarkView> getThirdMarks()throws ModelException{
        return ((ThirdMarkLst)this.getTheObject()).getThirdMarks();
    }
    public void setThirdMarks(java.util.Vector<ThirdMarkView> newValue) throws ModelException {
        ((ThirdMarkLst)this.getTheObject()).setThirdMarks(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleThirdMarkLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleThirdMarkLst(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleThirdMarkLst(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleThirdMarkLst(this);
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
