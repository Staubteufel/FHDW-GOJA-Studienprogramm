package model.meta;

public interface MarkNotCalculableMssgsVisitor extends MarkNotCalculableDOWNMssgsVisitor, MarkNotCalculableUPMssgsVisitor {}


interface MarkNotCalculableDOWNMssgsVisitor extends NoneMarkDOWNMssgsVisitor, BooleanMarkDOWNMssgsVisitor {

    
}


interface MarkNotCalculableUPMssgsVisitor extends MarkUPMssgsVisitor {

    
}
