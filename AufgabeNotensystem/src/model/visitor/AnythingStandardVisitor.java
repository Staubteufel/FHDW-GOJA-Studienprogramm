
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handlePassed(Passed4Public passed) throws PersistenceException{
        this.standardHandling(passed);
    }
    public void handleAddMGToMGCommand(AddMGToMGCommand4Public addMGToMGCommand) throws PersistenceException{
        this.standardHandling(addMGToMGCommand);
    }
    public void handleServer(Server4Public server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleCreateUnitCommand(CreateUnitCommand4Public createUnitCommand) throws PersistenceException{
        this.standardHandling(createUnitCommand);
    }
    public void handleMarkFactory(MarkFactory4Public markFactory) throws PersistenceException{
        this.standardHandling(markFactory);
    }
    public void handleThirdMarkLst(ThirdMarkLst4Public thirdMarkLst) throws PersistenceException{
        this.standardHandling(thirdMarkLst);
    }
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleStudyGroupLst(StudyGroupLst4Public studyGroupLst) throws PersistenceException{
        this.standardHandling(studyGroupLst);
    }
    public void handleModuleGroupLst(ModuleGroupLst4Public moduleGroupLst) throws PersistenceException{
        this.standardHandling(moduleGroupLst);
    }
    public void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException{
        this.standardHandling(moduleGroup);
    }
    public void handleUnit(Unit4Public unit) throws PersistenceException{
        this.standardHandling(unit);
    }
    public void handleFiveZero(FiveZero4Public fiveZero) throws PersistenceException{
        this.standardHandling(fiveZero);
    }
    public void handleFetchMCommand(FetchMCommand4Public fetchMCommand) throws PersistenceException{
        this.standardHandling(fetchMCommand);
    }
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException{
        this.standardHandling(commandCoordinator);
    }
    public void handleRemUFromMWUCommand(RemUFromMWUCommand4Public remUFromMWUCommand) throws PersistenceException{
        this.standardHandling(remUFromMWUCommand);
    }
    public void handleRemMGFromMGCommand(RemMGFromMGCommand4Public remMGFromMGCommand) throws PersistenceException{
        this.standardHandling(remMGFromMGCommand);
    }
    public void handleStudentServer(StudentServer4Public studentServer) throws PersistenceException{
        this.standardHandling(studentServer);
    }
    public void handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException{
        this.standardHandling(studyGroup);
    }
    public void handleTenthMark(TenthMark4Public tenthMark) throws PersistenceException{
        this.standardHandling(tenthMark);
    }
    public void handleTwoZero(TwoZero4Public twoZero) throws PersistenceException{
        this.standardHandling(twoZero);
    }
    public void handleRmvMWUCommand(RmvMWUCommand4Public rmvMWUCommand) throws PersistenceException{
        this.standardHandling(rmvMWUCommand);
    }
    public void handleCreateMWWUCommand(CreateMWWUCommand4Public createMWWUCommand) throws PersistenceException{
        this.standardHandling(createMWWUCommand);
    }
    public void handleNoneMark(NoneMark4Public noneMark) throws PersistenceException{
        this.standardHandling(noneMark);
    }
    public void handleRemoveUnitCommand(RemoveUnitCommand4Public removeUnitCommand) throws PersistenceException{
        this.standardHandling(removeUnitCommand);
    }
    public void handleStudyProgram(StudyProgram4Public studyProgram) throws PersistenceException{
        this.standardHandling(studyProgram);
    }
    public void handleFailed(Failed4Public failed) throws PersistenceException{
        this.standardHandling(failed);
    }
    public void handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException{
        this.standardHandling(createStudentCommand);
    }
    public void handleFetchStudentMCommand(FetchStudentMCommand4Public fetchStudentMCommand) throws PersistenceException{
        this.standardHandling(fetchStudentMCommand);
    }
    public void handleUnitLst(UnitLst4Public unitLst) throws PersistenceException{
        this.standardHandling(unitLst);
    }
    public void handleThreeSeven(ThreeSeven4Public threeSeven) throws PersistenceException{
        this.standardHandling(threeSeven);
    }
    public void handleModuleWithUnitsLst(ModuleWithUnitsLst4Public moduleWithUnitsLst) throws PersistenceException{
        this.standardHandling(moduleWithUnitsLst);
    }
    public void handleRemMGFromSPCommand(RemMGFromSPCommand4Public remMGFromSPCommand) throws PersistenceException{
        this.standardHandling(remMGFromSPCommand);
    }
    public void handleMarkHistoryEntry(MarkHistoryEntry4Public markHistoryEntry) throws PersistenceException{
        this.standardHandling(markHistoryEntry);
    }
    public void handleStudentServerLst(StudentServerLst4Public studentServerLst) throws PersistenceException{
        this.standardHandling(studentServerLst);
    }
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleThirdMark(ThirdMark4Public thirdMark) throws PersistenceException{
        this.standardHandling(thirdMark);
    }
    public void handleCreateMWUCommand(CreateMWUCommand4Public createMWUCommand) throws PersistenceException{
        this.standardHandling(createMWUCommand);
    }
    public void handleRemoveStudyProgramCommand(RemoveStudyProgramCommand4Public removeStudyProgramCommand) throws PersistenceException{
        this.standardHandling(removeStudyProgramCommand);
    }
    public void handleAdminServer(AdminServer4Public adminServer) throws PersistenceException{
        this.standardHandling(adminServer);
    }
    public void handleModuleWithoutUnits(ModuleWithoutUnits4Public moduleWithoutUnits) throws PersistenceException{
        this.standardHandling(moduleWithoutUnits);
    }
    public void handleThreeZero(ThreeZero4Public threeZero) throws PersistenceException{
        this.standardHandling(threeZero);
    }
    public void handleTwoSeven(TwoSeven4Public twoSeven) throws PersistenceException{
        this.standardHandling(twoSeven);
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
    public void handleRemoveStudyGroupCommand(RemoveStudyGroupCommand4Public removeStudyGroupCommand) throws PersistenceException{
        this.standardHandling(removeStudyGroupCommand);
    }
    public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException{
        this.standardHandling(moduleWithUnits);
    }
    public void handleOneSeven(OneSeven4Public oneSeven) throws PersistenceException{
        this.standardHandling(oneSeven);
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
    public void handleSetActiveSGCommand(SetActiveSGCommand4Public setActiveSGCommand) throws PersistenceException{
        this.standardHandling(setActiveSGCommand);
    }
    public void handleSorcMTSWiUCommand(SorcMTSWiUCommand4Public sorcMTSWiUCommand) throws PersistenceException{
        this.standardHandling(sorcMTSWiUCommand);
    }
    public void handleChangeCPCommand(ChangeCPCommand4Public changeCPCommand) throws PersistenceException{
        this.standardHandling(changeCPCommand);
    }
    public void handleThreeThree(ThreeThree4Public threeThree) throws PersistenceException{
        this.standardHandling(threeThree);
    }
    public void handleOneThree(OneThree4Public oneThree) throws PersistenceException{
        this.standardHandling(oneThree);
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
    public void handleTwoThree(TwoThree4Public twoThree) throws PersistenceException{
        this.standardHandling(twoThree);
    }
    public void handleBooleanMark(BooleanMark4Public booleanMark) throws PersistenceException{
        this.standardHandling(booleanMark);
    }
    public void handleFourZero(FourZero4Public fourZero) throws PersistenceException{
        this.standardHandling(fourZero);
    }
    public void handleOneZero(OneZero4Public oneZero) throws PersistenceException{
        this.standardHandling(oneZero);
    }
    public void handleRmvMWOUCommand(RmvMWOUCommand4Public rmvMWOUCommand) throws PersistenceException{
        this.standardHandling(rmvMWOUCommand);
    }
    public void handleStudyProgramLst(StudyProgramLst4Public studyProgramLst) throws PersistenceException{
        this.standardHandling(studyProgramLst);
    }
    public void handleRemMWUFromMGCommand(RemMWUFromMGCommand4Public remMWUFromMGCommand) throws PersistenceException{
        this.standardHandling(remMWUFromMGCommand);
    }
    public void handleCreateModuleGroupCommand(CreateModuleGroupCommand4Public createModuleGroupCommand) throws PersistenceException{
        this.standardHandling(createModuleGroupCommand);
    }
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException{
        this.standardHandling(commandExecuter);
    }
    public void handleAddUToMWUCommand(AddUToMWUCommand4Public addUToMWUCommand) throws PersistenceException{
        this.standardHandling(addUToMWUCommand);
    }
    public void handleModuleWithoutUnitsLst(ModuleWithoutUnitsLst4Public moduleWithoutUnitsLst) throws PersistenceException{
        this.standardHandling(moduleWithoutUnitsLst);
    }
    public void handleBooleanMarkLst(BooleanMarkLst4Public booleanMarkLst) throws PersistenceException{
        this.standardHandling(booleanMarkLst);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
