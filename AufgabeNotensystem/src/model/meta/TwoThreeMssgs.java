package model.meta;

public interface TwoThreeMssgs {
    void accept(TwoThreeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TwoThreeDOWNMssgs extends ThirdMarkDOWNMssgs, TwoThreeMssgs{}
interface TwoThreeUPMssgs extends Mssgs, TwoThreeMssgs{}
