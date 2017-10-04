package model.meta;

public interface MarkNotCalculableMssgs {
    void accept(MarkNotCalculableMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MarkNotCalculableDOWNMssgs extends MarkDOWNMssgs, MarkNotCalculableMssgs{}
interface MarkNotCalculableUPMssgs extends NoneMarkUPMssgs, BooleanMarkUPMssgs, MarkNotCalculableMssgs{}
