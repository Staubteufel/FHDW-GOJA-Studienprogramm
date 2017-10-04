
package view.visitor;
import view.*;

public interface PrototypeVisitor extends ApprVisitor{
    
    public void handleStudyGroup(StudyGroupView studyGroup) throws ModelException;
    
}
