package persistence;

public class RemMGFromSPCommandListEntryProxi extends RemMGFromSPCommandProxi implements PersistentRemMGFromSPCommandListEntryProxi {

  long entryId;

  public RemMGFromSPCommandListEntryProxi(long objectId, long entryId) {
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