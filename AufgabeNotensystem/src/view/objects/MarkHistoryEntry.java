
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class MarkHistoryEntry extends ViewObject implements MarkHistoryEntryView{
    
    protected Mark mark;
    protected String comment;
    protected java.util.Date timestamp;
    
    public MarkHistoryEntry(Mark mark,String comment,java.util.Date timestamp,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.mark = mark;
        this.comment = comment;
        this.timestamp = timestamp;        
    }
    
    static public long getTypeId() {
        return 121;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public Mark getMark()throws ModelException{
        return this.mark;
    }
    public void setMark(Mark newValue) throws ModelException {
        this.mark = newValue;
    }
    public String getComment()throws ModelException{
        return this.comment;
    }
    public void setComment(String newValue) throws ModelException {
        this.comment = newValue;
    }
    public java.util.Date getTimestamp()throws ModelException{
        return this.timestamp;
    }
    public void setTimestamp(java.util.Date newValue) throws ModelException {
        this.timestamp = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        Mark mark = this.getMark();
        if (mark != null) {
            ((ViewProxi)mark).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(mark.getClassId(), mark.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
        return true 
            && (this.getMark() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMark() != null && this.getMark().equals(child)) return result;
        if(this.getMark() != null) result = result + 1;
        return -1;
    }
    public int getCommentIndex() throws ModelException {
        return 0 + (this.getMark() == null ? 0 : 1);
    }
    public int getTimestampIndex() throws ModelException {
        return 0 + (this.getMark() == null ? 0 : 1) + 1;
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "comment";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "timestamp";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getComment();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return ViewRoot.toString(getTimestamp(), true );
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
            this.setComment(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setTimestamp(new java.text.SimpleDateFormat(TIMESTAMPFORMAT).parse(newValue));
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
