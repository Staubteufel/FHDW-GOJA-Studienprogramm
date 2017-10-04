package model;

import common.IconConstants;
import persistence.AddMGToMGCommand4Public;
import persistence.AddMGToSPCommand4Public;
import persistence.AddMWUToMGCommand4Public;
import persistence.AddMWWUToMGCommand4Public;
import persistence.AddSToSGCommand4Public;
import persistence.AddUToMWUCommand4Public;
import persistence.AdminServer4Public;
import persistence.Anything;
import persistence.BooleanMark4Public;
import persistence.BooleanMarkLst4Public;
import persistence.CommandCoordinator4Public;
import persistence.CommandExecuter4Public;
import persistence.CommonDate4Public;
import persistence.CreateMWUCommand4Public;
import persistence.CreateMWWUCommand4Public;
import persistence.CreateModuleGroupCommand4Public;
import persistence.CreateStudentCommand4Public;
import persistence.CreateStudyGroupCommand4Public;
import persistence.CreateStudyProgramCommand4Public;
import persistence.CreateUnitCommand4Public;
import persistence.ErrorDisplay4Public;
import persistence.Failed4Public;
import persistence.FetchMCommand4Public;
import persistence.FetchStudentMCommand4Public;
import persistence.FiveZero4Public;
import persistence.FourZero4Public;
import persistence.MarkHistoryEntry4Public;
import persistence.ModuleGroup4Public;
import persistence.ModuleGroupLst4Public;
import persistence.ModuleWithUnits4Public;
import persistence.ModuleWithUnitsLst4Public;
import persistence.ModuleWithoutUnits4Public;
import persistence.ModuleWithoutUnitsLst4Public;
import persistence.NoneMark4Public;
import persistence.OneSeven4Public;
import persistence.OneThree4Public;
import persistence.OneZero4Public;
import persistence.Passed4Public;
import persistence.PersistenceException;
import persistence.RemMGFromMGCommand4Public;
import persistence.RemMGFromSPCommand4Public;
import persistence.RemMWUFromMGCommand4Public;
import persistence.RemMWWUFromMGCommand4Public;
import persistence.RemUFromMWUCommand4Public;
import persistence.RemoveModuleGroupCommand4Public;
import persistence.RemoveStudyGroupCommand4Public;
import persistence.RemoveStudyProgramCommand4Public;
import persistence.RemoveUnitCommand4Public;
import persistence.RmvMWOUCommand4Public;
import persistence.RmvMWUCommand4Public;
import persistence.Server4Public;
import persistence.SetActiveSGCommand4Public;
import persistence.SorcMTSWiMWuUCommand4Public;
import persistence.SorcMTSWiUCommand4Public;
import persistence.StudentServer4Public;
import persistence.StudentServerLst4Public;
import persistence.StudyGroup4Public;
import persistence.StudyGroupLst4Public;
import persistence.StudyProgram4Public;
import persistence.StudyProgramLst4Public;
import persistence.TenthMark4Public;
import persistence.ThirdMark4Public;
import persistence.ThirdMarkLst4Public;
import persistence.ThreeSeven4Public;
import persistence.ThreeThree4Public;
import persistence.ThreeZero4Public;
import persistence.TwoSeven4Public;
import persistence.TwoThree4Public;
import persistence.TwoZero4Public;
import persistence.Unit4Public;
import persistence.UnitLst4Public;

public class GetIconInfo$Visitor extends model.visitor.AnythingStandardVisitor {

	int result = 0;
	
	@Override
	protected void standardHandling(Anything anything) throws PersistenceException {
		result = 0;	
	}

	public int getIconInfo(Anything anything) throws PersistenceException {
		anything.accept(this);
		return result;
	}


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
//        this.standardHandling(createUnitCommand);
    	result = IconConstants.Create;
    }
    public void handleThirdMarkLst(ThirdMarkLst4Public thirdMarkLst) throws PersistenceException{
//        this.standardHandling(thirdMarkLst);
    	result = IconConstants.Lst;
    }
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleStudyGroupLst(StudyGroupLst4Public studyGroupLst) throws PersistenceException{
//        this.standardHandling(studyGroupLst);
    	result = IconConstants.Lst;
    }
    public void handleModuleGroupLst(ModuleGroupLst4Public moduleGroupLst) throws PersistenceException{
//        this.standardHandling(moduleGroupLst);
    	result = IconConstants.Lst;
    }
    public void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException{
//        this.standardHandling(moduleGroup);
    	result = IconConstants.ModuleGroup;
    }
    public void handleUnit(Unit4Public unit) throws PersistenceException{
//        this.standardHandling(unit);
    	result = IconConstants.Unit;
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
//        this.standardHandling(studentServer);
    	result = IconConstants.Student;
    }
    public void handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException{
//        this.standardHandling(studyGroup);
    	result = IconConstants.StudyGroup;
    }
    public void handleTenthMark(TenthMark4Public tenthMark) throws PersistenceException{
        this.standardHandling(tenthMark);
    }
    public void handleTwoZero(TwoZero4Public twoZero) throws PersistenceException{
        this.standardHandling(twoZero);
    }
//    public void handleChCPWithMWWUCommand(ChCPWithMWWUCommand4Public chCPWithMWWUCommand) throws PersistenceException{
//        this.standardHandling(chCPWithMWWUCommand);
//    }
    public void handleRmvMWUCommand(RmvMWUCommand4Public rmvMWUCommand) throws PersistenceException{
        this.standardHandling(rmvMWUCommand);
    }
    public void handleCreateMWWUCommand(CreateMWWUCommand4Public createMWWUCommand) throws PersistenceException{
//        this.standardHandling(createMWWUCommand);
    	result = IconConstants.Create;
    }
    public void handleNoneMark(NoneMark4Public noneMark) throws PersistenceException{
        this.standardHandling(noneMark);
    }
    public void handleRemoveUnitCommand(RemoveUnitCommand4Public removeUnitCommand) throws PersistenceException{
        this.standardHandling(removeUnitCommand);
    }
    public void handleStudyProgram(StudyProgram4Public studyProgram) throws PersistenceException{
//        this.standardHandling(studyProgram);
    	result = IconConstants.StudyProgram;
    }
    public void handleFailed(Failed4Public failed) throws PersistenceException{
        this.standardHandling(failed);
    }
    public void handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException{
//        this.standardHandling(createStudentCommand);
    	result = IconConstants.Create;
    }
    public void handleFetchStudentMCommand(FetchStudentMCommand4Public fetchStudentMCommand) throws PersistenceException{
        this.standardHandling(fetchStudentMCommand);
    }
    public void handleUnitLst(UnitLst4Public unitLst) throws PersistenceException{
//        this.standardHandling(unitLst);
    	result = IconConstants.Lst;
    }
    public void handleThreeSeven(ThreeSeven4Public threeSeven) throws PersistenceException{
        this.standardHandling(threeSeven);
    }
    public void handleModuleWithUnitsLst(ModuleWithUnitsLst4Public moduleWithUnitsLst) throws PersistenceException{
//        this.standardHandling(moduleWithUnitsLst);
    	result = IconConstants.Lst;
    }
    public void handleRemMGFromSPCommand(RemMGFromSPCommand4Public remMGFromSPCommand) throws PersistenceException{
        this.standardHandling(remMGFromSPCommand);
    }
    public void handleMarkHistoryEntry(MarkHistoryEntry4Public markHistoryEntry) throws PersistenceException{
        this.standardHandling(markHistoryEntry);
    }
    public void handleStudentServerLst(StudentServerLst4Public studentServerLst) throws PersistenceException{
//        this.standardHandling(studentServerLst);
    	result = IconConstants.Lst;
    }
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleThirdMark(ThirdMark4Public thirdMark) throws PersistenceException{
        this.standardHandling(thirdMark);
    }
    public void handleCreateMWUCommand(CreateMWUCommand4Public createMWUCommand) throws PersistenceException{
//        this.standardHandling(createMWUCommand);
        result = IconConstants.Create;
    }
    public void handleRemoveStudyProgramCommand(RemoveStudyProgramCommand4Public removeStudyProgramCommand) throws PersistenceException{
        this.standardHandling(removeStudyProgramCommand);
    }
    public void handleAdminServer(AdminServer4Public adminServer) throws PersistenceException{
        this.standardHandling(adminServer);
    }
    public void handleModuleWithoutUnits(ModuleWithoutUnits4Public moduleWithoutUnits) throws PersistenceException{
//        this.standardHandling(moduleWithoutUnits);
    	result = IconConstants.ModuleWithoutUnits;
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
//        this.standardHandling(moduleWithUnits);
    	result = IconConstants.ModuleWithUnits;
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
    public void handleThreeThree(ThreeThree4Public threeThree) throws PersistenceException{
        this.standardHandling(threeThree);
    }
    public void handleOneThree(OneThree4Public oneThree) throws PersistenceException{
        this.standardHandling(oneThree);
    }
    public void handleCreateStudyProgramCommand(CreateStudyProgramCommand4Public createStudyProgramCommand) throws PersistenceException{
//        this.standardHandling(createStudyProgramCommand);
    	result = IconConstants.Create;
    }
    public void handleAddSToSGCommand(AddSToSGCommand4Public addSToSGCommand) throws PersistenceException{
        this.standardHandling(addSToSGCommand);
    }
    public void handleCreateStudyGroupCommand(CreateStudyGroupCommand4Public createStudyGroupCommand) throws PersistenceException{
//        this.standardHandling(createStudyGroupCommand);
    	result = IconConstants.Create;
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
//        this.standardHandling(studyProgramLst);
    	result = IconConstants.Lst;
    }
    public void handleRemMWUFromMGCommand(RemMWUFromMGCommand4Public remMWUFromMGCommand) throws PersistenceException{
        this.standardHandling(remMWUFromMGCommand);
    }
    public void handleCreateModuleGroupCommand(CreateModuleGroupCommand4Public createModuleGroupCommand) throws PersistenceException{
//        this.standardHandling(createModuleGroupCommand);
    	result = IconConstants.Create;
    }
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException{
        this.standardHandling(commandExecuter);
    }
    public void handleAddUToMWUCommand(AddUToMWUCommand4Public addUToMWUCommand) throws PersistenceException{
        this.standardHandling(addUToMWUCommand);
    }
    public void handleModuleWithoutUnitsLst(ModuleWithoutUnitsLst4Public moduleWithoutUnitsLst) throws PersistenceException{
//        this.standardHandling(moduleWithoutUnitsLst);
    	result = IconConstants.Lst;
    }
//    public void handleChCPWithUCommand(ChCPWithUCommand4Public chCPWithUCommand) throws PersistenceException{
//        this.standardHandling(chCPWithUCommand);
//    }
    public void handleBooleanMarkLst(BooleanMarkLst4Public booleanMarkLst) throws PersistenceException{
//        this.standardHandling(booleanMarkLst);
        result = IconConstants.Lst;
    }
}
