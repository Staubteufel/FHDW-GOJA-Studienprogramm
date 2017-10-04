package persistence;



import model.visitor.*;

public class StudentServerProxi extends ServiceProxi implements PersistentStudentServer{
    
    public StudentServerProxi(long objectId) {
        super(objectId);
    }
    public StudentServerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return -200;
    }
    
    public String getMatriculationNumber() throws PersistenceException {
        return ((PersistentStudentServer)this.getTheObject()).getMatriculationNumber();
    }
    public void setMatriculationNumber(String newValue) throws PersistenceException {
        ((PersistentStudentServer)this.getTheObject()).setMatriculationNumber(newValue);
    }
    public String getForename() throws PersistenceException {
        return ((PersistentStudentServer)this.getTheObject()).getForename();
    }
    public void setForename(String newValue) throws PersistenceException {
        ((PersistentStudentServer)this.getTheObject()).setForename(newValue);
    }
    public String getSurname() throws PersistenceException {
        return ((PersistentStudentServer)this.getTheObject()).getSurname();
    }
    public void setSurname(String newValue) throws PersistenceException {
        ((PersistentStudentServer)this.getTheObject()).setSurname(newValue);
    }
    public java.sql.Date getDateOfBirth() throws PersistenceException {
        return ((PersistentStudentServer)this.getTheObject()).getDateOfBirth();
    }
    public void setDateOfBirth(java.sql.Date newValue) throws PersistenceException {
        ((PersistentStudentServer)this.getTheObject()).setDateOfBirth(newValue);
    }
    public String getActiveStudyGroupName() throws PersistenceException {
        return ((PersistentStudentServer)this.getTheObject()).getActiveStudyGroupName();
    }
    public void setActiveStudyGroupName(String newValue) throws PersistenceException {
        ((PersistentStudentServer)this.getTheObject()).setActiveStudyGroupName(newValue);
    }
    public StudentServer_StudyGroupsAttendedProxi getStudyGroupsAttended() throws PersistenceException {
        return ((PersistentStudentServer)this.getTheObject()).getStudyGroupsAttended();
    }
    public StudyGroup4Public getActiveStudyGroup() throws PersistenceException {
        return ((PersistentStudentServer)this.getTheObject()).getActiveStudyGroup();
    }
    public void setActiveStudyGroup(StudyGroup4Public newValue) throws PersistenceException {
        ((PersistentStudentServer)this.getTheObject()).setActiveStudyGroup(newValue);
    }
    public PersistentStudentServer getThis() throws PersistenceException {
        return ((PersistentStudentServer)this.getTheObject()).getThis();
    }
    
    public void accept(ServiceVisitor visitor) throws PersistenceException {
        visitor.handleStudentServer(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentServer(this);
    }
    public <E extends model.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentServer(this);
    }
    public <R, E extends model.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentServer(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleStudentServer(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentServer(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentServer(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentServer(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudentServer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentServer(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentServer(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentServer(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleStudentServer(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentServer(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentServer(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentServer(this);
    }
    
    
    public StudyGroupSearchList appr_Path_In_FetchStudentM() 
				throws model.UserException, PersistenceException{
        return ((PersistentStudentServer)this.getTheObject()).appr_Path_In_FetchStudentM();
    }
    public void fetchStudentM(final Appr4Public appr, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentStudentServer)this.getTheObject()).fetchStudentM(appr, invoker);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentStudentServer)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentStudentServer)this.getTheObject()).signalChanged(signal);
    }
    public String studentServer_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        return ((PersistentStudentServer)this.getTheObject()).studentServer_Menu_Filter(anything);
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentStudentServer)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentStudentServer)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentStudentServer)this.getTheObject()).disconnected();
    }
    public Mark fetchStudentM(final Appr4Public appr) 
				throws PersistenceException{
        return ((PersistentStudentServer)this.getTheObject()).fetchStudentM(appr);
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentStudentServer)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentStudentServer)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentStudentServer)this.getTheObject()).hasChanged();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentStudentServer)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentStudentServer)this.getTheObject()).initializeOnInstantiation();
    }

    
}
