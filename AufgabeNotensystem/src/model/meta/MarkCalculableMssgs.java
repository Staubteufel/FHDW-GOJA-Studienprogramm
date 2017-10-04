package model.meta;

public interface MarkCalculableMssgs {
    void accept(MarkCalculableMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MarkCalculableDOWNMssgs extends MarkDOWNMssgs, MarkCalculableMssgs{}
interface MarkCalculableUPMssgs extends TenthMarkUPMssgs, ThirdMarkUPMssgs, MarkCalculableMssgs{}
