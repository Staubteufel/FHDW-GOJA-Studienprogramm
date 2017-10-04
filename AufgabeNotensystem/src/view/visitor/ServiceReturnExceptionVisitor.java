
package view.visitor;
import view.*;

public interface ServiceReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleAdminServer(AdminServerView adminServer) throws ModelException, E;
    public R handleStudentServer(StudentServerView studentServer) throws ModelException, E;
    
}
