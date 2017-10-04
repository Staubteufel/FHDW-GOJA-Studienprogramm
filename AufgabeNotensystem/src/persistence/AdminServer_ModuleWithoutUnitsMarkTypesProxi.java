package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class AdminServer_ModuleWithoutUnitsMarkTypesProxi extends PersistentListProxi<Mark> {

  	private MarkList list;
  	private AdminServer owner;

  	public AdminServer_ModuleWithoutUnitsMarkTypesProxi(AdminServer owner) {
    	this.owner = owner;
  	}
  	public MarkList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new MarkList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theAdminServerFacade.ModuleWithoutUnitsMarkTypesGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<Mark> getData() {
		return this.list.data;
	}
 
  	public Iterator<Mark> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(Mark entry) throws PersistenceException {
    	if (entry != null) {
      		MarkList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theAdminServerFacade
        	               	.ModuleWithoutUnitsMarkTypesAdd(owner.getId(), entry);
      		}
      		list.add((Mark)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theAdminServerFacade.ModuleWithoutUnitsMarkTypesRem(entry.getListEntryId());
    	}
    	
  	}
  	public AdminServer_ModuleWithoutUnitsMarkTypesProxi copy(AdminServer owner) throws PersistenceException {
  		AdminServer_ModuleWithoutUnitsMarkTypesProxi result = new AdminServer_ModuleWithoutUnitsMarkTypesProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Mark> entries = (this.list == null ? new java.util.Vector<Mark>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Mark current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theAdminServerFacade
            	           .ModuleWithoutUnitsMarkTypesAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
