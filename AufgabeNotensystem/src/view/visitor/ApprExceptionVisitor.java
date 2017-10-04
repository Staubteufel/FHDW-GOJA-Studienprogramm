
package view.visitor;
import view.*;

public interface ApprExceptionVisitor<E extends view.UserException> {
    
    public void handleModuleGroup(ModuleGroupView moduleGroup) throws ModelException, E;
    public void handleModuleWithUnits(ModuleWithUnitsView moduleWithUnits) throws ModelException, E;
    public void handleModuleWithoutUnits(ModuleWithoutUnitsView moduleWithoutUnits) throws ModelException, E;
    public void handleStudyProgram(StudyProgramView studyProgram) throws ModelException, E;
    public void handleUnit(UnitView unit) throws ModelException, E;
    
}
