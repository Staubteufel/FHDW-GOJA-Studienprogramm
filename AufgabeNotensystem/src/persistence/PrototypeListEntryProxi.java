package persistence;

public abstract class PrototypeListEntryProxi extends PrototypeProxi implements PersistentPrototypeListEntryProxi {

  long entryId;

  public PrototypeListEntryProxi(long objectId, long entryId) {
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