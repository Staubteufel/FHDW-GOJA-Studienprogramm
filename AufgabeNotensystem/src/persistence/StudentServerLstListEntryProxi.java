package persistence;

public class StudentServerLstListEntryProxi extends StudentServerLstProxi implements PersistentStudentServerLstListEntryProxi {

  long entryId;

  public StudentServerLstListEntryProxi(long objectId, long entryId) {
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