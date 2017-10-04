
package view.visitor;

import view.*;

public abstract class RemoteDirectVisitor implements RemoteVisitor {
    
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handleService(ServiceView service) throws ModelException;
    
    public void handleStudentServer(StudentServerView studentServer) throws ModelException{
        this.handleService(studentServer);
    }
    public void handleAdminServer(AdminServerView adminServer) throws ModelException{
        this.handleService(adminServer);
    }
    
}
