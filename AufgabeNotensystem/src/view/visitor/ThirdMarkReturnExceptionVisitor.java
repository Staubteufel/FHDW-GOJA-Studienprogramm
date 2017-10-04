
package view.visitor;
import view.*;

public interface ThirdMarkReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleFiveZero(FiveZeroView fiveZero) throws ModelException, E;
    public R handleFourZero(FourZeroView fourZero) throws ModelException, E;
    public R handleOneSeven(OneSevenView oneSeven) throws ModelException, E;
    public R handleOneThree(OneThreeView oneThree) throws ModelException, E;
    public R handleOneZero(OneZeroView oneZero) throws ModelException, E;
    public R handleThreeSeven(ThreeSevenView threeSeven) throws ModelException, E;
    public R handleThreeThree(ThreeThreeView threeThree) throws ModelException, E;
    public R handleThreeZero(ThreeZeroView threeZero) throws ModelException, E;
    public R handleTwoSeven(TwoSevenView twoSeven) throws ModelException, E;
    public R handleTwoThree(TwoThreeView twoThree) throws ModelException, E;
    public R handleTwoZero(TwoZeroView twoZero) throws ModelException, E;
    public R handleThirdMark(ThirdMarkView thirdMark) throws ModelException, E;
    
}
