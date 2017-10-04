package persistence;

public class RemMWWUFromMGCommandListEntryProxi extends RemMWWUFromMGCommandProxi implements PersistentRemMWWUFromMGCommandListEntryProxi {

  long entryId;

  public RemMWWUFromMGCommandListEntryProxi(long objectId, long entryId) {
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