package model.meta;

public class StringFACTORY{

    public static final String BooleanMark$FACTORY$Passed = "Passed";
    public static final String BooleanMark$FACTORY$BooleanMark = "BooleanMark";
    public static final String BooleanMark$FACTORY$Failed = "Failed";
    
    public static persistence.BooleanMark4Public createObjectBySubTypeNameForBooleanMark(String name, BooleanMarkSwitchPARAMETER switchAssistant) throws persistence.PersistenceException {
        if(name.equals(BooleanMark$FACTORY$Passed)) return model.Passed.getThePassed();
        if(name.equals(BooleanMark$FACTORY$BooleanMark)) return switchAssistant.handleBooleanMark();
        if(name.equals(BooleanMark$FACTORY$Failed)) return model.Failed.getTheFailed();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    
    public static final String ThirdMark$FACTORY$TwoThree = "TwoThree";
    public static final String ThirdMark$FACTORY$TwoSeven = "TwoSeven";
    public static final String ThirdMark$FACTORY$OneSeven = "OneSeven";
    public static final String ThirdMark$FACTORY$FourZero = "FourZero";
    public static final String ThirdMark$FACTORY$ThreeSeven = "ThreeSeven";
    public static final String ThirdMark$FACTORY$OneZero = "OneZero";
    public static final String ThirdMark$FACTORY$TwoZero = "TwoZero";
    public static final String ThirdMark$FACTORY$ThreeThree = "ThreeThree";
    public static final String ThirdMark$FACTORY$FiveZero = "FiveZero";
    public static final String ThirdMark$FACTORY$OneThree = "OneThree";
    public static final String ThirdMark$FACTORY$ThreeZero = "ThreeZero";
    public static final String ThirdMark$FACTORY$ThirdMark = "ThirdMark";
    
    public static persistence.ThirdMark4Public createObjectBySubTypeNameForThirdMark(String name, ThirdMarkSwitchPARAMETER switchAssistant) throws persistence.PersistenceException {
        if(name.equals(ThirdMark$FACTORY$TwoThree)) return model.TwoThree.getTheTwoThree();
        if(name.equals(ThirdMark$FACTORY$TwoSeven)) return model.TwoSeven.getTheTwoSeven();
        if(name.equals(ThirdMark$FACTORY$OneSeven)) return model.OneSeven.getTheOneSeven();
        if(name.equals(ThirdMark$FACTORY$FourZero)) return model.FourZero.getTheFourZero();
        if(name.equals(ThirdMark$FACTORY$ThreeSeven)) return model.ThreeSeven.getTheThreeSeven();
        if(name.equals(ThirdMark$FACTORY$OneZero)) return model.OneZero.getTheOneZero();
        if(name.equals(ThirdMark$FACTORY$TwoZero)) return model.TwoZero.getTheTwoZero();
        if(name.equals(ThirdMark$FACTORY$ThreeThree)) return model.ThreeThree.getTheThreeThree();
        if(name.equals(ThirdMark$FACTORY$FiveZero)) return model.FiveZero.getTheFiveZero();
        if(name.equals(ThirdMark$FACTORY$OneThree)) return model.OneThree.getTheOneThree();
        if(name.equals(ThirdMark$FACTORY$ThreeZero)) return model.ThreeZero.getTheThreeZero();
        if(name.equals(ThirdMark$FACTORY$ThirdMark)) return switchAssistant.handleThirdMark();
        throw new persistence.PersistenceException("No such type name!",0);
    }
    
    
}
