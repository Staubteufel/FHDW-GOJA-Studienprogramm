package model.meta;

public interface StudentServerLstMssgs {
    void accept(StudentServerLstMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface StudentServerLstDOWNMssgs extends Mssgs, StudentServerLstMssgs{}
interface StudentServerLstUPMssgs extends Mssgs, StudentServerLstMssgs{}
