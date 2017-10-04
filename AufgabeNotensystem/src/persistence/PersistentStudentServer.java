package persistence;


public interface PersistentStudentServer extends PersistentService, StudentServer4Public {
    
    public void setMatriculationNumber(String newValue) throws PersistenceException ;
    public void setForename(String newValue) throws PersistenceException ;
    public void setSurname(String newValue) throws PersistenceException ;
    public void setDateOfBirth(java.sql.Date newValue) throws PersistenceException ;
    public PersistentStudentServer getThis() throws PersistenceException ;
    
    

}

