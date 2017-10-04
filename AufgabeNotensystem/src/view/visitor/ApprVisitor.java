
package view.visitor;
import view.*;

public interface ApprVisitor {
    
    public void handleModuleGroup(ModuleGroupView moduleGroup) throws ModelException;
    public void handleModuleWithUnits(ModuleWithUnitsView moduleWithUnits) throws ModelException;
    public void handleModuleWithoutUnits(ModuleWithoutUnitsView moduleWithoutUnits) throws ModelException;
    public void handleStudyProgram(StudyProgramView studyProgram) throws ModelException;
    public void handleUnit(UnitView unit) throws ModelException;
    
}
