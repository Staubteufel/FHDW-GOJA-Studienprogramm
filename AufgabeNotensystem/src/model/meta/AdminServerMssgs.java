package model.meta;

public interface AdminServerMssgs {
    void accept(AdminServerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AdminServerDOWNMssgs extends ServiceDOWNMssgs, AdminServerMssgs{}
interface AdminServerUPMssgs extends Mssgs, AdminServerMssgs{}
