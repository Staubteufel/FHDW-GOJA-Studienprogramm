
package model.visitor;
import persistence.*;

public interface MarkCalculableReturnExceptionVisitor<R, E extends model.UserException> extends ThirdMarkReturnExceptionVisitor<R, E> {
    
    public R handleTenthMark(TenthMark4Public tenthMark) throws PersistenceException, E;
    public R handleThirdMark(ThirdMark4Public thirdMark) throws PersistenceException, E;
    
}
