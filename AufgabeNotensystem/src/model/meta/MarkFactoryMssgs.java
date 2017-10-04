package model.meta;

public interface MarkFactoryMssgs {
    void accept(MarkFactoryMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MarkFactoryDOWNMssgs extends Mssgs, MarkFactoryMssgs{}
interface MarkFactoryUPMssgs extends Mssgs, MarkFactoryMssgs{}
