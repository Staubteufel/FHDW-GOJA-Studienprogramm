package persistence;

public class ThreeZeroListEntryProxi extends ThreeZeroProxi implements PersistentThreeZeroListEntryProxi {

  long entryId;

  public ThreeZeroListEntryProxi(long objectId, long entryId) {
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