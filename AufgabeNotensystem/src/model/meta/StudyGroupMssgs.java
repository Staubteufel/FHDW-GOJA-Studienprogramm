package model.meta;

public interface StudyGroupMssgs {
    void accept(StudyGroupMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface StudyGroupDOWNMssgs extends PrototypeDOWNMssgs, StudyGroupMssgs{}
interface StudyGroupUPMssgs extends Mssgs, StudyGroupMssgs{}
