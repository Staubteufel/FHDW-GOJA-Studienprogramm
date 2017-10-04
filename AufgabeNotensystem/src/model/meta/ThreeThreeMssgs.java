package model.meta;

public interface ThreeThreeMssgs {
    void accept(ThreeThreeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ThreeThreeDOWNMssgs extends ThirdMarkDOWNMssgs, ThreeThreeMssgs{}
interface ThreeThreeUPMssgs extends Mssgs, ThreeThreeMssgs{}
