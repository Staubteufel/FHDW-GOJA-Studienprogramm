
package model.visitor;
import persistence.*;

public interface PrototypeExceptionVisitor<E extends model.UserException> extends ApprExceptionVisitor<E>{
    
    public void handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException, E;
    
}
