
package model.visitor;

import persistence.*;

public abstract class RemoteStandardVisitor implements RemoteVisitor {
    
    public void handleServer(Server4Public server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleStudentServer(StudentServer4Public studentServer) throws PersistenceException{
        this.standardHandling(studentServer);
    }
    public void handleAdminServer(AdminServer4Public adminServer) throws PersistenceException{
        this.standardHandling(adminServer);
    }
    protected abstract void standardHandling(Remote remote) throws PersistenceException;
}
