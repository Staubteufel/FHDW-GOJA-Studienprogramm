package model.meta;

public interface FourZeroMssgs {
    void accept(FourZeroMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface FourZeroDOWNMssgs extends ThirdMarkDOWNMssgs, FourZeroMssgs{}
interface FourZeroUPMssgs extends Mssgs, FourZeroMssgs{}
