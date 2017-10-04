package persistence;



import model.visitor.*;

public class ThirdMarkLstICProxi extends PersistentInCacheProxiOptimistic implements PersistentThirdMarkLst{
    
    public ThirdMarkLstICProxi(long objectId) {
        super(objectId);
    }
    public ThirdMarkLstICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theThirdMarkLstFacade
            .getThirdMarkLst(this.getId());
    }
    
    public long getClassId() {
        return 229;
    }
    
    public ThirdMarkLst_ThirdMarksProxi getThirdMarks() throws PersistenceException {
        return ((PersistentThirdMarkLst)this.getTheObject()).getThirdMarks();
    }
    public PersistentThirdMarkLst getThis() throws PersistenceException {
        return ((PersistentThirdMarkLst)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleThirdMarkLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleThirdMarkLst(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleThirdMarkLst(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleThirdMarkLst(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentThirdMarkLst)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentThirdMarkLst)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentThirdMarkLst)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentThirdMarkLst)this.getTheObject()).initializeOnInstantiation();
    }

    
}
