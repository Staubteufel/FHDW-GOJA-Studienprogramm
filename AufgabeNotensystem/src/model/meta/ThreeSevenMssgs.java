package model.meta;

public interface ThreeSevenMssgs {
    void accept(ThreeSevenMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ThreeSevenDOWNMssgs extends ThirdMarkDOWNMssgs, ThreeSevenMssgs{}
interface ThreeSevenUPMssgs extends Mssgs, ThreeSevenMssgs{}
