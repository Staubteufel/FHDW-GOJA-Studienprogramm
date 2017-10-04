
package view.visitor;
import view.*;

public interface AnythingReturnVisitor<R> extends MarkCalculableReturnVisitor<R> ,MarkNotCalculableReturnVisitor<R> ,PrototypeReturnVisitor<R> ,ServiceReturnVisitor<R> {
    
    public R handleBooleanMarkLst(BooleanMarkLstView booleanMarkLst) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleMarkFactory(MarkFactoryView markFactory) throws ModelException;
    public R handleMarkHistoryEntry(MarkHistoryEntryView markHistoryEntry) throws ModelException;
    public R handleModuleGroupLst(ModuleGroupLstView moduleGroupLst) throws ModelException;
    public R handleModuleWithUnitsLst(ModuleWithUnitsLstView moduleWithUnitsLst) throws ModelException;
    public R handleModuleWithoutUnitsLst(ModuleWithoutUnitsLstView moduleWithoutUnitsLst) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    public R handleStudentServerLst(StudentServerLstView studentServerLst) throws ModelException;
    public R handleStudyGroupLst(StudyGroupLstView studyGroupLst) throws ModelException;
    public R handleStudyProgramLst(StudyProgramLstView studyProgramLst) throws ModelException;
    public R handleThirdMarkLst(ThirdMarkLstView thirdMarkLst) throws ModelException;
    public R handleUnitLst(UnitLstView unitLst) throws ModelException;
    
}
