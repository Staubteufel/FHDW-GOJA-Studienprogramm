package model.meta;

public interface FiveZeroMssgs {
    void accept(FiveZeroMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface FiveZeroDOWNMssgs extends ThirdMarkDOWNMssgs, FiveZeroMssgs{}
interface FiveZeroUPMssgs extends Mssgs, FiveZeroMssgs{}
