package persistence;

public class FourZeroListEntryProxi extends FourZeroProxi implements PersistentFourZeroListEntryProxi {

  long entryId;

  public FourZeroListEntryProxi(long objectId, long entryId) {
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