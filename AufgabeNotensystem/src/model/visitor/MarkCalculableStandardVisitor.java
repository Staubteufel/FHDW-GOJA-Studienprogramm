
package model.visitor;

import persistence.*;

public abstract class MarkCalculableStandardVisitor implements MarkCalculableVisitor {
    
    public void handleOneSeven(OneSeven4Public oneSeven) throws PersistenceException{
        this.standardHandling(oneSeven);
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
    public void handleThirdMark(ThirdMark4Public thirdMark) throws PersistenceException{
        this.standardHandling(thirdMark);
    }
    protected abstract void standardHandling(MarkCalculable4Public markCalculable) throws PersistenceException;
}
