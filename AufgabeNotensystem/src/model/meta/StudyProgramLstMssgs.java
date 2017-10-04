package model.meta;

public interface StudyProgramLstMssgs {
    void accept(StudyProgramLstMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface StudyProgramLstDOWNMssgs extends Mssgs, StudyProgramLstMssgs{}
interface StudyProgramLstUPMssgs extends Mssgs, StudyProgramLstMssgs{}
