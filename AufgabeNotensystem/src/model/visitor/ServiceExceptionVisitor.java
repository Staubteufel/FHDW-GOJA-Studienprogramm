
package model.visitor;
import persistence.*;

public interface ServiceExceptionVisitor<E extends model.UserException> {
    
    public void handleAdminServer(AdminServer4Public adminServer) throws PersistenceException, E;
    public void handleStudentServer(StudentServer4Public studentServer) throws PersistenceException, E;
    
}
