package persistence;

public class CreateModuleGroupCommandListEntryProxi extends CreateModuleGroupCommandProxi implements PersistentCreateModuleGroupCommandListEntryProxi {

  long entryId;

  public CreateModuleGroupCommandListEntryProxi(long objectId, long entryId) {
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