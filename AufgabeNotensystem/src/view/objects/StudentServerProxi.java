package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class StudentServerProxi extends ServiceProxi implements StudentServerView{
    
    public StudentServerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public StudentServerView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> errors_string = (java.util.Vector<String>)resultTable.get("errors");
        java.util.Vector<ErrorDisplayView> errors = ViewProxi.getProxiVector(errors_string, connectionKey);
        String matriculationNumber = (String)resultTable.get("matriculationNumber");
        String forename = (String)resultTable.get("forename");
        String surname = (String)resultTable.get("surname");
        java.util.Date dateOfBirth = (java.util.Date)resultTable.get("dateOfBirth");
        String activeStudyGroupName = (String)resultTable.get("activeStudyGroupName");
        java.util.Vector<String> studyGroupsAttended_string = (java.util.Vector<String>)resultTable.get("studyGroupsAttended");
        java.util.Vector<StudyGroupView> studyGroupsAttended = ViewProxi.getProxiVector(studyGroupsAttended_string, connectionKey);
        StudentServerView result$$ = new StudentServer(errors,(String)matriculationNumber,(String)forename,(String)surname,(java.util.Date)dateOfBirth,(String)activeStudyGroupName,studyGroupsAttended, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getStudyGroupsAttended().size()) return new StudyGroupsAttendedStudentServerWrapper(this, originalIndex, (ViewRoot)this.getStudyGroupsAttended().get(index));
        index = index - this.getStudyGroupsAttended().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getStudyGroupsAttended().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getStudyGroupsAttended().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getStudyGroupsAttendedIterator = this.getStudyGroupsAttended().iterator();
        while(getStudyGroupsAttendedIterator.hasNext()){
            if(getStudyGroupsAttendedIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public String getMatriculationNumber()throws ModelException{
        return ((StudentServer)this.getTheObject()).getMatriculationNumber();
    }
    public void setMatriculationNumber(String newValue) throws ModelException {
        ((StudentServer)this.getTheObject()).setMatriculationNumber(newValue);
    }
    public String getForename()throws ModelException{
        return ((StudentServer)this.getTheObject()).getForename();
    }
    public void setForename(String newValue) throws ModelException {
        ((StudentServer)this.getTheObject()).setForename(newValue);
    }
    public String getSurname()throws ModelException{
        return ((StudentServer)this.getTheObject()).getSurname();
    }
    public void setSurname(String newValue) throws ModelException {
        ((StudentServer)this.getTheObject()).setSurname(newValue);
    }
    public java.util.Date getDateOfBirth()throws ModelException{
        return ((StudentServer)this.getTheObject()).getDateOfBirth();
    }
    public void setDateOfBirth(java.util.Date newValue) throws ModelException {
        ((StudentServer)this.getTheObject()).setDateOfBirth(newValue);
    }
    public String getActiveStudyGroupName()throws ModelException{
        return ((StudentServer)this.getTheObject()).getActiveStudyGroupName();
    }
    public void setActiveStudyGroupName(String newValue) throws ModelException {
        ((StudentServer)this.getTheObject()).setActiveStudyGroupName(newValue);
    }
    public java.util.Vector<StudyGroupView> getStudyGroupsAttended()throws ModelException{
        return ((StudentServer)this.getTheObject()).getStudyGroupsAttended();
    }
    public void setStudyGroupsAttended(java.util.Vector<StudyGroupView> newValue) throws ModelException {
        ((StudentServer)this.getTheObject()).setStudyGroupsAttended(newValue);
    }
    
    public void accept(ServiceVisitor visitor) throws ModelException {
        visitor.handleStudentServer(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudentServer(this);
    }
    public <E extends view.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudentServer(this);
    }
    public <R, E extends view.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudentServer(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleStudentServer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudentServer(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudentServer(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudentServer(this);
    }
    public void accept(RemoteVisitor visitor) throws ModelException {
        visitor.handleStudentServer(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudentServer(this);
    }
    public <E extends view.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudentServer(this);
    }
    public <R, E extends view.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudentServer(this);
    }
    
    
    public StudentServerConnection connectStudentServer(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException{
        StudentServerConnection result;
		try {
			result = (StudentServerConnection) new StudentServerConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
		} catch (java.net.MalformedURLException e) {
			throw new ModelException(e.getMessage(),0);
		}
		result.setHandler(handler);
		ConnectionIndex.getTheConnectionIndex().setConnection(handler,result);
		handler.setConnection(result);
		handler.initializeConnection();
		return result;
    }public boolean hasTransientFields(){
        return false;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
