package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class StudyProgramProxi extends ApprProxi implements StudyProgramView{
    
    public StudyProgramProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public StudyProgramView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        java.util.Vector<String> markHistory_string = (java.util.Vector<String>)resultTable.get("markHistory");
        java.util.Vector<MarkHistoryEntryView> markHistory = ViewProxi.getProxiVector(markHistory_string, connectionKey);
        common.Fraction creditPoints = common.Fraction.parse((String)resultTable.get("creditPoints"));
        java.util.Vector<String> moduleGroups_string = (java.util.Vector<String>)resultTable.get("moduleGroups");
        java.util.Vector<ModuleGroupView> moduleGroups = ViewProxi.getProxiVector(moduleGroups_string, connectionKey);
        StudyProgramView result$$ = new StudyProgram((String)name,markHistory,(common.Fraction)creditPoints,moduleGroups, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
        if (this.object == null) return this.getLeafInfo() == 0;
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
    
    public java.util.Vector<ModuleGroupView> getModuleGroups()throws ModelException{
        return ((StudyProgram)this.getTheObject()).getModuleGroups();
    }
    public void setModuleGroups(java.util.Vector<ModuleGroupView> newValue) throws ModelException {
        ((StudyProgram)this.getTheObject()).setModuleGroups(newValue);
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
