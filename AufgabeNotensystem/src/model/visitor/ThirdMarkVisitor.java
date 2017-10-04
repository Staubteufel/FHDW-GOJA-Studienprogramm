
package model.visitor;
import persistence.*;

public interface ThirdMarkVisitor {
    
    public void handleFiveZero(FiveZero4Public fiveZero) throws PersistenceException;
    public void handleFourZero(FourZero4Public fourZero) throws PersistenceException;
    public void handleOneSeven(OneSeven4Public oneSeven) throws PersistenceException;
    public void handleOneThree(OneThree4Public oneThree) throws PersistenceException;
    public void handleOneZero(OneZero4Public oneZero) throws PersistenceException;
    public void handleThreeSeven(ThreeSeven4Public threeSeven) throws PersistenceException;
    public void handleThreeThree(ThreeThree4Public threeThree) throws PersistenceException;
    public void handleThreeZero(ThreeZero4Public threeZero) throws PersistenceException;
    public void handleTwoSeven(TwoSeven4Public twoSeven) throws PersistenceException;
    public void handleTwoThree(TwoThree4Public twoThree) throws PersistenceException;
    public void handleTwoZero(TwoZero4Public twoZero) throws PersistenceException;
    public void handleThirdMark(ThirdMark4Public thirdMark) throws PersistenceException;
    
}
