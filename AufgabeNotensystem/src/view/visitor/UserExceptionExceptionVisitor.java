
package view.visitor;
import view.*;

public interface UserExceptionExceptionVisitor<E extends view.UserException> {
    
    public void handleAlreadyInUseException(AlreadyInUseException alreadyInUseException) throws ModelException, E;
    public void handleCreditPointInformationIsNotConsistent(CreditPointInformationIsNotConsistent creditPointInformationIsNotConsistent) throws ModelException, E;
    public void handleCycleException(CycleException cycleException) throws ModelException, E;
    public void handleMatricalNumberAlreadyUsed(MatricalNumberAlreadyUsed matricalNumberAlreadyUsed) throws ModelException, E;
    public void handleNameAlreadyExistsException(NameAlreadyExistsException nameAlreadyExistsException) throws ModelException, E;
    public void handleNotAllowedOperationOnPrototypeException(NotAllowedOperationOnPrototypeException notAllowedOperationOnPrototypeException) throws ModelException, E;
    public void handleNotInStudyGroupException(NotInStudyGroupException notInStudyGroupException) throws ModelException, E;
    public void handleOtherTypeThanSettedException(OtherTypeThanSettedException otherTypeThanSettedException) throws ModelException, E;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException, E;
    public void handleStudyGroupAlreadyInStudyProgramException(StudyGroupAlreadyInStudyProgramException studyGroupAlreadyInStudyProgramException) throws ModelException, E;
    public void handleThereIsAlreadyAStudyGroupException(ThereIsAlreadyAStudyGroupException thereIsAlreadyAStudyGroupException) throws ModelException, E;
    public void handleUnitIsAlreadyPartOfAModuleWithUnitsException(UnitIsAlreadyPartOfAModuleWithUnitsException unitIsAlreadyPartOfAModuleWithUnitsException) throws ModelException, E;
    
}
