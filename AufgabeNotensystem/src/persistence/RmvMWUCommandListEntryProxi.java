package persistence;

public class RmvMWUCommandListEntryProxi extends RmvMWUCommandProxi implements PersistentRmvMWUCommandListEntryProxi {

  long entryId;

  public RmvMWUCommandListEntryProxi(long objectId, long entryId) {
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