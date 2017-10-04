package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class BooleanMarkLst_BooleanMarksProxi extends PersistentListProxi<BooleanMark4Public> {

  	private BooleanMarkList list;
  	private BooleanMarkLst owner;

  	public BooleanMarkLst_BooleanMarksProxi(BooleanMarkLst owner) {
    	this.owner = owner;
  	}
  	public BooleanMarkList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new BooleanMarkList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theBooleanMarkLstFacade.booleanMarksGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<BooleanMark4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<BooleanMark4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(BooleanMark4Public entry) throws PersistenceException {
    	if (entry != null) {
      		BooleanMarkList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theBooleanMarkLstFacade
        	               	.booleanMarksAdd(owner.getId(), entry);
      		}
      		list.add((BooleanMark4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theBooleanMarkLstFacade.booleanMarksRem(entry.getListEntryId());
    	}
    	
  	}
  	public BooleanMarkLst_BooleanMarksProxi copy(BooleanMarkLst owner) throws PersistenceException {
  		BooleanMarkLst_BooleanMarksProxi result = new BooleanMarkLst_BooleanMarksProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<BooleanMark4Public> entries = (this.list == null ? new java.util.Vector<BooleanMark4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			BooleanMark4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theBooleanMarkLstFacade
            	           .booleanMarksAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
