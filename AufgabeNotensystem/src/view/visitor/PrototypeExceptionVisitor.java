
package view.visitor;
import view.*;

public interface PrototypeExceptionVisitor<E extends view.UserException> extends ApprExceptionVisitor<E>{
    
    public void handleStudyGroup(StudyGroupView studyGroup) throws ModelException, E;
    
}
