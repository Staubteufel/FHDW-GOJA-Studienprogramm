package persistence;

public class OneThreeListEntryProxi extends OneThreeProxi implements PersistentOneThreeListEntryProxi {

  long entryId;

  public OneThreeListEntryProxi(long objectId, long entryId) {
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