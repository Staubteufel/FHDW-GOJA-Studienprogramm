package persistence;

public class StudyProgramLstListEntryProxi extends StudyProgramLstProxi implements PersistentStudyProgramLstListEntryProxi {

  long entryId;

  public StudyProgramLstListEntryProxi(long objectId, long entryId) {
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