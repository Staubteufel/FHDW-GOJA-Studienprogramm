
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class UnitLst extends ViewObject implements UnitLstView{
    
    protected java.util.Vector<UnitView> units;
    
    public UnitLst(java.util.Vector<UnitView> units,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.units = units;        
    }
    
    static public long getTypeId() {
        return 203;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<UnitView> getUnits()throws ModelException{
        return this.units;
    }
    public void setUnits(java.util.Vector<UnitView> newValue) throws ModelException {
        this.units = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleUnitLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnitLst(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnitLst(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnitLst(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> units = this.getUnits();
        if (units != null) {
            ViewObject.resolveVectorProxies(units, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getUnits().size()) return new UnitsUnitLstWrapper(this, originalIndex, (ViewRoot)this.getUnits().get(index));
        index = index - this.getUnits().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getUnits().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getUnits().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getUnitsIterator = this.getUnits().iterator();
        while(getUnitsIterator.hasNext()){
            if(getUnitsIterator.next().equals(child)) return result;
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
