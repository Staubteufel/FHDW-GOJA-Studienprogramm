package model.meta;

public interface PrototypeMssgs {
    void accept(PrototypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface PrototypeDOWNMssgs extends Mssgs, PrototypeMssgs{}
interface PrototypeUPMssgs extends ApprUPMssgs, StudyGroupUPMssgs, PrototypeMssgs{}
