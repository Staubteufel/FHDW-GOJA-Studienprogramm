package persistence;

public class NoneMarkListEntryProxi extends NoneMarkProxi implements PersistentNoneMarkListEntryProxi {

  long entryId;

  public NoneMarkListEntryProxi(long objectId, long entryId) {
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