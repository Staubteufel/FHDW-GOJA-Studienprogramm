
package view.visitor;

import view.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleMarkNotCalculable(MarkNotCalculableView markNotCalculable) throws ModelException;
    
    public void handlePassed(PassedView passed) throws ModelException{
        this.handleMarkNotCalculable(passed);
    }
    public void handleBooleanMark(BooleanMarkView booleanMark) throws ModelException{
        this.handleMarkNotCalculable(booleanMark);
    }
    public void handleFailed(FailedView failed) throws ModelException{
        this.handleMarkNotCalculable(failed);
    }
    public void handleNoneMark(NoneMarkView noneMark) throws ModelException{
        this.handleMarkNotCalculable(noneMark);
    }
    public abstract void handlePrototype(PrototypeView prototype) throws ModelException;
    
    public void handleStudyProgram(StudyProgramView studyProgram) throws ModelException{
        this.handlePrototype(studyProgram);
    }
    public void handleStudyGroup(StudyGroupView studyGroup) throws ModelException{
        this.handlePrototype(studyGroup);
    }
    public void handleModuleWithUnits(ModuleWithUnitsView moduleWithUnits) throws ModelException{
        this.handlePrototype(moduleWithUnits);
    }
    public void handleModuleGroup(ModuleGroupView moduleGroup) throws ModelException{
        this.handlePrototype(moduleGroup);
    }
    public void handleUnit(UnitView unit) throws ModelException{
        this.handlePrototype(unit);
    }
    public void handleModuleWithoutUnits(ModuleWithoutUnitsView moduleWithoutUnits) throws ModelException{
        this.handlePrototype(moduleWithoutUnits);
    }
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handleMarkFactory(MarkFactoryView markFactory) throws ModelException;
    
    public abstract void handleThirdMarkLst(ThirdMarkLstView thirdMarkLst) throws ModelException;
    
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleStudyGroupLst(StudyGroupLstView studyGroupLst) throws ModelException;
    
    public abstract void handleModuleGroupLst(ModuleGroupLstView moduleGroupLst) throws ModelException;
    
    public abstract void handleService(ServiceView service) throws ModelException;
    
    public void handleStudentServer(StudentServerView studentServer) throws ModelException{
        this.handleService(studentServer);
    }
    public void handleAdminServer(AdminServerView adminServer) throws ModelException{
        this.handleService(adminServer);
    }
    public abstract void handleUnitLst(UnitLstView unitLst) throws ModelException;
    
    public abstract void handleMarkCalculable(MarkCalculableView markCalculable) throws ModelException;
    
    public void handleOneSeven(OneSevenView oneSeven) throws ModelException{
        this.handleMarkCalculable(oneSeven);
    }
    public void handleThreeThree(ThreeThreeView threeThree) throws ModelException{
        this.handleMarkCalculable(threeThree);
    }
    public void handleFiveZero(FiveZeroView fiveZero) throws ModelException{
        this.handleMarkCalculable(fiveZero);
    }
    public void handleOneThree(OneThreeView oneThree) throws ModelException{
        this.handleMarkCalculable(oneThree);
    }
    public void handleThreeZero(ThreeZeroView threeZero) throws ModelException{
        this.handleMarkCalculable(threeZero);
    }
    public void handleTwoThree(TwoThreeView twoThree) throws ModelException{
        this.handleMarkCalculable(twoThree);
    }
    public void handleTwoSeven(TwoSevenView twoSeven) throws ModelException{
        this.handleMarkCalculable(twoSeven);
    }
    public void handleFourZero(FourZeroView fourZero) throws ModelException{
        this.handleMarkCalculable(fourZero);
    }
    public void handleThreeSeven(ThreeSevenView threeSeven) throws ModelException{
        this.handleMarkCalculable(threeSeven);
    }
    public void handleOneZero(OneZeroView oneZero) throws ModelException{
        this.handleMarkCalculable(oneZero);
    }
    public void handleTenthMark(TenthMarkView tenthMark) throws ModelException{
        this.handleMarkCalculable(tenthMark);
    }
    public void handleTwoZero(TwoZeroView twoZero) throws ModelException{
        this.handleMarkCalculable(twoZero);
    }
    public void handleThirdMark(ThirdMarkView thirdMark) throws ModelException{
        this.handleMarkCalculable(thirdMark);
    }
    public abstract void handleModuleWithUnitsLst(ModuleWithUnitsLstView moduleWithUnitsLst) throws ModelException;
    
    public abstract void handleStudyProgramLst(StudyProgramLstView studyProgramLst) throws ModelException;
    
    public abstract void handleMarkHistoryEntry(MarkHistoryEntryView markHistoryEntry) throws ModelException;
    
    public abstract void handleStudentServerLst(StudentServerLstView studentServerLst) throws ModelException;
    
    public abstract void handleModuleWithoutUnitsLst(ModuleWithoutUnitsLstView moduleWithoutUnitsLst) throws ModelException;
    
    public abstract void handleBooleanMarkLst(BooleanMarkLstView booleanMarkLst) throws ModelException;
    
    
}
