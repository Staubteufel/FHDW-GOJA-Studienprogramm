
package view.visitor;
import view.*;

public interface ServiceVisitor {
    
    public void handleAdminServer(AdminServerView adminServer) throws ModelException;
    public void handleStudentServer(StudentServerView studentServer) throws ModelException;
    
}
