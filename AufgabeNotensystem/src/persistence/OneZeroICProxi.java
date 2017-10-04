package persistence;



import model.visitor.*;

public class OneZeroICProxi extends ThirdMarkICProxi implements PersistentOneZero{
    
    public OneZeroICProxi(long objectId) {
        super(objectId);
    }
    public OneZeroICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theOneZeroFacade
            .getOneZero(this.getId());
    }
    
    public long getClassId() {
        return 225;
    }
    
    public PersistentOneZero getThis() throws PersistenceException {
        return ((PersistentOneZero)this.getTheObject()).getThis();
    }
    
    public void accept(ThirdMarkVisitor visitor) throws PersistenceException {
        visitor.handleOneZero(this);
    }
    public <R> R accept(ThirdMarkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleOneZero(this);
    }
    public <E extends model.UserException>  void accept(ThirdMarkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleOneZero(this);
    }
    public <R, E extends model.UserException> R accept(ThirdMarkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleOneZero(this);
    }
    public void accept(MarkCalculableVisitor visitor) throws PersistenceException {
        visitor.handleOneZero(this);
    }
    public <R> R accept(MarkCalculableReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleOneZero(this);
    }
    public <E extends model.UserException>  void accept(MarkCalculableExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleOneZero(this);
    }
    public <R, E extends model.UserException> R accept(MarkCalculableReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleOneZero(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleOneZero(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleOneZero(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleOneZero(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleOneZero(this);
    }
    public void accept(MarkVisitor visitor) throws PersistenceException {
        visitor.handleOneZero(this);
    }
    public <R> R accept(MarkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleOneZero(this);
    }
    public <E extends model.UserException>  void accept(MarkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleOneZero(this);
    }
    public <R, E extends model.UserException> R accept(MarkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleOneZero(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentOneZero)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentOneZero)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public Boolean fetchIsCalculable() 
				throws PersistenceException{
        return ((PersistentOneZero)this.getTheObject()).fetchIsCalculable();
    }
    public common.Fraction fetchMarkValue() 
				throws PersistenceException{
        return ((PersistentOneZero)this.getTheObject()).fetchMarkValue();
    }
    public String fetchTypeAsString() 
				throws PersistenceException{
        return ((PersistentOneZero)this.getTheObject()).fetchTypeAsString();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentOneZero)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentOneZero)this.getTheObject()).initializeOnInstantiation();
    }

    
}
