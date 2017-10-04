package model.meta;

public interface TwoZeroMssgs {
    void accept(TwoZeroMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TwoZeroDOWNMssgs extends ThirdMarkDOWNMssgs, TwoZeroMssgs{}
interface TwoZeroUPMssgs extends Mssgs, TwoZeroMssgs{}
