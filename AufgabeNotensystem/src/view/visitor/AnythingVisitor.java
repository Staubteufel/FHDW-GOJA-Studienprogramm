
package view.visitor;
import view.*;

public interface AnythingVisitor extends MarkCalculableVisitor,MarkNotCalculableVisitor,PrototypeVisitor,ServiceVisitor{
    
    public void handleBooleanMarkLst(BooleanMarkLstView booleanMarkLst) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleMarkFactory(MarkFactoryView markFactory) throws ModelException;
    public void handleMarkHistoryEntry(MarkHistoryEntryView markHistoryEntry) throws ModelException;
    public void handleModuleGroupLst(ModuleGroupLstView moduleGroupLst) throws ModelException;
    public void handleModuleWithUnitsLst(ModuleWithUnitsLstView moduleWithUnitsLst) throws ModelException;
    public void handleModuleWithoutUnitsLst(ModuleWithoutUnitsLstView moduleWithoutUnitsLst) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    public void handleStudentServerLst(StudentServerLstView studentServerLst) throws ModelException;
    public void handleStudyGroupLst(StudyGroupLstView studyGroupLst) throws ModelException;
    public void handleStudyProgramLst(StudyProgramLstView studyProgramLst) throws ModelException;
    public void handleThirdMarkLst(ThirdMarkLstView thirdMarkLst) throws ModelException;
    public void handleUnitLst(UnitLstView unitLst) throws ModelException;
    
}
