
package model.visitor;

import persistence.*;

public abstract class ServiceStandardVisitor implements ServiceVisitor {
    
    public void handleStudentServer(StudentServer4Public studentServer) throws PersistenceException{
        this.standardHandling(studentServer);
    }
    public void handleAdminServer(AdminServer4Public adminServer) throws PersistenceException{
        this.standardHandling(adminServer);
    }
    protected abstract void standardHandling(Service4Public service) throws PersistenceException;
}
