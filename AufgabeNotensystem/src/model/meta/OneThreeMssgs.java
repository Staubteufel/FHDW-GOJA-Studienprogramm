package model.meta;

public interface OneThreeMssgs {
    void accept(OneThreeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface OneThreeDOWNMssgs extends ThirdMarkDOWNMssgs, OneThreeMssgs{}
interface OneThreeUPMssgs extends Mssgs, OneThreeMssgs{}
