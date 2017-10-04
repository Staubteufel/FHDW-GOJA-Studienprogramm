package persistence;


public interface PersistentSorcMTSWiUCommand extends Anything, AdminServerCommand, PersistentCommonDate, AbstractPersistentProxi, SorcMTSWiUCommand4Public {
    
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    

}

