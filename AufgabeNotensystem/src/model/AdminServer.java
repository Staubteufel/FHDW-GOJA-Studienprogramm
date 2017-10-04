
package model;

import persistence.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Iterator;

import model.visitor.*;
import common.Fraction;


/* Additional import section end */

public class AdminServer extends model.Service implements PersistentAdminServer{
    
    
    public static AdminServer4Public createAdminServer() throws PersistenceException{
        return createAdminServer(false);
    }
    
    public static AdminServer4Public createAdminServer(boolean delayed$Persistence) throws PersistenceException {
        PersistentAdminServer result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAdminServerFacade
                .newDelayedAdminServer();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAdminServerFacade
                .newAdminServer(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static AdminServer4Public createAdminServer(boolean delayed$Persistence,AdminServer4Public This) throws PersistenceException {
        PersistentAdminServer result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAdminServerFacade
                .newDelayedAdminServer();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAdminServerFacade
                .newAdminServer(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
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
            AbstractPersistentRoot units = (AbstractPersistentRoot)this.getUnits();
            if (units != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    units, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("units", proxiInformation);
                
            }
            AbstractPersistentRoot moduleWithUnits = (AbstractPersistentRoot)this.getModuleWithUnits();
            if (moduleWithUnits != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    moduleWithUnits, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("moduleWithUnits", proxiInformation);
                
            }
            AbstractPersistentRoot moduleWithoutUnits = (AbstractPersistentRoot)this.getModuleWithoutUnits();
            if (moduleWithoutUnits != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    moduleWithoutUnits, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("moduleWithoutUnits", proxiInformation);
                
            }
            AbstractPersistentRoot moduleGroups = (AbstractPersistentRoot)this.getModuleGroups();
            if (moduleGroups != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    moduleGroups, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("moduleGroups", proxiInformation);
                
            }
            AbstractPersistentRoot studyPrograms = (AbstractPersistentRoot)this.getStudyPrograms();
            if (studyPrograms != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    studyPrograms, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("studyPrograms", proxiInformation);
                
            }
            AbstractPersistentRoot studyGroups = (AbstractPersistentRoot)this.getStudyGroups();
            if (studyGroups != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    studyGroups, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("studyGroups", proxiInformation);
                
            }
            AbstractPersistentRoot students = (AbstractPersistentRoot)this.getStudents();
            if (students != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    students, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("students", proxiInformation);
                
            }
        }
        return result;
    }
    
    public AdminServer provideCopy() throws PersistenceException{
        AdminServer result = this;
        result = new AdminServer(this.This, 
                                 this.units, 
                                 this.moduleWithUnits, 
                                 this.moduleWithoutUnits, 
                                 this.moduleGroups, 
                                 this.studyPrograms, 
                                 this.studyGroups, 
                                 this.students, 
                                 this.thirdMarks, 
                                 this.getId());
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentUnitLst units;
    protected PersistentModuleWithUnitsLst moduleWithUnits;
    protected PersistentModuleWithoutUnitsLst moduleWithoutUnits;
    protected PersistentModuleGroupLst moduleGroups;
    protected PersistentStudyProgramLst studyPrograms;
    protected PersistentStudyGroupLst studyGroups;
    protected PersistentStudentServerLst students;
    protected AdminServer_ModuleWithoutUnitsMarkTypesProxi ModuleWithoutUnitsMarkTypes;
    protected PersistentThirdMarkLst thirdMarks;
    protected AdminServer_ModuleWithoutUnitsMarksProxi ModuleWithoutUnitsMarks;
    
    public AdminServer(PersistentService This,PersistentUnitLst units,PersistentModuleWithUnitsLst moduleWithUnits,PersistentModuleWithoutUnitsLst moduleWithoutUnits,PersistentModuleGroupLst moduleGroups,PersistentStudyProgramLst studyPrograms,PersistentStudyGroupLst studyGroups,PersistentStudentServerLst students,PersistentThirdMarkLst thirdMarks,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentService)This,id);
        this.units = units;
        this.moduleWithUnits = moduleWithUnits;
        this.moduleWithoutUnits = moduleWithoutUnits;
        this.moduleGroups = moduleGroups;
        this.studyPrograms = studyPrograms;
        this.studyGroups = studyGroups;
        this.students = students;
        this.ModuleWithoutUnitsMarkTypes = new AdminServer_ModuleWithoutUnitsMarkTypesProxi(this);
        this.thirdMarks = thirdMarks;
        this.ModuleWithoutUnitsMarks = new AdminServer_ModuleWithoutUnitsMarksProxi(this);        
    }
    
    static public long getTypeId() {
        return -201;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -201) ConnectionHandler.getTheConnectionHandler().theAdminServerFacade
            .newAdminServer(this.getId());
        super.store();
        if(this.getUnits() != null){
            this.getUnits().store();
            ConnectionHandler.getTheConnectionHandler().theAdminServerFacade.unitsSet(this.getId(), getUnits());
        }
        if(this.getModuleWithUnits() != null){
            this.getModuleWithUnits().store();
            ConnectionHandler.getTheConnectionHandler().theAdminServerFacade.moduleWithUnitsSet(this.getId(), getModuleWithUnits());
        }
        if(this.getModuleWithoutUnits() != null){
            this.getModuleWithoutUnits().store();
            ConnectionHandler.getTheConnectionHandler().theAdminServerFacade.moduleWithoutUnitsSet(this.getId(), getModuleWithoutUnits());
        }
        if(this.getModuleGroups() != null){
            this.getModuleGroups().store();
            ConnectionHandler.getTheConnectionHandler().theAdminServerFacade.moduleGroupsSet(this.getId(), getModuleGroups());
        }
        if(this.getStudyPrograms() != null){
            this.getStudyPrograms().store();
            ConnectionHandler.getTheConnectionHandler().theAdminServerFacade.studyProgramsSet(this.getId(), getStudyPrograms());
        }
        if(this.getStudyGroups() != null){
            this.getStudyGroups().store();
            ConnectionHandler.getTheConnectionHandler().theAdminServerFacade.studyGroupsSet(this.getId(), getStudyGroups());
        }
        if(this.getStudents() != null){
            this.getStudents().store();
            ConnectionHandler.getTheConnectionHandler().theAdminServerFacade.studentsSet(this.getId(), getStudents());
        }
        this.getModuleWithoutUnitsMarkTypes().store();
        if(this.getThirdMarks() != null){
            this.getThirdMarks().store();
            ConnectionHandler.getTheConnectionHandler().theAdminServerFacade.thirdMarksSet(this.getId(), getThirdMarks());
        }
        this.getModuleWithoutUnitsMarks().store();
        
    }
    
    public UnitLst4Public getUnits() throws PersistenceException {
        return this.units;
    }
    public void setUnits(UnitLst4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.units)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.units = (PersistentUnitLst)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAdminServerFacade.unitsSet(this.getId(), newValue);
        }
    }
    public ModuleWithUnitsLst4Public getModuleWithUnits() throws PersistenceException {
        return this.moduleWithUnits;
    }
    public void setModuleWithUnits(ModuleWithUnitsLst4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.moduleWithUnits)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.moduleWithUnits = (PersistentModuleWithUnitsLst)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAdminServerFacade.moduleWithUnitsSet(this.getId(), newValue);
        }
    }
    public ModuleWithoutUnitsLst4Public getModuleWithoutUnits() throws PersistenceException {
        return this.moduleWithoutUnits;
    }
    public void setModuleWithoutUnits(ModuleWithoutUnitsLst4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.moduleWithoutUnits)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.moduleWithoutUnits = (PersistentModuleWithoutUnitsLst)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAdminServerFacade.moduleWithoutUnitsSet(this.getId(), newValue);
        }
    }
    public ModuleGroupLst4Public getModuleGroups() throws PersistenceException {
        return this.moduleGroups;
    }
    public void setModuleGroups(ModuleGroupLst4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.moduleGroups)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.moduleGroups = (PersistentModuleGroupLst)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAdminServerFacade.moduleGroupsSet(this.getId(), newValue);
        }
    }
    public StudyProgramLst4Public getStudyPrograms() throws PersistenceException {
        return this.studyPrograms;
    }
    public void setStudyPrograms(StudyProgramLst4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.studyPrograms)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.studyPrograms = (PersistentStudyProgramLst)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAdminServerFacade.studyProgramsSet(this.getId(), newValue);
        }
    }
    public StudyGroupLst4Public getStudyGroups() throws PersistenceException {
        return this.studyGroups;
    }
    public void setStudyGroups(StudyGroupLst4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.studyGroups)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.studyGroups = (PersistentStudyGroupLst)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAdminServerFacade.studyGroupsSet(this.getId(), newValue);
        }
    }
    public StudentServerLst4Public getStudents() throws PersistenceException {
        return this.students;
    }
    public void setStudents(StudentServerLst4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.students)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.students = (PersistentStudentServerLst)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAdminServerFacade.studentsSet(this.getId(), newValue);
        }
    }
    public AdminServer_ModuleWithoutUnitsMarkTypesProxi getModuleWithoutUnitsMarkTypes() throws PersistenceException {
        return this.ModuleWithoutUnitsMarkTypes;
    }
    public ThirdMarkLst4Public getThirdMarks() throws PersistenceException {
        return this.thirdMarks;
    }
    public void setThirdMarks(ThirdMarkLst4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.thirdMarks)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.thirdMarks = (PersistentThirdMarkLst)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAdminServerFacade.thirdMarksSet(this.getId(), newValue);
        }
    }
    public AdminServer_ModuleWithoutUnitsMarksProxi getModuleWithoutUnitsMarks() throws PersistenceException {
        return this.ModuleWithoutUnitsMarks;
    }
    public PersistentAdminServer getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAdminServer result = (PersistentAdminServer)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentAdminServer)this.This;
    }
    
    public void accept(ServiceVisitor visitor) throws PersistenceException {
        visitor.handleAdminServer(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdminServer(this);
    }
    public <E extends model.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdminServer(this);
    }
    public <R, E extends model.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdminServer(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleAdminServer(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdminServer(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdminServer(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdminServer(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAdminServer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdminServer(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdminServer(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdminServer(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleAdminServer(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdminServer(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdminServer(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdminServer(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getUnits() != null) return 1;
        if (this.getModuleWithUnits() != null) return 1;
        if (this.getModuleWithoutUnits() != null) return 1;
        if (this.getModuleGroups() != null) return 1;
        if (this.getStudyPrograms() != null) return 1;
        if (this.getStudyGroups() != null) return 1;
        if (this.getStudents() != null) return 1;
        return 0;
    }
    
    
    public void addMGToMG(final ModuleGroup4Public moduleGroup, final ModuleGroup4Public mG, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		AddMGToMGCommand4Public command = model.meta.AddMGToMGCommand.createAddMGToMGCommand(nw, d1170);
		command.setModuleGroup(moduleGroup);
		command.setMG(mG);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void addMGToSP(final StudyProgram4Public studyProgram, final ModuleGroup4Public moduleGroup, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		AddMGToSPCommand4Public command = model.meta.AddMGToSPCommand.createAddMGToSPCommand(nw, d1170);
		command.setStudyProgram(studyProgram);
		command.setModuleGroup(moduleGroup);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void addMWUToMG(final ModuleGroup4Public moduleGroup, final ModuleWithUnits4Public moduleWithUnits, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		AddMWUToMGCommand4Public command = model.meta.AddMWUToMGCommand.createAddMWUToMGCommand(nw, d1170);
		command.setModuleGroup(moduleGroup);
		command.setModuleWithUnits(moduleWithUnits);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void addMWWUToMG(final ModuleGroup4Public moduleGroup, final ModuleWithoutUnits4Public moduleWithoutUnits, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		AddMWWUToMGCommand4Public command = model.meta.AddMWWUToMGCommand.createAddMWWUToMGCommand(nw, d1170);
		command.setModuleGroup(moduleGroup);
		command.setModuleWithoutUnits(moduleWithoutUnits);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void addSToSG(final StudyGroup4Public studyGroup, final StudentServer4Public student, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		AddSToSGCommand4Public command = model.meta.AddSToSGCommand.createAddSToSGCommand(nw, d1170);
		command.setStudyGroup(studyGroup);
		command.setStudent(student);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void addUToMWU(final ModuleWithUnits4Public moduleWithUnits, final Unit4Public unit, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		AddUToMWUCommand4Public command = model.meta.AddUToMWUCommand.createAddUToMWUCommand(nw, d1170);
		command.setModuleWithUnits(moduleWithUnits);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public String adminServer_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        String result = "+++";
		return result;
    }
    public void changeCP(final Appr4Public appr, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		ChangeCPCommand4Public command = model.meta.ChangeCPCommand.createChangeCPCommand(creditPoints, nw, d1170);
		command.setAppr(appr);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createMWU(final String name, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		CreateMWUCommand4Public command = model.meta.CreateMWUCommand.createCreateMWUCommand(name, creditPoints, nw, d1170);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createMWWU(final String name, final common.Fraction creditPoints, final Mark markType, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		CreateMWWUCommand4Public command = model.meta.CreateMWWUCommand.createCreateMWWUCommand(name, creditPoints, nw, d1170);
		command.setMarkType(markType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createModuleGroup(final String name, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		CreateModuleGroupCommand4Public command = model.meta.CreateModuleGroupCommand.createCreateModuleGroupCommand(name, creditPoints, nw, d1170);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createStudent(final String matricalNumber, final String password, final String forename, final String surname, final java.sql.Date dateOfBirth, final StudyGroup4Public studyGroup, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		CreateStudentCommand4Public command = model.meta.CreateStudentCommand.createCreateStudentCommand(matricalNumber, password, forename, surname, dateOfBirth, nw, d1170);
		command.setStudyGroup(studyGroup);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createStudyGroup(final String name, final StudyProgram4Public studyProgram, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		CreateStudyGroupCommand4Public command = model.meta.CreateStudyGroupCommand.createCreateStudyGroupCommand(name, nw, d1170);
		command.setStudyProgram(studyProgram);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createStudyProgram(final String name, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		CreateStudyProgramCommand4Public command = model.meta.CreateStudyProgramCommand.createCreateStudyProgramCommand(name, creditPoints, nw, d1170);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createUnit(final String name, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		CreateUnitCommand4Public command = model.meta.CreateUnitCommand.createCreateUnitCommand(name, creditPoints, nw, d1170);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void fetchM(final Appr4Public appr, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		FetchMCommand4Public command = model.meta.FetchMCommand.createFetchMCommand(nw, d1170);
		command.setAppr(appr);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAdminServer)This);
		if(this.isTheSameAs(This)){
		}
    }
    public ModuleGroupLst4Public mG_Path_In_AddMGToMG() 
				throws model.UserException, PersistenceException{
        	return getThis().getModuleGroups();
    }
    public ModuleGroupSearchList mG_Path_In_RemMGFromMG(final ModuleGroup4Public moduleGroup) 
				throws model.UserException, PersistenceException{
        	return new ModuleGroupSearchList(moduleGroup.
                getModuleGroups().getList());
    }
    public MarkSearchList markType_Path_In_CreateMWWU() 
				throws model.UserException, PersistenceException{
        	return new MarkSearchList(getThis().getModuleWithoutUnitsMarkTypes().getList());
    }
    public AnythingSearchList mark_Path_In_SorcMTSWiMWuU() 
				throws model.UserException, PersistenceException{
        	return new AnythingSearchList(getThis().getModuleWithoutUnitsMarks().getList());
    }
    public ThirdMarkLst4Public mark_Path_In_SorcMTSWiU() 
				throws model.UserException, PersistenceException{
        	return getThis().getThirdMarks();
    }
    public ModuleGroupLst4Public moduleGroup_Path_In_AddMGToSP() 
				throws model.UserException, PersistenceException{
        	return getThis().getModuleGroups();
    }
    public ModuleGroupSearchList moduleGroup_Path_In_RemMGFromSP(final StudyProgram4Public studyProgram) 
				throws model.UserException, PersistenceException{
        	return new ModuleGroupSearchList(studyProgram.
                getModuleGroups().getList());
    }
    public ModuleWithUnitsLst4Public moduleWithUnits_Path_In_AddMWUToMG() 
				throws model.UserException, PersistenceException{
        	return getThis().getModuleWithUnits();
    }
    public ModuleWithUnitsSearchList moduleWithUnits_Path_In_RemMWUFromMG(final ModuleGroup4Public moduleGroup) 
				throws model.UserException, PersistenceException{
        	return new ModuleWithUnitsSearchList(moduleGroup.
                getModuleWithUnits().getList());
    }
    public ModuleWithoutUnitsLst4Public moduleWithoutUnits_Path_In_AddMWWUToMG() 
				throws model.UserException, PersistenceException{
        	return getThis().getModuleWithoutUnits();
    }
    public ModuleWithoutUnitsSearchList moduleWithoutUnits_Path_In_RemMWWUFromMG(final ModuleGroup4Public moduleGroup) 
				throws model.UserException, PersistenceException{
        	return new ModuleWithoutUnitsSearchList(moduleGroup.
                getModuleWithoutUnits().getList());
    }
    public ModuleWithoutUnitsLst4Public moduleWithoutUnits_Path_In_SorcMTSWiMWuU() 
				throws model.UserException, PersistenceException{
        	return getThis().getModuleWithoutUnits();
    }
    public void remMGFromMG(final ModuleGroup4Public moduleGroup, final ModuleGroup4Public mG, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		RemMGFromMGCommand4Public command = model.meta.RemMGFromMGCommand.createRemMGFromMGCommand(nw, d1170);
		command.setModuleGroup(moduleGroup);
		command.setMG(mG);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void remMGFromSP(final StudyProgram4Public studyProgram, final ModuleGroup4Public moduleGroup, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		RemMGFromSPCommand4Public command = model.meta.RemMGFromSPCommand.createRemMGFromSPCommand(nw, d1170);
		command.setStudyProgram(studyProgram);
		command.setModuleGroup(moduleGroup);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void remMWUFromMG(final ModuleGroup4Public moduleGroup, final ModuleWithUnits4Public moduleWithUnits, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		RemMWUFromMGCommand4Public command = model.meta.RemMWUFromMGCommand.createRemMWUFromMGCommand(nw, d1170);
		command.setModuleGroup(moduleGroup);
		command.setModuleWithUnits(moduleWithUnits);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void remMWWUFromMG(final ModuleGroup4Public moduleGroup, final ModuleWithoutUnits4Public moduleWithoutUnits, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		RemMWWUFromMGCommand4Public command = model.meta.RemMWWUFromMGCommand.createRemMWWUFromMGCommand(nw, d1170);
		command.setModuleGroup(moduleGroup);
		command.setModuleWithoutUnits(moduleWithoutUnits);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void remUFromMWU(final ModuleWithUnits4Public moduleWithUnits, final Unit4Public unit, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		RemUFromMWUCommand4Public command = model.meta.RemUFromMWUCommand.createRemUFromMWUCommand(nw, d1170);
		command.setModuleWithUnits(moduleWithUnits);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void removeModuleGroup(final ModuleGroup4Public moduleGroup, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		RemoveModuleGroupCommand4Public command = model.meta.RemoveModuleGroupCommand.createRemoveModuleGroupCommand(nw, d1170);
		command.setModuleGroup(moduleGroup);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void removeStudyGroup(final StudyGroup4Public studyGroup, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		RemoveStudyGroupCommand4Public command = model.meta.RemoveStudyGroupCommand.createRemoveStudyGroupCommand(nw, d1170);
		command.setStudyGroup(studyGroup);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void removeStudyProgram(final StudyProgram4Public studyProgram, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		RemoveStudyProgramCommand4Public command = model.meta.RemoveStudyProgramCommand.createRemoveStudyProgramCommand(nw, d1170);
		command.setStudyProgram(studyProgram);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void removeUnit(final Unit4Public unit, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		RemoveUnitCommand4Public command = model.meta.RemoveUnitCommand.createRemoveUnitCommand(nw, d1170);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void rmvMWOU(final ModuleWithoutUnits4Public moduleWithoutUnits, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		RmvMWOUCommand4Public command = model.meta.RmvMWOUCommand.createRmvMWOUCommand(nw, d1170);
		command.setModuleWithoutUnits(moduleWithoutUnits);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void rmvMWU(final ModuleWithUnits4Public moduleWithUnits, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		RmvMWUCommand4Public command = model.meta.RmvMWUCommand.createRmvMWUCommand(nw, d1170);
		command.setModuleWithUnits(moduleWithUnits);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void setActiveSG(final StudentServer4Public student, final StudyGroup4Public studyGroup, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		SetActiveSGCommand4Public command = model.meta.SetActiveSGCommand.createSetActiveSGCommand(nw, d1170);
		command.setStudent(student);
		command.setStudyGroup(studyGroup);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void sorcMTSWiMWuU(final ModuleWithoutUnits4Public moduleWithoutUnits, final Mark mark, final String comment, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		SorcMTSWiMWuUCommand4Public command = model.meta.SorcMTSWiMWuUCommand.createSorcMTSWiMWuUCommand(comment, nw, d1170);
		command.setModuleWithoutUnits(moduleWithoutUnits);
		command.setMark(mark);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void sorcMTSWiU(final Unit4Public unit, final ThirdMark4Public mark, final String comment, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		SorcMTSWiUCommand4Public command = model.meta.SorcMTSWiUCommand.createSorcMTSWiUCommand(comment, nw, d1170);
		command.setUnit(unit);
		command.setMark(mark);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public StudentServerLst4Public student_Path_In_AddSToSG() 
				throws model.UserException, PersistenceException{
        	return getThis().getStudents();
    }
    public StudyGroupLst4Public studyGroup_Path_In_CreateStudent() 
				throws model.UserException, PersistenceException{
        	return getThis().getStudyGroups();
    }
    public StudyGroupSearchList studyGroup_Path_In_SetActiveSG(final StudentServer4Public student) 
				throws model.UserException, PersistenceException{
        	return new StudyGroupSearchList(student.
                getStudyGroupsAttended().getList());
    }
    public StudyProgramLst4Public studyProgram_Path_In_CreateStudyGroup() 
				throws model.UserException, PersistenceException{
        	return getThis().getStudyPrograms();
    }
    public UnitLst4Public unit_Path_In_AddUToMWU() 
				throws model.UserException, PersistenceException{
        	return getThis().getUnits();
    }
    public UnitSearchList unit_Path_In_RemUFromMWU(final ModuleWithUnits4Public moduleWithUnits) 
				throws model.UserException, PersistenceException{
        	return new UnitSearchList(moduleWithUnits.
                getConsistsOf().getList());
    }
    public UnitLst4Public unit_Path_In_SorcMTSWiU() 
				throws model.UserException, PersistenceException{
        	return getThis().getUnits();
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addMGToMG(final ModuleGroup4Public moduleGroup, final ModuleGroup4Public mG) 
				throws model.CycleException, model.AlreadyInUseException, PersistenceException{
    	if(moduleGroup.getPrototypeObserver().getLength() > 0 || moduleGroup.getPrototypeObservee() != null) {
    		throw new AlreadyInUseException("AlreadyInUseException");
    	}
    	moduleGroup.addModuleGroup(mG);
    	getThis().signalChanged(true);
    }
    public void addMGToSP(final StudyProgram4Public studyProgram, final ModuleGroup4Public moduleGroup) 
				throws model.AlreadyInUseException, PersistenceException{
    	if(studyProgram.getPrototypeObserver().getLength() > 0 || studyProgram.getPrototypeObservee() != null) {
    		throw new AlreadyInUseException("AlreadyInUseException");
    	}
    	studyProgram.addModuleGroup(moduleGroup);
    	getThis().signalChanged(true);
    }
    public void addMWUToMG(final ModuleGroup4Public moduleGroup, final ModuleWithUnits4Public moduleWithUnits) 
				throws model.CycleException, model.AlreadyInUseException, PersistenceException{
    	if(moduleGroup.getPrototypeObserver().getLength() > 0 || moduleGroup.getPrototypeObservee() != null) {
    		throw new AlreadyInUseException("AlreadyInUseException");
    	}
    	moduleGroup.addModuleWithUnits(moduleWithUnits);
    	getThis().signalChanged(true);
    }
    public void addMWWUToMG(final ModuleGroup4Public moduleGroup, final ModuleWithoutUnits4Public moduleWithoutUnits) 
				throws model.CycleException, model.AlreadyInUseException, PersistenceException{
    	if(moduleGroup.getPrototypeObserver().getLength() > 0 || moduleGroup.getPrototypeObservee() != null) {
    		throw new AlreadyInUseException("AlreadyInUseException");
    	}
    	moduleGroup.addModuleWithoutUnits(moduleWithoutUnits);
    	getThis().signalChanged(true);
    }
    public void addSToSG(final StudyGroup4Public studyGroup, final StudentServer4Public student) 
				throws model.AlreadyInUseException, PersistenceException{
    	if(studyGroup.getPrototypeObserver().getLength() > 0 || studyGroup.getPrototypeObservee() != null) {
    		throw new AlreadyInUseException("AlreadyInUseException");
    	}
        studyGroup.addStudent(student);
        student.getStudyGroupsAttended().add(studyGroup);
        getThis().signalChanged(true);
    }
    public void addUToMWU(final ModuleWithUnits4Public moduleWithUnits, final Unit4Public unit) 
				throws model.ThereIsAlreadyAStudyGroupException, model.UnitIsAlreadyPartOfAModuleWithUnitsException, model.AlreadyInUseException, PersistenceException{
    	if(moduleWithUnits.getPrototypeObserver().getLength() > 0 || moduleWithUnits.getPrototypeObservee() != null) {
    		throw new AlreadyInUseException("AlreadyInUseException");
    	}
        moduleWithUnits.addUnit(unit);
        getThis().signalChanged(true);
    }
    public void changeCP(final Appr4Public appr, final common.Fraction creditPoints) 
				throws model.AlreadyInUseException, PersistenceException{
    	if(appr.getPrototypeObserver().getLength() > 0) {
    		throw new AlreadyInUseException("AlreadyInUseException");
    	}
    	appr.setCreditPoints(creditPoints);
    	getThis().signalChanged(true);
    }
    public void connected(final String user) 
				throws PersistenceException{
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{

    }
    public void createMWU(final String name, final common.Fraction creditPoints) 
				throws model.NameAlreadyExistsException, PersistenceException{
    	for(ModuleWithUnits4Public x : ModuleWithUnitsLst.getTheModuleWithUnitsLst().getModuleWithUnits().getList()) if(x.getName().equals(name)) throw new NameAlreadyExistsException("NameAlreadyExistsException");
        
    	getThis().getModuleWithUnits().getModuleWithUnits().add(ModuleWithUnits.createModuleWithUnits(name, creditPoints));
        getThis().signalChanged(true);
    }
    public void createMWWU(final String name, final common.Fraction creditPoints, final Mark markType) 
				throws model.NameAlreadyExistsException, PersistenceException{
    	for(ModuleWithoutUnits4Public x : ModuleWithoutUnitsLst.getTheModuleWithoutUnitsLst().getModuleWithoutUnits().getList()) if(x.getName().equals(name)) throw new NameAlreadyExistsException("NameAlreadyExistsException");
        
    	getThis().getModuleWithoutUnits().getModuleWithoutUnits().add(ModuleWithoutUnits.createModuleWithoutUnits(name, creditPoints, markType));
        getThis().signalChanged(true);
    }
    public void createModuleGroup(final String name, final common.Fraction creditPoints) 
				throws model.NameAlreadyExistsException, PersistenceException{
    	for(ModuleGroup4Public x : ModuleGroupLst.getTheModuleGroupLst().getModuleGroups().getList()) if(x.getName().equals(name)) throw new NameAlreadyExistsException("NameAlreadyExistsException");
    	
    	getThis().getModuleGroups().getModuleGroups().add(ModuleGroup.createModuleGroup(name, creditPoints));
    	getThis().signalChanged(true);
    }
    public void createStudent(final String matricalNumber, final String password, final String forename, final String surname, final java.sql.Date dateOfBirth, final StudyGroup4Public studyGroup) 
				throws model.MatricalNumberAlreadyUsed, model.CreditPointInformationIsNotConsistent, PersistenceException{
    	if(StudentServerLst.getTheStudentServerLst().getStudentServers().get(matricalNumber) != null) throw new MatricalNumberAlreadyUsed("MatricalNumberAlreadyUsed");	
    	
    	if(!studyGroup.getAssignedTo().isConsistent()) {
    		throw new CreditPointInformationIsNotConsistent("CreditPointInformationIsNotConsistent");
    	}
    	
    	StudyGroup4Public studyGroupClone = (StudyGroup4Public)studyGroup.clonePrototype();
        StudentServer4Public student = StudentServer.createStudentServer(matricalNumber, forename, surname, dateOfBirth, studyGroupClone);
        studyGroup.addStudent(student);
        student.getStudyGroupsAttended().add(studyGroupClone);
        StudentServerLst.getTheStudentServerLst().getStudentServers().put(matricalNumber, student);
        try {
			getThis().setActiveSG(student, studyGroupClone);
		} catch (NotInStudyGroupException e) {
			e.printStackTrace();
		}
        Server.createServer(password, matricalNumber, 0, new Timestamp(System.currentTimeMillis()), false);
        getThis().signalChanged(true);
    }
    public void createStudyGroup(final String name, final StudyProgram4Public studyProgram) 
				throws model.NameAlreadyExistsException, model.CreditPointInformationIsNotConsistent, PersistenceException{
    	for(StudyGroup4Public x : StudyGroupLst.getTheStudyGroupLst().getStudyGroups().getList()) if(x.getName().equals(name)) throw new NameAlreadyExistsException("NameAlreadyExistsException");	
    	
    	StudyGroup4Public sg = StudyGroup.createStudyGroup(name, studyProgram);
        getThis().getStudyGroups().getStudyGroups().add(sg);
        getThis().signalChanged(true);
    }
    public void createStudyProgram(final String name, final common.Fraction creditPoints) 
				throws model.NameAlreadyExistsException, PersistenceException{
    	Iterator<StudyProgram4Public> i = StudyProgramLst.getTheStudyProgramLst().getStudyPrograms().iterator();
    	while(i.hasNext()) {
    		if(i.next().getName().equals(name)) throw new NameAlreadyExistsException("NameAlreadyExistsException");	
    	}

    	getThis().getStudyPrograms().getStudyPrograms().add(StudyProgram.createStudyProgram(name, creditPoints));
    	getThis().signalChanged(true);
    }
    public void createUnit(final String name, final common.Fraction creditPoints) 
				throws model.NameAlreadyExistsException, PersistenceException{
    	for(Unit4Public x : UnitLst.getTheUnitLst().getUnits().getList()) if(x.getName().equals(name)) throw new NameAlreadyExistsException("NameAlreadyExistsException");	
    	
    	getThis().getUnits().getUnits().add(Unit.createUnit(name, creditPoints));
    	getThis().signalChanged(true);
    }
    public void disconnected() 
				throws PersistenceException{
        
    }
    public Mark fetchM(final Appr4Public appr) 
				throws model.NotAllowedOperationOnPrototypeException, PersistenceException{
    	if(appr.getPrototypeObservee() == null) {
    		throw new NotAllowedOperationOnPrototypeException("NotAllowedOperationOnPrototypeException");
    	}
    	return appr.fetchMark();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
        getThis().setUnits(UnitLst.getTheUnitLst());
        getThis().setModuleWithUnits(ModuleWithUnitsLst.getTheModuleWithUnitsLst());
        getThis().setModuleWithoutUnits(ModuleWithoutUnitsLst.getTheModuleWithoutUnitsLst());
        getThis().setModuleGroups(ModuleGroupLst.getTheModuleGroupLst());
        getThis().setStudyPrograms(StudyProgramLst.getTheStudyProgramLst());
        getThis().setStudyGroups(StudyGroupLst.getTheStudyGroupLst());
        getThis().setStudents(StudentServerLst.getTheStudentServerLst());
        getThis().setThirdMarks(ThirdMarkLst.getTheThirdMarkLst());
        
        getThis().getModuleWithoutUnitsMarks().add(ThirdMarkLst.getTheThirdMarkLst());
        getThis().getModuleWithoutUnitsMarks().add(BooleanMarkLst.getTheBooleanMarkLst());
        
        Fraction f = new Fraction(BigInteger.ZERO, BigInteger.ONE);
        getThis().getModuleWithoutUnitsMarkTypes().add(ThirdMark.createThirdMark(f));
        getThis().getModuleWithoutUnitsMarkTypes().add(BooleanMark.createBooleanMark());
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
    }
    public void remMGFromMG(final ModuleGroup4Public moduleGroup, final ModuleGroup4Public mG) 
				throws model.AlreadyInUseException, PersistenceException{
    	if(moduleGroup.getPrototypeObserver().getLength() > 0 || moduleGroup.getPrototypeObservee() != null) {
    		throw new AlreadyInUseException("AlreadyInUseException");
    	}
        moduleGroup.removeModuleGroup(mG);
        getThis().signalChanged(true);
    }
    public void remMGFromSP(final StudyProgram4Public studyProgram, final ModuleGroup4Public moduleGroup) 
				throws model.AlreadyInUseException, PersistenceException{
    	if(moduleGroup.getPrototypeObserver().getLength() > 0 || studyProgram.getPrototypeObservee() != null) {
    		throw new AlreadyInUseException("AlreadyInUseException");
    	}
    	studyProgram.removeModuleGroup(moduleGroup);
    	getThis().signalChanged(true);
    }
    public void remMWUFromMG(final ModuleGroup4Public moduleGroup, final ModuleWithUnits4Public moduleWithUnits) 
				throws model.AlreadyInUseException, PersistenceException{
    	if(moduleGroup.getPrototypeObserver().getLength() > 0 || moduleGroup.getPrototypeObservee() != null) {
    		throw new AlreadyInUseException("AlreadyInUseException");
    	}
    	moduleGroup.removeModuleWithUnits(moduleWithUnits);
    	getThis().signalChanged(true);
    }
    public void remMWWUFromMG(final ModuleGroup4Public moduleGroup, final ModuleWithoutUnits4Public moduleWithoutUnits) 
				throws model.AlreadyInUseException, PersistenceException{
    	if(moduleGroup.getPrototypeObserver().getLength() > 0 || moduleGroup.getPrototypeObservee() != null) {
    		throw new AlreadyInUseException("AlreadyInUseException");
    	}
    	moduleGroup.removeModuleWithoutUnits(moduleWithoutUnits);
    	getThis().signalChanged(true);
    }
    public void remUFromMWU(final ModuleWithUnits4Public moduleWithUnits, final Unit4Public unit) 
				throws model.AlreadyInUseException, PersistenceException{
    	if(moduleWithUnits.getPrototypeObserver().getLength() > 0 || moduleWithUnits.getPrototypeObservee() != null) {
    		throw new AlreadyInUseException("AlreadyInUseException");
    	}
    	moduleWithUnits.removeUnit(unit);
    	getThis().signalChanged(true);
    }
    public void removeModuleGroup(final ModuleGroup4Public moduleGroup) 
				throws model.AlreadyInUseException, PersistenceException{
    	if(moduleGroup.getPrototypeObserver().getLength() > 0 || moduleGroup.getPrototypeObservee() != null) {
    		throw new AlreadyInUseException("AlreadyInUseException");
    	}
    	Iterator<StudyProgram4Public> mi = StudyProgramLst.getTheStudyProgramLst().getStudyPrograms().iterator();
    	while(mi.hasNext()) {
    		Iterator<ModuleGroup4Public> ui = mi.next().getModuleGroups().iterator();
    		while(ui.hasNext()) {
    			if(ui.next().equals(moduleGroup)) {
    				throw new AlreadyInUseException("AlreadyInUseException");
    			}
    		}
    	}
    	ModuleGroupLst.getTheModuleGroupLst().getModuleGroups().removeAll(moduleGroup);
    	moduleGroup.delete$Me();
    	getThis().signalChanged(true);
    }
    public void removeStudyGroup(final StudyGroup4Public studyGroup) 
				throws model.AlreadyInUseException, PersistenceException{
    	if(studyGroup.getPrototypeObserver().getLength() > 0 || studyGroup.getPrototypeObservee() != null) {
    		throw new AlreadyInUseException("AlreadyInUseException");
    	}
    	if(studyGroup.getStudents().iterator().hasNext()) {
    		throw new AlreadyInUseException("AlreadyInUseException");
    	}
    	StudyGroupLst.getTheStudyGroupLst().getStudyGroups().removeAll(studyGroup);
    	studyGroup.delete$Me();
    	getThis().signalChanged(true);
    }
    public void removeStudyProgram(final StudyProgram4Public studyProgram) 
				throws model.AlreadyInUseException, PersistenceException{
    	if(studyProgram.getPrototypeObserver().getLength() > 0 || studyProgram.getPrototypeObservee() != null) {
    		throw new AlreadyInUseException("AlreadyInUseException");
    	}
    	Iterator<StudyGroup4Public> mi = StudyGroupLst.getTheStudyGroupLst().getStudyGroups().iterator();
    	while(mi.hasNext()) {
    		if(mi.next().getAssignedTo().equals(studyProgram)) {
    			throw new AlreadyInUseException("AlreadyInUseException");
    		}
    	}
    	StudyProgramLst.getTheStudyProgramLst().getStudyPrograms().removeAll(studyProgram);
    	studyProgram.delete$Me();
    	getThis().signalChanged(true);
    }
    public void removeUnit(final Unit4Public unit) 
				throws model.UnitIsAlreadyPartOfAModuleWithUnitsException, model.AlreadyInUseException, PersistenceException{
    	if(unit.getPrototypeObserver().getLength() > 0 || unit.getPrototypeObservee() != null) {
    		throw new AlreadyInUseException("AlreadyInUseException");
    	}
    	Iterator<ModuleWithUnits4Public> mi = ModuleWithUnitsLst.getTheModuleWithUnitsLst().getModuleWithUnits().iterator();
    	while(mi.hasNext()) {
    		Iterator<Unit4Public> ui = mi.next().getConsistsOf().iterator();
    		while(ui.hasNext()) {
    			if(ui.next().equals(unit)) {
    				throw new UnitIsAlreadyPartOfAModuleWithUnitsException("UnitIsAlreadyPartOfAModuleWithUnitsException");
    			}
    		}
    	}
    	UnitLst.getTheUnitLst().getUnits().removeAll(unit);
    	unit.delete$Me();
    	getThis().signalChanged(true);
    }
    public void rmvMWOU(final ModuleWithoutUnits4Public moduleWithoutUnits) 
				throws model.AlreadyInUseException, PersistenceException{
    	if(moduleWithoutUnits.getPrototypeObserver().getLength() > 0 || moduleWithoutUnits.getPrototypeObservee() != null) {
    		throw new AlreadyInUseException("AlreadyInUseException");
    	}
    	Iterator<ModuleGroup4Public> mi = ModuleGroupLst.getTheModuleGroupLst().getModuleGroups().iterator();
    	while(mi.hasNext()) {
    		Iterator<ModuleWithoutUnits4Public> ui = mi.next().getModuleWithoutUnits().iterator();
    		while(ui.hasNext()) {
    			if(ui.next().equals(moduleWithoutUnits)) {
    				throw new AlreadyInUseException("AlreadyInUseException");
    			}
    		}
    	}
    	ModuleWithoutUnitsLst.getTheModuleWithoutUnitsLst().getModuleWithoutUnits().removeAll(moduleWithoutUnits);
    	moduleWithoutUnits.delete$Me();
    	getThis().signalChanged(true);
    }
    public void rmvMWU(final ModuleWithUnits4Public moduleWithUnits) 
				throws model.AlreadyInUseException, PersistenceException{
    	if(moduleWithUnits.getPrototypeObserver().getLength() > 0 || moduleWithUnits.getPrototypeObservee() != null) {
    		throw new AlreadyInUseException("AlreadyInUseException");
    	}
    	Iterator<ModuleGroup4Public> mi = ModuleGroupLst.getTheModuleGroupLst().getModuleGroups().iterator();
    	while(mi.hasNext()) {
    		Iterator<ModuleWithUnits4Public> ui = mi.next().getModuleWithUnits().iterator();
    		while(ui.hasNext()) {
    			if(ui.next().equals(moduleWithUnits)) {
    				throw new AlreadyInUseException("AlreadyInUseException");
    			}
    		}
    	}
    	ModuleWithUnitsLst.getTheModuleWithUnitsLst().getModuleWithUnits().removeAll(moduleWithUnits);
    	moduleWithUnits.delete$Me();
    	getThis().signalChanged(true);
    }
    public void setActiveSG(final StudentServer4Public student, final StudyGroup4Public studyGroup) 
				throws model.NotInStudyGroupException, PersistenceException{
    	Iterator<StudyGroup4Public> sg = student.getStudyGroupsAttended().iterator();
//    	while (sg.hasNext()) {
//			if(sg.next().equals(studyGroup)) return;
//		}
    	student.setActiveStudyGroup(studyGroup);
    	student.setActiveStudyGroupName(studyGroup.getName());
    	getThis().signalChanged(true);
    }
    public void sorcMTSWiMWuU(final ModuleWithoutUnits4Public moduleWithoutUnits, final Mark mark, final String comment) 
				throws model.OtherTypeThanSettedException, model.NotAllowedOperationOnPrototypeException, PersistenceException{
    	if(moduleWithoutUnits.getPrototypeObservee() == null) {
    		throw new NotAllowedOperationOnPrototypeException("NotAllowedOperationOnPrototypeException");
    	}
    	moduleWithoutUnits.setMark(mark, comment);
    	getThis().signalChanged(true);
    }
    public void sorcMTSWiU(final Unit4Public unit, final ThirdMark4Public mark, final String comment) 
				throws model.NotAllowedOperationOnPrototypeException, PersistenceException{
    	if(unit.getPrototypeObservee() == null) {
    		throw new NotAllowedOperationOnPrototypeException("NotAllowedOperationOnPrototypeException");
    	}
    	unit.setMark(mark, comment);
    	getThis().signalChanged(true);
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
