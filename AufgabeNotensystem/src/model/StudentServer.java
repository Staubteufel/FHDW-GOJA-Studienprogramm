
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class StudentServer extends model.Service implements PersistentStudentServer{
    
    
    public static StudentServer4Public createStudentServer(String matriculationNumber,String forename,String surname,java.sql.Date dateOfBirth,StudyGroup4Public activeStudyGroup) throws PersistenceException{
        return createStudentServer(matriculationNumber,forename,surname,dateOfBirth,activeStudyGroup,false);
    }
    
    public static StudentServer4Public createStudentServer(String matriculationNumber,String forename,String surname,java.sql.Date dateOfBirth,StudyGroup4Public activeStudyGroup,boolean delayed$Persistence) throws PersistenceException {
        if (matriculationNumber == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (forename == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (surname == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentStudentServer result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudentServerFacade
                .newDelayedStudentServer(matriculationNumber,forename,surname,dateOfBirth,"");
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudentServerFacade
                .newStudentServer(matriculationNumber,forename,surname,dateOfBirth,"",-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("matriculationNumber", matriculationNumber);
        final$$Fields.put("forename", forename);
        final$$Fields.put("surname", surname);
        final$$Fields.put("dateOfBirth", dateOfBirth);
        final$$Fields.put("activeStudyGroup", activeStudyGroup);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static StudentServer4Public createStudentServer(String matriculationNumber,String forename,String surname,java.sql.Date dateOfBirth,StudyGroup4Public activeStudyGroup,boolean delayed$Persistence,StudentServer4Public This) throws PersistenceException {
        if (matriculationNumber == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (forename == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (surname == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentStudentServer result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudentServerFacade
                .newDelayedStudentServer(matriculationNumber,forename,surname,dateOfBirth,"");
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudentServerFacade
                .newStudentServer(matriculationNumber,forename,surname,dateOfBirth,"",-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("matriculationNumber", matriculationNumber);
        final$$Fields.put("forename", forename);
        final$$Fields.put("surname", surname);
        final$$Fields.put("dateOfBirth", dateOfBirth);
        final$$Fields.put("activeStudyGroup", activeStudyGroup);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    @SuppressWarnings("unchecked")
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, boolean inDerived) throws PersistenceException {
        java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf){
                result = (java.util.HashMap<String,Object>)allResults.get(uniqueKey);
                if (result != null) return result;
            }
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, inDerived);
            if (leaf) allResults.put(uniqueKey, result);
            result.put("matriculationNumber", this.getMatriculationNumber());
            result.put("forename", this.getForename());
            result.put("surname", this.getSurname());
            result.put("dateOfBirth", this.getDateOfBirth());
            result.put("activeStudyGroupName", this.getActiveStudyGroupName());
            result.put("studyGroupsAttended", this.getStudyGroupsAttended().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
        }
        return result;
    }
    
    public StudentServer provideCopy() throws PersistenceException{
        StudentServer result = this;
        result = new StudentServer(this.This, 
                                   this.matriculationNumber, 
                                   this.forename, 
                                   this.surname, 
                                   this.dateOfBirth, 
                                   this.activeStudyGroupName, 
                                   this.activeStudyGroup, 
                                   this.getId());
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String matriculationNumber;
    protected String forename;
    protected String surname;
    protected java.sql.Date dateOfBirth;
    protected String activeStudyGroupName;
    protected StudentServer_StudyGroupsAttendedProxi studyGroupsAttended;
    protected PersistentStudyGroup activeStudyGroup;
    
    public StudentServer(PersistentService This,String matriculationNumber,String forename,String surname,java.sql.Date dateOfBirth,String activeStudyGroupName,PersistentStudyGroup activeStudyGroup,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentService)This,id);
        this.matriculationNumber = matriculationNumber;
        this.forename = forename;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.activeStudyGroupName = activeStudyGroupName;
        this.studyGroupsAttended = new StudentServer_StudyGroupsAttendedProxi(this);
        this.activeStudyGroup = activeStudyGroup;        
    }
    
    static public long getTypeId() {
        return -200;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -200) ConnectionHandler.getTheConnectionHandler().theStudentServerFacade
            .newStudentServer(matriculationNumber,forename,surname,dateOfBirth,activeStudyGroupName,this.getId());
        super.store();
        this.getStudyGroupsAttended().store();
        if(this.getActiveStudyGroup() != null){
            this.getActiveStudyGroup().store();
            ConnectionHandler.getTheConnectionHandler().theStudentServerFacade.activeStudyGroupSet(this.getId(), getActiveStudyGroup());
        }
        
    }
    
    public String getMatriculationNumber() throws PersistenceException {
        return this.matriculationNumber;
    }
    public void setMatriculationNumber(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theStudentServerFacade.matriculationNumberSet(this.getId(), newValue);
        this.matriculationNumber = newValue;
    }
    public String getForename() throws PersistenceException {
        return this.forename;
    }
    public void setForename(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theStudentServerFacade.forenameSet(this.getId(), newValue);
        this.forename = newValue;
    }
    public String getSurname() throws PersistenceException {
        return this.surname;
    }
    public void setSurname(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theStudentServerFacade.surnameSet(this.getId(), newValue);
        this.surname = newValue;
    }
    public java.sql.Date getDateOfBirth() throws PersistenceException {
        return this.dateOfBirth;
    }
    public void setDateOfBirth(java.sql.Date newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theStudentServerFacade.dateOfBirthSet(this.getId(), newValue);
        this.dateOfBirth = newValue;
    }
    public String getActiveStudyGroupName() throws PersistenceException {
        return this.activeStudyGroupName;
    }
    public void setActiveStudyGroupName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theStudentServerFacade.activeStudyGroupNameSet(this.getId(), newValue);
        this.activeStudyGroupName = newValue;
    }
    public StudentServer_StudyGroupsAttendedProxi getStudyGroupsAttended() throws PersistenceException {
        return this.studyGroupsAttended;
    }
    public StudyGroup4Public getActiveStudyGroup() throws PersistenceException {
        return this.activeStudyGroup;
    }
    public void setActiveStudyGroup(StudyGroup4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.activeStudyGroup)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.activeStudyGroup = (PersistentStudyGroup)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theStudentServerFacade.activeStudyGroupSet(this.getId(), newValue);
        }
    }
    public PersistentStudentServer getThis() throws PersistenceException {
        if(this.This == null){
            PersistentStudentServer result = (PersistentStudentServer)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentStudentServer)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getStudyGroupsAttended().getLength() > 0) return 1;
        return 0;
    }
    
    
    public StudyGroupSearchList appr_Path_In_FetchStudentM() 
				throws model.UserException, PersistenceException{
        	return new StudyGroupSearchList(getThis().getStudyGroupsAttended().getList());
    }
    public void fetchStudentM(final Appr4Public appr, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		FetchStudentMCommand4Public command = model.meta.FetchStudentMCommand.createFetchStudentMCommand(nw, d1170);
		command.setAppr(appr);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentStudentServer)This);
		if(this.isTheSameAs(This)){
			this.setMatriculationNumber((String)final$$Fields.get("matriculationNumber"));
			this.setForename((String)final$$Fields.get("forename"));
			this.setSurname((String)final$$Fields.get("surname"));
			this.setDateOfBirth((java.sql.Date)final$$Fields.get("dateOfBirth"));
			this.setActiveStudyGroup((PersistentStudyGroup)final$$Fields.get("activeStudyGroup"));
		}
    }
    public String studentServer_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        String result = "+++";
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void connected(final String user) 
				throws PersistenceException{
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{

        
    }
    public void disconnected() 
				throws PersistenceException{
        
    }
    public Mark fetchStudentM(final Appr4Public appr) 
				throws PersistenceException{
        return appr.fetchMark();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
    }
    
    
    // Start of section that contains overridden operations only.
    
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
		
	}
    public void handleResult(final Command command) 
				throws PersistenceException{
		
	}
    public boolean hasChanged() 
				throws PersistenceException{
    	if(super.changed){
    		getThis().signalChanged(false);
			return true;
		}
		return false;
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
