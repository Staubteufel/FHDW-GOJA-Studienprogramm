
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ModuleGroupLst extends ViewObject implements ModuleGroupLstView{
    
    protected java.util.Vector<ModuleGroupView> moduleGroups;
    
    public ModuleGroupLst(java.util.Vector<ModuleGroupView> moduleGroups,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.moduleGroups = moduleGroups;        
    }
    
    static public long getTypeId() {
        return 205;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<ModuleGroupView> getModuleGroups()throws ModelException{
        return this.moduleGroups;
    }
    public void setModuleGroups(java.util.Vector<ModuleGroupView> newValue) throws ModelException {
        this.moduleGroups = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleModuleGroupLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleGroupLst(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleGroupLst(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleGroupLst(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> moduleGroups = this.getModuleGroups();
        if (moduleGroups != null) {
            ViewObject.resolveVectorProxies(moduleGroups, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getModuleGroups().size()) return new ModuleGroupsModuleGroupLstWrapper(this, originalIndex, (ViewRoot)this.getModuleGroups().get(index));
        index = index - this.getModuleGroups().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getModuleGroups().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getModuleGroups().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getModuleGroupsIterator = this.getModuleGroups().iterator();
        while(getModuleGroupsIterator.hasNext()){
            if(getModuleGroupsIterator.next().equals(child)) return result;
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
