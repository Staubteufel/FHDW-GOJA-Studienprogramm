package persistence;

public class FailedListEntryProxi extends FailedProxi implements PersistentFailedListEntryProxi {

  long entryId;

  public FailedListEntryProxi(long objectId, long entryId) {
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