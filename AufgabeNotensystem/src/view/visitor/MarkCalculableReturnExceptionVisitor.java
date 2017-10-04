
package view.visitor;
import view.*;

public interface MarkCalculableReturnExceptionVisitor<R, E extends view.UserException> extends ThirdMarkReturnExceptionVisitor<R, E> {
    
    public R handleTenthMark(TenthMarkView tenthMark) throws ModelException, E;
    public R handleThirdMark(ThirdMarkView thirdMark) throws ModelException, E;
    
}
