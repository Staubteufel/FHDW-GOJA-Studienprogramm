
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class BooleanMarkLst extends ViewObject implements BooleanMarkLstView{
    
    protected java.util.Vector<BooleanMarkView> booleanMarks;
    
    public BooleanMarkLst(java.util.Vector<BooleanMarkView> booleanMarks,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.booleanMarks = booleanMarks;        
    }
    
    static public long getTypeId() {
        return 233;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<BooleanMarkView> getBooleanMarks()throws ModelException{
        return this.booleanMarks;
    }
    public void setBooleanMarks(java.util.Vector<BooleanMarkView> newValue) throws ModelException {
        this.booleanMarks = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> booleanMarks = this.getBooleanMarks();
        if (booleanMarks != null) {
            ViewObject.resolveVectorProxies(booleanMarks, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
    public int getRowCount(){
        return 0 ;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
            } else {
            }
            throw new ModelException("Table index out of bounds!", -1);
        } catch (ModelException e){
            return e.getMessage();
        }
    }
    
    public boolean isRowEditable(int index){
        return true;
    }
    public void setValueAt(String newValue, int rowIndex) throws Exception {
        
    }
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public javafx.scene.image.Image getImage() {
        return super.getImage();
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
