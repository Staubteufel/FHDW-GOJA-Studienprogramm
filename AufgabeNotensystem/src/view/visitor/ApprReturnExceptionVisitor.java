
package view.visitor;
import view.*;

public interface ApprReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleModuleGroup(ModuleGroupView moduleGroup) throws ModelException, E;
    public R handleModuleWithUnits(ModuleWithUnitsView moduleWithUnits) throws ModelException, E;
    public R handleModuleWithoutUnits(ModuleWithoutUnitsView moduleWithoutUnits) throws ModelException, E;
    public R handleStudyProgram(StudyProgramView studyProgram) throws ModelException, E;
    public R handleUnit(UnitView unit) throws ModelException, E;
    
}
