package persistence;

public class OneZeroListEntryProxi extends OneZeroProxi implements PersistentOneZeroListEntryProxi {

  long entryId;

  public OneZeroListEntryProxi(long objectId, long entryId) {
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