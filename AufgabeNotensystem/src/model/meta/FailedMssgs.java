package model.meta;

public interface FailedMssgs {
    void accept(FailedMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface FailedDOWNMssgs extends BooleanMarkDOWNMssgs, FailedMssgs{}
interface FailedUPMssgs extends Mssgs, FailedMssgs{}
