
package model.visitor;
import persistence.*;

public interface PrototypeReturnExceptionVisitor<R, E extends model.UserException> extends ApprReturnExceptionVisitor<R, E> {
    
    public R handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException, E;
    
}
