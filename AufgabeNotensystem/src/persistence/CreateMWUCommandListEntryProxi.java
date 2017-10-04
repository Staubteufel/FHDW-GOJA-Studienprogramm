package persistence;

public class CreateMWUCommandListEntryProxi extends CreateMWUCommandProxi implements PersistentCreateMWUCommandListEntryProxi {

  long entryId;

  public CreateMWUCommandListEntryProxi(long objectId, long entryId) {
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