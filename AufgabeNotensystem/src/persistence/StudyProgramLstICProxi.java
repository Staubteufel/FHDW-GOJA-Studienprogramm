package persistence;



import model.visitor.*;

public class StudyProgramLstICProxi extends PersistentInCacheProxiOptimistic implements PersistentStudyProgramLst{
    
    public StudyProgramLstICProxi(long objectId) {
        super(objectId);
    }
    public StudyProgramLstICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theStudyProgramLstFacade
            .getStudyProgramLst(this.getId());
    }
    
    public long getClassId() {
        return 207;
    }
    
    public StudyProgramLst_StudyProgramsProxi getStudyPrograms() throws PersistenceException {
        return ((PersistentStudyProgramLst)this.getTheObject()).getStudyPrograms();
    }
    public PersistentStudyProgramLst getThis() throws PersistenceException {
        return ((PersistentStudyProgramLst)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudyProgramLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyProgramLst(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyProgramLst(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyProgramLst(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentStudyProgramLst)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentStudyProgramLst)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentStudyProgramLst)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentStudyProgramLst)this.getTheObject()).initializeOnInstantiation();
    }

    
}
