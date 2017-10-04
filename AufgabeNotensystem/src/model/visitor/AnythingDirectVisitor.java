
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleMarkNotCalculable(MarkNotCalculable4Public markNotCalculable) throws PersistenceException;
    
    public void handlePassed(Passed4Public passed) throws PersistenceException{
        this.handleMarkNotCalculable(passed);
    }
    public void handleBooleanMark(BooleanMark4Public booleanMark) throws PersistenceException{
        this.handleMarkNotCalculable(booleanMark);
    }
    public void handleFailed(Failed4Public failed) throws PersistenceException{
        this.handleMarkNotCalculable(failed);
    }
    public void handleNoneMark(NoneMark4Public noneMark) throws PersistenceException{
        this.handleMarkNotCalculable(noneMark);
    }
    public abstract void handlePrototype(Prototype4Public prototype) throws PersistenceException;
    
    public void handleStudyProgram(StudyProgram4Public studyProgram) throws PersistenceException{
        this.handlePrototype(studyProgram);
    }
    public void handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException{
        this.handlePrototype(studyGroup);
    }
    public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException{
        this.handlePrototype(moduleWithUnits);
    }
    public void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException{
        this.handlePrototype(moduleGroup);
    }
    public void handleUnit(Unit4Public unit) throws PersistenceException{
        this.handlePrototype(unit);
    }
    public void handleModuleWithoutUnits(ModuleWithoutUnits4Public moduleWithoutUnits) throws PersistenceException{
        this.handlePrototype(moduleWithoutUnits);
    }
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    
    public abstract void handleMarkFactory(MarkFactory4Public markFactory) throws PersistenceException;
    
    public abstract void handleThirdMarkLst(ThirdMarkLst4Public thirdMarkLst) throws PersistenceException;
    
    public abstract void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    
    public abstract void handleStudyGroupLst(StudyGroupLst4Public studyGroupLst) throws PersistenceException;
    
    public abstract void handleModuleGroupLst(ModuleGroupLst4Public moduleGroupLst) throws PersistenceException;
    
    public abstract void handleService(Service4Public service) throws PersistenceException;
    
    public void handleStudentServer(StudentServer4Public studentServer) throws PersistenceException{
        this.handleService(studentServer);
    }
    public void handleAdminServer(AdminServer4Public adminServer) throws PersistenceException{
        this.handleService(adminServer);
    }
    public abstract void handleUnitLst(UnitLst4Public unitLst) throws PersistenceException;
    
    public abstract void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    
    public abstract void handleMarkCalculable(MarkCalculable4Public markCalculable) throws PersistenceException;
    
    public void handleOneSeven(OneSeven4Public oneSeven) throws PersistenceException{
        this.handleMarkCalculable(oneSeven);
    }
    public void handleThreeThree(ThreeThree4Public threeThree) throws PersistenceException{
        this.handleMarkCalculable(threeThree);
    }
    public void handleFiveZero(FiveZero4Public fiveZero) throws PersistenceException{
        this.handleMarkCalculable(fiveZero);
    }
    public void handleOneThree(OneThree4Public oneThree) throws PersistenceException{
        this.handleMarkCalculable(oneThree);
    }
    public void handleThreeZero(ThreeZero4Public threeZero) throws PersistenceException{
        this.handleMarkCalculable(threeZero);
    }
    public void handleTwoThree(TwoThree4Public twoThree) throws PersistenceException{
        this.handleMarkCalculable(twoThree);
    }
    public void handleTwoSeven(TwoSeven4Public twoSeven) throws PersistenceException{
        this.handleMarkCalculable(twoSeven);
    }
    public void handleFourZero(FourZero4Public fourZero) throws PersistenceException{
        this.handleMarkCalculable(fourZero);
    }
    public void handleThreeSeven(ThreeSeven4Public threeSeven) throws PersistenceException{
        this.handleMarkCalculable(threeSeven);
    }
    public void handleOneZero(OneZero4Public oneZero) throws PersistenceException{
        this.handleMarkCalculable(oneZero);
    }
    public void handleTenthMark(TenthMark4Public tenthMark) throws PersistenceException{
        this.handleMarkCalculable(tenthMark);
    }
    public void handleTwoZero(TwoZero4Public twoZero) throws PersistenceException{
        this.handleMarkCalculable(twoZero);
    }
    public void handleThirdMark(ThirdMark4Public thirdMark) throws PersistenceException{
        this.handleMarkCalculable(thirdMark);
    }
    public abstract void handleModuleWithUnitsLst(ModuleWithUnitsLst4Public moduleWithUnitsLst) throws PersistenceException;
    
    public abstract void handleStudyProgramLst(StudyProgramLst4Public studyProgramLst) throws PersistenceException;
    
    public abstract void handleMarkHistoryEntry(MarkHistoryEntry4Public markHistoryEntry) throws PersistenceException;
    
    public abstract void handleStudentServerLst(StudentServerLst4Public studentServerLst) throws PersistenceException;
    
    public abstract void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
    public void handleCreateMWUCommand(CreateMWUCommand4Public createMWUCommand) throws PersistenceException{
        this.handleCommonDate(createMWUCommand);
    }
    public void handleAddMGToMGCommand(AddMGToMGCommand4Public addMGToMGCommand) throws PersistenceException{
        this.handleCommonDate(addMGToMGCommand);
    }
    public void handleCreateUnitCommand(CreateUnitCommand4Public createUnitCommand) throws PersistenceException{
        this.handleCommonDate(createUnitCommand);
    }
    public void handleRemoveStudyProgramCommand(RemoveStudyProgramCommand4Public removeStudyProgramCommand) throws PersistenceException{
        this.handleCommonDate(removeStudyProgramCommand);
    }
    public void handleFetchMCommand(FetchMCommand4Public fetchMCommand) throws PersistenceException{
        this.handleCommonDate(fetchMCommand);
    }
    public void handleRemUFromMWUCommand(RemUFromMWUCommand4Public remUFromMWUCommand) throws PersistenceException{
        this.handleCommonDate(remUFromMWUCommand);
    }
    public void handleRemMGFromMGCommand(RemMGFromMGCommand4Public remMGFromMGCommand) throws PersistenceException{
        this.handleCommonDate(remMGFromMGCommand);
    }
    public void handleRemoveModuleGroupCommand(RemoveModuleGroupCommand4Public removeModuleGroupCommand) throws PersistenceException{
        this.handleCommonDate(removeModuleGroupCommand);
    }
    public void handleRemMWWUFromMGCommand(RemMWWUFromMGCommand4Public remMWWUFromMGCommand) throws PersistenceException{
        this.handleCommonDate(remMWWUFromMGCommand);
    }
    public void handleAddMWUToMGCommand(AddMWUToMGCommand4Public addMWUToMGCommand) throws PersistenceException{
        this.handleCommonDate(addMWUToMGCommand);
    }
    public void handleRmvMWUCommand(RmvMWUCommand4Public rmvMWUCommand) throws PersistenceException{
        this.handleCommonDate(rmvMWUCommand);
    }
    public void handleCreateMWWUCommand(CreateMWWUCommand4Public createMWWUCommand) throws PersistenceException{
        this.handleCommonDate(createMWWUCommand);
    }
    public void handleRemoveStudyGroupCommand(RemoveStudyGroupCommand4Public removeStudyGroupCommand) throws PersistenceException{
        this.handleCommonDate(removeStudyGroupCommand);
    }
    public void handleRemoveUnitCommand(RemoveUnitCommand4Public removeUnitCommand) throws PersistenceException{
        this.handleCommonDate(removeUnitCommand);
    }
    public void handleSorcMTSWiMWuUCommand(SorcMTSWiMWuUCommand4Public sorcMTSWiMWuUCommand) throws PersistenceException{
        this.handleCommonDate(sorcMTSWiMWuUCommand);
    }
    public void handleAddMGToSPCommand(AddMGToSPCommand4Public addMGToSPCommand) throws PersistenceException{
        this.handleCommonDate(addMGToSPCommand);
    }
    public void handleAddMWWUToMGCommand(AddMWWUToMGCommand4Public addMWWUToMGCommand) throws PersistenceException{
        this.handleCommonDate(addMWWUToMGCommand);
    }
    public void handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException{
        this.handleCommonDate(createStudentCommand);
    }
    public void handleSetActiveSGCommand(SetActiveSGCommand4Public setActiveSGCommand) throws PersistenceException{
        this.handleCommonDate(setActiveSGCommand);
    }
    public void handleSorcMTSWiUCommand(SorcMTSWiUCommand4Public sorcMTSWiUCommand) throws PersistenceException{
        this.handleCommonDate(sorcMTSWiUCommand);
    }
    public void handleChangeCPCommand(ChangeCPCommand4Public changeCPCommand) throws PersistenceException{
        this.handleCommonDate(changeCPCommand);
    }
    public void handleFetchStudentMCommand(FetchStudentMCommand4Public fetchStudentMCommand) throws PersistenceException{
        this.handleCommonDate(fetchStudentMCommand);
    }
    public void handleCreateStudyProgramCommand(CreateStudyProgramCommand4Public createStudyProgramCommand) throws PersistenceException{
        this.handleCommonDate(createStudyProgramCommand);
    }
    public void handleAddSToSGCommand(AddSToSGCommand4Public addSToSGCommand) throws PersistenceException{
        this.handleCommonDate(addSToSGCommand);
    }
    public void handleCreateStudyGroupCommand(CreateStudyGroupCommand4Public createStudyGroupCommand) throws PersistenceException{
        this.handleCommonDate(createStudyGroupCommand);
    }
    public void handleRemMGFromSPCommand(RemMGFromSPCommand4Public remMGFromSPCommand) throws PersistenceException{
        this.handleCommonDate(remMGFromSPCommand);
    }
    public void handleRmvMWOUCommand(RmvMWOUCommand4Public rmvMWOUCommand) throws PersistenceException{
        this.handleCommonDate(rmvMWOUCommand);
    }
    public void handleRemMWUFromMGCommand(RemMWUFromMGCommand4Public remMWUFromMGCommand) throws PersistenceException{
        this.handleCommonDate(remMWUFromMGCommand);
    }
    public void handleCreateModuleGroupCommand(CreateModuleGroupCommand4Public createModuleGroupCommand) throws PersistenceException{
        this.handleCommonDate(createModuleGroupCommand);
    }
    public void handleAddUToMWUCommand(AddUToMWUCommand4Public addUToMWUCommand) throws PersistenceException{
        this.handleCommonDate(addUToMWUCommand);
    }
    public abstract void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    
    public abstract void handleModuleWithoutUnitsLst(ModuleWithoutUnitsLst4Public moduleWithoutUnitsLst) throws PersistenceException;
    
    public abstract void handleBooleanMarkLst(BooleanMarkLst4Public booleanMarkLst) throws PersistenceException;
    
    
}
