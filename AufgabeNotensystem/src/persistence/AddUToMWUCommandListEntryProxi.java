package persistence;

public class AddUToMWUCommandListEntryProxi extends AddUToMWUCommandProxi implements PersistentAddUToMWUCommandListEntryProxi {

  long entryId;

  public AddUToMWUCommandListEntryProxi(long objectId, long entryId) {
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