package model.meta;

public interface MarkHistoryEntryMssgs {
    void accept(MarkHistoryEntryMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MarkHistoryEntryDOWNMssgs extends Mssgs, MarkHistoryEntryMssgs{}
interface MarkHistoryEntryUPMssgs extends Mssgs, MarkHistoryEntryMssgs{}
