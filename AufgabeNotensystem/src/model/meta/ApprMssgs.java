package model.meta;

public interface ApprMssgs {
    void accept(ApprMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ApprDOWNMssgs extends PrototypeDOWNMssgs, ApprMssgs{}
interface ApprUPMssgs extends ModuleGroupUPMssgs, UnitUPMssgs, ModuleWithoutUnitsUPMssgs, ModuleWithUnitsUPMssgs, StudyProgramUPMssgs, ApprMssgs{}
