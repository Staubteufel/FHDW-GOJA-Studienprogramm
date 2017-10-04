
package model.visitor;
import persistence.*;

public interface ModuleGroupsHIERARCHYExceptionVisitor<E extends model.UserException> {
    
    public void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException, E;
    public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException, E;
    public void handleModuleWithoutUnits(ModuleWithoutUnits4Public moduleWithoutUnits) throws PersistenceException, E;
    
}
