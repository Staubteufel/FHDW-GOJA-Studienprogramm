
package model.meta;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class AddMWUToMGCommand extends PersistentObject implements PersistentAddMWUToMGCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static AddMWUToMGCommand4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAddMWUToMGCommandFacade.getClass(objectId);
        return (AddMWUToMGCommand4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static AddMWUToMGCommand4Public createAddMWUToMGCommand(java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createAddMWUToMGCommand(createDate,commitDate,false);
    }
    
    public static AddMWUToMGCommand4Public createAddMWUToMGCommand(java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        PersistentAddMWUToMGCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAddMWUToMGCommandFacade
                .newDelayedAddMWUToMGCommand();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAddMWUToMGCommandFacade
                .newAddMWUToMGCommand(-1);
        }
        ((PersistentAddMWUToMGCommand)result).setMyCommonDate((PersistentCommonDate)CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentModuleGroup moduleGroup;
    protected PersistentModuleWithUnits moduleWithUnits;
    protected Invoker invoker;
    protected PersistentAdminServer commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public AddMWUToMGCommand(PersistentModuleGroup moduleGroup,PersistentModuleWithUnits moduleWithUnits,Invoker invoker,PersistentAdminServer commandReceiver,PersistentCommonDate myCommonDate,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.moduleGroup = moduleGroup;
        this.moduleWithUnits = moduleWithUnits;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 171;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 171) ConnectionHandler.getTheConnectionHandler().theAddMWUToMGCommandFacade
            .newAddMWUToMGCommand(this.getId());
        super.store();
        if(this.getModuleGroup() != null){
            this.getModuleGroup().store();
            ConnectionHandler.getTheConnectionHandler().theAddMWUToMGCommandFacade.moduleGroupSet(this.getId(), getModuleGroup());
        }
        if(this.getModuleWithUnits() != null){
            this.getModuleWithUnits().store();
            ConnectionHandler.getTheConnectionHandler().theAddMWUToMGCommandFacade.moduleWithUnitsSet(this.getId(), getModuleWithUnits());
        }
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theAddMWUToMGCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theAddMWUToMGCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theAddMWUToMGCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public ModuleGroup4Public getModuleGroup() throws PersistenceException {
        return this.moduleGroup;
    }
    public void setModuleGroup(ModuleGroup4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.moduleGroup)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.moduleGroup = (PersistentModuleGroup)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAddMWUToMGCommandFacade.moduleGroupSet(this.getId(), newValue);
        }
    }
    public ModuleWithUnits4Public getModuleWithUnits() throws PersistenceException {
        return this.moduleWithUnits;
    }
    public void setModuleWithUnits(ModuleWithUnits4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.moduleWithUnits)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.moduleWithUnits = (PersistentModuleWithUnits)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAddMWUToMGCommandFacade.moduleWithUnitsSet(this.getId(), newValue);
        }
    }
    public Invoker getInvoker() throws PersistenceException {
        return this.invoker;
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.invoker)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.invoker = (Invoker)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAddMWUToMGCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public AdminServer4Public getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(AdminServer4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentAdminServer)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAddMWUToMGCommandFacade.commandReceiverSet(this.getId(), newValue);
        }
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return this.myCommonDate;
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.myCommonDate)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAddMWUToMGCommandFacade.myCommonDateSet(this.getId(), newValue);
        }
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCommonDate)this.getMyCommonDate()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCommonDate)this.getMyCommonDate()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCommonDate)this.getMyCommonDate()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCommonDate)this.getMyCommonDate()).setCommitDate(newValue);
    }
    public void delete$Me() throws PersistenceException{
        super.delete$Me();
        this.getMyCommonDate().delete$Me();
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleAddMWUToMGCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddMWUToMGCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddMWUToMGCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddMWUToMGCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAddMWUToMGCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddMWUToMGCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddMWUToMGCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddMWUToMGCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleAddMWUToMGCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddMWUToMGCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddMWUToMGCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddMWUToMGCommand(this);
    }
    public void accept(AdminServerCommandVisitor visitor) throws PersistenceException {
        visitor.handleAddMWUToMGCommand(this);
    }
    public <R> R accept(AdminServerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddMWUToMGCommand(this);
    }
    public <E extends model.UserException>  void accept(AdminServerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddMWUToMGCommand(this);
    }
    public <R, E extends model.UserException> R accept(AdminServerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddMWUToMGCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getModuleGroup() != null) return 1;
        if (this.getModuleWithUnits() != null) return 1;
        if (this.getCommandReceiver() != null) return 1;
        return 0;
    }
    
    
    
    
    // Start of section that contains operations that must be implemented.
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        if (this.commandException != null) throw this.commandException;
    }
    public void execute() 
				throws PersistenceException{
        try{
			this.commandReceiver.addMWUToMG(this.getModuleGroup(), this.getModuleWithUnits());
		}
		catch(model.CycleException e){
			this.commandException = e;
		}
		catch(model.AlreadyInUseException e){
			this.commandException = e;
		}
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return this.getInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        this.invoker.handleException(this, exception);
    }
    public void sendResult() 
				throws PersistenceException{
        this.invoker.handleResult(this);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
