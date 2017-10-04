package persistence;

public class ModuleWithoutUnitsLstListEntryProxi extends ModuleWithoutUnitsLstProxi implements PersistentModuleWithoutUnitsLstListEntryProxi {

  long entryId;

  public ModuleWithoutUnitsLstListEntryProxi(long objectId, long entryId) {
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