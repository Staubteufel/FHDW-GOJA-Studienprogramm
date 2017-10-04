
package view.visitor;
import view.*;

public interface PrototypeReturnVisitor<R> extends ApprReturnVisitor<R> {
    
    public R handleStudyGroup(StudyGroupView studyGroup) throws ModelException;
    
}
