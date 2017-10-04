package persistence;

public class FiveZeroListEntryProxi extends FiveZeroProxi implements PersistentFiveZeroListEntryProxi {

  long entryId;

  public FiveZeroListEntryProxi(long objectId, long entryId) {
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