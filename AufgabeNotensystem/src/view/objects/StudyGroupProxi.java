package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class StudyGroupProxi extends PrototypeProxi implements StudyGroupView{
    
    public StudyGroupProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public StudyGroupView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        java.util.Vector<String> students_string = (java.util.Vector<String>)resultTable.get("students");
        java.util.Vector<StudentServerView> students = ViewProxi.getProxiVector(students_string, connectionKey);
        ViewProxi assignedTo = null;
        String assignedTo$String = (String)resultTable.get("assignedTo");
        if (assignedTo$String != null) {
            common.ProxiInformation assignedTo$Info = common.RPCConstantsAndServices.createProxiInformation(assignedTo$String);
            assignedTo = view.objects.ViewProxi.createProxi(assignedTo$Info,connectionKey);
            assignedTo.setToString(assignedTo$Info.getToString());
        }
        StudyGroupView result$$ = new StudyGroup((String)name,students,(StudyProgramView)assignedTo, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
        if (this.object == null) return this.getLeafInfo() == 0;
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
    
    public String getName()throws ModelException{
        return ((StudyGroup)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((StudyGroup)this.getTheObject()).setName(newValue);
    }
    public java.util.Vector<StudentServerView> getStudents()throws ModelException{
        return ((StudyGroup)this.getTheObject()).getStudents();
    }
    public void setStudents(java.util.Vector<StudentServerView> newValue) throws ModelException {
        ((StudyGroup)this.getTheObject()).setStudents(newValue);
    }
    public StudyProgramView getAssignedTo()throws ModelException{
        return ((StudyGroup)this.getTheObject()).getAssignedTo();
    }
    public void setAssignedTo(StudyProgramView newValue) throws ModelException {
        ((StudyGroup)this.getTheObject()).setAssignedTo(newValue);
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
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
