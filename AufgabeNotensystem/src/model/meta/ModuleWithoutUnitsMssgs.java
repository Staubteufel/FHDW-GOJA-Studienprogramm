package model.meta;

public interface ModuleWithoutUnitsMssgs {
    void accept(ModuleWithoutUnitsMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ModuleWithoutUnitsDOWNMssgs extends ApprDOWNMssgs, ModuleWithoutUnitsMssgs{}
interface ModuleWithoutUnitsUPMssgs extends Mssgs, ModuleWithoutUnitsMssgs{}
