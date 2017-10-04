
package model.visitor;
import persistence.*;

public interface CommonDateReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAddMGToMGCommand(AddMGToMGCommand4Public addMGToMGCommand) throws PersistenceException, E;
    public R handleAddMGToSPCommand(AddMGToSPCommand4Public addMGToSPCommand) throws PersistenceException, E;
    public R handleAddMWUToMGCommand(AddMWUToMGCommand4Public addMWUToMGCommand) throws PersistenceException, E;
    public R handleAddMWWUToMGCommand(AddMWWUToMGCommand4Public addMWWUToMGCommand) throws PersistenceException, E;
    public R handleAddSToSGCommand(AddSToSGCommand4Public addSToSGCommand) throws PersistenceException, E;
    public R handleAddUToMWUCommand(AddUToMWUCommand4Public addUToMWUCommand) throws PersistenceException, E;
    public R handleChangeCPCommand(ChangeCPCommand4Public changeCPCommand) throws PersistenceException, E;
    public R handleCreateMWUCommand(CreateMWUCommand4Public createMWUCommand) throws PersistenceException, E;
    public R handleCreateMWWUCommand(CreateMWWUCommand4Public createMWWUCommand) throws PersistenceException, E;
    public R handleCreateModuleGroupCommand(CreateModuleGroupCommand4Public createModuleGroupCommand) throws PersistenceException, E;
    public R handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException, E;
    public R handleCreateStudyGroupCommand(CreateStudyGroupCommand4Public createStudyGroupCommand) throws PersistenceException, E;
    public R handleCreateStudyProgramCommand(CreateStudyProgramCommand4Public createStudyProgramCommand) throws PersistenceException, E;
    public R handleCreateUnitCommand(CreateUnitCommand4Public createUnitCommand) throws PersistenceException, E;
    public R handleFetchMCommand(FetchMCommand4Public fetchMCommand) throws PersistenceException, E;
    public R handleFetchStudentMCommand(FetchStudentMCommand4Public fetchStudentMCommand) throws PersistenceException, E;
    public R handleRemMGFromMGCommand(RemMGFromMGCommand4Public remMGFromMGCommand) throws PersistenceException, E;
    public R handleRemMGFromSPCommand(RemMGFromSPCommand4Public remMGFromSPCommand) throws PersistenceException, E;
    public R handleRemMWUFromMGCommand(RemMWUFromMGCommand4Public remMWUFromMGCommand) throws PersistenceException, E;
    public R handleRemMWWUFromMGCommand(RemMWWUFromMGCommand4Public remMWWUFromMGCommand) throws PersistenceException, E;
    public R handleRemUFromMWUCommand(RemUFromMWUCommand4Public remUFromMWUCommand) throws PersistenceException, E;
    public R handleRemoveModuleGroupCommand(RemoveModuleGroupCommand4Public removeModuleGroupCommand) throws PersistenceException, E;
    public R handleRemoveStudyGroupCommand(RemoveStudyGroupCommand4Public removeStudyGroupCommand) throws PersistenceException, E;
    public R handleRemoveStudyProgramCommand(RemoveStudyProgramCommand4Public removeStudyProgramCommand) throws PersistenceException, E;
    public R handleRemoveUnitCommand(RemoveUnitCommand4Public removeUnitCommand) throws PersistenceException, E;
    public R handleRmvMWOUCommand(RmvMWOUCommand4Public rmvMWOUCommand) throws PersistenceException, E;
    public R handleRmvMWUCommand(RmvMWUCommand4Public rmvMWUCommand) throws PersistenceException, E;
    public R handleSetActiveSGCommand(SetActiveSGCommand4Public setActiveSGCommand) throws PersistenceException, E;
    public R handleSorcMTSWiMWuUCommand(SorcMTSWiMWuUCommand4Public sorcMTSWiMWuUCommand) throws PersistenceException, E;
    public R handleSorcMTSWiUCommand(SorcMTSWiUCommand4Public sorcMTSWiUCommand) throws PersistenceException, E;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    
}
