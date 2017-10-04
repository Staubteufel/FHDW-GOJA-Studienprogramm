package persistence;

public class StudyProgramListEntryProxi extends StudyProgramProxi implements PersistentStudyProgramListEntryProxi {

  long entryId;

  public StudyProgramListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }
  public void setListEntryId(long id){
	this.entryId = id;  
  }

}