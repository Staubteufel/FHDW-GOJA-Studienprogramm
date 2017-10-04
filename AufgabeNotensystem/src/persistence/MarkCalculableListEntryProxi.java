package persistence;

public abstract class MarkCalculableListEntryProxi extends MarkCalculableProxi implements PersistentMarkCalculableListEntryProxi {

  long entryId;

  public MarkCalculableListEntryProxi(long objectId, long entryId) {
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