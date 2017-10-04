
package model;

import persistence.*;

import java.util.Iterator;

import model.visitor.*;


/* Additional import section end */

public class StudyGroup extends model.Prototype implements PersistentStudyGroup{
    
    
    public static StudyGroup4Public createStudyGroup(String name,StudyProgram4Public assignedTo) throws PersistenceException{
        return createStudyGroup(name,assignedTo,false);
    }
    
    public static StudyGroup4Public createStudyGroup(String name,StudyProgram4Public assignedTo,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentStudyGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade
                .newDelayedStudyGroup(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade
                .newStudyGroup(name,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("assignedTo", assignedTo);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static StudyGroup4Public createStudyGroup(String name,StudyProgram4Public assignedTo,boolean delayed$Persistence,StudyGroup4Public This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentStudyGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade
                .newDelayedStudyGroup(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade
                .newStudyGroup(name,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("assignedTo", assignedTo);
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
            result.put("name", this.getName());
            result.put("students", this.getStudents().getValues().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
            AbstractPersistentRoot assignedTo = (AbstractPersistentRoot)this.getAssignedTo();
            if (assignedTo != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    assignedTo, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("assignedTo", proxiInformation);
                
            }
        }
        return result;
    }
    
    public StudyGroup provideCopy() throws PersistenceException{
        StudyGroup result = this;
        result = new StudyGroup(this.prototypeObservee, 
                                this.This, 
                                this.name, 
                                this.assignedTo, 
                                this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String name;
    protected StudyGroup_StudentsProxi students;
    protected PersistentStudyProgram assignedTo;
    
    public StudyGroup(PersistentPrototype prototypeObservee,PersistentPrototype This,String name,PersistentStudyProgram assignedTo,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentPrototype)prototypeObservee,(PersistentPrototype)This,id);
        this.name = name;
        this.students = new StudyGroup_StudentsProxi(this);
        this.assignedTo = assignedTo;        
    }
    
    static public long getTypeId() {
        return 111;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 111) ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade
            .newStudyGroup(name,this.getId());
        super.store();
        this.getStudents().store();
        if(this.getAssignedTo() != null){
            this.getAssignedTo().store();
            ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade.assignedToSet(this.getId(), getAssignedTo());
        }
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public StudyGroup_StudentsProxi getStudents() throws PersistenceException {
        return this.students;
    }
    public StudyProgram4Public getAssignedTo() throws PersistenceException {
        return this.assignedTo;
    }
    public void setAssignedTo(StudyProgram4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.assignedTo)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.assignedTo = (PersistentStudyProgram)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade.assignedToSet(this.getId(), newValue);
        }
    }
    public PersistentStudyGroup getThis() throws PersistenceException {
        if(this.This == null){
            PersistentStudyGroup result = (PersistentStudyGroup)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentStudyGroup)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getAssignedTo() != null) return 1;
        if( this.getStudents().getValues().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentStudyGroup)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
			this.setAssignedTo((PersistentStudyProgram)final$$Fields.get("assignedTo"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addStudent(final StudentServer4Public student) 
				throws PersistenceException{
    	getThis().getStudents().put(student.getMatriculationNumber(), student);
    	getThis().notifyPrototypeObservers();
    }
    public Prototype4Public clonePrototype() 
				throws PersistenceException{
    	StudyProgram4Public sp = (StudyProgram4Public)getThis().getAssignedTo().clonePrototype();
        StudyGroup4Public sg = StudyGroup.createStudyGroup(getThis().getName()+"(C)", sp);
        getThis().registerProtypeObserver(sg);
        
//        Iterator<StudentServer4Public> i = getThis().getStudents().iterator();
//		while (i.hasNext()) {
//			StudentServer4Public n = i.next();
//			sg.getStudents().put(n.getMatriculationNumber(), n);
//		}
        
        return sg;
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{

        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    public void updatePrototypeObserver() 
				throws PersistenceException{
//    	// Clear
//    	Iterator<StudentServer4Public> sg = getThis().getStudents().iterator();
//    	while(sg.hasNext()) {
//    		StudentServer4Public s = sg.next();
//    		try {
//				getThis().removeStudent(s);
//			} catch (StudentMustBeAtLeastMemberOfOneStudyGroupException e) {
//				e.printStackTrace();
//			}
//    	}
//    	
//    	// Fill
//    	StudyGroup4Public sgProto = (StudyGroup4Public) getThis().getPrototypeObserver();
//    	Iterator<StudentServer4Public> protoStudents = sgProto.getStudents().iterator();
//    	while(protoStudents.hasNext()) {
//    		StudentServer4Public protoStudent = protoStudents.next();
//    		getThis().addStudent(protoStudent);
//    	}
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
