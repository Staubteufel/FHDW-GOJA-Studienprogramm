package persistence;

public class SetActiveSGCommandListEntryProxi extends SetActiveSGCommandProxi implements PersistentSetActiveSGCommandListEntryProxi {

  long entryId;

  public SetActiveSGCommandListEntryProxi(long objectId, long entryId) {
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