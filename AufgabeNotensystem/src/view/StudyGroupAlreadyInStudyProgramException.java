
package view;


import viewClient.*;
import view.visitor.*;


/* Additional import section end */

@SuppressWarnings("serial")
public class StudyGroupAlreadyInStudyProgramException extends view.UserException{
    
    public static StudyGroupAlreadyInStudyProgramException fromHashtableToStudyGroupAlreadyInStudyProgramException(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String message = (String)resultTable.get("?Message?");
        return new StudyGroupAlreadyInStudyProgramException(message);
    }
    
    public StudyGroupAlreadyInStudyProgramException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    public void accept(UserExceptionVisitor visitor) throws ModelException {
        visitor.handleStudyGroupAlreadyInStudyProgramException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudyGroupAlreadyInStudyProgramException(this);
    }
    public <E extends view.UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudyGroupAlreadyInStudyProgramException(this);
    }
    public <R, E extends view.UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudyGroupAlreadyInStudyProgramException(this);
    }
    
    
}
