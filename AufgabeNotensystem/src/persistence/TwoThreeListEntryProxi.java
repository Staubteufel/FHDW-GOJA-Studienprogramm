package persistence;

public class TwoThreeListEntryProxi extends TwoThreeProxi implements PersistentTwoThreeListEntryProxi {

  long entryId;

  public TwoThreeListEntryProxi(long objectId, long entryId) {
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