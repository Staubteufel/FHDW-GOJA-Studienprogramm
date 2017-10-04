
package modelServer;


import persistence.*;

public  class RemoteAdminServer extends RemoteService {

	
	public RemoteAdminServer(String connectionName, String userName, PersistentAdminServer server){
		super (connectionName, userName , server);
	}

	
 

    public synchronized java.util.HashMap<?,?> adminServer_Menu_Filter(String anythingProxiString){
        try {
            Anything anything = (Anything)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(anythingProxiString));
            String result = ((PersistentAdminServer)this.server).adminServer_Menu_Filter(anything);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> mG_Path_In_AddMGToMG(){
        try {
            ModuleGroupLst4Public result = ((PersistentAdminServer)this.server).mG_Path_In_AddMGToMG();
            return createOKResult(result, 1);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> mG_Path_In_RemMGFromMG(String moduleGroupProxiString){
        try {
            PersistentModuleGroup moduleGroup = (PersistentModuleGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleGroupProxiString));
            ModuleGroupSearchList result = ((PersistentAdminServer)this.server).mG_Path_In_RemMGFromMG(moduleGroup);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> markType_Path_In_CreateMWWU(){
        try {
            MarkSearchList result = ((PersistentAdminServer)this.server).markType_Path_In_CreateMWWU();
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> mark_Path_In_SorcMTSWiMWuU(){
        try {
            AnythingSearchList result = ((PersistentAdminServer)this.server).mark_Path_In_SorcMTSWiMWuU();
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> mark_Path_In_SorcMTSWiU(){
        try {
            ThirdMarkLst4Public result = ((PersistentAdminServer)this.server).mark_Path_In_SorcMTSWiU();
            return createOKResult(result, 1);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> moduleGroup_Path_In_AddMGToSP(){
        try {
            ModuleGroupLst4Public result = ((PersistentAdminServer)this.server).moduleGroup_Path_In_AddMGToSP();
            return createOKResult(result, 1);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> moduleGroup_Path_In_RemMGFromSP(String studyProgramProxiString){
        try {
            PersistentStudyProgram studyProgram = (PersistentStudyProgram)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studyProgramProxiString));
            ModuleGroupSearchList result = ((PersistentAdminServer)this.server).moduleGroup_Path_In_RemMGFromSP(studyProgram);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> moduleWithUnits_Path_In_AddMWUToMG(){
        try {
            ModuleWithUnitsLst4Public result = ((PersistentAdminServer)this.server).moduleWithUnits_Path_In_AddMWUToMG();
            return createOKResult(result, 1);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> moduleWithUnits_Path_In_RemMWUFromMG(String moduleGroupProxiString){
        try {
            PersistentModuleGroup moduleGroup = (PersistentModuleGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleGroupProxiString));
            ModuleWithUnitsSearchList result = ((PersistentAdminServer)this.server).moduleWithUnits_Path_In_RemMWUFromMG(moduleGroup);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> moduleWithoutUnits_Path_In_AddMWWUToMG(){
        try {
            ModuleWithoutUnitsLst4Public result = ((PersistentAdminServer)this.server).moduleWithoutUnits_Path_In_AddMWWUToMG();
            return createOKResult(result, 1);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> moduleWithoutUnits_Path_In_RemMWWUFromMG(String moduleGroupProxiString){
        try {
            PersistentModuleGroup moduleGroup = (PersistentModuleGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleGroupProxiString));
            ModuleWithoutUnitsSearchList result = ((PersistentAdminServer)this.server).moduleWithoutUnits_Path_In_RemMWWUFromMG(moduleGroup);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> moduleWithoutUnits_Path_In_SorcMTSWiMWuU(){
        try {
            ModuleWithoutUnitsLst4Public result = ((PersistentAdminServer)this.server).moduleWithoutUnits_Path_In_SorcMTSWiMWuU();
            return createOKResult(result, 1);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> student_Path_In_AddSToSG(){
        try {
            StudentServerLst4Public result = ((PersistentAdminServer)this.server).student_Path_In_AddSToSG();
            return createOKResult(result, 1);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> studyGroup_Path_In_CreateStudent(){
        try {
            StudyGroupLst4Public result = ((PersistentAdminServer)this.server).studyGroup_Path_In_CreateStudent();
            return createOKResult(result, 1);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> studyGroup_Path_In_SetActiveSG(String studentProxiString){
        try {
            PersistentStudentServer student = (PersistentStudentServer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studentProxiString));
            StudyGroupSearchList result = ((PersistentAdminServer)this.server).studyGroup_Path_In_SetActiveSG(student);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> studyProgram_Path_In_CreateStudyGroup(){
        try {
            StudyProgramLst4Public result = ((PersistentAdminServer)this.server).studyProgram_Path_In_CreateStudyGroup();
            return createOKResult(result, 1);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> unit_Path_In_AddUToMWU(){
        try {
            UnitLst4Public result = ((PersistentAdminServer)this.server).unit_Path_In_AddUToMWU();
            return createOKResult(result, 1);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> unit_Path_In_RemUFromMWU(String moduleWithUnitsProxiString){
        try {
            PersistentModuleWithUnits moduleWithUnits = (PersistentModuleWithUnits)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleWithUnitsProxiString));
            UnitSearchList result = ((PersistentAdminServer)this.server).unit_Path_In_RemUFromMWU(moduleWithUnits);
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> unit_Path_In_SorcMTSWiU(){
        try {
            UnitLst4Public result = ((PersistentAdminServer)this.server).unit_Path_In_SorcMTSWiU();
            return createOKResult(result, 1);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> addMGToMG(String moduleGroupProxiString, String mGProxiString){
        try {
            PersistentModuleGroup moduleGroup = (PersistentModuleGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleGroupProxiString));
            PersistentModuleGroup mG = (PersistentModuleGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(mGProxiString));
            ((PersistentAdminServer)this.server).addMGToMG(moduleGroup, mG);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.CycleException e0){
            return createExceptionResult(e0);
        }catch(model.AlreadyInUseException e1){
            return createExceptionResult(e1);
        }
    }
    
    public synchronized java.util.HashMap<?,?> addMGToSP(String studyProgramProxiString, String moduleGroupProxiString){
        try {
            PersistentStudyProgram studyProgram = (PersistentStudyProgram)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studyProgramProxiString));
            PersistentModuleGroup moduleGroup = (PersistentModuleGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleGroupProxiString));
            ((PersistentAdminServer)this.server).addMGToSP(studyProgram, moduleGroup);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.AlreadyInUseException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> addMWUToMG(String moduleGroupProxiString, String moduleWithUnitsProxiString){
        try {
            PersistentModuleGroup moduleGroup = (PersistentModuleGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleGroupProxiString));
            PersistentModuleWithUnits moduleWithUnits = (PersistentModuleWithUnits)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleWithUnitsProxiString));
            ((PersistentAdminServer)this.server).addMWUToMG(moduleGroup, moduleWithUnits);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.CycleException e0){
            return createExceptionResult(e0);
        }catch(model.AlreadyInUseException e1){
            return createExceptionResult(e1);
        }
    }
    
    public synchronized java.util.HashMap<?,?> addMWWUToMG(String moduleGroupProxiString, String moduleWithoutUnitsProxiString){
        try {
            PersistentModuleGroup moduleGroup = (PersistentModuleGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleGroupProxiString));
            PersistentModuleWithoutUnits moduleWithoutUnits = (PersistentModuleWithoutUnits)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleWithoutUnitsProxiString));
            ((PersistentAdminServer)this.server).addMWWUToMG(moduleGroup, moduleWithoutUnits);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.CycleException e0){
            return createExceptionResult(e0);
        }catch(model.AlreadyInUseException e1){
            return createExceptionResult(e1);
        }
    }
    
    public synchronized java.util.HashMap<?,?> addSToSG(String studyGroupProxiString, String studentProxiString){
        try {
            PersistentStudyGroup studyGroup = (PersistentStudyGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studyGroupProxiString));
            PersistentStudentServer student = (PersistentStudentServer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studentProxiString));
            ((PersistentAdminServer)this.server).addSToSG(studyGroup, student);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.AlreadyInUseException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> addUToMWU(String moduleWithUnitsProxiString, String unitProxiString){
        try {
            PersistentModuleWithUnits moduleWithUnits = (PersistentModuleWithUnits)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleWithUnitsProxiString));
            PersistentUnit unit = (PersistentUnit)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitProxiString));
            ((PersistentAdminServer)this.server).addUToMWU(moduleWithUnits, unit);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.ThereIsAlreadyAStudyGroupException e0){
            return createExceptionResult(e0);
        }catch(model.UnitIsAlreadyPartOfAModuleWithUnitsException e1){
            return createExceptionResult(e1);
        }catch(model.AlreadyInUseException e2){
            return createExceptionResult(e2);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeCP(String apprProxiString, String creditPointsAsString){
        try {
            PersistentAppr appr = (PersistentAppr)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(apprProxiString));
            common.Fraction creditPoints = common.Fraction.parse(creditPointsAsString);
            ((PersistentAdminServer)this.server).changeCP(appr, creditPoints);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.AlreadyInUseException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createMWU(String name, String creditPointsAsString){
        try {
            common.Fraction creditPoints = common.Fraction.parse(creditPointsAsString);
            ((PersistentAdminServer)this.server).createMWU(name, creditPoints);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.NameAlreadyExistsException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createMWWU(String name, String creditPointsAsString, String markTypeProxiString){
        try {
            common.Fraction creditPoints = common.Fraction.parse(creditPointsAsString);
            Mark markType = (Mark)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(markTypeProxiString));
            ((PersistentAdminServer)this.server).createMWWU(name, creditPoints, markType);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.NameAlreadyExistsException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createModuleGroup(String name, String creditPointsAsString){
        try {
            common.Fraction creditPoints = common.Fraction.parse(creditPointsAsString);
            ((PersistentAdminServer)this.server).createModuleGroup(name, creditPoints);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.NameAlreadyExistsException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createStudent(String matricalNumber, String password, String forename, String surname, java.util.Date dateOfBirth, String studyGroupProxiString){
        try {
            PersistentStudyGroup studyGroup = (PersistentStudyGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studyGroupProxiString));
            ((PersistentAdminServer)this.server).createStudent(matricalNumber, password, forename, surname, new java.sql.Date(dateOfBirth.getTime()), studyGroup);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.MatricalNumberAlreadyUsed e0){
            return createExceptionResult(e0);
        }catch(model.CreditPointInformationIsNotConsistent e1){
            return createExceptionResult(e1);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createStudyGroup(String name, String studyProgramProxiString){
        try {
            PersistentStudyProgram studyProgram = (PersistentStudyProgram)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studyProgramProxiString));
            ((PersistentAdminServer)this.server).createStudyGroup(name, studyProgram);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.NameAlreadyExistsException e0){
            return createExceptionResult(e0);
        }catch(model.CreditPointInformationIsNotConsistent e1){
            return createExceptionResult(e1);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createStudyProgram(String name, String creditPointsAsString){
        try {
            common.Fraction creditPoints = common.Fraction.parse(creditPointsAsString);
            ((PersistentAdminServer)this.server).createStudyProgram(name, creditPoints);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.NameAlreadyExistsException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createUnit(String name, String creditPointsAsString){
        try {
            common.Fraction creditPoints = common.Fraction.parse(creditPointsAsString);
            ((PersistentAdminServer)this.server).createUnit(name, creditPoints);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.NameAlreadyExistsException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> fetchM(String apprProxiString){
        try {
            PersistentAppr appr = (PersistentAppr)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(apprProxiString));
            Mark result = ((PersistentAdminServer)this.server).fetchM(appr);
            return createOKResult(result, 1);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.NotAllowedOperationOnPrototypeException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> remMGFromMG(String moduleGroupProxiString, String mGProxiString){
        try {
            PersistentModuleGroup moduleGroup = (PersistentModuleGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleGroupProxiString));
            PersistentModuleGroup mG = (PersistentModuleGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(mGProxiString));
            ((PersistentAdminServer)this.server).remMGFromMG(moduleGroup, mG);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.AlreadyInUseException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> remMGFromSP(String studyProgramProxiString, String moduleGroupProxiString){
        try {
            PersistentStudyProgram studyProgram = (PersistentStudyProgram)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studyProgramProxiString));
            PersistentModuleGroup moduleGroup = (PersistentModuleGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleGroupProxiString));
            ((PersistentAdminServer)this.server).remMGFromSP(studyProgram, moduleGroup);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.AlreadyInUseException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> remMWUFromMG(String moduleGroupProxiString, String moduleWithUnitsProxiString){
        try {
            PersistentModuleGroup moduleGroup = (PersistentModuleGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleGroupProxiString));
            PersistentModuleWithUnits moduleWithUnits = (PersistentModuleWithUnits)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleWithUnitsProxiString));
            ((PersistentAdminServer)this.server).remMWUFromMG(moduleGroup, moduleWithUnits);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.AlreadyInUseException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> remMWWUFromMG(String moduleGroupProxiString, String moduleWithoutUnitsProxiString){
        try {
            PersistentModuleGroup moduleGroup = (PersistentModuleGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleGroupProxiString));
            PersistentModuleWithoutUnits moduleWithoutUnits = (PersistentModuleWithoutUnits)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleWithoutUnitsProxiString));
            ((PersistentAdminServer)this.server).remMWWUFromMG(moduleGroup, moduleWithoutUnits);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.AlreadyInUseException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> remUFromMWU(String moduleWithUnitsProxiString, String unitProxiString){
        try {
            PersistentModuleWithUnits moduleWithUnits = (PersistentModuleWithUnits)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleWithUnitsProxiString));
            PersistentUnit unit = (PersistentUnit)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitProxiString));
            ((PersistentAdminServer)this.server).remUFromMWU(moduleWithUnits, unit);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.AlreadyInUseException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> removeModuleGroup(String moduleGroupProxiString){
        try {
            PersistentModuleGroup moduleGroup = (PersistentModuleGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleGroupProxiString));
            ((PersistentAdminServer)this.server).removeModuleGroup(moduleGroup);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.AlreadyInUseException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> removeStudyGroup(String studyGroupProxiString){
        try {
            PersistentStudyGroup studyGroup = (PersistentStudyGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studyGroupProxiString));
            ((PersistentAdminServer)this.server).removeStudyGroup(studyGroup);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.AlreadyInUseException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> removeStudyProgram(String studyProgramProxiString){
        try {
            PersistentStudyProgram studyProgram = (PersistentStudyProgram)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studyProgramProxiString));
            ((PersistentAdminServer)this.server).removeStudyProgram(studyProgram);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.AlreadyInUseException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> removeUnit(String unitProxiString){
        try {
            PersistentUnit unit = (PersistentUnit)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitProxiString));
            ((PersistentAdminServer)this.server).removeUnit(unit);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UnitIsAlreadyPartOfAModuleWithUnitsException e0){
            return createExceptionResult(e0);
        }catch(model.AlreadyInUseException e1){
            return createExceptionResult(e1);
        }
    }
    
    public synchronized java.util.HashMap<?,?> rmvMWOU(String moduleWithoutUnitsProxiString){
        try {
            PersistentModuleWithoutUnits moduleWithoutUnits = (PersistentModuleWithoutUnits)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleWithoutUnitsProxiString));
            ((PersistentAdminServer)this.server).rmvMWOU(moduleWithoutUnits);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.AlreadyInUseException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> rmvMWU(String moduleWithUnitsProxiString){
        try {
            PersistentModuleWithUnits moduleWithUnits = (PersistentModuleWithUnits)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleWithUnitsProxiString));
            ((PersistentAdminServer)this.server).rmvMWU(moduleWithUnits);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.AlreadyInUseException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> setActiveSG(String studentProxiString, String studyGroupProxiString){
        try {
            PersistentStudentServer student = (PersistentStudentServer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studentProxiString));
            PersistentStudyGroup studyGroup = (PersistentStudyGroup)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(studyGroupProxiString));
            ((PersistentAdminServer)this.server).setActiveSG(student, studyGroup);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.NotInStudyGroupException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> sorcMTSWiMWuU(String moduleWithoutUnitsProxiString, String markProxiString, String comment){
        try {
            PersistentModuleWithoutUnits moduleWithoutUnits = (PersistentModuleWithoutUnits)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(moduleWithoutUnitsProxiString));
            Mark mark = (Mark)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(markProxiString));
            ((PersistentAdminServer)this.server).sorcMTSWiMWuU(moduleWithoutUnits, mark, comment);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.OtherTypeThanSettedException e0){
            return createExceptionResult(e0);
        }catch(model.NotAllowedOperationOnPrototypeException e1){
            return createExceptionResult(e1);
        }
    }
    
    public synchronized java.util.HashMap<?,?> sorcMTSWiU(String unitProxiString, String markProxiString, String comment){
        try {
            PersistentUnit unit = (PersistentUnit)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitProxiString));
            PersistentThirdMark mark = (PersistentThirdMark)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(markProxiString));
            ((PersistentAdminServer)this.server).sorcMTSWiU(unit, mark, comment);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.NotAllowedOperationOnPrototypeException e0){
            return createExceptionResult(e0);
        }
    }
    


}