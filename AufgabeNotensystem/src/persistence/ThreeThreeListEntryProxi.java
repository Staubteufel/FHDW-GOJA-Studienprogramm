package persistence;

public class ThreeThreeListEntryProxi extends ThreeThreeProxi implements PersistentThreeThreeListEntryProxi {

  long entryId;

  public ThreeThreeListEntryProxi(long objectId, long entryId) {
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