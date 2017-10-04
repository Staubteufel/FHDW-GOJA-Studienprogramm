package model.meta;

public interface UnitMssgs {
    void accept(UnitMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface UnitDOWNMssgs extends ApprDOWNMssgs, UnitMssgs{}
interface UnitUPMssgs extends Mssgs, UnitMssgs{}
