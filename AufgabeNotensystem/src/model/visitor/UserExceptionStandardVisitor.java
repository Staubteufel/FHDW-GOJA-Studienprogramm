
package model.visitor;

import persistence.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleNotInStudyGroupException(model.NotInStudyGroupException notInStudyGroupException) throws PersistenceException{
        this.standardHandling(notInStudyGroupException);
    }
    public void handleStudyGroupAlreadyInStudyProgramException(model.StudyGroupAlreadyInStudyProgramException studyGroupAlreadyInStudyProgramException) throws PersistenceException{
        this.standardHandling(studyGroupAlreadyInStudyProgramException);
    }
    public void handleAlreadyInUseException(model.AlreadyInUseException alreadyInUseException) throws PersistenceException{
        this.standardHandling(alreadyInUseException);
    }
    public void handleThereIsAlreadyAStudyGroupException(model.ThereIsAlreadyAStudyGroupException thereIsAlreadyAStudyGroupException) throws PersistenceException{
        this.standardHandling(thereIsAlreadyAStudyGroupException);
    }
    public void handleCreditPointInformationIsNotConsistent(model.CreditPointInformationIsNotConsistent creditPointInformationIsNotConsistent) throws PersistenceException{
        this.standardHandling(creditPointInformationIsNotConsistent);
    }
    public void handleUnitIsAlreadyPartOfAModuleWithUnitsException(model.UnitIsAlreadyPartOfAModuleWithUnitsException unitIsAlreadyPartOfAModuleWithUnitsException) throws PersistenceException{
        this.standardHandling(unitIsAlreadyPartOfAModuleWithUnitsException);
    }
    public void handleNameAlreadyExistsException(model.NameAlreadyExistsException nameAlreadyExistsException) throws PersistenceException{
        this.standardHandling(nameAlreadyExistsException);
    }
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException{
        this.standardHandling(cycleException);
    }
    public void handleNotAllowedOperationOnPrototypeException(model.NotAllowedOperationOnPrototypeException notAllowedOperationOnPrototypeException) throws PersistenceException{
        this.standardHandling(notAllowedOperationOnPrototypeException);
    }
    public void handleMatricalNumberAlreadyUsed(model.MatricalNumberAlreadyUsed matricalNumberAlreadyUsed) throws PersistenceException{
        this.standardHandling(matricalNumberAlreadyUsed);
    }
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException{
        this.standardHandling(restrictionException);
    }
    public void handleOtherTypeThanSettedException(model.OtherTypeThanSettedException otherTypeThanSettedException) throws PersistenceException{
        this.standardHandling(otherTypeThanSettedException);
    }
    protected abstract void standardHandling(model.UserException userException) throws PersistenceException;
}
