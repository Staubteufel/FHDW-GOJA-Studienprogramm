package model.meta;

public interface MarkMssgs {
    void accept(MarkMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MarkDOWNMssgs extends Mssgs, MarkMssgs{}
interface MarkUPMssgs extends MarkNotCalculableUPMssgs, MarkCalculableUPMssgs, MarkMssgs{}
