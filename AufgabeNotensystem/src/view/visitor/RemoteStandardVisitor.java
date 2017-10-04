
package view.visitor;

import view.*;

public abstract class RemoteStandardVisitor implements RemoteVisitor {
    
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleStudentServer(StudentServerView studentServer) throws ModelException{
        this.standardHandling(studentServer);
    }
    public void handleAdminServer(AdminServerView adminServer) throws ModelException{
        this.standardHandling(adminServer);
    }
    protected abstract void standardHandling(Remote remote) throws ModelException;
}
