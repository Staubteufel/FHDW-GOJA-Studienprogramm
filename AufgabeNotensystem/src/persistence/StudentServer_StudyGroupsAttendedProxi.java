package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class StudentServer_StudyGroupsAttendedProxi extends PersistentListProxi<StudyGroup4Public> {

  	private StudyGroupList list;
  	private StudentServer owner;

  	public StudentServer_StudyGroupsAttendedProxi(StudentServer owner) {
    	this.owner = owner;
  	}
  	public StudyGroupList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new StudyGroupList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theStudentServerFacade.studyGroupsAttendedGet(this.owner.getId());
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
        		entryId = ConnectionHandler.getTheConnectionHandler().theStudentServerFacade
        	               	.studyGroupsAttendedAdd(owner.getId(), entry);
      		}
      		list.add((StudyGroup4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theStudentServerFacade.studyGroupsAttendedRem(entry.getListEntryId());
    	}
    	
  	}
  	public StudentServer_StudyGroupsAttendedProxi copy(StudentServer owner) throws PersistenceException {
  		StudentServer_StudyGroupsAttendedProxi result = new StudentServer_StudyGroupsAttendedProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<StudyGroup4Public> entries = (this.list == null ? new java.util.Vector<StudyGroup4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			StudyGroup4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theStudentServerFacade
            	           .studyGroupsAttendedAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
