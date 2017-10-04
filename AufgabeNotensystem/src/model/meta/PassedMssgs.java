package model.meta;

public interface PassedMssgs {
    void accept(PassedMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface PassedDOWNMssgs extends BooleanMarkDOWNMssgs, PassedMssgs{}
interface PassedUPMssgs extends Mssgs, PassedMssgs{}
