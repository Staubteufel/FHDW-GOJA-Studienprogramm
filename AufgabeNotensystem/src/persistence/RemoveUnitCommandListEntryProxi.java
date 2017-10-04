package persistence;

public class RemoveUnitCommandListEntryProxi extends RemoveUnitCommandProxi implements PersistentRemoveUnitCommandListEntryProxi {

  long entryId;

  public RemoveUnitCommandListEntryProxi(long objectId, long entryId) {
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