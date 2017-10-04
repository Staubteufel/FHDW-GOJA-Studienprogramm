package persistence;

public class AddMGToSPCommandListEntryProxi extends AddMGToSPCommandProxi implements PersistentAddMGToSPCommandListEntryProxi {

  long entryId;

  public AddMGToSPCommandListEntryProxi(long objectId, long entryId) {
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