
package model.visitor;
import persistence.*;

public interface PrototypeVisitor extends ApprVisitor{
    
    public void handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException;
    
}
