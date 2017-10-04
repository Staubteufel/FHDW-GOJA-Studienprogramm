
package model.visitor;
import persistence.*;

public interface ApprReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException, E;
    public R handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException, E;
    public R handleModuleWithoutUnits(ModuleWithoutUnits4Public moduleWithoutUnits) throws PersistenceException, E;
    public R handleStudyProgram(StudyProgram4Public studyProgram) throws PersistenceException, E;
    public R handleUnit(Unit4Public unit) throws PersistenceException, E;
    
}
