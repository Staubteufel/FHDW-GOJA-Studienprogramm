package persistence;



import model.visitor.*;

public class ThirdMarkProxi extends MarkCalculableProxi implements PersistentThirdMark{
    
    public ThirdMarkProxi(long objectId) {
        super(objectId);
    }
    public ThirdMarkProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 124;
    }
    
    public PersistentThirdMark getThis() throws PersistenceException {
        return ((PersistentThirdMark)this.getTheObject()).getThis();
    }
    
    public void accept(ThirdMarkVisitor visitor) throws PersistenceException {
        visitor.handleThirdMark(this);
    }
    public <R> R accept(ThirdMarkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleThirdMark(this);
    }
    public <E extends model.UserException>  void accept(ThirdMarkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleThirdMark(this);
    }
    public <R, E extends model.UserException> R accept(ThirdMarkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleThirdMark(this);
    }
    public void accept(MarkCalculableVisitor visitor) throws PersistenceException {
        visitor.handleThirdMark(this);
    }
    public <R> R accept(MarkCalculableReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleThirdMark(this);
    }
    public <E extends model.UserException>  void accept(MarkCalculableExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleThirdMark(this);
    }
    public <R, E extends model.UserException> R accept(MarkCalculableReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleThirdMark(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleThirdMark(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleThirdMark(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleThirdMark(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleThirdMark(this);
    }
    public void accept(MarkVisitor visitor) throws PersistenceException {
        visitor.handleThirdMark(this);
    }
    public <R> R accept(MarkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleThirdMark(this);
    }
    public <E extends model.UserException>  void accept(MarkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleThirdMark(this);
    }
    public <R, E extends model.UserException> R accept(MarkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleThirdMark(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentThirdMark)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentThirdMark)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public Boolean fetchIsCalculable() 
				throws PersistenceException{
        return ((PersistentThirdMark)this.getTheObject()).fetchIsCalculable();
    }
    public common.Fraction fetchMarkValue() 
				throws PersistenceException{
        return ((PersistentThirdMark)this.getTheObject()).fetchMarkValue();
    }
    public String fetchTypeAsString() 
				throws PersistenceException{
        return ((PersistentThirdMark)this.getTheObject()).fetchTypeAsString();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentThirdMark)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentThirdMark)this.getTheObject()).initializeOnInstantiation();
    }

    
}
