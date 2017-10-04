package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class UnitLst_UnitsProxi extends PersistentListProxi<Unit4Public> {

  	private UnitList list;
  	private UnitLst owner;

  	public UnitLst_UnitsProxi(UnitLst owner) {
    	this.owner = owner;
  	}
  	public UnitList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new UnitList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theUnitLstFacade.unitsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<Unit4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<Unit4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(Unit4Public entry) throws PersistenceException {
    	if (entry != null) {
      		UnitList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theUnitLstFacade
        	               	.unitsAdd(owner.getId(), entry);
      		}
      		list.add((Unit4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theUnitLstFacade.unitsRem(entry.getListEntryId());
    	}
    	
  	}
  	public UnitLst_UnitsProxi copy(UnitLst owner) throws PersistenceException {
  		UnitLst_UnitsProxi result = new UnitLst_UnitsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Unit4Public> entries = (this.list == null ? new java.util.Vector<Unit4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Unit4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theUnitLstFacade
            	           .unitsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
