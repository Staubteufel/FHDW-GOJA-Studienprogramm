package model.meta;

public interface ServiceMssgsVisitor extends ServiceDOWNMssgsVisitor, ServiceUPMssgsVisitor {}


interface ServiceDOWNMssgsVisitor extends AdminServerDOWNMssgsVisitor, StudentServerDOWNMssgsVisitor {

    
}


interface ServiceUPMssgsVisitor  {

    
}
