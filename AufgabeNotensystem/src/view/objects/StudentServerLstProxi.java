package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class StudentServerLstProxi extends ViewProxi implements StudentServerLstView{
    
    public StudentServerLstProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public StudentServerLstView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> studentServers_string = (java.util.Vector<String>)resultTable.get("studentServers");
        java.util.Vector<StudentServerView> studentServers = ViewProxi.getProxiVector(studentServers_string, connectionKey);
        StudentServerLstView result$$ = new StudentServerLst(studentServers, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
        if (this.object == null) return this.getLeafInfo() == 0;
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
    
    public java.util.Vector<StudentServerView> getStudentServers()throws ModelException{
        return ((StudentServerLst)this.getTheObject()).getStudentServers();
    }
    public void setStudentServers(java.util.Vector<StudentServerView> newValue) throws ModelException {
        ((StudentServerLst)this.getTheObject()).setStudentServers(newValue);
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
