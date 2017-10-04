
package view.visitor;
import view.*;

public interface ThirdMarkExceptionVisitor<E extends view.UserException> {
    
    public void handleFiveZero(FiveZeroView fiveZero) throws ModelException, E;
    public void handleFourZero(FourZeroView fourZero) throws ModelException, E;
    public void handleOneSeven(OneSevenView oneSeven) throws ModelException, E;
    public void handleOneThree(OneThreeView oneThree) throws ModelException, E;
    public void handleOneZero(OneZeroView oneZero) throws ModelException, E;
    public void handleThreeSeven(ThreeSevenView threeSeven) throws ModelException, E;
    public void handleThreeThree(ThreeThreeView threeThree) throws ModelException, E;
    public void handleThreeZero(ThreeZeroView threeZero) throws ModelException, E;
    public void handleTwoSeven(TwoSevenView twoSeven) throws ModelException, E;
    public void handleTwoThree(TwoThreeView twoThree) throws ModelException, E;
    public void handleTwoZero(TwoZeroView twoZero) throws ModelException, E;
    public void handleThirdMark(ThirdMarkView thirdMark) throws ModelException, E;
    
}
