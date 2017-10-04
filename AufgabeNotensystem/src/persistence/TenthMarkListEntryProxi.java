package persistence;

public class TenthMarkListEntryProxi extends TenthMarkProxi implements PersistentTenthMarkListEntryProxi {

  long entryId;

  public TenthMarkListEntryProxi(long objectId, long entryId) {
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