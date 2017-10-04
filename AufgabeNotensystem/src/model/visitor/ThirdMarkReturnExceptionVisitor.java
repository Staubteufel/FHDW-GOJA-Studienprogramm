
package model.visitor;
import persistence.*;

public interface ThirdMarkReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleFiveZero(FiveZero4Public fiveZero) throws PersistenceException, E;
    public R handleFourZero(FourZero4Public fourZero) throws PersistenceException, E;
    public R handleOneSeven(OneSeven4Public oneSeven) throws PersistenceException, E;
    public R handleOneThree(OneThree4Public oneThree) throws PersistenceException, E;
    public R handleOneZero(OneZero4Public oneZero) throws PersistenceException, E;
    public R handleThreeSeven(ThreeSeven4Public threeSeven) throws PersistenceException, E;
    public R handleThreeThree(ThreeThree4Public threeThree) throws PersistenceException, E;
    public R handleThreeZero(ThreeZero4Public threeZero) throws PersistenceException, E;
    public R handleTwoSeven(TwoSeven4Public twoSeven) throws PersistenceException, E;
    public R handleTwoThree(TwoThree4Public twoThree) throws PersistenceException, E;
    public R handleTwoZero(TwoZero4Public twoZero) throws PersistenceException, E;
    public R handleThirdMark(ThirdMark4Public thirdMark) throws PersistenceException, E;
    
}
