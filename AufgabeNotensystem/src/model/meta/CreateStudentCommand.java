
package model.meta;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class CreateStudentCommand extends PersistentObject implements PersistentCreateStudentCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static CreateStudentCommand4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCreateStudentCommandFacade.getClass(objectId);
        return (CreateStudentCommand4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static CreateStudentCommand4Public createCreateStudentCommand(String matricalNumber,String password,String forename,String surname,java.sql.Date dateOfBirth,java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createCreateStudentCommand(matricalNumber,password,forename,surname,dateOfBirth,createDate,commitDate,false);
    }
    
    public static CreateStudentCommand4Public createCreateStudentCommand(String matricalNumber,String password,String forename,String surname,java.sql.Date dateOfBirth,java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        if (matricalNumber == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (password == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (forename == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (surname == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentCreateStudentCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCreateStudentCommandFacade
                .newDelayedCreateStudentCommand(matricalNumber,password,forename,surname,dateOfBirth);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCreateStudentCommandFacade
                .newCreateStudentCommand(matricalNumber,password,forename,surname,dateOfBirth,-1);
        }
        ((PersistentCreateStudentCommand)result).setMyCommonDate((PersistentCommonDate)CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected String matricalNumber;
    protected String password;
    protected String forename;
    protected String surname;
    protected java.sql.Date dateOfBirth;
    protected PersistentStudyGroup studyGroup;
    protected Invoker invoker;
    protected PersistentAdminServer commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public CreateStudentCommand(String matricalNumber,String password,String forename,String surname,java.sql.Date dateOfBirth,PersistentStudyGroup studyGroup,Invoker invoker,PersistentAdminServer commandReceiver,PersistentCommonDate myCommonDate,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.matricalNumber = matricalNumber;
        this.password = password;
        this.forename = forename;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.studyGroup = studyGroup;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 166;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 166) ConnectionHandler.getTheConnectionHandler().theCreateStudentCommandFacade
            .newCreateStudentCommand(matricalNumber,password,forename,surname,dateOfBirth,this.getId());
        super.store();
        if(this.getStudyGroup() != null){
            this.getStudyGroup().store();
            ConnectionHandler.getTheConnectionHandler().theCreateStudentCommandFacade.studyGroupSet(this.getId(), getStudyGroup());
        }
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theCreateStudentCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theCreateStudentCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theCreateStudentCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public String getMatricalNumber() throws PersistenceException {
        return this.matricalNumber;
    }
    public void setMatricalNumber(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theCreateStudentCommandFacade.matricalNumberSet(this.getId(), newValue);
        this.matricalNumber = newValue;
    }
    public String getPassword() throws PersistenceException {
        return this.password;
    }
    public void setPassword(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theCreateStudentCommandFacade.passwordSet(this.getId(), newValue);
        this.password = newValue;
    }
    public String getForename() throws PersistenceException {
        return this.forename;
    }
    public void setForename(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theCreateStudentCommandFacade.forenameSet(this.getId(), newValue);
        this.forename = newValue;
    }
    public String getSurname() throws PersistenceException {
        return this.surname;
    }
    public void setSurname(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theCreateStudentCommandFacade.surnameSet(this.getId(), newValue);
        this.surname = newValue;
    }
    public java.sql.Date getDateOfBirth() throws PersistenceException {
        return this.dateOfBirth;
    }
    public void setDateOfBirth(java.sql.Date newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theCreateStudentCommandFacade.dateOfBirthSet(this.getId(), newValue);
        this.dateOfBirth = newValue;
    }
    public StudyGroup4Public getStudyGroup() throws PersistenceException {
        return this.studyGroup;
    }
    public void setStudyGroup(StudyGroup4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.studyGroup)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.studyGroup = (PersistentStudyGroup)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateStudentCommandFacade.studyGroupSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theCreateStudentCommandFacade.invokerSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theCreateStudentCommandFacade.commandReceiverSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theCreateStudentCommandFacade.myCommonDateSet(this.getId(), newValue);
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
        visitor.handleCreateStudentCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateStudentCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateStudentCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateStudentCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateStudentCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateStudentCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateStudentCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateStudentCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateStudentCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateStudentCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateStudentCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateStudentCommand(this);
    }
    public void accept(AdminServerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateStudentCommand(this);
    }
    public <R> R accept(AdminServerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateStudentCommand(this);
    }
    public <E extends model.UserException>  void accept(AdminServerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateStudentCommand(this);
    }
    public <R, E extends model.UserException> R accept(AdminServerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateStudentCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getStudyGroup() != null) return 1;
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
			this.commandReceiver.createStudent(this.getMatricalNumber(), this.getPassword(), this.getForename(), this.getSurname(), this.getDateOfBirth(), this.getStudyGroup());
		}
		catch(model.MatricalNumberAlreadyUsed e){
			this.commandException = e;
		}
		catch(model.CreditPointInformationIsNotConsistent e){
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
