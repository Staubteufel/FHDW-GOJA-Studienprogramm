package persistence;

public class RemMWUFromMGCommandListEntryProxi extends RemMWUFromMGCommandProxi implements PersistentRemMWUFromMGCommandListEntryProxi {

  long entryId;

  public RemMWUFromMGCommandListEntryProxi(long objectId, long entryId) {
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