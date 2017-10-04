
package model.visitor;
import persistence.*;

public interface AdminServerCommandReturnVisitor<R> {
    
    public R handleAddMGToMGCommand(AddMGToMGCommand4Public addMGToMGCommand) throws PersistenceException;
    public R handleAddMGToSPCommand(AddMGToSPCommand4Public addMGToSPCommand) throws PersistenceException;
    public R handleAddMWUToMGCommand(AddMWUToMGCommand4Public addMWUToMGCommand) throws PersistenceException;
    public R handleAddMWWUToMGCommand(AddMWWUToMGCommand4Public addMWWUToMGCommand) throws PersistenceException;
    public R handleAddSToSGCommand(AddSToSGCommand4Public addSToSGCommand) throws PersistenceException;
    public R handleAddUToMWUCommand(AddUToMWUCommand4Public addUToMWUCommand) throws PersistenceException;
    public R handleChangeCPCommand(ChangeCPCommand4Public changeCPCommand) throws PersistenceException;
    public R handleCreateMWUCommand(CreateMWUCommand4Public createMWUCommand) throws PersistenceException;
    public R handleCreateMWWUCommand(CreateMWWUCommand4Public createMWWUCommand) throws PersistenceException;
    public R handleCreateModuleGroupCommand(CreateModuleGroupCommand4Public createModuleGroupCommand) throws PersistenceException;
    public R handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException;
    public R handleCreateStudyGroupCommand(CreateStudyGroupCommand4Public createStudyGroupCommand) throws PersistenceException;
    public R handleCreateStudyProgramCommand(CreateStudyProgramCommand4Public createStudyProgramCommand) throws PersistenceException;
    public R handleCreateUnitCommand(CreateUnitCommand4Public createUnitCommand) throws PersistenceException;
    public R handleFetchMCommand(FetchMCommand4Public fetchMCommand) throws PersistenceException;
    public R handleRemMGFromMGCommand(RemMGFromMGCommand4Public remMGFromMGCommand) throws PersistenceException;
    public R handleRemMGFromSPCommand(RemMGFromSPCommand4Public remMGFromSPCommand) throws PersistenceException;
    public R handleRemMWUFromMGCommand(RemMWUFromMGCommand4Public remMWUFromMGCommand) throws PersistenceException;
    public R handleRemMWWUFromMGCommand(RemMWWUFromMGCommand4Public remMWWUFromMGCommand) throws PersistenceException;
    public R handleRemUFromMWUCommand(RemUFromMWUCommand4Public remUFromMWUCommand) throws PersistenceException;
    public R handleRemoveModuleGroupCommand(RemoveModuleGroupCommand4Public removeModuleGroupCommand) throws PersistenceException;
    public R handleRemoveStudyGroupCommand(RemoveStudyGroupCommand4Public removeStudyGroupCommand) throws PersistenceException;
    public R handleRemoveStudyProgramCommand(RemoveStudyProgramCommand4Public removeStudyProgramCommand) throws PersistenceException;
    public R handleRemoveUnitCommand(RemoveUnitCommand4Public removeUnitCommand) throws PersistenceException;
    public R handleRmvMWOUCommand(RmvMWOUCommand4Public rmvMWOUCommand) throws PersistenceException;
    public R handleRmvMWUCommand(RmvMWUCommand4Public rmvMWUCommand) throws PersistenceException;
    public R handleSetActiveSGCommand(SetActiveSGCommand4Public setActiveSGCommand) throws PersistenceException;
    public R handleSorcMTSWiMWuUCommand(SorcMTSWiMWuUCommand4Public sorcMTSWiMWuUCommand) throws PersistenceException;
    public R handleSorcMTSWiUCommand(SorcMTSWiUCommand4Public sorcMTSWiUCommand) throws PersistenceException;
    
}
