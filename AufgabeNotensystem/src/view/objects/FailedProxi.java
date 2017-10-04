package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class FailedProxi extends BooleanMarkProxi implements FailedView{
    
    public FailedProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public FailedView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        FailedView result$$ = new Failed( this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
        return -1;
    }
    
    
    public void accept(BooleanMarkVisitor visitor) throws ModelException {
        visitor.handleFailed(this);
    }
    public <R> R accept(BooleanMarkReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleFailed(this);
    }
    public <E extends view.UserException>  void accept(BooleanMarkExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleFailed(this);
    }
    public <R, E extends view.UserException> R accept(BooleanMarkReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleFailed(this);
    }
    public void accept(MarkNotCalculableVisitor visitor) throws ModelException {
        visitor.handleFailed(this);
    }
    public <R> R accept(MarkNotCalculableReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleFailed(this);
    }
    public <E extends view.UserException>  void accept(MarkNotCalculableExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleFailed(this);
    }
    public <R, E extends view.UserException> R accept(MarkNotCalculableReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleFailed(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleFailed(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleFailed(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleFailed(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleFailed(this);
    }
    public void accept(MarkVisitor visitor) throws ModelException {
        visitor.handleFailed(this);
    }
    public <R> R accept(MarkReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleFailed(this);
    }
    public <E extends view.UserException>  void accept(MarkExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleFailed(this);
    }
    public <R, E extends view.UserException> R accept(MarkReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleFailed(this);
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
