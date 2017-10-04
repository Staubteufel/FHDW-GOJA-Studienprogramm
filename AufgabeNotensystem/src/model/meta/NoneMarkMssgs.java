package model.meta;

public interface NoneMarkMssgs {
    void accept(NoneMarkMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NoneMarkDOWNMssgs extends MarkNotCalculableDOWNMssgs, NoneMarkMssgs{}
interface NoneMarkUPMssgs extends Mssgs, NoneMarkMssgs{}
