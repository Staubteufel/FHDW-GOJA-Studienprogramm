package persistence;

public class RemMGFromMGCommandListEntryProxi extends RemMGFromMGCommandProxi implements PersistentRemMGFromMGCommandListEntryProxi {

  long entryId;

  public RemMGFromMGCommandListEntryProxi(long objectId, long entryId) {
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