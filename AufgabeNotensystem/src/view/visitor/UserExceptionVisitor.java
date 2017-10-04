
package view.visitor;
import view.*;

public interface UserExceptionVisitor {
    
    public void handleAlreadyInUseException(AlreadyInUseException alreadyInUseException) throws ModelException;
    public void handleCreditPointInformationIsNotConsistent(CreditPointInformationIsNotConsistent creditPointInformationIsNotConsistent) throws ModelException;
    public void handleCycleException(CycleException cycleException) throws ModelException;
    public void handleMatricalNumberAlreadyUsed(MatricalNumberAlreadyUsed matricalNumberAlreadyUsed) throws ModelException;
    public void handleNameAlreadyExistsException(NameAlreadyExistsException nameAlreadyExistsException) throws ModelException;
    public void handleNotAllowedOperationOnPrototypeException(NotAllowedOperationOnPrototypeException notAllowedOperationOnPrototypeException) throws ModelException;
    public void handleNotInStudyGroupException(NotInStudyGroupException notInStudyGroupException) throws ModelException;
    public void handleOtherTypeThanSettedException(OtherTypeThanSettedException otherTypeThanSettedException) throws ModelException;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    public void handleStudyGroupAlreadyInStudyProgramException(StudyGroupAlreadyInStudyProgramException studyGroupAlreadyInStudyProgramException) throws ModelException;
    public void handleThereIsAlreadyAStudyGroupException(ThereIsAlreadyAStudyGroupException thereIsAlreadyAStudyGroupException) throws ModelException;
    public void handleUnitIsAlreadyPartOfAModuleWithUnitsException(UnitIsAlreadyPartOfAModuleWithUnitsException unitIsAlreadyPartOfAModuleWithUnitsException) throws ModelException;
    
}
