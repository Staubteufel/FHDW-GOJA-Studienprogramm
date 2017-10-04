package persistence;



import model.visitor.*;

public class BooleanMarkProxi extends MarkNotCalculableProxi implements PersistentBooleanMark{
    
    public BooleanMarkProxi(long objectId) {
        super(objectId);
    }
    public BooleanMarkProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 119;
    }
    
    public PersistentBooleanMark getThis() throws PersistenceException {
        return ((PersistentBooleanMark)this.getTheObject()).getThis();
    }
    
    public void accept(BooleanMarkVisitor visitor) throws PersistenceException {
        visitor.handleBooleanMark(this);
    }
    public <R> R accept(BooleanMarkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBooleanMark(this);
    }
    public <E extends model.UserException>  void accept(BooleanMarkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBooleanMark(this);
    }
    public <R, E extends model.UserException> R accept(BooleanMarkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBooleanMark(this);
    }
    public void accept(MarkNotCalculableVisitor visitor) throws PersistenceException {
        visitor.handleBooleanMark(this);
    }
    public <R> R accept(MarkNotCalculableReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBooleanMark(this);
    }
    public <E extends model.UserException>  void accept(MarkNotCalculableExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBooleanMark(this);
    }
    public <R, E extends model.UserException> R accept(MarkNotCalculableReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBooleanMark(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBooleanMark(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBooleanMark(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBooleanMark(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBooleanMark(this);
    }
    public void accept(MarkVisitor visitor) throws PersistenceException {
        visitor.handleBooleanMark(this);
    }
    public <R> R accept(MarkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBooleanMark(this);
    }
    public <E extends model.UserException>  void accept(MarkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBooleanMark(this);
    }
    public <R, E extends model.UserException> R accept(MarkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBooleanMark(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentBooleanMark)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentBooleanMark)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public Boolean fetchIsCalculable() 
				throws PersistenceException{
        return ((PersistentBooleanMark)this.getTheObject()).fetchIsCalculable();
    }
    public common.Fraction fetchMarkValue() 
				throws PersistenceException{
        return ((PersistentBooleanMark)this.getTheObject()).fetchMarkValue();
    }
    public String fetchTypeAsString() 
				throws PersistenceException{
        return ((PersistentBooleanMark)this.getTheObject()).fetchTypeAsString();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentBooleanMark)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentBooleanMark)this.getTheObject()).initializeOnInstantiation();
    }

    
}
