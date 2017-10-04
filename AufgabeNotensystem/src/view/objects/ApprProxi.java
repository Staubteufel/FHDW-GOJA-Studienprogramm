package view.objects;

import view.*;
import viewClient.*;

public abstract class ApprProxi extends PrototypeProxi implements ApprView{
    
    public ApprProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public String getName()throws ModelException{
        return ((Appr)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((Appr)this.getTheObject()).setName(newValue);
    }
    public java.util.Vector<MarkHistoryEntryView> getMarkHistory()throws ModelException{
        return ((Appr)this.getTheObject()).getMarkHistory();
    }
    public void setMarkHistory(java.util.Vector<MarkHistoryEntryView> newValue) throws ModelException {
        ((Appr)this.getTheObject()).setMarkHistory(newValue);
    }
    public common.Fraction getCreditPoints()throws ModelException{
        return ((Appr)this.getTheObject()).getCreditPoints();
    }
    public void setCreditPoints(common.Fraction newValue) throws ModelException {
        ((Appr)this.getTheObject()).setCreditPoints(newValue);
    }
    
    
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
