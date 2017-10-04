package persistence;

public class ThirdMarkLstListEntryProxi extends ThirdMarkLstProxi implements PersistentThirdMarkLstListEntryProxi {

  long entryId;

  public ThirdMarkLstListEntryProxi(long objectId, long entryId) {
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