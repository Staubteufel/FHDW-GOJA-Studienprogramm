
package view.visitor;

import view.*;

public abstract class PrototypeStandardVisitor implements PrototypeVisitor {
    
    public void handleStudyProgram(StudyProgramView studyProgram) throws ModelException{
        this.standardHandling(studyProgram);
    }
    public void handleStudyGroup(StudyGroupView studyGroup) throws ModelException{
        this.standardHandling(studyGroup);
    }
    public void handleModuleWithUnits(ModuleWithUnitsView moduleWithUnits) throws ModelException{
        this.standardHandling(moduleWithUnits);
    }
    public void handleModuleGroup(ModuleGroupView moduleGroup) throws ModelException{
        this.standardHandling(moduleGroup);
    }
    public void handleUnit(UnitView unit) throws ModelException{
        this.standardHandling(unit);
    }
    public void handleModuleWithoutUnits(ModuleWithoutUnitsView moduleWithoutUnits) throws ModelException{
        this.standardHandling(moduleWithoutUnits);
    }
    protected abstract void standardHandling(PrototypeView prototype) throws ModelException;
}
