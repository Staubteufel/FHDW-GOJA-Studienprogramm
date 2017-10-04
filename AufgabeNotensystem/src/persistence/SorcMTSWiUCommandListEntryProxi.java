package persistence;

public class SorcMTSWiUCommandListEntryProxi extends SorcMTSWiUCommandProxi implements PersistentSorcMTSWiUCommandListEntryProxi {

  long entryId;

  public SorcMTSWiUCommandListEntryProxi(long objectId, long entryId) {
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