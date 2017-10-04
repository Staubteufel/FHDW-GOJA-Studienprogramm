package model.meta;

public interface ThirdMarkMssgsVisitor extends ThirdMarkDOWNMssgsVisitor, ThirdMarkUPMssgsVisitor {}


interface ThirdMarkDOWNMssgsVisitor extends FiveZeroDOWNMssgsVisitor, ThreeZeroDOWNMssgsVisitor, TwoSevenDOWNMssgsVisitor, TwoZeroDOWNMssgsVisitor, OneSevenDOWNMssgsVisitor, ThreeThreeDOWNMssgsVisitor, OneThreeDOWNMssgsVisitor, TwoThreeDOWNMssgsVisitor, FourZeroDOWNMssgsVisitor, ThreeSevenDOWNMssgsVisitor, OneZeroDOWNMssgsVisitor {

    
}


interface ThirdMarkUPMssgsVisitor extends MarkCalculableUPMssgsVisitor {

    
}
