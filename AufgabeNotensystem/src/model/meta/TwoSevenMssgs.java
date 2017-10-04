package model.meta;

public interface TwoSevenMssgs {
    void accept(TwoSevenMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TwoSevenDOWNMssgs extends ThirdMarkDOWNMssgs, TwoSevenMssgs{}
interface TwoSevenUPMssgs extends Mssgs, TwoSevenMssgs{}
