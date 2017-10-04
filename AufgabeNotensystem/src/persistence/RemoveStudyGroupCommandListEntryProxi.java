package persistence;

public class RemoveStudyGroupCommandListEntryProxi extends RemoveStudyGroupCommandProxi implements PersistentRemoveStudyGroupCommandListEntryProxi {

  long entryId;

  public RemoveStudyGroupCommandListEntryProxi(long objectId, long entryId) {
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