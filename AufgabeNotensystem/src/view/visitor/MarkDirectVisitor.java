
package view.visitor;

import view.*;

public abstract class MarkDirectVisitor implements MarkVisitor {
    
    public abstract void handleMarkCalculable(MarkCalculableView markCalculable) throws ModelException;
    
    public void handleOneSeven(OneSevenView oneSeven) throws ModelException{
        this.handleMarkCalculable(oneSeven);
    }
    public void handleThreeThree(ThreeThreeView threeThree) throws ModelException{
        this.handleMarkCalculable(threeThree);
    }
    public void handleFiveZero(FiveZeroView fiveZero) throws ModelException{
        this.handleMarkCalculable(fiveZero);
    }
    public void handleOneThree(OneThreeView oneThree) throws ModelException{
        this.handleMarkCalculable(oneThree);
    }
    public void handleThreeZero(ThreeZeroView threeZero) throws ModelException{
        this.handleMarkCalculable(threeZero);
    }
    public void handleTwoThree(TwoThreeView twoThree) throws ModelException{
        this.handleMarkCalculable(twoThree);
    }
    public void handleTwoSeven(TwoSevenView twoSeven) throws ModelException{
        this.handleMarkCalculable(twoSeven);
    }
    public void handleFourZero(FourZeroView fourZero) throws ModelException{
        this.handleMarkCalculable(fourZero);
    }
    public void handleThreeSeven(ThreeSevenView threeSeven) throws ModelException{
        this.handleMarkCalculable(threeSeven);
    }
    public void handleOneZero(OneZeroView oneZero) throws ModelException{
        this.handleMarkCalculable(oneZero);
    }
    public void handleTenthMark(TenthMarkView tenthMark) throws ModelException{
        this.handleMarkCalculable(tenthMark);
    }
    public void handleTwoZero(TwoZeroView twoZero) throws ModelException{
        this.handleMarkCalculable(twoZero);
    }
    public void handleThirdMark(ThirdMarkView thirdMark) throws ModelException{
        this.handleMarkCalculable(thirdMark);
    }
    public abstract void handleMarkNotCalculable(MarkNotCalculableView markNotCalculable) throws ModelException;
    
    public void handlePassed(PassedView passed) throws ModelException{
        this.handleMarkNotCalculable(passed);
    }
    public void handleBooleanMark(BooleanMarkView booleanMark) throws ModelException{
        this.handleMarkNotCalculable(booleanMark);
    }
    public void handleFailed(FailedView failed) throws ModelException{
        this.handleMarkNotCalculable(failed);
    }
    public void handleNoneMark(NoneMarkView noneMark) throws ModelException{
        this.handleMarkNotCalculable(noneMark);
    }
    
}
