
package view.visitor;
import view.*;

public interface MarkCalculableExceptionVisitor<E extends view.UserException> extends ThirdMarkExceptionVisitor<E>{
    
    public void handleTenthMark(TenthMarkView tenthMark) throws ModelException, E;
    public void handleThirdMark(ThirdMarkView thirdMark) throws ModelException, E;
    
}
