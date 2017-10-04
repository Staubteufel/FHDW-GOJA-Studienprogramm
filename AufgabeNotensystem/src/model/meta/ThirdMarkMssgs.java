package model.meta;

public interface ThirdMarkMssgs {
    void accept(ThirdMarkMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ThirdMarkDOWNMssgs extends MarkCalculableDOWNMssgs, ThirdMarkMssgs{}
interface ThirdMarkUPMssgs extends FiveZeroUPMssgs, ThreeZeroUPMssgs, TwoSevenUPMssgs, TwoZeroUPMssgs, OneSevenUPMssgs, ThreeThreeUPMssgs, OneThreeUPMssgs, TwoThreeUPMssgs, FourZeroUPMssgs, ThreeSevenUPMssgs, OneZeroUPMssgs, ThirdMarkMssgs{}
