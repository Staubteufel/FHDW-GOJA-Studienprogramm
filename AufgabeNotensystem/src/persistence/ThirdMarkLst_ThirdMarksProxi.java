package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class ThirdMarkLst_ThirdMarksProxi extends PersistentListProxi<ThirdMark4Public> {

  	private ThirdMarkList list;
  	private ThirdMarkLst owner;

  	public ThirdMarkLst_ThirdMarksProxi(ThirdMarkLst owner) {
    	this.owner = owner;
  	}
  	public ThirdMarkList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new ThirdMarkList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theThirdMarkLstFacade.thirdMarksGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<ThirdMark4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<ThirdMark4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(ThirdMark4Public entry) throws PersistenceException {
    	if (entry != null) {
      		ThirdMarkList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theThirdMarkLstFacade
        	               	.thirdMarksAdd(owner.getId(), entry);
      		}
      		list.add((ThirdMark4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theThirdMarkLstFacade.thirdMarksRem(entry.getListEntryId());
    	}
    	
  	}
  	public ThirdMarkLst_ThirdMarksProxi copy(ThirdMarkLst owner) throws PersistenceException {
  		ThirdMarkLst_ThirdMarksProxi result = new ThirdMarkLst_ThirdMarksProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<ThirdMark4Public> entries = (this.list == null ? new java.util.Vector<ThirdMark4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			ThirdMark4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theThirdMarkLstFacade
            	           .thirdMarksAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
