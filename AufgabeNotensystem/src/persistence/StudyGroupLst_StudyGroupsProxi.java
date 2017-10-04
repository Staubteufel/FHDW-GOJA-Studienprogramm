package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class StudyGroupLst_StudyGroupsProxi extends PersistentListProxi<StudyGroup4Public> {

  	private StudyGroupList list;
  	private StudyGroupLst owner;

  	public StudyGroupLst_StudyGroupsProxi(StudyGroupLst owner) {
    	this.owner = owner;
  	}
  	public StudyGroupList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new StudyGroupList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theStudyGroupLstFacade.studyGroupsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<StudyGroup4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<StudyGroup4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(StudyGroup4Public entry) throws PersistenceException {
    	if (entry != null) {
      		StudyGroupList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theStudyGroupLstFacade
        	               	.studyGroupsAdd(owner.getId(), entry);
      		}
      		list.add((StudyGroup4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theStudyGroupLstFacade.studyGroupsRem(entry.getListEntryId());
    	}
    	
  	}
  	public StudyGroupLst_StudyGroupsProxi copy(StudyGroupLst owner) throws PersistenceException {
  		StudyGroupLst_StudyGroupsProxi result = new StudyGroupLst_StudyGroupsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<StudyGroup4Public> entries = (this.list == null ? new java.util.Vector<StudyGroup4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			StudyGroup4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theStudyGroupLstFacade
            	           .studyGroupsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
