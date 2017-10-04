
package model.visitor;
import persistence.*;

public interface ModuleGroupsHIERARCHYVisitor {
    
    public void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException;
    public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException;
    public void handleModuleWithoutUnits(ModuleWithoutUnits4Public moduleWithoutUnits) throws PersistenceException;
    
}
