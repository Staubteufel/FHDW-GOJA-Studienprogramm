
package model.visitor;
import persistence.*;

public interface UserExceptionVisitor {
    
    public void handleAlreadyInUseException(model.AlreadyInUseException alreadyInUseException) throws PersistenceException;
    public void handleCreditPointInformationIsNotConsistent(model.CreditPointInformationIsNotConsistent creditPointInformationIsNotConsistent) throws PersistenceException;
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public void handleMatricalNumberAlreadyUsed(model.MatricalNumberAlreadyUsed matricalNumberAlreadyUsed) throws PersistenceException;
    public void handleNameAlreadyExistsException(model.NameAlreadyExistsException nameAlreadyExistsException) throws PersistenceException;
    public void handleNotAllowedOperationOnPrototypeException(model.NotAllowedOperationOnPrototypeException notAllowedOperationOnPrototypeException) throws PersistenceException;
    public void handleNotInStudyGroupException(model.NotInStudyGroupException notInStudyGroupException) throws PersistenceException;
    public void handleOtherTypeThanSettedException(model.OtherTypeThanSettedException otherTypeThanSettedException) throws PersistenceException;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    public void handleStudyGroupAlreadyInStudyProgramException(model.StudyGroupAlreadyInStudyProgramException studyGroupAlreadyInStudyProgramException) throws PersistenceException;
    public void handleThereIsAlreadyAStudyGroupException(model.ThereIsAlreadyAStudyGroupException thereIsAlreadyAStudyGroupException) throws PersistenceException;
    public void handleUnitIsAlreadyPartOfAModuleWithUnitsException(model.UnitIsAlreadyPartOfAModuleWithUnitsException unitIsAlreadyPartOfAModuleWithUnitsException) throws PersistenceException;
    
}
