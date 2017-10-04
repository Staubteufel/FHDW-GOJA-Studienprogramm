package persistence;



import model.visitor.*;

public class NoneMarkICProxi extends MarkNotCalculableICProxi implements PersistentNoneMark{
    
    public NoneMarkICProxi(long objectId) {
        super(objectId);
    }
    public NoneMarkICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theNoneMarkFacade
            .getNoneMark(this.getId());
    }
    
    public long getClassId() {
        return 115;
    }
    
    public PersistentNoneMark getThis() throws PersistenceException {
        return ((PersistentNoneMark)this.getTheObject()).getThis();
    }
    
    public void accept(MarkNotCalculableVisitor visitor) throws PersistenceException {
        visitor.handleNoneMark(this);
    }
    public <R> R accept(MarkNotCalculableReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoneMark(this);
    }
    public <E extends model.UserException>  void accept(MarkNotCalculableExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoneMark(this);
    }
    public <R, E extends model.UserException> R accept(MarkNotCalculableReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoneMark(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNoneMark(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoneMark(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoneMark(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoneMark(this);
    }
    public void accept(MarkVisitor visitor) throws PersistenceException {
        visitor.handleNoneMark(this);
    }
    public <R> R accept(MarkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoneMark(this);
    }
    public <E extends model.UserException>  void accept(MarkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoneMark(this);
    }
    public <R, E extends model.UserException> R accept(MarkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoneMark(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentNoneMark)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentNoneMark)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public Boolean fetchIsCalculable() 
				throws PersistenceException{
        return ((PersistentNoneMark)this.getTheObject()).fetchIsCalculable();
    }
    public common.Fraction fetchMarkValue() 
				throws PersistenceException{
        return ((PersistentNoneMark)this.getTheObject()).fetchMarkValue();
    }
    public String fetchTypeAsString() 
				throws PersistenceException{
        return ((PersistentNoneMark)this.getTheObject()).fetchTypeAsString();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentNoneMark)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentNoneMark)this.getTheObject()).initializeOnInstantiation();
    }

    
}
