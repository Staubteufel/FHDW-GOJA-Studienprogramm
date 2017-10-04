package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class AdminServer_ModuleWithoutUnitsMarksProxi extends PersistentListProxi<Anything> {

  	private AnythingList list;
  	private AdminServer owner;

  	public AdminServer_ModuleWithoutUnitsMarksProxi(AdminServer owner) {
    	this.owner = owner;
  	}
  	public AnythingList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new AnythingList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theAdminServerFacade.ModuleWithoutUnitsMarksGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<Anything> getData() {
		return this.list.data;
	}
 
  	public Iterator<Anything> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(Anything entry) throws PersistenceException {
    	if (entry != null) {
      		AnythingList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theAdminServerFacade
        	               	.ModuleWithoutUnitsMarksAdd(owner.getId(), entry);
      		}
      		list.add((Anything)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theAdminServerFacade.ModuleWithoutUnitsMarksRem(entry.getListEntryId());
    	}
    	
  	}
  	public AdminServer_ModuleWithoutUnitsMarksProxi copy(AdminServer owner) throws PersistenceException {
  		AdminServer_ModuleWithoutUnitsMarksProxi result = new AdminServer_ModuleWithoutUnitsMarksProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Anything> entries = (this.list == null ? new java.util.Vector<Anything>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Anything current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theAdminServerFacade
            	           .ModuleWithoutUnitsMarksAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
