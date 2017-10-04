
package model.visitor;
import persistence.*;

public interface ServiceVisitor {
    
    public void handleAdminServer(AdminServer4Public adminServer) throws PersistenceException;
    public void handleStudentServer(StudentServer4Public studentServer) throws PersistenceException;
    
}
