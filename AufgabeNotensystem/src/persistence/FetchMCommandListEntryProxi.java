package persistence;

public class FetchMCommandListEntryProxi extends FetchMCommandProxi implements PersistentFetchMCommandListEntryProxi {

  long entryId;

  public FetchMCommandListEntryProxi(long objectId, long entryId) {
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