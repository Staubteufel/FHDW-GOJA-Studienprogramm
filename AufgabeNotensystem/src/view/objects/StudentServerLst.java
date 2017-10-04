
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class StudentServerLst extends ViewObject implements StudentServerLstView{
    
    protected java.util.Vector<StudentServerView> studentServers;
    
    public StudentServerLst(java.util.Vector<StudentServerView> studentServers,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.studentServers = studentServers;        
    }
    
    static public long getTypeId() {
        return 228;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<StudentServerView> getStudentServers()throws ModelException{
        return this.studentServers;
    }
    public void setStudentServers(java.util.Vector<StudentServerView> newValue) throws ModelException {
        this.studentServers = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleStudentServerLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudentServerLst(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudentServerLst(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudentServerLst(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> studentServers = this.getStudentServers();
        if (studentServers != null) {
            ViewObject.resolveVectorProxies(studentServers, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getStudentServers().size()) return new StudentServersStudentServerLstWrapper(this, originalIndex, (ViewRoot)this.getStudentServers().get(index));
        index = index - this.getStudentServers().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getStudentServers().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getStudentServers().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getStudentServersIterator = this.getStudentServers().iterator();
        while(getStudentServersIterator.hasNext()){
            if(getStudentServersIterator.next().equals(child)) return result;
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
