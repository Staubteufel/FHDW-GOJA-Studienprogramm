
package view.visitor;

import view.*;

public abstract class MarkCalculableStandardVisitor implements MarkCalculableVisitor {
    
    public void handleOneSeven(OneSevenView oneSeven) throws ModelException{
        this.standardHandling(oneSeven);
    }
    public void handleThreeThree(ThreeThreeView threeThree) throws ModelException{
        this.standardHandling(threeThree);
    }
    public void handleFiveZero(FiveZeroView fiveZero) throws ModelException{
        this.standardHandling(fiveZero);
    }
    public void handleOneThree(OneThreeView oneThree) throws ModelException{
        this.standardHandling(oneThree);
    }
    public void handleThreeZero(ThreeZeroView threeZero) throws ModelException{
        this.standardHandling(threeZero);
    }
    public void handleTwoThree(TwoThreeView twoThree) throws ModelException{
        this.standardHandling(twoThree);
    }
    public void handleTwoSeven(TwoSevenView twoSeven) throws ModelException{
        this.standardHandling(twoSeven);
    }
    public void handleFourZero(FourZeroView fourZero) throws ModelException{
        this.standardHandling(fourZero);
    }
    public void handleThreeSeven(ThreeSevenView threeSeven) throws ModelException{
        this.standardHandling(threeSeven);
    }
    public void handleOneZero(OneZeroView oneZero) throws ModelException{
        this.standardHandling(oneZero);
    }
    public void handleTenthMark(TenthMarkView tenthMark) throws ModelException{
        this.standardHandling(tenthMark);
    }
    public void handleTwoZero(TwoZeroView twoZero) throws ModelException{
        this.standardHandling(twoZero);
    }
    public void handleThirdMark(ThirdMarkView thirdMark) throws ModelException{
        this.standardHandling(thirdMark);
    }
    protected abstract void standardHandling(MarkCalculableView markCalculable) throws ModelException;
}
