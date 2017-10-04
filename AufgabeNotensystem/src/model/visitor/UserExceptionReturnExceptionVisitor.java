
package model.visitor;
import persistence.*;

public interface UserExceptionReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAlreadyInUseException(model.AlreadyInUseException alreadyInUseException) throws PersistenceException, E;
    public R handleCreditPointInformationIsNotConsistent(model.CreditPointInformationIsNotConsistent creditPointInformationIsNotConsistent) throws PersistenceException, E;
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException, E;
    public R handleMatricalNumberAlreadyUsed(model.MatricalNumberAlreadyUsed matricalNumberAlreadyUsed) throws PersistenceException, E;
    public R handleNameAlreadyExistsException(model.NameAlreadyExistsException nameAlreadyExistsException) throws PersistenceException, E;
    public R handleNotAllowedOperationOnPrototypeException(model.NotAllowedOperationOnPrototypeException notAllowedOperationOnPrototypeException) throws PersistenceException, E;
    public R handleNotInStudyGroupException(model.NotInStudyGroupException notInStudyGroupException) throws PersistenceException, E;
    public R handleOtherTypeThanSettedException(model.OtherTypeThanSettedException otherTypeThanSettedException) throws PersistenceException, E;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException, E;
    public R handleStudyGroupAlreadyInStudyProgramException(model.StudyGroupAlreadyInStudyProgramException studyGroupAlreadyInStudyProgramException) throws PersistenceException, E;
    public R handleThereIsAlreadyAStudyGroupException(model.ThereIsAlreadyAStudyGroupException thereIsAlreadyAStudyGroupException) throws PersistenceException, E;
    public R handleUnitIsAlreadyPartOfAModuleWithUnitsException(model.UnitIsAlreadyPartOfAModuleWithUnitsException unitIsAlreadyPartOfAModuleWithUnitsException) throws PersistenceException, E;
    
}
