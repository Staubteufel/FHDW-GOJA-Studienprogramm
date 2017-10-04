package persistence;

public class ModuleWithUnitsLstListEntryProxi extends ModuleWithUnitsLstProxi implements PersistentModuleWithUnitsLstListEntryProxi {

  long entryId;

  public ModuleWithUnitsLstListEntryProxi(long objectId, long entryId) {
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