
package model.visitor;
import persistence.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleAlreadyInUseException(model.AlreadyInUseException alreadyInUseException) throws PersistenceException;
    public R handleCreditPointInformationIsNotConsistent(model.CreditPointInformationIsNotConsistent creditPointInformationIsNotConsistent) throws PersistenceException;
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public R handleMatricalNumberAlreadyUsed(model.MatricalNumberAlreadyUsed matricalNumberAlreadyUsed) throws PersistenceException;
    public R handleNameAlreadyExistsException(model.NameAlreadyExistsException nameAlreadyExistsException) throws PersistenceException;
    public R handleNotAllowedOperationOnPrototypeException(model.NotAllowedOperationOnPrototypeException notAllowedOperationOnPrototypeException) throws PersistenceException;
    public R handleNotInStudyGroupException(model.NotInStudyGroupException notInStudyGroupException) throws PersistenceException;
    public R handleOtherTypeThanSettedException(model.OtherTypeThanSettedException otherTypeThanSettedException) throws PersistenceException;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    public R handleStudyGroupAlreadyInStudyProgramException(model.StudyGroupAlreadyInStudyProgramException studyGroupAlreadyInStudyProgramException) throws PersistenceException;
    public R handleThereIsAlreadyAStudyGroupException(model.ThereIsAlreadyAStudyGroupException thereIsAlreadyAStudyGroupException) throws PersistenceException;
    public R handleUnitIsAlreadyPartOfAModuleWithUnitsException(model.UnitIsAlreadyPartOfAModuleWithUnitsException unitIsAlreadyPartOfAModuleWithUnitsException) throws PersistenceException;
    
}
