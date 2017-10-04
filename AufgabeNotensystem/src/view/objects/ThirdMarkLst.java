
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ThirdMarkLst extends ViewObject implements ThirdMarkLstView{
    
    protected java.util.Vector<ThirdMarkView> thirdMarks;
    
    public ThirdMarkLst(java.util.Vector<ThirdMarkView> thirdMarks,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.thirdMarks = thirdMarks;        
    }
    
    static public long getTypeId() {
        return 229;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<ThirdMarkView> getThirdMarks()throws ModelException{
        return this.thirdMarks;
    }
    public void setThirdMarks(java.util.Vector<ThirdMarkView> newValue) throws ModelException {
        this.thirdMarks = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> thirdMarks = this.getThirdMarks();
        if (thirdMarks != null) {
            ViewObject.resolveVectorProxies(thirdMarks, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
