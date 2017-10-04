package model.meta;

public interface ModuleWithoutUnitsLstMssgs {
    void accept(ModuleWithoutUnitsLstMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ModuleWithoutUnitsLstDOWNMssgs extends Mssgs, ModuleWithoutUnitsLstMssgs{}
interface ModuleWithoutUnitsLstUPMssgs extends Mssgs, ModuleWithoutUnitsLstMssgs{}
