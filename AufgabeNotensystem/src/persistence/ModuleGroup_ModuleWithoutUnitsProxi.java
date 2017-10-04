package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class ModuleGroup_ModuleWithoutUnitsProxi extends PersistentListProxi<ModuleWithoutUnits4Public> {

  	private ModuleWithoutUnitsList list;
  	private ModuleGroup owner;

  	public ModuleGroup_ModuleWithoutUnitsProxi(ModuleGroup owner) {
    	this.owner = owner;
  	}
  	public ModuleWithoutUnitsList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new ModuleWithoutUnitsList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theModuleGroupFacade.moduleWithoutUnitsGet(this.owner.getId());
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
  	public void add(ModuleWithoutUnits4Public entry) throws PersistenceException , model.CycleException{
    	if (entry != null) {
      		if (entry.containsModuleGroups(this.owner)) throw new model.CycleException("Cycle in ModuleGroups detected!");
			ModuleWithoutUnitsList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theModuleGroupFacade
        	               	.moduleWithoutUnitsAdd(owner.getId(), entry);
      		}
      		list.add((ModuleWithoutUnits4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theModuleGroupFacade.moduleWithoutUnitsRem(entry.getListEntryId());
    	}
    	
  	}
  	public ModuleGroup_ModuleWithoutUnitsProxi copy(ModuleGroup owner) throws PersistenceException {
  		ModuleGroup_ModuleWithoutUnitsProxi result = new ModuleGroup_ModuleWithoutUnitsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<ModuleWithoutUnits4Public> entries = (this.list == null ? new java.util.Vector<ModuleWithoutUnits4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			ModuleWithoutUnits4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theModuleGroupFacade
            	           .moduleWithoutUnitsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
