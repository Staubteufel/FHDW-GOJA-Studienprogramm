package persistence;

public class ThirdMarkListEntryProxi extends ThirdMarkProxi implements PersistentThirdMarkListEntryProxi {

  long entryId;

  public ThirdMarkListEntryProxi(long objectId, long entryId) {
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