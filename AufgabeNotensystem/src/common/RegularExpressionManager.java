package common;

import expressions.RegularExpressionHandler;

public class RegularExpressionManager {

    public static RegularExpressionHandler booleanMarkSUBTYPEName = new RegularExpressionHandler( "[(Passed)" + 
		"(BooleanMark)" + 
		"(Failed)]" );
    public static RegularExpressionHandler thirdMarkSUBTYPEName = new RegularExpressionHandler( "[(TwoThree)" + 
		"(TwoSeven)" + 
		"(OneSeven)" + 
		"(FourZero)" + 
		"(ThreeSeven)" + 
		"(OneZero)" + 
		"(TwoZero)" + 
		"(ThreeThree)" + 
		"(FiveZero)" + 
		"(OneThree)" + 
		"(ThreeZero)" + 
		"(ThirdMark)]" );
    

}
