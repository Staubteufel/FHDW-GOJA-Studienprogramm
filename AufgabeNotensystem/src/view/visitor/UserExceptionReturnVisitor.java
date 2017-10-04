
package view.visitor;
import view.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleAlreadyInUseException(AlreadyInUseException alreadyInUseException) throws ModelException;
    public R handleCreditPointInformationIsNotConsistent(CreditPointInformationIsNotConsistent creditPointInformationIsNotConsistent) throws ModelException;
    public R handleCycleException(CycleException cycleException) throws ModelException;
    public R handleMatricalNumberAlreadyUsed(MatricalNumberAlreadyUsed matricalNumberAlreadyUsed) throws ModelException;
    public R handleNameAlreadyExistsException(NameAlreadyExistsException nameAlreadyExistsException) throws ModelException;
    public R handleNotAllowedOperationOnPrototypeException(NotAllowedOperationOnPrototypeException notAllowedOperationOnPrototypeException) throws ModelException;
    public R handleNotInStudyGroupException(NotInStudyGroupException notInStudyGroupException) throws ModelException;
    public R handleOtherTypeThanSettedException(OtherTypeThanSettedException otherTypeThanSettedException) throws ModelException;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    public R handleStudyGroupAlreadyInStudyProgramException(StudyGroupAlreadyInStudyProgramException studyGroupAlreadyInStudyProgramException) throws ModelException;
    public R handleThereIsAlreadyAStudyGroupException(ThereIsAlreadyAStudyGroupException thereIsAlreadyAStudyGroupException) throws ModelException;
    public R handleUnitIsAlreadyPartOfAModuleWithUnitsException(UnitIsAlreadyPartOfAModuleWithUnitsException unitIsAlreadyPartOfAModuleWithUnitsException) throws ModelException;
    
}
