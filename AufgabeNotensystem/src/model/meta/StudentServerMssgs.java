package model.meta;

public interface StudentServerMssgs {
    void accept(StudentServerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface StudentServerDOWNMssgs extends ServiceDOWNMssgs, StudentServerMssgs{}
interface StudentServerUPMssgs extends Mssgs, StudentServerMssgs{}
