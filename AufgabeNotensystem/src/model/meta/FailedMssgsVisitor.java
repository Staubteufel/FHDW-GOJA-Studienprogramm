package model.meta;

public interface FailedMssgsVisitor extends FailedDOWNMssgsVisitor, FailedUPMssgsVisitor {}


interface FailedDOWNMssgsVisitor  {

    
}


interface FailedUPMssgsVisitor extends BooleanMarkUPMssgsVisitor {

    
}
