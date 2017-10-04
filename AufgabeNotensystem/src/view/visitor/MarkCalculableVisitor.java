
package view.visitor;
import view.*;

public interface MarkCalculableVisitor extends ThirdMarkVisitor{
    
    public void handleTenthMark(TenthMarkView tenthMark) throws ModelException;
    public void handleThirdMark(ThirdMarkView thirdMark) throws ModelException;
    
}
