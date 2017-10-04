package persistence;


import model.visitor.*;

public interface AdminServer4Public extends Service4Public {
    
    public UnitLst4Public getUnits() throws PersistenceException ;
    public ModuleWithUnitsLst4Public getModuleWithUnits() throws PersistenceException ;
    public ModuleWithoutUnitsLst4Public getModuleWithoutUnits() throws PersistenceException ;
    public ModuleGroupLst4Public getModuleGroups() throws PersistenceException ;
    public StudyProgramLst4Public getStudyPrograms() throws PersistenceException ;
    public StudyGroupLst4Public getStudyGroups() throws PersistenceException ;
    public StudentServerLst4Public getStudents() throws PersistenceException ;
    public AdminServer_ModuleWithoutUnitsMarkTypesProxi getModuleWithoutUnitsMarkTypes() throws PersistenceException ;
    public ThirdMarkLst4Public getThirdMarks() throws PersistenceException ;
    public AdminServer_ModuleWithoutUnitsMarksProxi getModuleWithoutUnitsMarks() throws PersistenceException ;
    
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
    
    public void addMGToMG(final ModuleGroup4Public moduleGroup, final ModuleGroup4Public mG, final Invoker invoker) 
				throws PersistenceException;
    public void addMGToSP(final StudyProgram4Public studyProgram, final ModuleGroup4Public moduleGroup, final Invoker invoker) 
				throws PersistenceException;
    public void addMWUToMG(final ModuleGroup4Public moduleGroup, final ModuleWithUnits4Public moduleWithUnits, final Invoker invoker) 
				throws PersistenceException;
    public void addMWWUToMG(final ModuleGroup4Public moduleGroup, final ModuleWithoutUnits4Public moduleWithoutUnits, final Invoker invoker) 
				throws PersistenceException;
    public void addSToSG(final StudyGroup4Public studyGroup, final StudentServer4Public student, final Invoker invoker) 
				throws PersistenceException;
    public void addUToMWU(final ModuleWithUnits4Public moduleWithUnits, final Unit4Public unit, final Invoker invoker) 
				throws PersistenceException;
    public String adminServer_Menu_Filter(final Anything anything) 
				throws PersistenceException;
    public void changeCP(final Appr4Public appr, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException;
    public void createMWU(final String name, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException;
    public void createMWWU(final String name, final common.Fraction creditPoints, final Mark markType, final Invoker invoker) 
				throws PersistenceException;
    public void createModuleGroup(final String name, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException;
    public void createStudent(final String matricalNumber, final String password, final String forename, final String surname, final java.sql.Date dateOfBirth, final StudyGroup4Public studyGroup, final Invoker invoker) 
				throws PersistenceException;
    public void createStudyGroup(final String name, final StudyProgram4Public studyProgram, final Invoker invoker) 
				throws PersistenceException;
    public void createStudyProgram(final String name, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException;
    public void createUnit(final String name, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException;
    public void fetchM(final Appr4Public appr, final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public ModuleGroupLst4Public mG_Path_In_AddMGToMG() 
				throws model.UserException, PersistenceException;
    public ModuleGroupSearchList mG_Path_In_RemMGFromMG(final ModuleGroup4Public moduleGroup) 
				throws model.UserException, PersistenceException;
    public MarkSearchList markType_Path_In_CreateMWWU() 
				throws model.UserException, PersistenceException;
    public AnythingSearchList mark_Path_In_SorcMTSWiMWuU() 
				throws model.UserException, PersistenceException;
    public ThirdMarkLst4Public mark_Path_In_SorcMTSWiU() 
				throws model.UserException, PersistenceException;
    public ModuleGroupLst4Public moduleGroup_Path_In_AddMGToSP() 
				throws model.UserException, PersistenceException;
    public ModuleGroupSearchList moduleGroup_Path_In_RemMGFromSP(final StudyProgram4Public studyProgram) 
				throws model.UserException, PersistenceException;
    public ModuleWithUnitsLst4Public moduleWithUnits_Path_In_AddMWUToMG() 
				throws model.UserException, PersistenceException;
    public ModuleWithUnitsSearchList moduleWithUnits_Path_In_RemMWUFromMG(final ModuleGroup4Public moduleGroup) 
				throws model.UserException, PersistenceException;
    public ModuleWithoutUnitsLst4Public moduleWithoutUnits_Path_In_AddMWWUToMG() 
				throws model.UserException, PersistenceException;
    public ModuleWithoutUnitsSearchList moduleWithoutUnits_Path_In_RemMWWUFromMG(final ModuleGroup4Public moduleGroup) 
				throws model.UserException, PersistenceException;
    public ModuleWithoutUnitsLst4Public moduleWithoutUnits_Path_In_SorcMTSWiMWuU() 
				throws model.UserException, PersistenceException;
    public void remMGFromMG(final ModuleGroup4Public moduleGroup, final ModuleGroup4Public mG, final Invoker invoker) 
				throws PersistenceException;
    public void remMGFromSP(final StudyProgram4Public studyProgram, final ModuleGroup4Public moduleGroup, final Invoker invoker) 
				throws PersistenceException;
    public void remMWUFromMG(final ModuleGroup4Public moduleGroup, final ModuleWithUnits4Public moduleWithUnits, final Invoker invoker) 
				throws PersistenceException;
    public void remMWWUFromMG(final ModuleGroup4Public moduleGroup, final ModuleWithoutUnits4Public moduleWithoutUnits, final Invoker invoker) 
				throws PersistenceException;
    public void remUFromMWU(final ModuleWithUnits4Public moduleWithUnits, final Unit4Public unit, final Invoker invoker) 
				throws PersistenceException;
    public void removeModuleGroup(final ModuleGroup4Public moduleGroup, final Invoker invoker) 
				throws PersistenceException;
    public void removeStudyGroup(final StudyGroup4Public studyGroup, final Invoker invoker) 
				throws PersistenceException;
    public void removeStudyProgram(final StudyProgram4Public studyProgram, final Invoker invoker) 
				throws PersistenceException;
    public void removeUnit(final Unit4Public unit, final Invoker invoker) 
				throws PersistenceException;
    public void rmvMWOU(final ModuleWithoutUnits4Public moduleWithoutUnits, final Invoker invoker) 
				throws PersistenceException;
    public void rmvMWU(final ModuleWithUnits4Public moduleWithUnits, final Invoker invoker) 
				throws PersistenceException;
    public void setActiveSG(final StudentServer4Public student, final StudyGroup4Public studyGroup, final Invoker invoker) 
				throws PersistenceException;
    public void sorcMTSWiMWuU(final ModuleWithoutUnits4Public moduleWithoutUnits, final Mark mark, final String comment, final Invoker invoker) 
				throws PersistenceException;
    public void sorcMTSWiU(final Unit4Public unit, final ThirdMark4Public mark, final String comment, final Invoker invoker) 
				throws PersistenceException;
    public StudentServerLst4Public student_Path_In_AddSToSG() 
				throws model.UserException, PersistenceException;
    public StudyGroupLst4Public studyGroup_Path_In_CreateStudent() 
				throws model.UserException, PersistenceException;
    public StudyGroupSearchList studyGroup_Path_In_SetActiveSG(final StudentServer4Public student) 
				throws model.UserException, PersistenceException;
    public StudyProgramLst4Public studyProgram_Path_In_CreateStudyGroup() 
				throws model.UserException, PersistenceException;
    public UnitLst4Public unit_Path_In_AddUToMWU() 
				throws model.UserException, PersistenceException;
    public UnitSearchList unit_Path_In_RemUFromMWU(final ModuleWithUnits4Public moduleWithUnits) 
				throws model.UserException, PersistenceException;
    public UnitLst4Public unit_Path_In_SorcMTSWiU() 
				throws model.UserException, PersistenceException;
    public void addMGToMG(final ModuleGroup4Public moduleGroup, final ModuleGroup4Public mG) 
				throws model.CycleException, model.AlreadyInUseException, PersistenceException;
    public void addMGToSP(final StudyProgram4Public studyProgram, final ModuleGroup4Public moduleGroup) 
				throws model.AlreadyInUseException, PersistenceException;
    public void addMWUToMG(final ModuleGroup4Public moduleGroup, final ModuleWithUnits4Public moduleWithUnits) 
				throws model.CycleException, model.AlreadyInUseException, PersistenceException;
    public void addMWWUToMG(final ModuleGroup4Public moduleGroup, final ModuleWithoutUnits4Public moduleWithoutUnits) 
				throws model.CycleException, model.AlreadyInUseException, PersistenceException;
    public void addSToSG(final StudyGroup4Public studyGroup, final StudentServer4Public student) 
				throws model.AlreadyInUseException, PersistenceException;
    public void addUToMWU(final ModuleWithUnits4Public moduleWithUnits, final Unit4Public unit) 
				throws model.ThereIsAlreadyAStudyGroupException, model.UnitIsAlreadyPartOfAModuleWithUnitsException, model.AlreadyInUseException, PersistenceException;
    public void changeCP(final Appr4Public appr, final common.Fraction creditPoints) 
				throws model.AlreadyInUseException, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createMWU(final String name, final common.Fraction creditPoints) 
				throws model.NameAlreadyExistsException, PersistenceException;
    public void createMWWU(final String name, final common.Fraction creditPoints, final Mark markType) 
				throws model.NameAlreadyExistsException, PersistenceException;
    public void createModuleGroup(final String name, final common.Fraction creditPoints) 
				throws model.NameAlreadyExistsException, PersistenceException;
    public void createStudent(final String matricalNumber, final String password, final String forename, final String surname, final java.sql.Date dateOfBirth, final StudyGroup4Public studyGroup) 
				throws model.MatricalNumberAlreadyUsed, model.CreditPointInformationIsNotConsistent, PersistenceException;
    public void createStudyGroup(final String name, final StudyProgram4Public studyProgram) 
				throws model.NameAlreadyExistsException, model.CreditPointInformationIsNotConsistent, PersistenceException;
    public void createStudyProgram(final String name, final common.Fraction creditPoints) 
				throws model.NameAlreadyExistsException, PersistenceException;
    public void createUnit(final String name, final common.Fraction creditPoints) 
				throws model.NameAlreadyExistsException, PersistenceException;
    public Mark fetchM(final Appr4Public appr) 
				throws model.NotAllowedOperationOnPrototypeException, PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void remMGFromMG(final ModuleGroup4Public moduleGroup, final ModuleGroup4Public mG) 
				throws model.AlreadyInUseException, PersistenceException;
    public void remMGFromSP(final StudyProgram4Public studyProgram, final ModuleGroup4Public moduleGroup) 
				throws model.AlreadyInUseException, PersistenceException;
    public void remMWUFromMG(final ModuleGroup4Public moduleGroup, final ModuleWithUnits4Public moduleWithUnits) 
				throws model.AlreadyInUseException, PersistenceException;
    public void remMWWUFromMG(final ModuleGroup4Public moduleGroup, final ModuleWithoutUnits4Public moduleWithoutUnits) 
				throws model.AlreadyInUseException, PersistenceException;
    public void remUFromMWU(final ModuleWithUnits4Public moduleWithUnits, final Unit4Public unit) 
				throws model.AlreadyInUseException, PersistenceException;
    public void removeModuleGroup(final ModuleGroup4Public moduleGroup) 
				throws model.AlreadyInUseException, PersistenceException;
    public void removeStudyGroup(final StudyGroup4Public studyGroup) 
				throws model.AlreadyInUseException, PersistenceException;
    public void removeStudyProgram(final StudyProgram4Public studyProgram) 
				throws model.AlreadyInUseException, PersistenceException;
    public void removeUnit(final Unit4Public unit) 
				throws model.UnitIsAlreadyPartOfAModuleWithUnitsException, model.AlreadyInUseException, PersistenceException;
    public void rmvMWOU(final ModuleWithoutUnits4Public moduleWithoutUnits) 
				throws model.AlreadyInUseException, PersistenceException;
    public void rmvMWU(final ModuleWithUnits4Public moduleWithUnits) 
				throws model.AlreadyInUseException, PersistenceException;
    public void setActiveSG(final StudentServer4Public student, final StudyGroup4Public studyGroup) 
				throws model.NotInStudyGroupException, PersistenceException;
    public void sorcMTSWiMWuU(final ModuleWithoutUnits4Public moduleWithoutUnits, final Mark mark, final String comment) 
				throws model.OtherTypeThanSettedException, model.NotAllowedOperationOnPrototypeException, PersistenceException;
    public void sorcMTSWiU(final Unit4Public unit, final ThirdMark4Public mark, final String comment) 
				throws model.NotAllowedOperationOnPrototypeException, PersistenceException;

}

