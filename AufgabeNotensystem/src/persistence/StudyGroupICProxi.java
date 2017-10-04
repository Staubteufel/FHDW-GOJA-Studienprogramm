package persistence;



import model.visitor.*;

public class StudyGroupICProxi extends PrototypeICProxi implements PersistentStudyGroup{
    
    public StudyGroupICProxi(long objectId) {
        super(objectId);
    }
    public StudyGroupICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade
            .getStudyGroup(this.getId());
    }
    
    public long getClassId() {
        return 111;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentStudyGroup)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentStudyGroup)this.getTheObject()).setName(newValue);
    }
    public StudyGroup_StudentsProxi getStudents() throws PersistenceException {
        return ((PersistentStudyGroup)this.getTheObject()).getStudents();
    }
    public StudyProgram4Public getAssignedTo() throws PersistenceException {
        return ((PersistentStudyGroup)this.getTheObject()).getAssignedTo();
    }
    public void setAssignedTo(StudyProgram4Public newValue) throws PersistenceException {
        ((PersistentStudyGroup)this.getTheObject()).setAssignedTo(newValue);
    }
    public PersistentStudyGroup getThis() throws PersistenceException {
        return ((PersistentStudyGroup)this.getTheObject()).getThis();
    }
    
    public void accept(PrototypeVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroup(this);
    }
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroup(this);
    }
    public <E extends model.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroup(this);
    }
    public <R, E extends model.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroup(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroup(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroup(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentStudyGroup)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void addStudent(final StudentServer4Public student) 
				throws PersistenceException{
        ((PersistentStudyGroup)this.getTheObject()).addStudent(student);
    }
    public Prototype4Public clonePrototype() 
				throws PersistenceException{
        return ((PersistentStudyGroup)this.getTheObject()).clonePrototype();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentStudyGroup)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void deregisterPrototypeObserver(final Prototype4Public observer) 
				throws PersistenceException{
        ((PersistentStudyGroup)this.getTheObject()).deregisterPrototypeObserver(observer);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentStudyGroup)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentStudyGroup)this.getTheObject()).initializeOnInstantiation();
    }
    public void notifyPrototypeObservers() 
				throws PersistenceException{
        ((PersistentStudyGroup)this.getTheObject()).notifyPrototypeObservers();
    }
    public void registerProtypeObserver(final Prototype4Public observer) 
				throws PersistenceException{
        ((PersistentStudyGroup)this.getTheObject()).registerProtypeObserver(observer);
    }
    public void updatePrototypeObserver() 
				throws PersistenceException{
        ((PersistentStudyGroup)this.getTheObject()).updatePrototypeObserver();
    }

    
}
