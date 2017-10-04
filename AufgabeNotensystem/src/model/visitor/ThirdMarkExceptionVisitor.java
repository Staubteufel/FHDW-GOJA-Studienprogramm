
package model.visitor;
import persistence.*;

public interface ThirdMarkExceptionVisitor<E extends model.UserException> {
    
    public void handleFiveZero(FiveZero4Public fiveZero) throws PersistenceException, E;
    public void handleFourZero(FourZero4Public fourZero) throws PersistenceException, E;
    public void handleOneSeven(OneSeven4Public oneSeven) throws PersistenceException, E;
    public void handleOneThree(OneThree4Public oneThree) throws PersistenceException, E;
    public void handleOneZero(OneZero4Public oneZero) throws PersistenceException, E;
    public void handleThreeSeven(ThreeSeven4Public threeSeven) throws PersistenceException, E;
    public void handleThreeThree(ThreeThree4Public threeThree) throws PersistenceException, E;
    public void handleThreeZero(ThreeZero4Public threeZero) throws PersistenceException, E;
    public void handleTwoSeven(TwoSeven4Public twoSeven) throws PersistenceException, E;
    public void handleTwoThree(TwoThree4Public twoThree) throws PersistenceException, E;
    public void handleTwoZero(TwoZero4Public twoZero) throws PersistenceException, E;
    public void handleThirdMark(ThirdMark4Public thirdMark) throws PersistenceException, E;
    
}
