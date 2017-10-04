
package model.visitor;

import persistence.*;

public abstract class MarkStandardVisitor implements MarkVisitor {
    
    public void handlePassed(Passed4Public passed) throws PersistenceException{
        this.standardHandling(passed);
    }
    public void handleOneSeven(OneSeven4Public oneSeven) throws PersistenceException{
        this.standardHandling(oneSeven);
    }
    public void handleFailed(Failed4Public failed) throws PersistenceException{
        this.standardHandling(failed);
    }
    public void handleThreeThree(ThreeThree4Public threeThree) throws PersistenceException{
        this.standardHandling(threeThree);
    }
    public void handleFiveZero(FiveZero4Public fiveZero) throws PersistenceException{
        this.standardHandling(fiveZero);
    }
    public void handleOneThree(OneThree4Public oneThree) throws PersistenceException{
        this.standardHandling(oneThree);
    }
    public void handleThreeZero(ThreeZero4Public threeZero) throws PersistenceException{
        this.standardHandling(threeZero);
    }
    public void handleTwoThree(TwoThree4Public twoThree) throws PersistenceException{
        this.standardHandling(twoThree);
    }
    public void handleBooleanMark(BooleanMark4Public booleanMark) throws PersistenceException{
        this.standardHandling(booleanMark);
    }
    public void handleTwoSeven(TwoSeven4Public twoSeven) throws PersistenceException{
        this.standardHandling(twoSeven);
    }
    public void handleFourZero(FourZero4Public fourZero) throws PersistenceException{
        this.standardHandling(fourZero);
    }
    public void handleThreeSeven(ThreeSeven4Public threeSeven) throws PersistenceException{
        this.standardHandling(threeSeven);
    }
    public void handleOneZero(OneZero4Public oneZero) throws PersistenceException{
        this.standardHandling(oneZero);
    }
    public void handleTenthMark(TenthMark4Public tenthMark) throws PersistenceException{
        this.standardHandling(tenthMark);
    }
    public void handleTwoZero(TwoZero4Public twoZero) throws PersistenceException{
        this.standardHandling(twoZero);
    }
    public void handleNoneMark(NoneMark4Public noneMark) throws PersistenceException{
        this.standardHandling(noneMark);
    }
    public void handleThirdMark(ThirdMark4Public thirdMark) throws PersistenceException{
        this.standardHandling(thirdMark);
    }
    protected abstract void standardHandling(Mark mark) throws PersistenceException;
}
