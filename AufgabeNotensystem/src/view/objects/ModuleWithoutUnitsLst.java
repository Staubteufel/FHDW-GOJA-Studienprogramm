
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ModuleWithoutUnitsLst extends ViewObject implements ModuleWithoutUnitsLstView{
    
    protected java.util.Vector<ModuleWithoutUnitsView> moduleWithoutUnits;
    
    public ModuleWithoutUnitsLst(java.util.Vector<ModuleWithoutUnitsView> moduleWithoutUnits,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.moduleWithoutUnits = moduleWithoutUnits;        
    }
    
    static public long getTypeId() {
        return 209;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<ModuleWithoutUnitsView> getModuleWithoutUnits()throws ModelException{
        return this.moduleWithoutUnits;
    }
    public void setModuleWithoutUnits(java.util.Vector<ModuleWithoutUnitsView> newValue) throws ModelException {
        this.moduleWithoutUnits = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> moduleWithoutUnits = this.getModuleWithoutUnits();
        if (moduleWithoutUnits != null) {
            ViewObject.resolveVectorProxies(moduleWithoutUnits, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
