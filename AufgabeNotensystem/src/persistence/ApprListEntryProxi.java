package persistence;

public abstract class ApprListEntryProxi extends ApprProxi implements PersistentApprListEntryProxi {

  long entryId;

  public ApprListEntryProxi(long objectId, long entryId) {
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