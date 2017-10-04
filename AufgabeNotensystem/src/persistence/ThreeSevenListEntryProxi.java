package persistence;

public class ThreeSevenListEntryProxi extends ThreeSevenProxi implements PersistentThreeSevenListEntryProxi {

  long entryId;

  public ThreeSevenListEntryProxi(long objectId, long entryId) {
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