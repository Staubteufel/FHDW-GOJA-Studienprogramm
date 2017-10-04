package model.meta;

public interface BooleanMarkMssgs {
    void accept(BooleanMarkMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface BooleanMarkDOWNMssgs extends MarkNotCalculableDOWNMssgs, BooleanMarkMssgs{}
interface BooleanMarkUPMssgs extends PassedUPMssgs, FailedUPMssgs, BooleanMarkMssgs{}
