
package view;


import viewClient.*;
import view.visitor.*;


/* Additional import section end */

@SuppressWarnings("serial")
public class ThereIsAlreadyAStudyGroupException extends view.UserException{
    
    public static ThereIsAlreadyAStudyGroupException fromHashtableToThereIsAlreadyAStudyGroupException(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String message = (String)resultTable.get("?Message?");
        return new ThereIsAlreadyAStudyGroupException(message);
    }
    
    public ThereIsAlreadyAStudyGroupException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    public void accept(UserExceptionVisitor visitor) throws ModelException {
        visitor.handleThereIsAlreadyAStudyGroupException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleThereIsAlreadyAStudyGroupException(this);
    }
    public <E extends view.UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleThereIsAlreadyAStudyGroupException(this);
    }
    public <R, E extends view.UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleThereIsAlreadyAStudyGroupException(this);
    }
    
    
}
