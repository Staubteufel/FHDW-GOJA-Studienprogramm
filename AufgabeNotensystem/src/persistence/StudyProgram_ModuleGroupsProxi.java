package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class StudyProgram_ModuleGroupsProxi extends PersistentListProxi<ModuleGroup4Public> {

  	private ModuleGroupList list;
  	private StudyProgram owner;

  	public StudyProgram_ModuleGroupsProxi(StudyProgram owner) {
    	this.owner = owner;
  	}
  	public ModuleGroupList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new ModuleGroupList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theStudyProgramFacade.moduleGroupsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<ModuleGroup4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<ModuleGroup4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(ModuleGroup4Public entry) throws PersistenceException {
    	if (entry != null) {
      		ModuleGroupList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theStudyProgramFacade
        	               	.moduleGroupsAdd(owner.getId(), entry);
      		}
      		list.add((ModuleGroup4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theStudyProgramFacade.moduleGroupsRem(entry.getListEntryId());
    	}
    	
  	}
  	public StudyProgram_ModuleGroupsProxi copy(StudyProgram owner) throws PersistenceException {
  		StudyProgram_ModuleGroupsProxi result = new StudyProgram_ModuleGroupsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<ModuleGroup4Public> entries = (this.list == null ? new java.util.Vector<ModuleGroup4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			ModuleGroup4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theStudyProgramFacade
            	           .moduleGroupsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
