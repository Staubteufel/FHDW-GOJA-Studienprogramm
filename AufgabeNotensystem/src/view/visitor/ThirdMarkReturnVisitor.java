
package view.visitor;
import view.*;

public interface ThirdMarkReturnVisitor<R> {
    
    public R handleFiveZero(FiveZeroView fiveZero) throws ModelException;
    public R handleFourZero(FourZeroView fourZero) throws ModelException;
    public R handleOneSeven(OneSevenView oneSeven) throws ModelException;
    public R handleOneThree(OneThreeView oneThree) throws ModelException;
    public R handleOneZero(OneZeroView oneZero) throws ModelException;
    public R handleThreeSeven(ThreeSevenView threeSeven) throws ModelException;
    public R handleThreeThree(ThreeThreeView threeThree) throws ModelException;
    public R handleThreeZero(ThreeZeroView threeZero) throws ModelException;
    public R handleTwoSeven(TwoSevenView twoSeven) throws ModelException;
    public R handleTwoThree(TwoThreeView twoThree) throws ModelException;
    public R handleTwoZero(TwoZeroView twoZero) throws ModelException;
    public R handleThirdMark(ThirdMarkView thirdMark) throws ModelException;
    
}
