package persistence;

public class RemoveModuleGroupCommandListEntryProxi extends RemoveModuleGroupCommandProxi implements PersistentRemoveModuleGroupCommandListEntryProxi {

  long entryId;

  public RemoveModuleGroupCommandListEntryProxi(long objectId, long entryId) {
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