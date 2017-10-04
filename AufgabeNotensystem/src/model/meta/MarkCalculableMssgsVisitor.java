package model.meta;

public interface MarkCalculableMssgsVisitor extends MarkCalculableDOWNMssgsVisitor, MarkCalculableUPMssgsVisitor {}


interface MarkCalculableDOWNMssgsVisitor extends TenthMarkDOWNMssgsVisitor, ThirdMarkDOWNMssgsVisitor {

    
}


interface MarkCalculableUPMssgsVisitor extends MarkUPMssgsVisitor {

    
}
