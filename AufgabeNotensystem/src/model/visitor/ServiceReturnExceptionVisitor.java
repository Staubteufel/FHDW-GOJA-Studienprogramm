
package model.visitor;
import persistence.*;

public interface ServiceReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAdminServer(AdminServer4Public adminServer) throws PersistenceException, E;
    public R handleStudentServer(StudentServer4Public studentServer) throws PersistenceException, E;
    
}
