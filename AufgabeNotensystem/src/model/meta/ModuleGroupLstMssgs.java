package model.meta;

public interface ModuleGroupLstMssgs {
    void accept(ModuleGroupLstMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ModuleGroupLstDOWNMssgs extends Mssgs, ModuleGroupLstMssgs{}
interface ModuleGroupLstUPMssgs extends Mssgs, ModuleGroupLstMssgs{}
