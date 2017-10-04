
package view.visitor;

import view.*;

public abstract class MarkCalculableDirectVisitor implements MarkCalculableVisitor {
    
    public abstract void handleTenthMark(TenthMarkView tenthMark) throws ModelException;
    
    public abstract void handleThirdMark(ThirdMarkView thirdMark) throws ModelException;
    
    public void handleTwoThree(TwoThreeView twoThree) throws ModelException{
        this.handleThirdMark(twoThree);
    }
    public void handleTwoSeven(TwoSevenView twoSeven) throws ModelException{
        this.handleThirdMark(twoSeven);
    }
    public void handleOneSeven(OneSevenView oneSeven) throws ModelException{
        this.handleThirdMark(oneSeven);
    }
    public void handleFourZero(FourZeroView fourZero) throws ModelException{
        this.handleThirdMark(fourZero);
    }
    public void handleThreeSeven(ThreeSevenView threeSeven) throws ModelException{
        this.handleThirdMark(threeSeven);
    }
    public void handleOneZero(OneZeroView oneZero) throws ModelException{
        this.handleThirdMark(oneZero);
    }
    public void handleTwoZero(TwoZeroView twoZero) throws ModelException{
        this.handleThirdMark(twoZero);
    }
    public void handleThreeThree(ThreeThreeView threeThree) throws ModelException{
        this.handleThirdMark(threeThree);
    }
    public void handleFiveZero(FiveZeroView fiveZero) throws ModelException{
        this.handleThirdMark(fiveZero);
    }
    public void handleOneThree(OneThreeView oneThree) throws ModelException{
        this.handleThirdMark(oneThree);
    }
    public void handleThreeZero(ThreeZeroView threeZero) throws ModelException{
        this.handleThirdMark(threeZero);
    }
    
}
