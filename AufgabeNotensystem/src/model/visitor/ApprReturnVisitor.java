
package model.visitor;
import persistence.*;

public interface ApprReturnVisitor<R> {
    
    public R handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException;
    public R handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException;
    public R handleModuleWithoutUnits(ModuleWithoutUnits4Public moduleWithoutUnits) throws PersistenceException;
    public R handleStudyProgram(StudyProgram4Public studyProgram) throws PersistenceException;
    public R handleUnit(Unit4Public unit) throws PersistenceException;
    
}
