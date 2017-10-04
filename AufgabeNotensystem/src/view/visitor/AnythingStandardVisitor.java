
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handlePassed(PassedView passed) throws ModelException{
        this.standardHandling(passed);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleMarkFactory(MarkFactoryView markFactory) throws ModelException{
        this.standardHandling(markFactory);
    }
    public void handleThirdMarkLst(ThirdMarkLstView thirdMarkLst) throws ModelException{
        this.standardHandling(thirdMarkLst);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleStudyGroupLst(StudyGroupLstView studyGroupLst) throws ModelException{
        this.standardHandling(studyGroupLst);
    }
    public void handleModuleGroupLst(ModuleGroupLstView moduleGroupLst) throws ModelException{
        this.standardHandling(moduleGroupLst);
    }
    public void handleModuleGroup(ModuleGroupView moduleGroup) throws ModelException{
        this.standardHandling(moduleGroup);
    }
    public void handleUnit(UnitView unit) throws ModelException{
        this.standardHandling(unit);
    }
    public void handleFiveZero(FiveZeroView fiveZero) throws ModelException{
        this.standardHandling(fiveZero);
    }
    public void handleStudentServer(StudentServerView studentServer) throws ModelException{
        this.standardHandling(studentServer);
    }
    public void handleStudyGroup(StudyGroupView studyGroup) throws ModelException{
        this.standardHandling(studyGroup);
    }
    public void handleTenthMark(TenthMarkView tenthMark) throws ModelException{
        this.standardHandling(tenthMark);
    }
    public void handleTwoZero(TwoZeroView twoZero) throws ModelException{
        this.standardHandling(twoZero);
    }
    public void handleNoneMark(NoneMarkView noneMark) throws ModelException{
        this.standardHandling(noneMark);
    }
    public void handleStudyProgram(StudyProgramView studyProgram) throws ModelException{
        this.standardHandling(studyProgram);
    }
    public void handleFailed(FailedView failed) throws ModelException{
        this.standardHandling(failed);
    }
    public void handleUnitLst(UnitLstView unitLst) throws ModelException{
        this.standardHandling(unitLst);
    }
    public void handleThreeSeven(ThreeSevenView threeSeven) throws ModelException{
        this.standardHandling(threeSeven);
    }
    public void handleModuleWithUnitsLst(ModuleWithUnitsLstView moduleWithUnitsLst) throws ModelException{
        this.standardHandling(moduleWithUnitsLst);
    }
    public void handleMarkHistoryEntry(MarkHistoryEntryView markHistoryEntry) throws ModelException{
        this.standardHandling(markHistoryEntry);
    }
    public void handleStudentServerLst(StudentServerLstView studentServerLst) throws ModelException{
        this.standardHandling(studentServerLst);
    }
    public void handleThirdMark(ThirdMarkView thirdMark) throws ModelException{
        this.standardHandling(thirdMark);
    }
    public void handleAdminServer(AdminServerView adminServer) throws ModelException{
        this.standardHandling(adminServer);
    }
    public void handleModuleWithoutUnits(ModuleWithoutUnitsView moduleWithoutUnits) throws ModelException{
        this.standardHandling(moduleWithoutUnits);
    }
    public void handleThreeZero(ThreeZeroView threeZero) throws ModelException{
        this.standardHandling(threeZero);
    }
    public void handleTwoSeven(TwoSevenView twoSeven) throws ModelException{
        this.standardHandling(twoSeven);
    }
    public void handleModuleWithUnits(ModuleWithUnitsView moduleWithUnits) throws ModelException{
        this.standardHandling(moduleWithUnits);
    }
    public void handleOneSeven(OneSevenView oneSeven) throws ModelException{
        this.standardHandling(oneSeven);
    }
    public void handleThreeThree(ThreeThreeView threeThree) throws ModelException{
        this.standardHandling(threeThree);
    }
    public void handleOneThree(OneThreeView oneThree) throws ModelException{
        this.standardHandling(oneThree);
    }
    public void handleTwoThree(TwoThreeView twoThree) throws ModelException{
        this.standardHandling(twoThree);
    }
    public void handleBooleanMark(BooleanMarkView booleanMark) throws ModelException{
        this.standardHandling(booleanMark);
    }
    public void handleFourZero(FourZeroView fourZero) throws ModelException{
        this.standardHandling(fourZero);
    }
    public void handleOneZero(OneZeroView oneZero) throws ModelException{
        this.standardHandling(oneZero);
    }
    public void handleStudyProgramLst(StudyProgramLstView studyProgramLst) throws ModelException{
        this.standardHandling(studyProgramLst);
    }
    public void handleModuleWithoutUnitsLst(ModuleWithoutUnitsLstView moduleWithoutUnitsLst) throws ModelException{
        this.standardHandling(moduleWithoutUnitsLst);
    }
    public void handleBooleanMarkLst(BooleanMarkLstView booleanMarkLst) throws ModelException{
        this.standardHandling(booleanMarkLst);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
