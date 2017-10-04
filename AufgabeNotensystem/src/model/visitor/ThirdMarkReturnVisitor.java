
package model.visitor;
import persistence.*;

public interface ThirdMarkReturnVisitor<R> {
    
    public R handleFiveZero(FiveZero4Public fiveZero) throws PersistenceException;
    public R handleFourZero(FourZero4Public fourZero) throws PersistenceException;
    public R handleOneSeven(OneSeven4Public oneSeven) throws PersistenceException;
    public R handleOneThree(OneThree4Public oneThree) throws PersistenceException;
    public R handleOneZero(OneZero4Public oneZero) throws PersistenceException;
    public R handleThreeSeven(ThreeSeven4Public threeSeven) throws PersistenceException;
    public R handleThreeThree(ThreeThree4Public threeThree) throws PersistenceException;
    public R handleThreeZero(ThreeZero4Public threeZero) throws PersistenceException;
    public R handleTwoSeven(TwoSeven4Public twoSeven) throws PersistenceException;
    public R handleTwoThree(TwoThree4Public twoThree) throws PersistenceException;
    public R handleTwoZero(TwoZero4Public twoZero) throws PersistenceException;
    public R handleThirdMark(ThirdMark4Public thirdMark) throws PersistenceException;
    
}
