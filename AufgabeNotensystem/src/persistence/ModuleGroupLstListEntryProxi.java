package persistence;

public class ModuleGroupLstListEntryProxi extends ModuleGroupLstProxi implements PersistentModuleGroupLstListEntryProxi {

  long entryId;

  public ModuleGroupLstListEntryProxi(long objectId, long entryId) {
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