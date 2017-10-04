
package model.visitor;
import persistence.*;

public interface CommonDateVisitor {
    
    public void handleAddMGToMGCommand(AddMGToMGCommand4Public addMGToMGCommand) throws PersistenceException;
    public void handleAddMGToSPCommand(AddMGToSPCommand4Public addMGToSPCommand) throws PersistenceException;
    public void handleAddMWUToMGCommand(AddMWUToMGCommand4Public addMWUToMGCommand) throws PersistenceException;
    public void handleAddMWWUToMGCommand(AddMWWUToMGCommand4Public addMWWUToMGCommand) throws PersistenceException;
    public void handleAddSToSGCommand(AddSToSGCommand4Public addSToSGCommand) throws PersistenceException;
    public void handleAddUToMWUCommand(AddUToMWUCommand4Public addUToMWUCommand) throws PersistenceException;
    public void handleChangeCPCommand(ChangeCPCommand4Public changeCPCommand) throws PersistenceException;
    public void handleCreateMWUCommand(CreateMWUCommand4Public createMWUCommand) throws PersistenceException;
    public void handleCreateMWWUCommand(CreateMWWUCommand4Public createMWWUCommand) throws PersistenceException;
    public void handleCreateModuleGroupCommand(CreateModuleGroupCommand4Public createModuleGroupCommand) throws PersistenceException;
    public void handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException;
    public void handleCreateStudyGroupCommand(CreateStudyGroupCommand4Public createStudyGroupCommand) throws PersistenceException;
    public void handleCreateStudyProgramCommand(CreateStudyProgramCommand4Public createStudyProgramCommand) throws PersistenceException;
    public void handleCreateUnitCommand(CreateUnitCommand4Public createUnitCommand) throws PersistenceException;
    public void handleFetchMCommand(FetchMCommand4Public fetchMCommand) throws PersistenceException;
    public void handleFetchStudentMCommand(FetchStudentMCommand4Public fetchStudentMCommand) throws PersistenceException;
    public void handleRemMGFromMGCommand(RemMGFromMGCommand4Public remMGFromMGCommand) throws PersistenceException;
    public void handleRemMGFromSPCommand(RemMGFromSPCommand4Public remMGFromSPCommand) throws PersistenceException;
    public void handleRemMWUFromMGCommand(RemMWUFromMGCommand4Public remMWUFromMGCommand) throws PersistenceException;
    public void handleRemMWWUFromMGCommand(RemMWWUFromMGCommand4Public remMWWUFromMGCommand) throws PersistenceException;
    public void handleRemUFromMWUCommand(RemUFromMWUCommand4Public remUFromMWUCommand) throws PersistenceException;
    public void handleRemoveModuleGroupCommand(RemoveModuleGroupCommand4Public removeModuleGroupCommand) throws PersistenceException;
    public void handleRemoveStudyGroupCommand(RemoveStudyGroupCommand4Public removeStudyGroupCommand) throws PersistenceException;
    public void handleRemoveStudyProgramCommand(RemoveStudyProgramCommand4Public removeStudyProgramCommand) throws PersistenceException;
    public void handleRemoveUnitCommand(RemoveUnitCommand4Public removeUnitCommand) throws PersistenceException;
    public void handleRmvMWOUCommand(RmvMWOUCommand4Public rmvMWOUCommand) throws PersistenceException;
    public void handleRmvMWUCommand(RmvMWUCommand4Public rmvMWUCommand) throws PersistenceException;
    public void handleSetActiveSGCommand(SetActiveSGCommand4Public setActiveSGCommand) throws PersistenceException;
    public void handleSorcMTSWiMWuUCommand(SorcMTSWiMWuUCommand4Public sorcMTSWiMWuUCommand) throws PersistenceException;
    public void handleSorcMTSWiUCommand(SorcMTSWiUCommand4Public sorcMTSWiUCommand) throws PersistenceException;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
}
