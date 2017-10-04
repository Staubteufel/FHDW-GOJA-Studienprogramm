
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class StudyProgramLst extends ViewObject implements StudyProgramLstView{
    
    protected java.util.Vector<StudyProgramView> studyPrograms;
    
    public StudyProgramLst(java.util.Vector<StudyProgramView> studyPrograms,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.studyPrograms = studyPrograms;        
    }
    
    static public long getTypeId() {
        return 207;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<StudyProgramView> getStudyPrograms()throws ModelException{
        return this.studyPrograms;
    }
    public void setStudyPrograms(java.util.Vector<StudyProgramView> newValue) throws ModelException {
        this.studyPrograms = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleStudyProgramLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudyProgramLst(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudyProgramLst(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudyProgramLst(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> studyPrograms = this.getStudyPrograms();
        if (studyPrograms != null) {
            ViewObject.resolveVectorProxies(studyPrograms, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getStudyPrograms().size()) return new StudyProgramsStudyProgramLstWrapper(this, originalIndex, (ViewRoot)this.getStudyPrograms().get(index));
        index = index - this.getStudyPrograms().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getStudyPrograms().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getStudyPrograms().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getStudyProgramsIterator = this.getStudyPrograms().iterator();
        while(getStudyProgramsIterator.hasNext()){
            if(getStudyProgramsIterator.next().equals(child)) return result;
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
