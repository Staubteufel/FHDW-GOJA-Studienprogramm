
package view.visitor;
import view.*;

public interface AnythingExceptionVisitor<E extends view.UserException> extends MarkCalculableExceptionVisitor<E>,MarkNotCalculableExceptionVisitor<E>,PrototypeExceptionVisitor<E>,ServiceExceptionVisitor<E>{
    
    public void handleBooleanMarkLst(BooleanMarkLstView booleanMarkLst) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleMarkFactory(MarkFactoryView markFactory) throws ModelException, E;
    public void handleMarkHistoryEntry(MarkHistoryEntryView markHistoryEntry) throws ModelException, E;
    public void handleModuleGroupLst(ModuleGroupLstView moduleGroupLst) throws ModelException, E;
    public void handleModuleWithUnitsLst(ModuleWithUnitsLstView moduleWithUnitsLst) throws ModelException, E;
    public void handleModuleWithoutUnitsLst(ModuleWithoutUnitsLstView moduleWithoutUnitsLst) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    public void handleStudentServerLst(StudentServerLstView studentServerLst) throws ModelException, E;
    public void handleStudyGroupLst(StudyGroupLstView studyGroupLst) throws ModelException, E;
    public void handleStudyProgramLst(StudyProgramLstView studyProgramLst) throws ModelException, E;
    public void handleThirdMarkLst(ThirdMarkLstView thirdMarkLst) throws ModelException, E;
    public void handleUnitLst(UnitLstView unitLst) throws ModelException, E;
    
}
