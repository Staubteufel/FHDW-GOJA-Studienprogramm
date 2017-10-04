
package view.visitor;
import view.*;

public interface UserExceptionReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleAlreadyInUseException(AlreadyInUseException alreadyInUseException) throws ModelException, E;
    public R handleCreditPointInformationIsNotConsistent(CreditPointInformationIsNotConsistent creditPointInformationIsNotConsistent) throws ModelException, E;
    public R handleCycleException(CycleException cycleException) throws ModelException, E;
    public R handleMatricalNumberAlreadyUsed(MatricalNumberAlreadyUsed matricalNumberAlreadyUsed) throws ModelException, E;
    public R handleNameAlreadyExistsException(NameAlreadyExistsException nameAlreadyExistsException) throws ModelException, E;
    public R handleNotAllowedOperationOnPrototypeException(NotAllowedOperationOnPrototypeException notAllowedOperationOnPrototypeException) throws ModelException, E;
    public R handleNotInStudyGroupException(NotInStudyGroupException notInStudyGroupException) throws ModelException, E;
    public R handleOtherTypeThanSettedException(OtherTypeThanSettedException otherTypeThanSettedException) throws ModelException, E;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException, E;
    public R handleStudyGroupAlreadyInStudyProgramException(StudyGroupAlreadyInStudyProgramException studyGroupAlreadyInStudyProgramException) throws ModelException, E;
    public R handleThereIsAlreadyAStudyGroupException(ThereIsAlreadyAStudyGroupException thereIsAlreadyAStudyGroupException) throws ModelException, E;
    public R handleUnitIsAlreadyPartOfAModuleWithUnitsException(UnitIsAlreadyPartOfAModuleWithUnitsException unitIsAlreadyPartOfAModuleWithUnitsException) throws ModelException, E;
    
}
