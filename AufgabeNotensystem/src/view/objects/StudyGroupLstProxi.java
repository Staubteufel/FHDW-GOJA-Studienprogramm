package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class StudyGroupLstProxi extends ViewProxi implements StudyGroupLstView{
    
    public StudyGroupLstProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public StudyGroupLstView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> studyGroups_string = (java.util.Vector<String>)resultTable.get("studyGroups");
        java.util.Vector<StudyGroupView> studyGroups = ViewProxi.getProxiVector(studyGroups_string, connectionKey);
        StudyGroupLstView result$$ = new StudyGroupLst(studyGroups, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
        if (this.object == null) return this.getLeafInfo() == 0;
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
    
    public java.util.Vector<StudyGroupView> getStudyGroups()throws ModelException{
        return ((StudyGroupLst)this.getTheObject()).getStudyGroups();
    }
    public void setStudyGroups(java.util.Vector<StudyGroupView> newValue) throws ModelException {
        ((StudyGroupLst)this.getTheObject()).setStudyGroups(newValue);
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
