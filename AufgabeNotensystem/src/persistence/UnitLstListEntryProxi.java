package persistence;

public class UnitLstListEntryProxi extends UnitLstProxi implements PersistentUnitLstListEntryProxi {

  long entryId;

  public UnitLstListEntryProxi(long objectId, long entryId) {
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