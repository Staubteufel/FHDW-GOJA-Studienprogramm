package persistence;

public abstract class MarkNotCalculableListEntryProxi extends MarkNotCalculableProxi implements PersistentMarkNotCalculableListEntryProxi {

  long entryId;

  public MarkNotCalculableListEntryProxi(long objectId, long entryId) {
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