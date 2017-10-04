
package model.visitor;

import persistence.*;

public abstract class StudentServer$AuthoriseVisitor extends AnythingStandardVisitor{
    
    public abstract void handlePassed(PersistentPassed passed) throws PersistenceException;
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public abstract void handleFiveZero(PersistentFiveZero fiveZero) throws PersistenceException;
    public abstract void handleModuleGroup(PersistentModuleGroup moduleGroup) throws PersistenceException;
    public abstract void handleUnit(PersistentUnit unit) throws PersistenceException;
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
    public abstract void handleTwoThree(PersistentTwoThree twoThree) throws PersistenceException;
    public abstract void handleBooleanMark(PersistentBooleanMark booleanMark) throws PersistenceException;
    public abstract void handleFourZero(PersistentFourZero fourZero) throws PersistenceException;
    public abstract void handleThreeSeven(PersistentThreeSeven threeSeven) throws PersistenceException;
    public abstract void handleOneZero(PersistentOneZero oneZero) throws PersistenceException;
    public abstract void handleMarkHistoryEntry(PersistentMarkHistoryEntry markHistoryEntry) throws PersistenceException;
    public abstract void handleThirdMark(PersistentThirdMark thirdMark) throws PersistenceException;
    
}
