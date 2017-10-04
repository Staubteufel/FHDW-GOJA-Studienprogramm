package model.meta;

public interface ApprMssgsVisitor extends ApprDOWNMssgsVisitor, ApprUPMssgsVisitor {}


interface ApprDOWNMssgsVisitor extends ModuleGroupDOWNMssgsVisitor, UnitDOWNMssgsVisitor, ModuleWithoutUnitsDOWNMssgsVisitor, ModuleWithUnitsDOWNMssgsVisitor, StudyProgramDOWNMssgsVisitor {

    
}


interface ApprUPMssgsVisitor extends PrototypeUPMssgsVisitor {

    
}
