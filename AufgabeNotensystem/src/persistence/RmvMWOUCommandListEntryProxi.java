package persistence;

public class RmvMWOUCommandListEntryProxi extends RmvMWOUCommandProxi implements PersistentRmvMWOUCommandListEntryProxi {

  long entryId;

  public RmvMWOUCommandListEntryProxi(long objectId, long entryId) {
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