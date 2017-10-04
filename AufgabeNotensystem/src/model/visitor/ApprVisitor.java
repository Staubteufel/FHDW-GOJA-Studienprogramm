
package model.visitor;
import persistence.*;

public interface ApprVisitor {
    
    public void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException;
    public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException;
    public void handleModuleWithoutUnits(ModuleWithoutUnits4Public moduleWithoutUnits) throws PersistenceException;
    public void handleStudyProgram(StudyProgram4Public studyProgram) throws PersistenceException;
    public void handleUnit(Unit4Public unit) throws PersistenceException;
    
}
