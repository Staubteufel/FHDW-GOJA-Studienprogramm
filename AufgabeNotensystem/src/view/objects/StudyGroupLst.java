
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class StudyGroupLst extends ViewObject implements StudyGroupLstView{
    
    protected java.util.Vector<StudyGroupView> studyGroups;
    
    public StudyGroupLst(java.util.Vector<StudyGroupView> studyGroups,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.studyGroups = studyGroups;        
    }
    
    static public long getTypeId() {
        return 204;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<StudyGroupView> getStudyGroups()throws ModelException{
        return this.studyGroups;
    }
    public void setStudyGroups(java.util.Vector<StudyGroupView> newValue) throws ModelException {
        this.studyGroups = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleStudyGroupLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudyGroupLst(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudyGroupLst(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudyGroupLst(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> studyGroups = this.getStudyGroups();
        if (studyGroups != null) {
            ViewObject.resolveVectorProxies(studyGroups, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getStudyGroups().size()) return new StudyGroupsStudyGroupLstWrapper(this, originalIndex, (ViewRoot)this.getStudyGroups().get(index));
        index = index - this.getStudyGroups().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getStudyGroups().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getStudyGroups().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getStudyGroupsIterator = this.getStudyGroups().iterator();
        while(getStudyGroupsIterator.hasNext()){
            if(getStudyGroupsIterator.next().equals(child)) return result;
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
