
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class StudyProgram extends view.objects.Appr implements StudyProgramView{
    
    protected java.util.Vector<ModuleGroupView> moduleGroups;
    
    public StudyProgram(String name,java.util.Vector<MarkHistoryEntryView> markHistory,common.Fraction creditPoints,java.util.Vector<ModuleGroupView> moduleGroups,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((String)name,markHistory,(common.Fraction)creditPoints,id, classId);
        this.moduleGroups = moduleGroups;        
    }
    
    static public long getTypeId() {
        return 116;
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
    
    public void accept(ApprVisitor visitor) throws ModelException {
        visitor.handleStudyProgram(this);
    }
    public <R> R accept(ApprReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudyProgram(this);
    }
    public <E extends view.UserException>  void accept(ApprExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudyProgram(this);
    }
    public <R, E extends view.UserException> R accept(ApprReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudyProgram(this);
    }
    public void accept(PrototypeVisitor visitor) throws ModelException {
        visitor.handleStudyProgram(this);
    }
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudyProgram(this);
    }
    public <E extends view.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudyProgram(this);
    }
    public <R, E extends view.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudyProgram(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleStudyProgram(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudyProgram(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudyProgram(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudyProgram(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> markHistory = this.getMarkHistory();
        if (markHistory != null) {
            ViewObject.resolveVectorProxies(markHistory, resultTable);
        }
        java.util.Vector<?> moduleGroups = this.getModuleGroups();
        if (moduleGroups != null) {
            ViewObject.resolveVectorProxies(moduleGroups, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getMarkHistory().size()) return new MarkHistoryApprWrapper(this, originalIndex, (ViewRoot)this.getMarkHistory().get(index));
        index = index - this.getMarkHistory().size();
        if(index < this.getModuleGroups().size()) return new ModuleGroupsStudyProgramWrapper(this, originalIndex, (ViewRoot)this.getModuleGroups().get(index));
        index = index - this.getModuleGroups().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMarkHistory().size())
            + (this.getModuleGroups().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getMarkHistory().size() == 0)
            && (this.getModuleGroups().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getMarkHistoryIterator = this.getMarkHistory().iterator();
        while(getMarkHistoryIterator.hasNext()){
            if(getMarkHistoryIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getModuleGroupsIterator = this.getModuleGroups().iterator();
        while(getModuleGroupsIterator.hasNext()){
            if(getModuleGroupsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    public int getNameIndex() throws ModelException {
        return 0;
    }
    public int getCreditPointsIndex() throws ModelException {
        return 0 + 1 + this.getMarkHistory().size();
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "name";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "creditPoints";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getName();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getCreditPoints();
                rowIndex = rowIndex - 1;
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
        if(rowIndex == 0){
            this.setName(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setCreditPoints(common.Fraction.parse(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
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
