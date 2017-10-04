package model.meta;

public interface MarkMssgsVisitor extends MarkDOWNMssgsVisitor, MarkUPMssgsVisitor {}


interface MarkDOWNMssgsVisitor extends MarkNotCalculableDOWNMssgsVisitor, MarkCalculableDOWNMssgsVisitor {

    
}


interface MarkUPMssgsVisitor  {

    
}
