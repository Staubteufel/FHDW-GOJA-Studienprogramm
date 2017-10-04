package persistence;

public class StudentServerListEntryProxi extends StudentServerProxi implements PersistentStudentServerListEntryProxi {

  long entryId;

  public StudentServerListEntryProxi(long objectId, long entryId) {
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