package persistence;

public class ModuleWithoutUnitsListEntryProxi extends ModuleWithoutUnitsProxi implements PersistentModuleWithoutUnitsListEntryProxi {

  long entryId;

  public ModuleWithoutUnitsListEntryProxi(long objectId, long entryId) {
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