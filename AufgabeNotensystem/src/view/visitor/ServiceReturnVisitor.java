
package view.visitor;
import view.*;

public interface ServiceReturnVisitor<R> {
    
    public R handleAdminServer(AdminServerView adminServer) throws ModelException;
    public R handleStudentServer(StudentServerView studentServer) throws ModelException;
    
}
