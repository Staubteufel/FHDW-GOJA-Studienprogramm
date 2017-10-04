package persistence;



import model.visitor.*;

public class StudyProgramICProxi extends ApprICProxi implements PersistentStudyProgram{
    
    public StudyProgramICProxi(long objectId) {
        super(objectId);
    }
    public StudyProgramICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theStudyProgramFacade
            .getStudyProgram(this.getId());
    }
    
    public long getClassId() {
        return 116;
    }
    
    public StudyProgram_ModuleGroupsProxi getModuleGroups() throws PersistenceException {
        return ((PersistentStudyProgram)this.getTheObject()).getModuleGroups();
    }
    public PersistentStudyProgram getThis() throws PersistenceException {
        return ((PersistentStudyProgram)this.getTheObject()).getThis();
    }
    
    public void accept(ApprVisitor visitor) throws PersistenceException {
        visitor.handleStudyProgram(this);
    }
    public <R> R accept(ApprReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyProgram(this);
    }
    public <E extends model.UserException>  void accept(ApprExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyProgram(this);
    }
    public <R, E extends model.UserException> R accept(ApprReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyProgram(this);
    }
    public void accept(PrototypeVisitor visitor) throws PersistenceException {
        visitor.handleStudyProgram(this);
    }
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyProgram(this);
    }
    public <E extends model.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyProgram(this);
    }
    public <R, E extends model.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyProgram(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudyProgram(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyProgram(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyProgram(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyProgram(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentStudyProgram)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void addModuleGroup(final ModuleGroup4Public moduleGroup) 
				throws PersistenceException{
        ((PersistentStudyProgram)this.getTheObject()).addModuleGroup(moduleGroup);
    }
    public Prototype4Public clonePrototype() 
				throws PersistenceException{
        return ((PersistentStudyProgram)this.getTheObject()).clonePrototype();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentStudyProgram)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void deregisterPrototypeObserver(final Prototype4Public observer) 
				throws PersistenceException{
        ((PersistentStudyProgram)this.getTheObject()).deregisterPrototypeObserver(observer);
    }
    public Mark fetchMark() 
				throws PersistenceException{
        return ((PersistentStudyProgram)this.getTheObject()).fetchMark();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentStudyProgram)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentStudyProgram)this.getTheObject()).initializeOnInstantiation();
    }
    public Boolean isConsistent() 
				throws PersistenceException{
        return ((PersistentStudyProgram)this.getTheObject()).isConsistent();
    }
    public void notifyPrototypeObservers() 
				throws PersistenceException{
        ((PersistentStudyProgram)this.getTheObject()).notifyPrototypeObservers();
    }
    public void registerProtypeObserver(final Prototype4Public observer) 
				throws PersistenceException{
        ((PersistentStudyProgram)this.getTheObject()).registerProtypeObserver(observer);
    }
    public void removeModuleGroup(final ModuleGroup4Public moduleGroup) 
				throws PersistenceException{
        ((PersistentStudyProgram)this.getTheObject()).removeModuleGroup(moduleGroup);
    }
    public void updatePrototypeObserver() 
				throws PersistenceException{
        ((PersistentStudyProgram)this.getTheObject()).updatePrototypeObserver();
    }

    
}
