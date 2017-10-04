
package model.visitor;
import persistence.*;

public interface MarkCalculableVisitor extends ThirdMarkVisitor{
    
    public void handleTenthMark(TenthMark4Public tenthMark) throws PersistenceException;
    public void handleThirdMark(ThirdMark4Public thirdMark) throws PersistenceException;
    
}
