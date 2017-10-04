
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handlePassed(Passed4Public passed) throws PersistenceException;
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    public abstract void handleMarkFactory(MarkFactory4Public markFactory) throws PersistenceException;
    public abstract void handleThirdMarkLst(ThirdMarkLst4Public thirdMarkLst) throws PersistenceException;
    public abstract void handleStudyGroupLst(StudyGroupLst4Public studyGroupLst) throws PersistenceException;
    public abstract void handleModuleGroupLst(ModuleGroupLst4Public moduleGroupLst) throws PersistenceException;
    public abstract void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException;
    public abstract void handleUnit(Unit4Public unit) throws PersistenceException;
    public abstract void handleFiveZero(FiveZero4Public fiveZero) throws PersistenceException;
    public abstract void handleStudentServer(StudentServer4Public studentServer) throws PersistenceException;
    public abstract void handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException;
    public abstract void handleTenthMark(TenthMark4Public tenthMark) throws PersistenceException;
    public abstract void handleTwoZero(TwoZero4Public twoZero) throws PersistenceException;
    public abstract void handleNoneMark(NoneMark4Public noneMark) throws PersistenceException;
    public abstract void handleStudyProgram(StudyProgram4Public studyProgram) throws PersistenceException;
    public abstract void handleFailed(Failed4Public failed) throws PersistenceException;
    public abstract void handleUnitLst(UnitLst4Public unitLst) throws PersistenceException;
    public abstract void handleThreeSeven(ThreeSeven4Public threeSeven) throws PersistenceException;
    public abstract void handleModuleWithUnitsLst(ModuleWithUnitsLst4Public moduleWithUnitsLst) throws PersistenceException;
    public abstract void handleMarkHistoryEntry(MarkHistoryEntry4Public markHistoryEntry) throws PersistenceException;
    public abstract void handleStudentServerLst(StudentServerLst4Public studentServerLst) throws PersistenceException;
    public abstract void handleThirdMark(ThirdMark4Public thirdMark) throws PersistenceException;
    public abstract void handleAdminServer(AdminServer4Public adminServer) throws PersistenceException;
    public abstract void handleModuleWithoutUnits(ModuleWithoutUnits4Public moduleWithoutUnits) throws PersistenceException;
    public abstract void handleThreeZero(ThreeZero4Public threeZero) throws PersistenceException;
    public abstract void handleTwoSeven(TwoSeven4Public twoSeven) throws PersistenceException;
    public abstract void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException;
    public abstract void handleOneSeven(OneSeven4Public oneSeven) throws PersistenceException;
    public abstract void handleThreeThree(ThreeThree4Public threeThree) throws PersistenceException;
    public abstract void handleOneThree(OneThree4Public oneThree) throws PersistenceException;
    public abstract void handleTwoThree(TwoThree4Public twoThree) throws PersistenceException;
    public abstract void handleBooleanMark(BooleanMark4Public booleanMark) throws PersistenceException;
    public abstract void handleFourZero(FourZero4Public fourZero) throws PersistenceException;
    public abstract void handleOneZero(OneZero4Public oneZero) throws PersistenceException;
    public abstract void handleStudyProgramLst(StudyProgramLst4Public studyProgramLst) throws PersistenceException;
    public abstract void handleModuleWithoutUnitsLst(ModuleWithoutUnitsLst4Public moduleWithoutUnitsLst) throws PersistenceException;
    public abstract void handleBooleanMarkLst(BooleanMarkLst4Public booleanMarkLst) throws PersistenceException;
    
}
