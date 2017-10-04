
package model.visitor;
import persistence.*;

public interface ModuleGroupsHIERARCHYReturnVisitor<R> {
    
    public R handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException;
    public R handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException;
    public R handleModuleWithoutUnits(ModuleWithoutUnits4Public moduleWithoutUnits) throws PersistenceException;
    
}
