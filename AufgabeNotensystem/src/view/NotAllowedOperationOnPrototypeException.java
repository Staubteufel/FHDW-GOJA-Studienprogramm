
package view;


import viewClient.*;
import view.visitor.*;


/* Additional import section end */

@SuppressWarnings("serial")
public class NotAllowedOperationOnPrototypeException extends view.UserException{
    
    public static NotAllowedOperationOnPrototypeException fromHashtableToNotAllowedOperationOnPrototypeException(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String message = (String)resultTable.get("?Message?");
        return new NotAllowedOperationOnPrototypeException(message);
    }
    
    public NotAllowedOperationOnPrototypeException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    public void accept(UserExceptionVisitor visitor) throws ModelException {
        visitor.handleNotAllowedOperationOnPrototypeException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNotAllowedOperationOnPrototypeException(this);
    }
    public <E extends view.UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNotAllowedOperationOnPrototypeException(this);
    }
    public <R, E extends view.UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNotAllowedOperationOnPrototypeException(this);
    }
    
    
}
