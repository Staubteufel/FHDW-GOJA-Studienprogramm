
package view.visitor;
import view.*;

public interface PrototypeReturnExceptionVisitor<R, E extends view.UserException> extends ApprReturnExceptionVisitor<R, E> {
    
    public R handleStudyGroup(StudyGroupView studyGroup) throws ModelException, E;
    
}
