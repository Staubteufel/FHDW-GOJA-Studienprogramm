
package view.visitor;

import view.*;

public abstract class ServiceStandardVisitor implements ServiceVisitor {
    
    public void handleStudentServer(StudentServerView studentServer) throws ModelException{
        this.standardHandling(studentServer);
    }
    public void handleAdminServer(AdminServerView adminServer) throws ModelException{
        this.standardHandling(adminServer);
    }
    protected abstract void standardHandling(ServiceView service) throws ModelException;
}
