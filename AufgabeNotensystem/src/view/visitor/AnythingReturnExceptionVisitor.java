
package view.visitor;
import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends view.UserException> extends MarkCalculableReturnExceptionVisitor<R, E> ,MarkNotCalculableReturnExceptionVisitor<R, E> ,PrototypeReturnExceptionVisitor<R, E> ,ServiceReturnExceptionVisitor<R, E> {
    
    public R handleBooleanMarkLst(BooleanMarkLstView booleanMarkLst) throws ModelException, E;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleMarkFactory(MarkFactoryView markFactory) throws ModelException, E;
    public R handleMarkHistoryEntry(MarkHistoryEntryView markHistoryEntry) throws ModelException, E;
    public R handleModuleGroupLst(ModuleGroupLstView moduleGroupLst) throws ModelException, E;
    public R handleModuleWithUnitsLst(ModuleWithUnitsLstView moduleWithUnitsLst) throws ModelException, E;
    public R handleModuleWithoutUnitsLst(ModuleWithoutUnitsLstView moduleWithoutUnitsLst) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    public R handleStudentServerLst(StudentServerLstView studentServerLst) throws ModelException, E;
    public R handleStudyGroupLst(StudyGroupLstView studyGroupLst) throws ModelException, E;
    public R handleStudyProgramLst(StudyProgramLstView studyProgramLst) throws ModelException, E;
    public R handleThirdMarkLst(ThirdMarkLstView thirdMarkLst) throws ModelException, E;
    public R handleUnitLst(UnitLstView unitLst) throws ModelException, E;
    
}
