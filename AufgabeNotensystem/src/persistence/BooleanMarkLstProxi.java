package persistence;



import model.visitor.*;

public class BooleanMarkLstProxi extends PersistentProxi implements PersistentBooleanMarkLst{
    
    public BooleanMarkLstProxi(long objectId) {
        super(objectId);
    }
    public BooleanMarkLstProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 233;
    }
    
    public BooleanMarkLst_BooleanMarksProxi getBooleanMarks() throws PersistenceException {
        return ((PersistentBooleanMarkLst)this.getTheObject()).getBooleanMarks();
    }
    public PersistentBooleanMarkLst getThis() throws PersistenceException {
        return ((PersistentBooleanMarkLst)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBooleanMarkLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBooleanMarkLst(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBooleanMarkLst(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBooleanMarkLst(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentBooleanMarkLst)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentBooleanMarkLst)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentBooleanMarkLst)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentBooleanMarkLst)this.getTheObject()).initializeOnInstantiation();
    }

    
}
