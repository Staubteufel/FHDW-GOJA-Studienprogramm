package persistence;

public class RemoveStudyProgramCommandListEntryProxi extends RemoveStudyProgramCommandProxi implements PersistentRemoveStudyProgramCommandListEntryProxi {

  long entryId;

  public RemoveStudyProgramCommandListEntryProxi(long objectId, long entryId) {
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