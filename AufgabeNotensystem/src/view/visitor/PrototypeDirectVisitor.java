
package view.visitor;

import view.*;

public abstract class PrototypeDirectVisitor implements PrototypeVisitor {
    
    public abstract void handleStudyGroup(StudyGroupView studyGroup) throws ModelException;
    
    public abstract void handleAppr(ApprView appr) throws ModelException;
    
    public void handleStudyProgram(StudyProgramView studyProgram) throws ModelException{
        this.handleAppr(studyProgram);
    }
    public void handleModuleWithUnits(ModuleWithUnitsView moduleWithUnits) throws ModelException{
        this.handleAppr(moduleWithUnits);
    }
    public void handleModuleGroup(ModuleGroupView moduleGroup) throws ModelException{
        this.handleAppr(moduleGroup);
    }
    public void handleUnit(UnitView unit) throws ModelException{
        this.handleAppr(unit);
    }
    public void handleModuleWithoutUnits(ModuleWithoutUnitsView moduleWithoutUnits) throws ModelException{
        this.handleAppr(moduleWithoutUnits);
    }
    
}
