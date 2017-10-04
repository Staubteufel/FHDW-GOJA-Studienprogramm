package persistence;

public class AdminServerListEntryProxi extends AdminServerProxi implements PersistentAdminServerListEntryProxi {

  long entryId;

  public AdminServerListEntryProxi(long objectId, long entryId) {
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