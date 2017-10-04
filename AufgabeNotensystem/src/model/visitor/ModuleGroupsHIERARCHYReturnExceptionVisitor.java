
package model.visitor;
import persistence.*;

public interface ModuleGroupsHIERARCHYReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException, E;
    public R handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException, E;
    public R handleModuleWithoutUnits(ModuleWithoutUnits4Public moduleWithoutUnits) throws PersistenceException, E;
    
}
