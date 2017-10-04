
package model.visitor;

import persistence.*;

public abstract class MarkCalculableDirectVisitor implements MarkCalculableVisitor {
    
    public abstract void handleTenthMark(TenthMark4Public tenthMark) throws PersistenceException;
    
    public abstract void handleThirdMark(ThirdMark4Public thirdMark) throws PersistenceException;
    
    public void handleTwoThree(TwoThree4Public twoThree) throws PersistenceException{
        this.handleThirdMark(twoThree);
    }
    public void handleTwoSeven(TwoSeven4Public twoSeven) throws PersistenceException{
        this.handleThirdMark(twoSeven);
    }
    public void handleOneSeven(OneSeven4Public oneSeven) throws PersistenceException{
        this.handleThirdMark(oneSeven);
    }
    public void handleFourZero(FourZero4Public fourZero) throws PersistenceException{
        this.handleThirdMark(fourZero);
    }
    public void handleThreeSeven(ThreeSeven4Public threeSeven) throws PersistenceException{
        this.handleThirdMark(threeSeven);
    }
    public void handleOneZero(OneZero4Public oneZero) throws PersistenceException{
        this.handleThirdMark(oneZero);
    }
    public void handleTwoZero(TwoZero4Public twoZero) throws PersistenceException{
        this.handleThirdMark(twoZero);
    }
    public void handleThreeThree(ThreeThree4Public threeThree) throws PersistenceException{
        this.handleThirdMark(threeThree);
    }
    public void handleFiveZero(FiveZero4Public fiveZero) throws PersistenceException{
        this.handleThirdMark(fiveZero);
    }
    public void handleOneThree(OneThree4Public oneThree) throws PersistenceException{
        this.handleThirdMark(oneThree);
    }
    public void handleThreeZero(ThreeZero4Public threeZero) throws PersistenceException{
        this.handleThirdMark(threeZero);
    }
    
}
