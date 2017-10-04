package model.meta;

public interface ModuleWithUnitsLstMssgs {
    void accept(ModuleWithUnitsLstMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ModuleWithUnitsLstDOWNMssgs extends Mssgs, ModuleWithUnitsLstMssgs{}
interface ModuleWithUnitsLstUPMssgs extends Mssgs, ModuleWithUnitsLstMssgs{}
