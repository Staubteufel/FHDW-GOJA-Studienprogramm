
package model.visitor;
import persistence.*;

public interface MarkCalculableReturnVisitor<R> extends ThirdMarkReturnVisitor<R> {
    
    public R handleTenthMark(TenthMark4Public tenthMark) throws PersistenceException;
    public R handleThirdMark(ThirdMark4Public thirdMark) throws PersistenceException;
    
}
