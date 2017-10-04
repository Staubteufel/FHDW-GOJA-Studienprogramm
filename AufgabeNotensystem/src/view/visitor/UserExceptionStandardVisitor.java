
package view.visitor;

import view.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleNotInStudyGroupException(NotInStudyGroupException notInStudyGroupException) throws ModelException{
        this.standardHandling(notInStudyGroupException);
    }
    public void handleStudyGroupAlreadyInStudyProgramException(StudyGroupAlreadyInStudyProgramException studyGroupAlreadyInStudyProgramException) throws ModelException{
        this.standardHandling(studyGroupAlreadyInStudyProgramException);
    }
    public void handleAlreadyInUseException(AlreadyInUseException alreadyInUseException) throws ModelException{
        this.standardHandling(alreadyInUseException);
    }
    public void handleThereIsAlreadyAStudyGroupException(ThereIsAlreadyAStudyGroupException thereIsAlreadyAStudyGroupException) throws ModelException{
        this.standardHandling(thereIsAlreadyAStudyGroupException);
    }
    public void handleCreditPointInformationIsNotConsistent(CreditPointInformationIsNotConsistent creditPointInformationIsNotConsistent) throws ModelException{
        this.standardHandling(creditPointInformationIsNotConsistent);
    }
    public void handleUnitIsAlreadyPartOfAModuleWithUnitsException(UnitIsAlreadyPartOfAModuleWithUnitsException unitIsAlreadyPartOfAModuleWithUnitsException) throws ModelException{
        this.standardHandling(unitIsAlreadyPartOfAModuleWithUnitsException);
    }
    public void handleNameAlreadyExistsException(NameAlreadyExistsException nameAlreadyExistsException) throws ModelException{
        this.standardHandling(nameAlreadyExistsException);
    }
    public void handleCycleException(CycleException cycleException) throws ModelException{
        this.standardHandling(cycleException);
    }
    public void handleNotAllowedOperationOnPrototypeException(NotAllowedOperationOnPrototypeException notAllowedOperationOnPrototypeException) throws ModelException{
        this.standardHandling(notAllowedOperationOnPrototypeException);
    }
    public void handleMatricalNumberAlreadyUsed(MatricalNumberAlreadyUsed matricalNumberAlreadyUsed) throws ModelException{
        this.standardHandling(matricalNumberAlreadyUsed);
    }
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException{
        this.standardHandling(restrictionException);
    }
    public void handleOtherTypeThanSettedException(OtherTypeThanSettedException otherTypeThanSettedException) throws ModelException{
        this.standardHandling(otherTypeThanSettedException);
    }
    protected abstract void standardHandling(UserException userException) throws ModelException;
}
