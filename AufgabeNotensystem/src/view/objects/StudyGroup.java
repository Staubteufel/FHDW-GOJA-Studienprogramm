
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class StudyGroup extends view.objects.Prototype implements StudyGroupView{
    
    protected String name;
    protected java.util.Vector<StudentServerView> students;
    protected StudyProgramView assignedTo;
    
    public StudyGroup(String name,java.util.Vector<StudentServerView> students,StudyProgramView assignedTo,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.name = name;
        this.students = students;
        this.assignedTo = assignedTo;        
    }
    
    static public long getTypeId() {
        return 111;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getName()throws ModelException{
        return this.name;
    }
    public void setName(String newValue) throws ModelException {
        this.name = newValue;
    }
    public java.util.Vector<StudentServerView> getStudents()throws ModelException{
        return this.students;
    }
    public void setStudents(java.util.Vector<StudentServerView> newValue) throws ModelException {
        this.students = newValue;
    }
    public StudyProgramView getAssignedTo()throws ModelException{
        return this.assignedTo;
    }
    public void setAssignedTo(StudyProgramView newValue) throws ModelException {
        this.assignedTo = newValue;
    }
    
    public void accept(PrototypeVisitor visitor) throws ModelException {
        visitor.handleStudyGroup(this);
    }
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudyGroup(this);
    }
    public <E extends view.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudyGroup(this);
    }
    public <R, E extends view.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudyGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleStudyGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudyGroup(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudyGroup(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudyGroup(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> students = this.getStudents();
        if (students != null) {
            ViewObject.resolveVectorProxies(students, resultTable);
        }
        StudyProgramView assignedTo = this.getAssignedTo();
        if (assignedTo != null) {
            ((ViewProxi)assignedTo).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(assignedTo.getClassId(), assignedTo.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getStudents().size()) return new StudentsStudyGroupWrapper(this, originalIndex, (ViewRoot)this.getStudents().get(index));
        index = index - this.getStudents().size();
        if(index == 0 && this.getAssignedTo() != null) return new AssignedToStudyGroupWrapper(this, originalIndex, (ViewRoot)this.getAssignedTo());
        if(this.getAssignedTo() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getStudents().size())
            + (this.getAssignedTo() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getStudents().size() == 0)
            && (this.getAssignedTo() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getStudentsIterator = this.getStudents().iterator();
        while(getStudentsIterator.hasNext()){
            if(getStudentsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        if(this.getAssignedTo() != null && this.getAssignedTo().equals(child)) return result;
        if(this.getAssignedTo() != null) result = result + 1;
        return -1;
    }
    public int getNameIndex() throws ModelException {
        return 0;
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "name";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getName();
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
