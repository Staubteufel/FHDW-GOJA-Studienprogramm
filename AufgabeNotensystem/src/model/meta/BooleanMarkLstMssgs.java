package model.meta;

public interface BooleanMarkLstMssgs {
    void accept(BooleanMarkLstMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface BooleanMarkLstDOWNMssgs extends Mssgs, BooleanMarkLstMssgs{}
interface BooleanMarkLstUPMssgs extends Mssgs, BooleanMarkLstMssgs{}
