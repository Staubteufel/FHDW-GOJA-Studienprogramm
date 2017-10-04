
package model.visitor;

import persistence.*;

public abstract class PrototypeStandardVisitor implements PrototypeVisitor {
    
    public void handleStudyProgram(StudyProgram4Public studyProgram) throws PersistenceException{
        this.standardHandling(studyProgram);
    }
    public void handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException{
        this.standardHandling(studyGroup);
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
    protected abstract void standardHandling(Prototype4Public prototype) throws PersistenceException;
}
