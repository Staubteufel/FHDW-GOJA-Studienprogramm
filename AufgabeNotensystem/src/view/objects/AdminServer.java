
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class AdminServer extends view.objects.Service implements AdminServerView{
    
    protected UnitLstView units;
    protected ModuleWithUnitsLstView moduleWithUnits;
    protected ModuleWithoutUnitsLstView moduleWithoutUnits;
    protected ModuleGroupLstView moduleGroups;
    protected StudyProgramLstView studyPrograms;
    protected StudyGroupLstView studyGroups;
    protected StudentServerLstView students;
    
    public AdminServer(java.util.Vector<ErrorDisplayView> errors,UnitLstView units,ModuleWithUnitsLstView moduleWithUnits,ModuleWithoutUnitsLstView moduleWithoutUnits,ModuleGroupLstView moduleGroups,StudyProgramLstView studyPrograms,StudyGroupLstView studyGroups,StudentServerLstView students,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(errors,id, classId);
        this.units = units;
        this.moduleWithUnits = moduleWithUnits;
        this.moduleWithoutUnits = moduleWithoutUnits;
        this.moduleGroups = moduleGroups;
        this.studyPrograms = studyPrograms;
        this.studyGroups = studyGroups;
        this.students = students;        
    }
    
    static public long getTypeId() {
        return -201;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public UnitLstView getUnits()throws ModelException{
        return this.units;
    }
    public void setUnits(UnitLstView newValue) throws ModelException {
        this.units = newValue;
    }
    public ModuleWithUnitsLstView getModuleWithUnits()throws ModelException{
        return this.moduleWithUnits;
    }
    public void setModuleWithUnits(ModuleWithUnitsLstView newValue) throws ModelException {
        this.moduleWithUnits = newValue;
    }
    public ModuleWithoutUnitsLstView getModuleWithoutUnits()throws ModelException{
        return this.moduleWithoutUnits;
    }
    public void setModuleWithoutUnits(ModuleWithoutUnitsLstView newValue) throws ModelException {
        this.moduleWithoutUnits = newValue;
    }
    public ModuleGroupLstView getModuleGroups()throws ModelException{
        return this.moduleGroups;
    }
    public void setModuleGroups(ModuleGroupLstView newValue) throws ModelException {
        this.moduleGroups = newValue;
    }
    public StudyProgramLstView getStudyPrograms()throws ModelException{
        return this.studyPrograms;
    }
    public void setStudyPrograms(StudyProgramLstView newValue) throws ModelException {
        this.studyPrograms = newValue;
    }
    public StudyGroupLstView getStudyGroups()throws ModelException{
        return this.studyGroups;
    }
    public void setStudyGroups(StudyGroupLstView newValue) throws ModelException {
        this.studyGroups = newValue;
    }
    public StudentServerLstView getStudents()throws ModelException{
        return this.students;
    }
    public void setStudents(StudentServerLstView newValue) throws ModelException {
        this.students = newValue;
    }
    
    public void accept(ServiceVisitor visitor) throws ModelException {
        visitor.handleAdminServer(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAdminServer(this);
    }
    public <E extends view.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAdminServer(this);
    }
    public <R, E extends view.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAdminServer(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleAdminServer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAdminServer(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAdminServer(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAdminServer(this);
    }
    public void accept(RemoteVisitor visitor) throws ModelException {
        visitor.handleAdminServer(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAdminServer(this);
    }
    public <E extends view.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAdminServer(this);
    }
    public <R, E extends view.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAdminServer(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> errors = this.getErrors();
        if (errors != null) {
            ViewObject.resolveVectorProxies(errors, resultTable);
        }
        UnitLstView units = this.getUnits();
        if (units != null) {
            ((ViewProxi)units).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(units.getClassId(), units.getId())));
        }
        ModuleWithUnitsLstView moduleWithUnits = this.getModuleWithUnits();
        if (moduleWithUnits != null) {
            ((ViewProxi)moduleWithUnits).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(moduleWithUnits.getClassId(), moduleWithUnits.getId())));
        }
        ModuleWithoutUnitsLstView moduleWithoutUnits = this.getModuleWithoutUnits();
        if (moduleWithoutUnits != null) {
            ((ViewProxi)moduleWithoutUnits).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(moduleWithoutUnits.getClassId(), moduleWithoutUnits.getId())));
        }
        ModuleGroupLstView moduleGroups = this.getModuleGroups();
        if (moduleGroups != null) {
            ((ViewProxi)moduleGroups).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(moduleGroups.getClassId(), moduleGroups.getId())));
        }
        StudyProgramLstView studyPrograms = this.getStudyPrograms();
        if (studyPrograms != null) {
            ((ViewProxi)studyPrograms).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(studyPrograms.getClassId(), studyPrograms.getId())));
        }
        StudyGroupLstView studyGroups = this.getStudyGroups();
        if (studyGroups != null) {
            ((ViewProxi)studyGroups).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(studyGroups.getClassId(), studyGroups.getId())));
        }
        StudentServerLstView students = this.getStudents();
        if (students != null) {
            ((ViewProxi)students).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(students.getClassId(), students.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getUnits() != null) return new UnitsAdminServerWrapper(this, originalIndex, (ViewRoot)this.getUnits());
        if(this.getUnits() != null) index = index - 1;
        if(index == 0 && this.getModuleWithUnits() != null) return new ModuleWithUnitsAdminServerWrapper(this, originalIndex, (ViewRoot)this.getModuleWithUnits());
        if(this.getModuleWithUnits() != null) index = index - 1;
        if(index == 0 && this.getModuleWithoutUnits() != null) return new ModuleWithoutUnitsAdminServerWrapper(this, originalIndex, (ViewRoot)this.getModuleWithoutUnits());
        if(this.getModuleWithoutUnits() != null) index = index - 1;
        if(index == 0 && this.getModuleGroups() != null) return new ModuleGroupsAdminServerWrapper(this, originalIndex, (ViewRoot)this.getModuleGroups());
        if(this.getModuleGroups() != null) index = index - 1;
        if(index == 0 && this.getStudyPrograms() != null) return new StudyProgramsAdminServerWrapper(this, originalIndex, (ViewRoot)this.getStudyPrograms());
        if(this.getStudyPrograms() != null) index = index - 1;
        if(index == 0 && this.getStudyGroups() != null) return new StudyGroupsAdminServerWrapper(this, originalIndex, (ViewRoot)this.getStudyGroups());
        if(this.getStudyGroups() != null) index = index - 1;
        if(index == 0 && this.getStudents() != null) return new StudentsAdminServerWrapper(this, originalIndex, (ViewRoot)this.getStudents());
        if(this.getStudents() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getUnits() == null ? 0 : 1)
            + (this.getModuleWithUnits() == null ? 0 : 1)
            + (this.getModuleWithoutUnits() == null ? 0 : 1)
            + (this.getModuleGroups() == null ? 0 : 1)
            + (this.getStudyPrograms() == null ? 0 : 1)
            + (this.getStudyGroups() == null ? 0 : 1)
            + (this.getStudents() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getUnits() == null ? true : false)
            && (this.getModuleWithUnits() == null ? true : false)
            && (this.getModuleWithoutUnits() == null ? true : false)
            && (this.getModuleGroups() == null ? true : false)
            && (this.getStudyPrograms() == null ? true : false)
            && (this.getStudyGroups() == null ? true : false)
            && (this.getStudents() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getUnits() != null && this.getUnits().equals(child)) return result;
        if(this.getUnits() != null) result = result + 1;
        if(this.getModuleWithUnits() != null && this.getModuleWithUnits().equals(child)) return result;
        if(this.getModuleWithUnits() != null) result = result + 1;
        if(this.getModuleWithoutUnits() != null && this.getModuleWithoutUnits().equals(child)) return result;
        if(this.getModuleWithoutUnits() != null) result = result + 1;
        if(this.getModuleGroups() != null && this.getModuleGroups().equals(child)) return result;
        if(this.getModuleGroups() != null) result = result + 1;
        if(this.getStudyPrograms() != null && this.getStudyPrograms().equals(child)) return result;
        if(this.getStudyPrograms() != null) result = result + 1;
        if(this.getStudyGroups() != null && this.getStudyGroups().equals(child)) return result;
        if(this.getStudyGroups() != null) result = result + 1;
        if(this.getStudents() != null && this.getStudents().equals(child)) return result;
        if(this.getStudents() != null) result = result + 1;
        return -1;
    }
    public int getRowCount(){
        return 0 ;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
            } else {
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
        
    }
    public AdminServerConnection connectAdminServer(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException{
        AdminServerConnection result;
		try {
			result = (AdminServerConnection) new AdminServerConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
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
