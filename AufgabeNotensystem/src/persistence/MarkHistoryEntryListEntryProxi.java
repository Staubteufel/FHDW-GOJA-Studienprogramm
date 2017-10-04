package persistence;

public class MarkHistoryEntryListEntryProxi extends MarkHistoryEntryProxi implements PersistentMarkHistoryEntryListEntryProxi {

  long entryId;

  public MarkHistoryEntryListEntryProxi(long objectId, long entryId) {
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