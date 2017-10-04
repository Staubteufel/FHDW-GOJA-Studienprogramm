package model.meta;

public interface OneZeroMssgs {
    void accept(OneZeroMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface OneZeroDOWNMssgs extends ThirdMarkDOWNMssgs, OneZeroMssgs{}
interface OneZeroUPMssgs extends Mssgs, OneZeroMssgs{}
