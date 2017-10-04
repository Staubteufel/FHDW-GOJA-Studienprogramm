package model.meta;

public interface OneSevenMssgs {
    void accept(OneSevenMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface OneSevenDOWNMssgs extends ThirdMarkDOWNMssgs, OneSevenMssgs{}
interface OneSevenUPMssgs extends Mssgs, OneSevenMssgs{}
