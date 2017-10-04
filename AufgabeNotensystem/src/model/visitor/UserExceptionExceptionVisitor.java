
package model.visitor;
import persistence.*;

public interface UserExceptionExceptionVisitor<E extends model.UserException> {
    
    public void handleAlreadyInUseException(model.AlreadyInUseException alreadyInUseException) throws PersistenceException, E;
    public void handleCreditPointInformationIsNotConsistent(model.CreditPointInformationIsNotConsistent creditPointInformationIsNotConsistent) throws PersistenceException, E;
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException, E;
    public void handleMatricalNumberAlreadyUsed(model.MatricalNumberAlreadyUsed matricalNumberAlreadyUsed) throws PersistenceException, E;
    public void handleNameAlreadyExistsException(model.NameAlreadyExistsException nameAlreadyExistsException) throws PersistenceException, E;
    public void handleNotAllowedOperationOnPrototypeException(model.NotAllowedOperationOnPrototypeException notAllowedOperationOnPrototypeException) throws PersistenceException, E;
    public void handleNotInStudyGroupException(model.NotInStudyGroupException notInStudyGroupException) throws PersistenceException, E;
    public void handleOtherTypeThanSettedException(model.OtherTypeThanSettedException otherTypeThanSettedException) throws PersistenceException, E;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException, E;
    public void handleStudyGroupAlreadyInStudyProgramException(model.StudyGroupAlreadyInStudyProgramException studyGroupAlreadyInStudyProgramException) throws PersistenceException, E;
    public void handleThereIsAlreadyAStudyGroupException(model.ThereIsAlreadyAStudyGroupException thereIsAlreadyAStudyGroupException) throws PersistenceException, E;
    public void handleUnitIsAlreadyPartOfAModuleWithUnitsException(model.UnitIsAlreadyPartOfAModuleWithUnitsException unitIsAlreadyPartOfAModuleWithUnitsException) throws PersistenceException, E;
    
}
