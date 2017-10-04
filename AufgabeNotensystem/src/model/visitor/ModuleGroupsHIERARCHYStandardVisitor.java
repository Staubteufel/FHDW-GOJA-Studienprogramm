
package model.visitor;

import persistence.*;

public abstract class ModuleGroupsHIERARCHYStandardVisitor implements ModuleGroupsHIERARCHYVisitor {
    
    public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException{
        this.standardHandling(moduleWithUnits);
    }
    public void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException{
        this.standardHandling(moduleGroup);
    }
    public void handleModuleWithoutUnits(ModuleWithoutUnits4Public moduleWithoutUnits) throws PersistenceException{
        this.standardHandling(moduleWithoutUnits);
    }
    protected abstract void standardHandling(ModuleGroupsHIERARCHY moduleGroupsHIERARCHY) throws PersistenceException;
}
