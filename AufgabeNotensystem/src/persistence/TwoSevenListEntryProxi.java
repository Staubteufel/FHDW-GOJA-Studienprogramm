package persistence;

public class TwoSevenListEntryProxi extends TwoSevenProxi implements PersistentTwoSevenListEntryProxi {

  long entryId;

  public TwoSevenListEntryProxi(long objectId, long entryId) {
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