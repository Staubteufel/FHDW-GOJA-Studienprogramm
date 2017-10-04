
package model.visitor;

import persistence.*;

public abstract class ApprStandardVisitor implements ApprVisitor {
    
    public void handleStudyProgram(StudyProgram4Public studyProgram) throws PersistenceException{
        this.standardHandling(studyProgram);
    }
    public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException{
        this.standardHandling(moduleWithUnits);
    }
    public void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException{
        this.standardHandling(moduleGroup);
    }
    public void handleUnit(Unit4Public unit) throws PersistenceException{
        this.standardHandling(unit);
    }
    public void handleModuleWithoutUnits(ModuleWithoutUnits4Public moduleWithoutUnits) throws PersistenceException{
        this.standardHandling(moduleWithoutUnits);
    }
    protected abstract void standardHandling(Appr4Public appr) throws PersistenceException;
}
