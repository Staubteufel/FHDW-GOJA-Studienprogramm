package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class AdminServerProxi extends ServiceProxi implements AdminServerView{
    
    public AdminServerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public AdminServerView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> errors_string = (java.util.Vector<String>)resultTable.get("errors");
        java.util.Vector<ErrorDisplayView> errors = ViewProxi.getProxiVector(errors_string, connectionKey);
        ViewProxi units = null;
        String units$String = (String)resultTable.get("units");
        if (units$String != null) {
            common.ProxiInformation units$Info = common.RPCConstantsAndServices.createProxiInformation(units$String);
            units = view.objects.ViewProxi.createProxi(units$Info,connectionKey);
            units.setToString(units$Info.getToString());
        }
        ViewProxi moduleWithUnits = null;
        String moduleWithUnits$String = (String)resultTable.get("moduleWithUnits");
        if (moduleWithUnits$String != null) {
            common.ProxiInformation moduleWithUnits$Info = common.RPCConstantsAndServices.createProxiInformation(moduleWithUnits$String);
            moduleWithUnits = view.objects.ViewProxi.createProxi(moduleWithUnits$Info,connectionKey);
            moduleWithUnits.setToString(moduleWithUnits$Info.getToString());
        }
        ViewProxi moduleWithoutUnits = null;
        String moduleWithoutUnits$String = (String)resultTable.get("moduleWithoutUnits");
        if (moduleWithoutUnits$String != null) {
            common.ProxiInformation moduleWithoutUnits$Info = common.RPCConstantsAndServices.createProxiInformation(moduleWithoutUnits$String);
            moduleWithoutUnits = view.objects.ViewProxi.createProxi(moduleWithoutUnits$Info,connectionKey);
            moduleWithoutUnits.setToString(moduleWithoutUnits$Info.getToString());
        }
        ViewProxi moduleGroups = null;
        String moduleGroups$String = (String)resultTable.get("moduleGroups");
        if (moduleGroups$String != null) {
            common.ProxiInformation moduleGroups$Info = common.RPCConstantsAndServices.createProxiInformation(moduleGroups$String);
            moduleGroups = view.objects.ViewProxi.createProxi(moduleGroups$Info,connectionKey);
            moduleGroups.setToString(moduleGroups$Info.getToString());
        }
        ViewProxi studyPrograms = null;
        String studyPrograms$String = (String)resultTable.get("studyPrograms");
        if (studyPrograms$String != null) {
            common.ProxiInformation studyPrograms$Info = common.RPCConstantsAndServices.createProxiInformation(studyPrograms$String);
            studyPrograms = view.objects.ViewProxi.createProxi(studyPrograms$Info,connectionKey);
            studyPrograms.setToString(studyPrograms$Info.getToString());
        }
        ViewProxi studyGroups = null;
        String studyGroups$String = (String)resultTable.get("studyGroups");
        if (studyGroups$String != null) {
            common.ProxiInformation studyGroups$Info = common.RPCConstantsAndServices.createProxiInformation(studyGroups$String);
            studyGroups = view.objects.ViewProxi.createProxi(studyGroups$Info,connectionKey);
            studyGroups.setToString(studyGroups$Info.getToString());
        }
        ViewProxi students = null;
        String students$String = (String)resultTable.get("students");
        if (students$String != null) {
            common.ProxiInformation students$Info = common.RPCConstantsAndServices.createProxiInformation(students$String);
            students = view.objects.ViewProxi.createProxi(students$Info,connectionKey);
            students.setToString(students$Info.getToString());
        }
        AdminServerView result$$ = new AdminServer(errors,(UnitLstView)units,(ModuleWithUnitsLstView)moduleWithUnits,(ModuleWithoutUnitsLstView)moduleWithoutUnits,(ModuleGroupLstView)moduleGroups,(StudyProgramLstView)studyPrograms,(StudyGroupLstView)studyGroups,(StudentServerLstView)students, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
        if (this.object == null) return this.getLeafInfo() == 0;
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
    
    public UnitLstView getUnits()throws ModelException{
        return ((AdminServer)this.getTheObject()).getUnits();
    }
    public void setUnits(UnitLstView newValue) throws ModelException {
        ((AdminServer)this.getTheObject()).setUnits(newValue);
    }
    public ModuleWithUnitsLstView getModuleWithUnits()throws ModelException{
        return ((AdminServer)this.getTheObject()).getModuleWithUnits();
    }
    public void setModuleWithUnits(ModuleWithUnitsLstView newValue) throws ModelException {
        ((AdminServer)this.getTheObject()).setModuleWithUnits(newValue);
    }
    public ModuleWithoutUnitsLstView getModuleWithoutUnits()throws ModelException{
        return ((AdminServer)this.getTheObject()).getModuleWithoutUnits();
    }
    public void setModuleWithoutUnits(ModuleWithoutUnitsLstView newValue) throws ModelException {
        ((AdminServer)this.getTheObject()).setModuleWithoutUnits(newValue);
    }
    public ModuleGroupLstView getModuleGroups()throws ModelException{
        return ((AdminServer)this.getTheObject()).getModuleGroups();
    }
    public void setModuleGroups(ModuleGroupLstView newValue) throws ModelException {
        ((AdminServer)this.getTheObject()).setModuleGroups(newValue);
    }
    public StudyProgramLstView getStudyPrograms()throws ModelException{
        return ((AdminServer)this.getTheObject()).getStudyPrograms();
    }
    public void setStudyPrograms(StudyProgramLstView newValue) throws ModelException {
        ((AdminServer)this.getTheObject()).setStudyPrograms(newValue);
    }
    public StudyGroupLstView getStudyGroups()throws ModelException{
        return ((AdminServer)this.getTheObject()).getStudyGroups();
    }
    public void setStudyGroups(StudyGroupLstView newValue) throws ModelException {
        ((AdminServer)this.getTheObject()).setStudyGroups(newValue);
    }
    public StudentServerLstView getStudents()throws ModelException{
        return ((AdminServer)this.getTheObject()).getStudents();
    }
    public void setStudents(StudentServerLstView newValue) throws ModelException {
        ((AdminServer)this.getTheObject()).setStudents(newValue);
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
