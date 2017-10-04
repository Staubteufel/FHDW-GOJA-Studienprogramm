
package view.visitor;
import view.*;

public interface MarkCalculableReturnVisitor<R> extends ThirdMarkReturnVisitor<R> {
    
    public R handleTenthMark(TenthMarkView tenthMark) throws ModelException;
    public R handleThirdMark(ThirdMarkView thirdMark) throws ModelException;
    
}
