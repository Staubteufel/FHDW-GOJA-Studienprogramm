
package view.visitor;
import view.*;

public interface ServiceExceptionVisitor<E extends view.UserException> {
    
    public void handleAdminServer(AdminServerView adminServer) throws ModelException, E;
    public void handleStudentServer(StudentServerView studentServer) throws ModelException, E;
    
}
