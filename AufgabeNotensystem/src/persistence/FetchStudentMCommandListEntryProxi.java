package persistence;

public class FetchStudentMCommandListEntryProxi extends FetchStudentMCommandProxi implements PersistentFetchStudentMCommandListEntryProxi {

  long entryId;

  public FetchStudentMCommandListEntryProxi(long objectId, long entryId) {
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