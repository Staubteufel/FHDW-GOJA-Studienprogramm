
package model.visitor;
import persistence.*;

public interface PrototypeReturnVisitor<R> extends ApprReturnVisitor<R> {
    
    public R handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException;
    
}
