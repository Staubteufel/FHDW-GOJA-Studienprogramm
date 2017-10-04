package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class StudyProgramLstProxi extends ViewProxi implements StudyProgramLstView{
    
    public StudyProgramLstProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public StudyProgramLstView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> studyPrograms_string = (java.util.Vector<String>)resultTable.get("studyPrograms");
        java.util.Vector<StudyProgramView> studyPrograms = ViewProxi.getProxiVector(studyPrograms_string, connectionKey);
        StudyProgramLstView result$$ = new StudyProgramLst(studyPrograms, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
        if (this.object == null) return this.getLeafInfo() == 0;
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
    
    public java.util.Vector<StudyProgramView> getStudyPrograms()throws ModelException{
        return ((StudyProgramLst)this.getTheObject()).getStudyPrograms();
    }
    public void setStudyPrograms(java.util.Vector<StudyProgramView> newValue) throws ModelException {
        ((StudyProgramLst)this.getTheObject()).setStudyPrograms(newValue);
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
