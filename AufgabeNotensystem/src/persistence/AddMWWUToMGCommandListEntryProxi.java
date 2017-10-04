package persistence;

public class AddMWWUToMGCommandListEntryProxi extends AddMWWUToMGCommandProxi implements PersistentAddMWWUToMGCommandListEntryProxi {

  long entryId;

  public AddMWWUToMGCommandListEntryProxi(long objectId, long entryId) {
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