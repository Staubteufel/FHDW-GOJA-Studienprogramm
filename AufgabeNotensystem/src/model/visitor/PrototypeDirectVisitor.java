
package model.visitor;

import persistence.*;

public abstract class PrototypeDirectVisitor implements PrototypeVisitor {
    
    public abstract void handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException;
    
    public abstract void handleAppr(Appr4Public appr) throws PersistenceException;
    
    public void handleStudyProgram(StudyProgram4Public studyProgram) throws PersistenceException{
        this.handleAppr(studyProgram);
    }
    public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException{
        this.handleAppr(moduleWithUnits);
    }
    public void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException{
        this.handleAppr(moduleGroup);
    }
    public void handleUnit(Unit4Public unit) throws PersistenceException{
        this.handleAppr(unit);
    }
    public void handleModuleWithoutUnits(ModuleWithoutUnits4Public moduleWithoutUnits) throws PersistenceException{
        this.handleAppr(moduleWithoutUnits);
    }
    
}
