package model.meta;

public interface ThirdMarkLstMssgs {
    void accept(ThirdMarkLstMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ThirdMarkLstDOWNMssgs extends Mssgs, ThirdMarkLstMssgs{}
interface ThirdMarkLstUPMssgs extends Mssgs, ThirdMarkLstMssgs{}
