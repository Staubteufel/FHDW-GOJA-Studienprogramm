package persistence;

public class StudyGroupLstListEntryProxi extends StudyGroupLstProxi implements PersistentStudyGroupLstListEntryProxi {

  long entryId;

  public StudyGroupLstListEntryProxi(long objectId, long entryId) {
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