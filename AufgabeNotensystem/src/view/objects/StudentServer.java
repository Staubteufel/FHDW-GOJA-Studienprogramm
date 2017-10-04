
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class StudentServer extends view.objects.Service implements StudentServerView{
    
    protected String matriculationNumber;
    protected String forename;
    protected String surname;
    protected java.util.Date dateOfBirth;
    protected String activeStudyGroupName;
    protected java.util.Vector<StudyGroupView> studyGroupsAttended;
    
    public StudentServer(java.util.Vector<ErrorDisplayView> errors,String matriculationNumber,String forename,String surname,java.util.Date dateOfBirth,String activeStudyGroupName,java.util.Vector<StudyGroupView> studyGroupsAttended,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(errors,id, classId);
        this.matriculationNumber = matriculationNumber;
        this.forename = forename;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.activeStudyGroupName = activeStudyGroupName;
        this.studyGroupsAttended = studyGroupsAttended;        
    }
    
    static public long getTypeId() {
        return -200;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getMatriculationNumber()throws ModelException{
        return this.matriculationNumber;
    }
    public void setMatriculationNumber(String newValue) throws ModelException {
        this.matriculationNumber = newValue;
    }
    public String getForename()throws ModelException{
        return this.forename;
    }
    public void setForename(String newValue) throws ModelException {
        this.forename = newValue;
    }
    public String getSurname()throws ModelException{
        return this.surname;
    }
    public void setSurname(String newValue) throws ModelException {
        this.surname = newValue;
    }
    public java.util.Date getDateOfBirth()throws ModelException{
        return this.dateOfBirth;
    }
    public void setDateOfBirth(java.util.Date newValue) throws ModelException {
        this.dateOfBirth = newValue;
    }
    public String getActiveStudyGroupName()throws ModelException{
        return this.activeStudyGroupName;
    }
    public void setActiveStudyGroupName(String newValue) throws ModelException {
        this.activeStudyGroupName = newValue;
    }
    public java.util.Vector<StudyGroupView> getStudyGroupsAttended()throws ModelException{
        return this.studyGroupsAttended;
    }
    public void setStudyGroupsAttended(java.util.Vector<StudyGroupView> newValue) throws ModelException {
        this.studyGroupsAttended = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> errors = this.getErrors();
        if (errors != null) {
            ViewObject.resolveVectorProxies(errors, resultTable);
        }
        java.util.Vector<?> studyGroupsAttended = this.getStudyGroupsAttended();
        if (studyGroupsAttended != null) {
            ViewObject.resolveVectorProxies(studyGroupsAttended, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
    public int getMatriculationNumberIndex() throws ModelException {
        return 0;
    }
    public int getForenameIndex() throws ModelException {
        return 0 + 1;
    }
    public int getSurnameIndex() throws ModelException {
        return 0 + 1 + 1;
    }
    public int getDateOfBirthIndex() throws ModelException {
        return 0 + 1 + 1 + 1;
    }
    public int getActiveStudyGroupNameIndex() throws ModelException {
        return 0 + 1 + 1 + 1 + 1;
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1
            + 1
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "matriculationNumber";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "forename";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "surname";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "dateOfBirth";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "activeStudyGroupName";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getMatriculationNumber();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getForename();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getSurname();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return ViewRoot.toString(getDateOfBirth(), false );
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getActiveStudyGroupName();
                rowIndex = rowIndex - 1;
            }
            throw new ModelException("Table index out of bounds!", -1);
        } catch (ModelException e){
            return e.getMessage();
        }
    }
    
    public boolean isRowEditable(int index){
        return true;
    }
    public void setValueAt(String newValue, int rowIndex) throws Exception {
        if(rowIndex == 0){
            this.setMatriculationNumber(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setForename(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setSurname(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setDateOfBirth(new java.text.SimpleDateFormat(DATEFORMAT).parse(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setActiveStudyGroupName(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
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
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public javafx.scene.image.Image getImage() {
        return super.getImage();
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
