
package view.visitor;
import view.*;

public interface ApprReturnVisitor<R> {
    
    public R handleModuleGroup(ModuleGroupView moduleGroup) throws ModelException;
    public R handleModuleWithUnits(ModuleWithUnitsView moduleWithUnits) throws ModelException;
    public R handleModuleWithoutUnits(ModuleWithoutUnitsView moduleWithoutUnits) throws ModelException;
    public R handleStudyProgram(StudyProgramView studyProgram) throws ModelException;
    public R handleUnit(UnitView unit) throws ModelException;
    
}
