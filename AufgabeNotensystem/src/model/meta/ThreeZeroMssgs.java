package model.meta;

public interface ThreeZeroMssgs {
    void accept(ThreeZeroMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ThreeZeroDOWNMssgs extends ThirdMarkDOWNMssgs, ThreeZeroMssgs{}
interface ThreeZeroUPMssgs extends Mssgs, ThreeZeroMssgs{}
