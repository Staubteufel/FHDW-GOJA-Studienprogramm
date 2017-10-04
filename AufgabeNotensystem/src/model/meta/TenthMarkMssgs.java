package model.meta;

public interface TenthMarkMssgs {
    void accept(TenthMarkMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TenthMarkDOWNMssgs extends MarkCalculableDOWNMssgs, TenthMarkMssgs{}
interface TenthMarkUPMssgs extends Mssgs, TenthMarkMssgs{}
