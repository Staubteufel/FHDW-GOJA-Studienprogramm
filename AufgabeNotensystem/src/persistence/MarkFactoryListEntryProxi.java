package persistence;

public class MarkFactoryListEntryProxi extends MarkFactoryProxi implements PersistentMarkFactoryListEntryProxi {

  long entryId;

  public MarkFactoryListEntryProxi(long objectId, long entryId) {
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