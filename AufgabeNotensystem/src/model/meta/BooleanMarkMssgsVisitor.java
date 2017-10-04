package model.meta;

public interface BooleanMarkMssgsVisitor extends BooleanMarkDOWNMssgsVisitor, BooleanMarkUPMssgsVisitor {}


interface BooleanMarkDOWNMssgsVisitor extends PassedDOWNMssgsVisitor, FailedDOWNMssgsVisitor {

    
}


interface BooleanMarkUPMssgsVisitor extends MarkNotCalculableUPMssgsVisitor {

    
}
