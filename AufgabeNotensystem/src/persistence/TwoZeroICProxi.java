package persistence;



import model.visitor.*;

public class TwoZeroICProxi extends ThirdMarkICProxi implements PersistentTwoZero{
    
    public TwoZeroICProxi(long objectId) {
        super(objectId);
    }
    public TwoZeroICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theTwoZeroFacade
            .getTwoZero(this.getId());
    }
    
    public long getClassId() {
        return 216;
    }
    
    public PersistentTwoZero getThis() throws PersistenceException {
        return ((PersistentTwoZero)this.getTheObject()).getThis();
    }
    
    public void accept(ThirdMarkVisitor visitor) throws PersistenceException {
        visitor.handleTwoZero(this);
    }
    public <R> R accept(ThirdMarkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTwoZero(this);
    }
    public <E extends model.UserException>  void accept(ThirdMarkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTwoZero(this);
    }
    public <R, E extends model.UserException> R accept(ThirdMarkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTwoZero(this);
    }
    public void accept(MarkCalculableVisitor visitor) throws PersistenceException {
        visitor.handleTwoZero(this);
    }
    public <R> R accept(MarkCalculableReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTwoZero(this);
    }
    public <E extends model.UserException>  void accept(MarkCalculableExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTwoZero(this);
    }
    public <R, E extends model.UserException> R accept(MarkCalculableReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTwoZero(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTwoZero(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTwoZero(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTwoZero(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTwoZero(this);
    }
    public void accept(MarkVisitor visitor) throws PersistenceException {
        visitor.handleTwoZero(this);
    }
    public <R> R accept(MarkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTwoZero(this);
    }
    public <E extends model.UserException>  void accept(MarkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTwoZero(this);
    }
    public <R, E extends model.UserException> R accept(MarkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTwoZero(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTwoZero)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTwoZero)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public Boolean fetchIsCalculable() 
				throws PersistenceException{
        return ((PersistentTwoZero)this.getTheObject()).fetchIsCalculable();
    }
    public common.Fraction fetchMarkValue() 
				throws PersistenceException{
        return ((PersistentTwoZero)this.getTheObject()).fetchMarkValue();
    }
    public String fetchTypeAsString() 
				throws PersistenceException{
        return ((PersistentTwoZero)this.getTheObject()).fetchTypeAsString();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTwoZero)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTwoZero)this.getTheObject()).initializeOnInstantiation();
    }

    
}
