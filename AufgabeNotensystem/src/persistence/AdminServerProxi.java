package persistence;



import model.visitor.*;

public class AdminServerProxi extends ServiceProxi implements PersistentAdminServer{
    
    public AdminServerProxi(long objectId) {
        super(objectId);
    }
    public AdminServerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return -201;
    }
    
    public UnitLst4Public getUnits() throws PersistenceException {
        return ((PersistentAdminServer)this.getTheObject()).getUnits();
    }
    public void setUnits(UnitLst4Public newValue) throws PersistenceException {
        ((PersistentAdminServer)this.getTheObject()).setUnits(newValue);
    }
    public ModuleWithUnitsLst4Public getModuleWithUnits() throws PersistenceException {
        return ((PersistentAdminServer)this.getTheObject()).getModuleWithUnits();
    }
    public void setModuleWithUnits(ModuleWithUnitsLst4Public newValue) throws PersistenceException {
        ((PersistentAdminServer)this.getTheObject()).setModuleWithUnits(newValue);
    }
    public ModuleWithoutUnitsLst4Public getModuleWithoutUnits() throws PersistenceException {
        return ((PersistentAdminServer)this.getTheObject()).getModuleWithoutUnits();
    }
    public void setModuleWithoutUnits(ModuleWithoutUnitsLst4Public newValue) throws PersistenceException {
        ((PersistentAdminServer)this.getTheObject()).setModuleWithoutUnits(newValue);
    }
    public ModuleGroupLst4Public getModuleGroups() throws PersistenceException {
        return ((PersistentAdminServer)this.getTheObject()).getModuleGroups();
    }
    public void setModuleGroups(ModuleGroupLst4Public newValue) throws PersistenceException {
        ((PersistentAdminServer)this.getTheObject()).setModuleGroups(newValue);
    }
    public StudyProgramLst4Public getStudyPrograms() throws PersistenceException {
        return ((PersistentAdminServer)this.getTheObject()).getStudyPrograms();
    }
    public void setStudyPrograms(StudyProgramLst4Public newValue) throws PersistenceException {
        ((PersistentAdminServer)this.getTheObject()).setStudyPrograms(newValue);
    }
    public StudyGroupLst4Public getStudyGroups() throws PersistenceException {
        return ((PersistentAdminServer)this.getTheObject()).getStudyGroups();
    }
    public void setStudyGroups(StudyGroupLst4Public newValue) throws PersistenceException {
        ((PersistentAdminServer)this.getTheObject()).setStudyGroups(newValue);
    }
    public StudentServerLst4Public getStudents() throws PersistenceException {
        return ((PersistentAdminServer)this.getTheObject()).getStudents();
    }
    public void setStudents(StudentServerLst4Public newValue) throws PersistenceException {
        ((PersistentAdminServer)this.getTheObject()).setStudents(newValue);
    }
    public AdminServer_ModuleWithoutUnitsMarkTypesProxi getModuleWithoutUnitsMarkTypes() throws PersistenceException {
        return ((PersistentAdminServer)this.getTheObject()).getModuleWithoutUnitsMarkTypes();
    }
    public ThirdMarkLst4Public getThirdMarks() throws PersistenceException {
        return ((PersistentAdminServer)this.getTheObject()).getThirdMarks();
    }
    public void setThirdMarks(ThirdMarkLst4Public newValue) throws PersistenceException {
        ((PersistentAdminServer)this.getTheObject()).setThirdMarks(newValue);
    }
    public AdminServer_ModuleWithoutUnitsMarksProxi getModuleWithoutUnitsMarks() throws PersistenceException {
        return ((PersistentAdminServer)this.getTheObject()).getModuleWithoutUnitsMarks();
    }
    public PersistentAdminServer getThis() throws PersistenceException {
        return ((PersistentAdminServer)this.getTheObject()).getThis();
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
    
    
    public void addMGToMG(final ModuleGroup4Public moduleGroup, final ModuleGroup4Public mG, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).addMGToMG(moduleGroup, mG, invoker);
    }
    public void addMGToSP(final StudyProgram4Public studyProgram, final ModuleGroup4Public moduleGroup, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).addMGToSP(studyProgram, moduleGroup, invoker);
    }
    public void addMWUToMG(final ModuleGroup4Public moduleGroup, final ModuleWithUnits4Public moduleWithUnits, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).addMWUToMG(moduleGroup, moduleWithUnits, invoker);
    }
    public void addMWWUToMG(final ModuleGroup4Public moduleGroup, final ModuleWithoutUnits4Public moduleWithoutUnits, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).addMWWUToMG(moduleGroup, moduleWithoutUnits, invoker);
    }
    public void addSToSG(final StudyGroup4Public studyGroup, final StudentServer4Public student, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).addSToSG(studyGroup, student, invoker);
    }
    public void addUToMWU(final ModuleWithUnits4Public moduleWithUnits, final Unit4Public unit, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).addUToMWU(moduleWithUnits, unit, invoker);
    }
    public String adminServer_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).adminServer_Menu_Filter(anything);
    }
    public void changeCP(final Appr4Public appr, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).changeCP(appr, creditPoints, invoker);
    }
    public void createMWU(final String name, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).createMWU(name, creditPoints, invoker);
    }
    public void createMWWU(final String name, final common.Fraction creditPoints, final Mark markType, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).createMWWU(name, creditPoints, markType, invoker);
    }
    public void createModuleGroup(final String name, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).createModuleGroup(name, creditPoints, invoker);
    }
    public void createStudent(final String matricalNumber, final String password, final String forename, final String surname, final java.sql.Date dateOfBirth, final StudyGroup4Public studyGroup, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).createStudent(matricalNumber, password, forename, surname, dateOfBirth, studyGroup, invoker);
    }
    public void createStudyGroup(final String name, final StudyProgram4Public studyProgram, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).createStudyGroup(name, studyProgram, invoker);
    }
    public void createStudyProgram(final String name, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).createStudyProgram(name, creditPoints, invoker);
    }
    public void createUnit(final String name, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).createUnit(name, creditPoints, invoker);
    }
    public void fetchM(final Appr4Public appr, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).fetchM(appr, invoker);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).initialize(This, final$$Fields);
    }
    public ModuleGroupLst4Public mG_Path_In_AddMGToMG() 
				throws model.UserException, PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).mG_Path_In_AddMGToMG();
    }
    public ModuleGroupSearchList mG_Path_In_RemMGFromMG(final ModuleGroup4Public moduleGroup) 
				throws model.UserException, PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).mG_Path_In_RemMGFromMG(moduleGroup);
    }
    public MarkSearchList markType_Path_In_CreateMWWU() 
				throws model.UserException, PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).markType_Path_In_CreateMWWU();
    }
    public AnythingSearchList mark_Path_In_SorcMTSWiMWuU() 
				throws model.UserException, PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).mark_Path_In_SorcMTSWiMWuU();
    }
    public ThirdMarkLst4Public mark_Path_In_SorcMTSWiU() 
				throws model.UserException, PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).mark_Path_In_SorcMTSWiU();
    }
    public ModuleGroupLst4Public moduleGroup_Path_In_AddMGToSP() 
				throws model.UserException, PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).moduleGroup_Path_In_AddMGToSP();
    }
    public ModuleGroupSearchList moduleGroup_Path_In_RemMGFromSP(final StudyProgram4Public studyProgram) 
				throws model.UserException, PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).moduleGroup_Path_In_RemMGFromSP(studyProgram);
    }
    public ModuleWithUnitsLst4Public moduleWithUnits_Path_In_AddMWUToMG() 
				throws model.UserException, PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).moduleWithUnits_Path_In_AddMWUToMG();
    }
    public ModuleWithUnitsSearchList moduleWithUnits_Path_In_RemMWUFromMG(final ModuleGroup4Public moduleGroup) 
				throws model.UserException, PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).moduleWithUnits_Path_In_RemMWUFromMG(moduleGroup);
    }
    public ModuleWithoutUnitsLst4Public moduleWithoutUnits_Path_In_AddMWWUToMG() 
				throws model.UserException, PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).moduleWithoutUnits_Path_In_AddMWWUToMG();
    }
    public ModuleWithoutUnitsSearchList moduleWithoutUnits_Path_In_RemMWWUFromMG(final ModuleGroup4Public moduleGroup) 
				throws model.UserException, PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).moduleWithoutUnits_Path_In_RemMWWUFromMG(moduleGroup);
    }
    public ModuleWithoutUnitsLst4Public moduleWithoutUnits_Path_In_SorcMTSWiMWuU() 
				throws model.UserException, PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).moduleWithoutUnits_Path_In_SorcMTSWiMWuU();
    }
    public void remMGFromMG(final ModuleGroup4Public moduleGroup, final ModuleGroup4Public mG, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).remMGFromMG(moduleGroup, mG, invoker);
    }
    public void remMGFromSP(final StudyProgram4Public studyProgram, final ModuleGroup4Public moduleGroup, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).remMGFromSP(studyProgram, moduleGroup, invoker);
    }
    public void remMWUFromMG(final ModuleGroup4Public moduleGroup, final ModuleWithUnits4Public moduleWithUnits, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).remMWUFromMG(moduleGroup, moduleWithUnits, invoker);
    }
    public void remMWWUFromMG(final ModuleGroup4Public moduleGroup, final ModuleWithoutUnits4Public moduleWithoutUnits, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).remMWWUFromMG(moduleGroup, moduleWithoutUnits, invoker);
    }
    public void remUFromMWU(final ModuleWithUnits4Public moduleWithUnits, final Unit4Public unit, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).remUFromMWU(moduleWithUnits, unit, invoker);
    }
    public void removeModuleGroup(final ModuleGroup4Public moduleGroup, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).removeModuleGroup(moduleGroup, invoker);
    }
    public void removeStudyGroup(final StudyGroup4Public studyGroup, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).removeStudyGroup(studyGroup, invoker);
    }
    public void removeStudyProgram(final StudyProgram4Public studyProgram, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).removeStudyProgram(studyProgram, invoker);
    }
    public void removeUnit(final Unit4Public unit, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).removeUnit(unit, invoker);
    }
    public void rmvMWOU(final ModuleWithoutUnits4Public moduleWithoutUnits, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).rmvMWOU(moduleWithoutUnits, invoker);
    }
    public void rmvMWU(final ModuleWithUnits4Public moduleWithUnits, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).rmvMWU(moduleWithUnits, invoker);
    }
    public void setActiveSG(final StudentServer4Public student, final StudyGroup4Public studyGroup, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).setActiveSG(student, studyGroup, invoker);
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).signalChanged(signal);
    }
    public void sorcMTSWiMWuU(final ModuleWithoutUnits4Public moduleWithoutUnits, final Mark mark, final String comment, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).sorcMTSWiMWuU(moduleWithoutUnits, mark, comment, invoker);
    }
    public void sorcMTSWiU(final Unit4Public unit, final ThirdMark4Public mark, final String comment, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).sorcMTSWiU(unit, mark, comment, invoker);
    }
    public StudentServerLst4Public student_Path_In_AddSToSG() 
				throws model.UserException, PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).student_Path_In_AddSToSG();
    }
    public StudyGroupLst4Public studyGroup_Path_In_CreateStudent() 
				throws model.UserException, PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).studyGroup_Path_In_CreateStudent();
    }
    public StudyGroupSearchList studyGroup_Path_In_SetActiveSG(final StudentServer4Public student) 
				throws model.UserException, PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).studyGroup_Path_In_SetActiveSG(student);
    }
    public StudyProgramLst4Public studyProgram_Path_In_CreateStudyGroup() 
				throws model.UserException, PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).studyProgram_Path_In_CreateStudyGroup();
    }
    public UnitLst4Public unit_Path_In_AddUToMWU() 
				throws model.UserException, PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).unit_Path_In_AddUToMWU();
    }
    public UnitSearchList unit_Path_In_RemUFromMWU(final ModuleWithUnits4Public moduleWithUnits) 
				throws model.UserException, PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).unit_Path_In_RemUFromMWU(moduleWithUnits);
    }
    public UnitLst4Public unit_Path_In_SorcMTSWiU() 
				throws model.UserException, PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).unit_Path_In_SorcMTSWiU();
    }
    public void addMGToMG(final ModuleGroup4Public moduleGroup, final ModuleGroup4Public mG) 
				throws model.CycleException, model.AlreadyInUseException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).addMGToMG(moduleGroup, mG);
    }
    public void addMGToSP(final StudyProgram4Public studyProgram, final ModuleGroup4Public moduleGroup) 
				throws model.AlreadyInUseException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).addMGToSP(studyProgram, moduleGroup);
    }
    public void addMWUToMG(final ModuleGroup4Public moduleGroup, final ModuleWithUnits4Public moduleWithUnits) 
				throws model.CycleException, model.AlreadyInUseException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).addMWUToMG(moduleGroup, moduleWithUnits);
    }
    public void addMWWUToMG(final ModuleGroup4Public moduleGroup, final ModuleWithoutUnits4Public moduleWithoutUnits) 
				throws model.CycleException, model.AlreadyInUseException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).addMWWUToMG(moduleGroup, moduleWithoutUnits);
    }
    public void addSToSG(final StudyGroup4Public studyGroup, final StudentServer4Public student) 
				throws model.AlreadyInUseException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).addSToSG(studyGroup, student);
    }
    public void addUToMWU(final ModuleWithUnits4Public moduleWithUnits, final Unit4Public unit) 
				throws model.ThereIsAlreadyAStudyGroupException, model.UnitIsAlreadyPartOfAModuleWithUnitsException, model.AlreadyInUseException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).addUToMWU(moduleWithUnits, unit);
    }
    public void changeCP(final Appr4Public appr, final common.Fraction creditPoints) 
				throws model.AlreadyInUseException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).changeCP(appr, creditPoints);
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createMWU(final String name, final common.Fraction creditPoints) 
				throws model.NameAlreadyExistsException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).createMWU(name, creditPoints);
    }
    public void createMWWU(final String name, final common.Fraction creditPoints, final Mark markType) 
				throws model.NameAlreadyExistsException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).createMWWU(name, creditPoints, markType);
    }
    public void createModuleGroup(final String name, final common.Fraction creditPoints) 
				throws model.NameAlreadyExistsException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).createModuleGroup(name, creditPoints);
    }
    public void createStudent(final String matricalNumber, final String password, final String forename, final String surname, final java.sql.Date dateOfBirth, final StudyGroup4Public studyGroup) 
				throws model.MatricalNumberAlreadyUsed, model.CreditPointInformationIsNotConsistent, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).createStudent(matricalNumber, password, forename, surname, dateOfBirth, studyGroup);
    }
    public void createStudyGroup(final String name, final StudyProgram4Public studyProgram) 
				throws model.NameAlreadyExistsException, model.CreditPointInformationIsNotConsistent, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).createStudyGroup(name, studyProgram);
    }
    public void createStudyProgram(final String name, final common.Fraction creditPoints) 
				throws model.NameAlreadyExistsException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).createStudyProgram(name, creditPoints);
    }
    public void createUnit(final String name, final common.Fraction creditPoints) 
				throws model.NameAlreadyExistsException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).createUnit(name, creditPoints);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).disconnected();
    }
    public Mark fetchM(final Appr4Public appr) 
				throws model.NotAllowedOperationOnPrototypeException, PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).fetchM(appr);
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentAdminServer)this.getTheObject()).hasChanged();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).initializeOnInstantiation();
    }
    public void remMGFromMG(final ModuleGroup4Public moduleGroup, final ModuleGroup4Public mG) 
				throws model.AlreadyInUseException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).remMGFromMG(moduleGroup, mG);
    }
    public void remMGFromSP(final StudyProgram4Public studyProgram, final ModuleGroup4Public moduleGroup) 
				throws model.AlreadyInUseException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).remMGFromSP(studyProgram, moduleGroup);
    }
    public void remMWUFromMG(final ModuleGroup4Public moduleGroup, final ModuleWithUnits4Public moduleWithUnits) 
				throws model.AlreadyInUseException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).remMWUFromMG(moduleGroup, moduleWithUnits);
    }
    public void remMWWUFromMG(final ModuleGroup4Public moduleGroup, final ModuleWithoutUnits4Public moduleWithoutUnits) 
				throws model.AlreadyInUseException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).remMWWUFromMG(moduleGroup, moduleWithoutUnits);
    }
    public void remUFromMWU(final ModuleWithUnits4Public moduleWithUnits, final Unit4Public unit) 
				throws model.AlreadyInUseException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).remUFromMWU(moduleWithUnits, unit);
    }
    public void removeModuleGroup(final ModuleGroup4Public moduleGroup) 
				throws model.AlreadyInUseException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).removeModuleGroup(moduleGroup);
    }
    public void removeStudyGroup(final StudyGroup4Public studyGroup) 
				throws model.AlreadyInUseException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).removeStudyGroup(studyGroup);
    }
    public void removeStudyProgram(final StudyProgram4Public studyProgram) 
				throws model.AlreadyInUseException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).removeStudyProgram(studyProgram);
    }
    public void removeUnit(final Unit4Public unit) 
				throws model.UnitIsAlreadyPartOfAModuleWithUnitsException, model.AlreadyInUseException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).removeUnit(unit);
    }
    public void rmvMWOU(final ModuleWithoutUnits4Public moduleWithoutUnits) 
				throws model.AlreadyInUseException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).rmvMWOU(moduleWithoutUnits);
    }
    public void rmvMWU(final ModuleWithUnits4Public moduleWithUnits) 
				throws model.AlreadyInUseException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).rmvMWU(moduleWithUnits);
    }
    public void setActiveSG(final StudentServer4Public student, final StudyGroup4Public studyGroup) 
				throws model.NotInStudyGroupException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).setActiveSG(student, studyGroup);
    }
    public void sorcMTSWiMWuU(final ModuleWithoutUnits4Public moduleWithoutUnits, final Mark mark, final String comment) 
				throws model.OtherTypeThanSettedException, model.NotAllowedOperationOnPrototypeException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).sorcMTSWiMWuU(moduleWithoutUnits, mark, comment);
    }
    public void sorcMTSWiU(final Unit4Public unit, final ThirdMark4Public mark, final String comment) 
				throws model.NotAllowedOperationOnPrototypeException, PersistenceException{
        ((PersistentAdminServer)this.getTheObject()).sorcMTSWiU(unit, mark, comment);
    }

    
}
