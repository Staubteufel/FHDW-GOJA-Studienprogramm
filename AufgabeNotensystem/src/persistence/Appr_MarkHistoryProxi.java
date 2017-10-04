package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class Appr_MarkHistoryProxi extends PersistentListProxi<MarkHistoryEntry4Public> {

  	private MarkHistoryEntryList list;
  	private Appr owner;

  	public Appr_MarkHistoryProxi(Appr owner) {
    	this.owner = owner;
  	}
  	public MarkHistoryEntryList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new MarkHistoryEntryList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theApprFacade.markHistoryGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<MarkHistoryEntry4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<MarkHistoryEntry4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(MarkHistoryEntry4Public entry) throws PersistenceException {
    	if (entry != null) {
      		MarkHistoryEntryList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theApprFacade
        	               	.markHistoryAdd(owner.getId(), entry);
      		}
      		list.add((MarkHistoryEntry4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theApprFacade.markHistoryRem(entry.getListEntryId());
    	}
    	
  	}
  	public Appr_MarkHistoryProxi copy(Appr owner) throws PersistenceException {
  		Appr_MarkHistoryProxi result = new Appr_MarkHistoryProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<MarkHistoryEntry4Public> entries = (this.list == null ? new java.util.Vector<MarkHistoryEntry4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			MarkHistoryEntry4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theApprFacade
            	           .markHistoryAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
