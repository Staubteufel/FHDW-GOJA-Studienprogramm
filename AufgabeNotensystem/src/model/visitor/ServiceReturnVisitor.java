
package model.visitor;
import persistence.*;

public interface ServiceReturnVisitor<R> {
    
    public R handleAdminServer(AdminServer4Public adminServer) throws PersistenceException;
    public R handleStudentServer(StudentServer4Public studentServer) throws PersistenceException;
    
}
