
package model.visitor;

import persistence.*;

public abstract class InvokerStandardVisitor implements InvokerVisitor {
    
    public void handleServer(Server4Public server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleStudentServer(StudentServer4Public studentServer) throws PersistenceException{
        this.standardHandling(studentServer);
    }
    public void handleAdminServer(AdminServer4Public adminServer) throws PersistenceException{
        this.standardHandling(adminServer);
    }
    protected abstract void standardHandling(Invoker invoker) throws PersistenceException;
}
