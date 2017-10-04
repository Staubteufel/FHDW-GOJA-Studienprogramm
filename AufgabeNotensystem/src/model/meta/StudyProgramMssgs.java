package model.meta;

public interface StudyProgramMssgs {
    void accept(StudyProgramMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface StudyProgramDOWNMssgs extends ApprDOWNMssgs, StudyProgramMssgs{}
interface StudyProgramUPMssgs extends Mssgs, StudyProgramMssgs{}
