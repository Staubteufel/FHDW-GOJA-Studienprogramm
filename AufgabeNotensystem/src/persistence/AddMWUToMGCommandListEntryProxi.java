package persistence;

public class AddMWUToMGCommandListEntryProxi extends AddMWUToMGCommandProxi implements PersistentAddMWUToMGCommandListEntryProxi {

  long entryId;

  public AddMWUToMGCommandListEntryProxi(long objectId, long entryId) {
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