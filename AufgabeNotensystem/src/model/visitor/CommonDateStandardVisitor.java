
package model.visitor;

import persistence.*;

public abstract class CommonDateStandardVisitor implements CommonDateVisitor {
    
    public void handleCreateMWUCommand(CreateMWUCommand4Public createMWUCommand) throws PersistenceException{
        this.standardHandling(createMWUCommand);
    }
    public void handleAddMGToMGCommand(AddMGToMGCommand4Public addMGToMGCommand) throws PersistenceException{
        this.standardHandling(addMGToMGCommand);
    }
    public void handleCreateUnitCommand(CreateUnitCommand4Public createUnitCommand) throws PersistenceException{
        this.standardHandling(createUnitCommand);
    }
    public void handleRemoveStudyProgramCommand(RemoveStudyProgramCommand4Public removeStudyProgramCommand) throws PersistenceException{
        this.standardHandling(removeStudyProgramCommand);
    }
    public void handleFetchMCommand(FetchMCommand4Public fetchMCommand) throws PersistenceException{
        this.standardHandling(fetchMCommand);
    }
    public void handleRemUFromMWUCommand(RemUFromMWUCommand4Public remUFromMWUCommand) throws PersistenceException{
        this.standardHandling(remUFromMWUCommand);
    }
    public void handleRemMGFromMGCommand(RemMGFromMGCommand4Public remMGFromMGCommand) throws PersistenceException{
        this.standardHandling(remMGFromMGCommand);
    }
    public void handleRemoveModuleGroupCommand(RemoveModuleGroupCommand4Public removeModuleGroupCommand) throws PersistenceException{
        this.standardHandling(removeModuleGroupCommand);
    }
    public void handleRemMWWUFromMGCommand(RemMWWUFromMGCommand4Public remMWWUFromMGCommand) throws PersistenceException{
        this.standardHandling(remMWWUFromMGCommand);
    }
    public void handleAddMWUToMGCommand(AddMWUToMGCommand4Public addMWUToMGCommand) throws PersistenceException{
        this.standardHandling(addMWUToMGCommand);
    }
    public void handleRmvMWUCommand(RmvMWUCommand4Public rmvMWUCommand) throws PersistenceException{
        this.standardHandling(rmvMWUCommand);
    }
    public void handleCreateMWWUCommand(CreateMWWUCommand4Public createMWWUCommand) throws PersistenceException{
        this.standardHandling(createMWWUCommand);
    }
    public void handleRemoveStudyGroupCommand(RemoveStudyGroupCommand4Public removeStudyGroupCommand) throws PersistenceException{
        this.standardHandling(removeStudyGroupCommand);
    }
    public void handleRemoveUnitCommand(RemoveUnitCommand4Public removeUnitCommand) throws PersistenceException{
        this.standardHandling(removeUnitCommand);
    }
    public void handleSorcMTSWiMWuUCommand(SorcMTSWiMWuUCommand4Public sorcMTSWiMWuUCommand) throws PersistenceException{
        this.standardHandling(sorcMTSWiMWuUCommand);
    }
    public void handleAddMGToSPCommand(AddMGToSPCommand4Public addMGToSPCommand) throws PersistenceException{
        this.standardHandling(addMGToSPCommand);
    }
    public void handleAddMWWUToMGCommand(AddMWWUToMGCommand4Public addMWWUToMGCommand) throws PersistenceException{
        this.standardHandling(addMWWUToMGCommand);
    }
    public void handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException{
        this.standardHandling(createStudentCommand);
    }
    public void handleSetActiveSGCommand(SetActiveSGCommand4Public setActiveSGCommand) throws PersistenceException{
        this.standardHandling(setActiveSGCommand);
    }
    public void handleSorcMTSWiUCommand(SorcMTSWiUCommand4Public sorcMTSWiUCommand) throws PersistenceException{
        this.standardHandling(sorcMTSWiUCommand);
    }
    public void handleChangeCPCommand(ChangeCPCommand4Public changeCPCommand) throws PersistenceException{
        this.standardHandling(changeCPCommand);
    }
    public void handleFetchStudentMCommand(FetchStudentMCommand4Public fetchStudentMCommand) throws PersistenceException{
        this.standardHandling(fetchStudentMCommand);
    }
    public void handleCreateStudyProgramCommand(CreateStudyProgramCommand4Public createStudyProgramCommand) throws PersistenceException{
        this.standardHandling(createStudyProgramCommand);
    }
    public void handleAddSToSGCommand(AddSToSGCommand4Public addSToSGCommand) throws PersistenceException{
        this.standardHandling(addSToSGCommand);
    }
    public void handleCreateStudyGroupCommand(CreateStudyGroupCommand4Public createStudyGroupCommand) throws PersistenceException{
        this.standardHandling(createStudyGroupCommand);
    }
    public void handleRemMGFromSPCommand(RemMGFromSPCommand4Public remMGFromSPCommand) throws PersistenceException{
        this.standardHandling(remMGFromSPCommand);
    }
    public void handleRmvMWOUCommand(RmvMWOUCommand4Public rmvMWOUCommand) throws PersistenceException{
        this.standardHandling(rmvMWOUCommand);
    }
    public void handleRemMWUFromMGCommand(RemMWUFromMGCommand4Public remMWUFromMGCommand) throws PersistenceException{
        this.standardHandling(remMWUFromMGCommand);
    }
    public void handleCreateModuleGroupCommand(CreateModuleGroupCommand4Public createModuleGroupCommand) throws PersistenceException{
        this.standardHandling(createModuleGroupCommand);
    }
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleAddUToMWUCommand(AddUToMWUCommand4Public addUToMWUCommand) throws PersistenceException{
        this.standardHandling(addUToMWUCommand);
    }
    protected abstract void standardHandling(CommonDate4Public commonDate) throws PersistenceException;
}
