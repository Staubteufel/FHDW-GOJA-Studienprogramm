package persistence;



import model.visitor.*;

public class StudyGroupLstProxi extends PersistentProxi implements PersistentStudyGroupLst{
    
    public StudyGroupLstProxi(long objectId) {
        super(objectId);
    }
    public StudyGroupLstProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 204;
    }
    
    public StudyGroupLst_StudyGroupsProxi getStudyGroups() throws PersistenceException {
        return ((PersistentStudyGroupLst)this.getTheObject()).getStudyGroups();
    }
    public PersistentStudyGroupLst getThis() throws PersistenceException {
        return ((PersistentStudyGroupLst)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroupLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroupLst(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroupLst(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroupLst(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentStudyGroupLst)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentStudyGroupLst)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentStudyGroupLst)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentStudyGroupLst)this.getTheObject()).initializeOnInstantiation();
    }

    
}
