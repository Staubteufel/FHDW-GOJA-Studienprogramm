package persistence;


import model.visitor.*;

public interface StudentServer4Public extends Service4Public {
    
    public String getMatriculationNumber() throws PersistenceException ;
    public String getForename() throws PersistenceException ;
    public String getSurname() throws PersistenceException ;
    public java.sql.Date getDateOfBirth() throws PersistenceException ;
    public String getActiveStudyGroupName() throws PersistenceException ;
    public void setActiveStudyGroupName(String newValue) throws PersistenceException ;
    public StudentServer_StudyGroupsAttendedProxi getStudyGroupsAttended() throws PersistenceException ;
    public StudyGroup4Public getActiveStudyGroup() throws PersistenceException ;
    public void setActiveStudyGroup(StudyGroup4Public newValue) throws PersistenceException ;
    
    public void accept(ServiceVisitor visitor) throws PersistenceException;
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(InvokerVisitor visitor) throws PersistenceException;
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(RemoteVisitor visitor) throws PersistenceException;
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public StudyGroupSearchList appr_Path_In_FetchStudentM() 
				throws model.UserException, PersistenceException;
    public void fetchStudentM(final Appr4Public appr, final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public String studentServer_Menu_Filter(final Anything anything) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public Mark fetchStudentM(final Appr4Public appr) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

