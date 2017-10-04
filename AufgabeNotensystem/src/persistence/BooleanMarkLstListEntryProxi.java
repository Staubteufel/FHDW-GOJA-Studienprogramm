package persistence;

public class BooleanMarkLstListEntryProxi extends BooleanMarkLstProxi implements PersistentBooleanMarkLstListEntryProxi {

  long entryId;

  public BooleanMarkLstListEntryProxi(long objectId, long entryId) {
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