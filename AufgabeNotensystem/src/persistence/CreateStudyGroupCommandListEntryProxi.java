package persistence;

public class CreateStudyGroupCommandListEntryProxi extends CreateStudyGroupCommandProxi implements PersistentCreateStudyGroupCommandListEntryProxi {

  long entryId;

  public CreateStudyGroupCommandListEntryProxi(long objectId, long entryId) {
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