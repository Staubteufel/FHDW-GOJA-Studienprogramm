package persistence;



import model.visitor.*;

public class StudentServerLstICProxi extends PersistentInCacheProxiOptimistic implements PersistentStudentServerLst{
    
    public StudentServerLstICProxi(long objectId) {
        super(objectId);
    }
    public StudentServerLstICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theStudentServerLstFacade
            .getStudentServerLst(this.getId());
    }
    
    public long getClassId() {
        return 228;
    }
    
    public StudentServerLst_StudentServersProxi getStudentServers() throws PersistenceException {
        return ((PersistentStudentServerLst)this.getTheObject()).getStudentServers();
    }
    public PersistentStudentServerLst getThis() throws PersistenceException {
        return ((PersistentStudentServerLst)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudentServerLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentServerLst(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentServerLst(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentServerLst(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentStudentServerLst)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentStudentServerLst)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentStudentServerLst)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentStudentServerLst)this.getTheObject()).initializeOnInstantiation();
    }

    
}
