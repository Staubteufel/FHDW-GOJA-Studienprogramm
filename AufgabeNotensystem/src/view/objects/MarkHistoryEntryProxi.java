package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class MarkHistoryEntryProxi extends ViewProxi implements MarkHistoryEntryView{
    
    public MarkHistoryEntryProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public MarkHistoryEntryView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi mark = null;
        String mark$String = (String)resultTable.get("mark");
        if (mark$String != null) {
            common.ProxiInformation mark$Info = common.RPCConstantsAndServices.createProxiInformation(mark$String);
            mark = view.objects.ViewProxi.createProxi(mark$Info,connectionKey);
            mark.setToString(mark$Info.getToString());
        }
        String comment = (String)resultTable.get("comment");
        java.util.Date timestamp = (java.util.Date)resultTable.get("timestamp");
        MarkHistoryEntryView result$$ = new MarkHistoryEntry((Mark)mark,(String)comment,(java.util.Date)timestamp, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getMark() != null) return new MarkMarkHistoryEntryWrapper(this, originalIndex, (ViewRoot)this.getMark());
        if(this.getMark() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMark() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getMark() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMark() != null && this.getMark().equals(child)) return result;
        if(this.getMark() != null) result = result + 1;
        return -1;
    }
    
    public Mark getMark()throws ModelException{
        return ((MarkHistoryEntry)this.getTheObject()).getMark();
    }
    public void setMark(Mark newValue) throws ModelException {
        ((MarkHistoryEntry)this.getTheObject()).setMark(newValue);
    }
    public String getComment()throws ModelException{
        return ((MarkHistoryEntry)this.getTheObject()).getComment();
    }
    public void setComment(String newValue) throws ModelException {
        ((MarkHistoryEntry)this.getTheObject()).setComment(newValue);
    }
    public java.util.Date getTimestamp()throws ModelException{
        return ((MarkHistoryEntry)this.getTheObject()).getTimestamp();
    }
    public void setTimestamp(java.util.Date newValue) throws ModelException {
        ((MarkHistoryEntry)this.getTheObject()).setTimestamp(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMarkHistoryEntry(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMarkHistoryEntry(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMarkHistoryEntry(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMarkHistoryEntry(this);
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
