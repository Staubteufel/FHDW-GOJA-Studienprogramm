package persistence;

public class TwoZeroListEntryProxi extends TwoZeroProxi implements PersistentTwoZeroListEntryProxi {

  long entryId;

  public TwoZeroListEntryProxi(long objectId, long entryId) {
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