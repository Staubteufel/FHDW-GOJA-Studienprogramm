package persistence;

public class BooleanMarkListEntryProxi extends BooleanMarkProxi implements PersistentBooleanMarkListEntryProxi {

  long entryId;

  public BooleanMarkListEntryProxi(long objectId, long entryId) {
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