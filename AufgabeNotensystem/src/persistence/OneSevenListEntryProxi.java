package persistence;

public class OneSevenListEntryProxi extends OneSevenProxi implements PersistentOneSevenListEntryProxi {

  long entryId;

  public OneSevenListEntryProxi(long objectId, long entryId) {
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