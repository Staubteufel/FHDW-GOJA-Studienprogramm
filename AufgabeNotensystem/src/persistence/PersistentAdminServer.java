package persistence;


public interface PersistentAdminServer extends PersistentService, AdminServer4Public {
    
    public void setUnits(UnitLst4Public newValue) throws PersistenceException ;
    public void setModuleWithUnits(ModuleWithUnitsLst4Public newValue) throws PersistenceException ;
    public void setModuleWithoutUnits(ModuleWithoutUnitsLst4Public newValue) throws PersistenceException ;
    public void setModuleGroups(ModuleGroupLst4Public newValue) throws PersistenceException ;
    public void setStudyPrograms(StudyProgramLst4Public newValue) throws PersistenceException ;
    public void setStudyGroups(StudyGroupLst4Public newValue) throws PersistenceException ;
    public void setStudents(StudentServerLst4Public newValue) throws PersistenceException ;
    public void setThirdMarks(ThirdMarkLst4Public newValue) throws PersistenceException ;
    public PersistentAdminServer getThis() throws PersistenceException ;
    
    

}

