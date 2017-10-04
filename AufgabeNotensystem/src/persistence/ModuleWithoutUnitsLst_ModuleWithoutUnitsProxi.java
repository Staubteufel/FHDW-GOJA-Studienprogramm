package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class ModuleWithoutUnitsLst_ModuleWithoutUnitsProxi extends PersistentListProxi<ModuleWithoutUnits4Public> {

  	private ModuleWithoutUnitsList list;
  	private ModuleWithoutUnitsLst owner;

  	public ModuleWithoutUnitsLst_ModuleWithoutUnitsProxi(ModuleWithoutUnitsLst owner) {
    	this.owner = owner;
  	}
  	public ModuleWithoutUnitsList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new ModuleWithoutUnitsList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theModuleWithoutUnitsLstFacade.moduleWithoutUnitsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<ModuleWithoutUnits4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<ModuleWithoutUnits4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(ModuleWithoutUnits4Public entry) throws PersistenceException {
    	if (entry != null) {
      		ModuleWithoutUnitsList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theModuleWithoutUnitsLstFacade
        	               	.moduleWithoutUnitsAdd(owner.getId(), entry);
      		}
      		list.add((ModuleWithoutUnits4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theModuleWithoutUnitsLstFacade.moduleWithoutUnitsRem(entry.getListEntryId());
    	}
    	
  	}
  	public ModuleWithoutUnitsLst_ModuleWithoutUnitsProxi copy(ModuleWithoutUnitsLst owner) throws PersistenceException {
  		ModuleWithoutUnitsLst_ModuleWithoutUnitsProxi result = new ModuleWithoutUnitsLst_ModuleWithoutUnitsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<ModuleWithoutUnits4Public> entries = (this.list == null ? new java.util.Vector<ModuleWithoutUnits4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			ModuleWithoutUnits4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theModuleWithoutUnitsLstFacade
            	           .moduleWithoutUnitsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
