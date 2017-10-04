package model.meta;

public interface UnitLstMssgs {
    void accept(UnitLstMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface UnitLstDOWNMssgs extends Mssgs, UnitLstMssgs{}
interface UnitLstUPMssgs extends Mssgs, UnitLstMssgs{}
