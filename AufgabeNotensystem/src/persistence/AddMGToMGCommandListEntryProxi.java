package persistence;

public class AddMGToMGCommandListEntryProxi extends AddMGToMGCommandProxi implements PersistentAddMGToMGCommandListEntryProxi {

  long entryId;

  public AddMGToMGCommandListEntryProxi(long objectId, long entryId) {
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