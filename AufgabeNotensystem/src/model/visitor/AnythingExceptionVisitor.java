
package model.visitor;
import persistence.*;

public interface AnythingExceptionVisitor<E extends model.UserException> extends CommonDateExceptionVisitor<E>,MarkCalculableExceptionVisitor<E>,MarkNotCalculableExceptionVisitor<E>,PrototypeExceptionVisitor<E>,ServiceExceptionVisitor<E>{
    
    public void handleAddMGToMGCommand(AddMGToMGCommand4Public addMGToMGCommand) throws PersistenceException, E;
    public void handleAddMGToSPCommand(AddMGToSPCommand4Public addMGToSPCommand) throws PersistenceException, E;
    public void handleAddMWUToMGCommand(AddMWUToMGCommand4Public addMWUToMGCommand) throws PersistenceException, E;
    public void handleAddMWWUToMGCommand(AddMWWUToMGCommand4Public addMWWUToMGCommand) throws PersistenceException, E;
    public void handleAddSToSGCommand(AddSToSGCommand4Public addSToSGCommand) throws PersistenceException, E;
    public void handleAddUToMWUCommand(AddUToMWUCommand4Public addUToMWUCommand) throws PersistenceException, E;
    public void handleBooleanMarkLst(BooleanMarkLst4Public booleanMarkLst) throws PersistenceException, E;
    public void handleChangeCPCommand(ChangeCPCommand4Public changeCPCommand) throws PersistenceException, E;
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException, E;
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException, E;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    public void handleCreateMWUCommand(CreateMWUCommand4Public createMWUCommand) throws PersistenceException, E;
    public void handleCreateMWWUCommand(CreateMWWUCommand4Public createMWWUCommand) throws PersistenceException, E;
    public void handleCreateModuleGroupCommand(CreateModuleGroupCommand4Public createModuleGroupCommand) throws PersistenceException, E;
    public void handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException, E;
    public void handleCreateStudyGroupCommand(CreateStudyGroupCommand4Public createStudyGroupCommand) throws PersistenceException, E;
    public void handleCreateStudyProgramCommand(CreateStudyProgramCommand4Public createStudyProgramCommand) throws PersistenceException, E;
    public void handleCreateUnitCommand(CreateUnitCommand4Public createUnitCommand) throws PersistenceException, E;
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public void handleFetchMCommand(FetchMCommand4Public fetchMCommand) throws PersistenceException, E;
    public void handleFetchStudentMCommand(FetchStudentMCommand4Public fetchStudentMCommand) throws PersistenceException, E;
    public void handleMarkFactory(MarkFactory4Public markFactory) throws PersistenceException, E;
    public void handleMarkHistoryEntry(MarkHistoryEntry4Public markHistoryEntry) throws PersistenceException, E;
    public void handleModuleGroupLst(ModuleGroupLst4Public moduleGroupLst) throws PersistenceException, E;
    public void handleModuleWithUnitsLst(ModuleWithUnitsLst4Public moduleWithUnitsLst) throws PersistenceException, E;
    public void handleModuleWithoutUnitsLst(ModuleWithoutUnitsLst4Public moduleWithoutUnitsLst) throws PersistenceException, E;
    public void handleRemMGFromMGCommand(RemMGFromMGCommand4Public remMGFromMGCommand) throws PersistenceException, E;
    public void handleRemMGFromSPCommand(RemMGFromSPCommand4Public remMGFromSPCommand) throws PersistenceException, E;
    public void handleRemMWUFromMGCommand(RemMWUFromMGCommand4Public remMWUFromMGCommand) throws PersistenceException, E;
    public void handleRemMWWUFromMGCommand(RemMWWUFromMGCommand4Public remMWWUFromMGCommand) throws PersistenceException, E;
    public void handleRemUFromMWUCommand(RemUFromMWUCommand4Public remUFromMWUCommand) throws PersistenceException, E;
    public void handleRemoveModuleGroupCommand(RemoveModuleGroupCommand4Public removeModuleGroupCommand) throws PersistenceException, E;
    public void handleRemoveStudyGroupCommand(RemoveStudyGroupCommand4Public removeStudyGroupCommand) throws PersistenceException, E;
    public void handleRemoveStudyProgramCommand(RemoveStudyProgramCommand4Public removeStudyProgramCommand) throws PersistenceException, E;
    public void handleRemoveUnitCommand(RemoveUnitCommand4Public removeUnitCommand) throws PersistenceException, E;
    public void handleRmvMWOUCommand(RmvMWOUCommand4Public rmvMWOUCommand) throws PersistenceException, E;
    public void handleRmvMWUCommand(RmvMWUCommand4Public rmvMWUCommand) throws PersistenceException, E;
    public void handleServer(Server4Public server) throws PersistenceException, E;
    public void handleSetActiveSGCommand(SetActiveSGCommand4Public setActiveSGCommand) throws PersistenceException, E;
    public void handleSorcMTSWiMWuUCommand(SorcMTSWiMWuUCommand4Public sorcMTSWiMWuUCommand) throws PersistenceException, E;
    public void handleSorcMTSWiUCommand(SorcMTSWiUCommand4Public sorcMTSWiUCommand) throws PersistenceException, E;
    public void handleStudentServerLst(StudentServerLst4Public studentServerLst) throws PersistenceException, E;
    public void handleStudyGroupLst(StudyGroupLst4Public studyGroupLst) throws PersistenceException, E;
    public void handleStudyProgramLst(StudyProgramLst4Public studyProgramLst) throws PersistenceException, E;
    public void handleThirdMarkLst(ThirdMarkLst4Public thirdMarkLst) throws PersistenceException, E;
    public void handleUnitLst(UnitLst4Public unitLst) throws PersistenceException, E;
    
}
