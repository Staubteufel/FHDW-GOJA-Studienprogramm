package persistence;

public class CreateMWWUCommandListEntryProxi extends CreateMWWUCommandProxi implements PersistentCreateMWWUCommandListEntryProxi {

  long entryId;

  public CreateMWWUCommandListEntryProxi(long objectId, long entryId) {
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