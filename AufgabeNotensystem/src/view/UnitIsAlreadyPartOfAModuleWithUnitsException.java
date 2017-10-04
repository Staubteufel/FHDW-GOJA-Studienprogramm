
package view;


import viewClient.*;
import view.visitor.*;


/* Additional import section end */

@SuppressWarnings("serial")
public class UnitIsAlreadyPartOfAModuleWithUnitsException extends view.UserException{
    
    public static UnitIsAlreadyPartOfAModuleWithUnitsException fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String message = (String)resultTable.get("?Message?");
        return new UnitIsAlreadyPartOfAModuleWithUnitsException(message);
    }
    
    public UnitIsAlreadyPartOfAModuleWithUnitsException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    public void accept(UserExceptionVisitor visitor) throws ModelException {
        visitor.handleUnitIsAlreadyPartOfAModuleWithUnitsException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnitIsAlreadyPartOfAModuleWithUnitsException(this);
    }
    public <E extends view.UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnitIsAlreadyPartOfAModuleWithUnitsException(this);
    }
    public <R, E extends view.UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnitIsAlreadyPartOfAModuleWithUnitsException(this);
    }
    
    
}
