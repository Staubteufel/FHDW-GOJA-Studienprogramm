package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class NoneMarkProxi extends MarkNotCalculableProxi implements NoneMarkView{
    
    public NoneMarkProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public NoneMarkView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        NoneMarkView result$$ = new NoneMark( this.getId(), this.getClassId());
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
    
    
    public void accept(MarkNotCalculableVisitor visitor) throws ModelException {
        visitor.handleNoneMark(this);
    }
    public <R> R accept(MarkNotCalculableReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNoneMark(this);
    }
    public <E extends view.UserException>  void accept(MarkNotCalculableExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNoneMark(this);
    }
    public <R, E extends view.UserException> R accept(MarkNotCalculableReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNoneMark(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleNoneMark(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNoneMark(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNoneMark(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNoneMark(this);
    }
    public void accept(MarkVisitor visitor) throws ModelException {
        visitor.handleNoneMark(this);
    }
    public <R> R accept(MarkReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNoneMark(this);
    }
    public <E extends view.UserException>  void accept(MarkExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNoneMark(this);
    }
    public <R, E extends view.UserException> R accept(MarkReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNoneMark(this);
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
