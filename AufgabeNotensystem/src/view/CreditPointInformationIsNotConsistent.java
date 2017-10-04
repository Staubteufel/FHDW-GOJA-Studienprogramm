
package view;


import viewClient.*;
import view.visitor.*;


/* Additional import section end */

@SuppressWarnings("serial")
public class CreditPointInformationIsNotConsistent extends view.UserException{
    
    public static CreditPointInformationIsNotConsistent fromHashtableToCreditPointInformationIsNotConsistent(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String message = (String)resultTable.get("?Message?");
        return new CreditPointInformationIsNotConsistent(message);
    }
    
    public CreditPointInformationIsNotConsistent(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    public void accept(UserExceptionVisitor visitor) throws ModelException {
        visitor.handleCreditPointInformationIsNotConsistent(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCreditPointInformationIsNotConsistent(this);
    }
    public <E extends view.UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCreditPointInformationIsNotConsistent(this);
    }
    public <R, E extends view.UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCreditPointInformationIsNotConsistent(this);
    }
    
    
}
