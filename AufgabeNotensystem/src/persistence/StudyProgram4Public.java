package persistence;


import model.visitor.*;

public interface StudyProgram4Public extends Appr4Public {
    
    public StudyProgram_ModuleGroupsProxi getModuleGroups() throws PersistenceException ;
    
    public void accept(ApprVisitor visitor) throws PersistenceException;
    public <R> R accept(ApprReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ApprExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ApprReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(PrototypeVisitor visitor) throws PersistenceException;
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void addModuleGroup(final ModuleGroup4Public moduleGroup) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public Boolean isConsistent() 
				throws PersistenceException;
    public void removeModuleGroup(final ModuleGroup4Public moduleGroup) 
				throws PersistenceException;

}

