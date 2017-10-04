package persistence;

public class RemUFromMWUCommandListEntryProxi extends RemUFromMWUCommandProxi implements PersistentRemUFromMWUCommandListEntryProxi {

  long entryId;

  public RemUFromMWUCommandListEntryProxi(long objectId, long entryId) {
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