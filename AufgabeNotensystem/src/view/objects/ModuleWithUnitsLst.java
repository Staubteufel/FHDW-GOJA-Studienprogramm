
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ModuleWithUnitsLst extends ViewObject implements ModuleWithUnitsLstView{
    
    protected java.util.Vector<ModuleWithUnitsView> moduleWithUnits;
    
    public ModuleWithUnitsLst(java.util.Vector<ModuleWithUnitsView> moduleWithUnits,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.moduleWithUnits = moduleWithUnits;        
    }
    
    static public long getTypeId() {
        return 206;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<ModuleWithUnitsView> getModuleWithUnits()throws ModelException{
        return this.moduleWithUnits;
    }
    public void setModuleWithUnits(java.util.Vector<ModuleWithUnitsView> newValue) throws ModelException {
        this.moduleWithUnits = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> moduleWithUnits = this.getModuleWithUnits();
        if (moduleWithUnits != null) {
            ViewObject.resolveVectorProxies(moduleWithUnits, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
