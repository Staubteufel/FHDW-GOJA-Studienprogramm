package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class ModuleWithUnitsLst_ModuleWithUnitsProxi extends PersistentListProxi<ModuleWithUnits4Public> {

  	private ModuleWithUnitsList list;
  	private ModuleWithUnitsLst owner;

  	public ModuleWithUnitsLst_ModuleWithUnitsProxi(ModuleWithUnitsLst owner) {
    	this.owner = owner;
  	}
  	public ModuleWithUnitsList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new ModuleWithUnitsList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theModuleWithUnitsLstFacade.moduleWithUnitsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<ModuleWithUnits4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<ModuleWithUnits4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(ModuleWithUnits4Public entry) throws PersistenceException {
    	if (entry != null) {
      		ModuleWithUnitsList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsLstFacade
        	               	.moduleWithUnitsAdd(owner.getId(), entry);
      		}
      		list.add((ModuleWithUnits4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsLstFacade.moduleWithUnitsRem(entry.getListEntryId());
    	}
    	
  	}
  	public ModuleWithUnitsLst_ModuleWithUnitsProxi copy(ModuleWithUnitsLst owner) throws PersistenceException {
  		ModuleWithUnitsLst_ModuleWithUnitsProxi result = new ModuleWithUnitsLst_ModuleWithUnitsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<ModuleWithUnits4Public> entries = (this.list == null ? new java.util.Vector<ModuleWithUnits4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			ModuleWithUnits4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsLstFacade
            	           .moduleWithUnitsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
