
package model.visitor;

import persistence.*;

public abstract class AdminServer$AuthoriseVisitor extends AnythingStandardVisitor{
    
    public abstract void handlePassed(PersistentPassed passed) throws PersistenceException;
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleMarkFactory(PersistentMarkFactory markFactory) throws PersistenceException;
    public abstract void handleAdminServer(PersistentAdminServer adminServer) throws PersistenceException;
    public abstract void handleThirdMarkLst(PersistentThirdMarkLst thirdMarkLst) throws PersistenceException;
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public abstract void handleStudyGroupLst(PersistentStudyGroupLst studyGroupLst) throws PersistenceException;
    public abstract void handleModuleGroupLst(PersistentModuleGroupLst moduleGroupLst) throws PersistenceException;
    public abstract void handleUnit(PersistentUnit unit) throws PersistenceException;
    public abstract void handleFiveZero(PersistentFiveZero fiveZero) throws PersistenceException;
    public abstract void handleModuleGroup(PersistentModuleGroup moduleGroup) throws PersistenceException;
    public abstract void handleThreeZero(PersistentThreeZero threeZero) throws PersistenceException;
    public abstract void handleModuleWithoutUnits(PersistentModuleWithoutUnits moduleWithoutUnits) throws PersistenceException;
    public abstract void handleTwoSeven(PersistentTwoSeven twoSeven) throws PersistenceException;
    public abstract void handleStudentServer(PersistentStudentServer studentServer) throws PersistenceException;
    public abstract void handleStudyGroup(PersistentStudyGroup studyGroup) throws PersistenceException;
    public abstract void handleTenthMark(PersistentTenthMark tenthMark) throws PersistenceException;
    public abstract void handleTwoZero(PersistentTwoZero twoZero) throws PersistenceException;
    public abstract void handleModuleWithUnits(PersistentModuleWithUnits moduleWithUnits) throws PersistenceException;
    public abstract void handleNoneMark(PersistentNoneMark noneMark) throws PersistenceException;
    public abstract void handleStudyProgram(PersistentStudyProgram studyProgram) throws PersistenceException;
    public abstract void handleOneSeven(PersistentOneSeven oneSeven) throws PersistenceException;
    public abstract void handleFailed(PersistentFailed failed) throws PersistenceException;
    public abstract void handleThreeThree(PersistentThreeThree threeThree) throws PersistenceException;
    public abstract void handleOneThree(PersistentOneThree oneThree) throws PersistenceException;
    public abstract void handleUnitLst(PersistentUnitLst unitLst) throws PersistenceException;
    public abstract void handleTwoThree(PersistentTwoThree twoThree) throws PersistenceException;
    public abstract void handleBooleanMark(PersistentBooleanMark booleanMark) throws PersistenceException;
    public abstract void handleFourZero(PersistentFourZero fourZero) throws PersistenceException;
    public abstract void handleThreeSeven(PersistentThreeSeven threeSeven) throws PersistenceException;
    public abstract void handleModuleWithUnitsLst(PersistentModuleWithUnitsLst moduleWithUnitsLst) throws PersistenceException;
    public abstract void handleOneZero(PersistentOneZero oneZero) throws PersistenceException;
    public abstract void handleStudyProgramLst(PersistentStudyProgramLst studyProgramLst) throws PersistenceException;
    public abstract void handleMarkHistoryEntry(PersistentMarkHistoryEntry markHistoryEntry) throws PersistenceException;
    public abstract void handleStudentServerLst(PersistentStudentServerLst studentServerLst) throws PersistenceException;
    public abstract void handleModuleWithoutUnitsLst(PersistentModuleWithoutUnitsLst moduleWithoutUnitsLst) throws PersistenceException;
    public abstract void handleThirdMark(PersistentThirdMark thirdMark) throws PersistenceException;
    public abstract void handleBooleanMarkLst(PersistentBooleanMarkLst booleanMarkLst) throws PersistenceException;
    
}
