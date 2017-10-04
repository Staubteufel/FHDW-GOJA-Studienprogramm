package model.meta;

public interface StudyGroupLstMssgs {
    void accept(StudyGroupLstMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface StudyGroupLstDOWNMssgs extends Mssgs, StudyGroupLstMssgs{}
interface StudyGroupLstUPMssgs extends Mssgs, StudyGroupLstMssgs{}
