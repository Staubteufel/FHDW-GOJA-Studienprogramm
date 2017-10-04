
package model.visitor;

import persistence.*;

public abstract class InvokerDirectVisitor implements InvokerVisitor {
    
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    
    public abstract void handleService(Service4Public service) throws PersistenceException;
    
    public void handleStudentServer(StudentServer4Public studentServer) throws PersistenceException{
        this.handleService(studentServer);
    }
    public void handleAdminServer(AdminServer4Public adminServer) throws PersistenceException{
        this.handleService(adminServer);
    }
    
}
