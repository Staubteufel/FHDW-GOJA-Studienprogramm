package persistence;

public class SorcMTSWiMWuUCommandListEntryProxi extends SorcMTSWiMWuUCommandProxi implements PersistentSorcMTSWiMWuUCommandListEntryProxi {

  long entryId;

  public SorcMTSWiMWuUCommandListEntryProxi(long objectId, long entryId) {
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