
package model.visitor;
import persistence.*;

public interface MarkCalculableExceptionVisitor<E extends model.UserException> extends ThirdMarkExceptionVisitor<E>{
    
    public void handleTenthMark(TenthMark4Public tenthMark) throws PersistenceException, E;
    public void handleThirdMark(ThirdMark4Public thirdMark) throws PersistenceException, E;
    
}
