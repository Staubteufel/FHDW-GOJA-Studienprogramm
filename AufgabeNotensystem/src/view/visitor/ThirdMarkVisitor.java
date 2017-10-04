
package view.visitor;
import view.*;

public interface ThirdMarkVisitor {
    
    public void handleFiveZero(FiveZeroView fiveZero) throws ModelException;
    public void handleFourZero(FourZeroView fourZero) throws ModelException;
    public void handleOneSeven(OneSevenView oneSeven) throws ModelException;
    public void handleOneThree(OneThreeView oneThree) throws ModelException;
    public void handleOneZero(OneZeroView oneZero) throws ModelException;
    public void handleThreeSeven(ThreeSevenView threeSeven) throws ModelException;
    public void handleThreeThree(ThreeThreeView threeThree) throws ModelException;
    public void handleThreeZero(ThreeZeroView threeZero) throws ModelException;
    public void handleTwoSeven(TwoSevenView twoSeven) throws ModelException;
    public void handleTwoThree(TwoThreeView twoThree) throws ModelException;
    public void handleTwoZero(TwoZeroView twoZero) throws ModelException;
    public void handleThirdMark(ThirdMarkView thirdMark) throws ModelException;
    
}
