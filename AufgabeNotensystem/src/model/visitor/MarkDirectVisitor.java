
package model.visitor;

import persistence.*;

public abstract class MarkDirectVisitor implements MarkVisitor {
    
    public abstract void handleMarkCalculable(MarkCalculable4Public markCalculable) throws PersistenceException;
    
    public void handleOneSeven(OneSeven4Public oneSeven) throws PersistenceException{
        this.handleMarkCalculable(oneSeven);
    }
    public void handleThreeThree(ThreeThree4Public threeThree) throws PersistenceException{
        this.handleMarkCalculable(threeThree);
    }
    public void handleFiveZero(FiveZero4Public fiveZero) throws PersistenceException{
        this.handleMarkCalculable(fiveZero);
    }
    public void handleOneThree(OneThree4Public oneThree) throws PersistenceException{
        this.handleMarkCalculable(oneThree);
    }
    public void handleThreeZero(ThreeZero4Public threeZero) throws PersistenceException{
        this.handleMarkCalculable(threeZero);
    }
    public void handleTwoThree(TwoThree4Public twoThree) throws PersistenceException{
        this.handleMarkCalculable(twoThree);
    }
    public void handleTwoSeven(TwoSeven4Public twoSeven) throws PersistenceException{
        this.handleMarkCalculable(twoSeven);
    }
    public void handleFourZero(FourZero4Public fourZero) throws PersistenceException{
        this.handleMarkCalculable(fourZero);
    }
    public void handleThreeSeven(ThreeSeven4Public threeSeven) throws PersistenceException{
        this.handleMarkCalculable(threeSeven);
    }
    public void handleOneZero(OneZero4Public oneZero) throws PersistenceException{
        this.handleMarkCalculable(oneZero);
    }
    public void handleTenthMark(TenthMark4Public tenthMark) throws PersistenceException{
        this.handleMarkCalculable(tenthMark);
    }
    public void handleTwoZero(TwoZero4Public twoZero) throws PersistenceException{
        this.handleMarkCalculable(twoZero);
    }
    public void handleThirdMark(ThirdMark4Public thirdMark) throws PersistenceException{
        this.handleMarkCalculable(thirdMark);
    }
    public abstract void handleMarkNotCalculable(MarkNotCalculable4Public markNotCalculable) throws PersistenceException;
    
    public void handlePassed(Passed4Public passed) throws PersistenceException{
        this.handleMarkNotCalculable(passed);
    }
    public void handleBooleanMark(BooleanMark4Public booleanMark) throws PersistenceException{
        this.handleMarkNotCalculable(booleanMark);
    }
    public void handleFailed(Failed4Public failed) throws PersistenceException{
        this.handleMarkNotCalculable(failed);
    }
    public void handleNoneMark(NoneMark4Public noneMark) throws PersistenceException{
        this.handleMarkNotCalculable(noneMark);
    }
    
}
