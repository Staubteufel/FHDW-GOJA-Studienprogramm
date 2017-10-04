package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class StudyProgramLst_StudyProgramsProxi extends PersistentListProxi<StudyProgram4Public> {

  	private StudyProgramList list;
  	private StudyProgramLst owner;

  	public StudyProgramLst_StudyProgramsProxi(StudyProgramLst owner) {
    	this.owner = owner;
  	}
  	public StudyProgramList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new StudyProgramList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theStudyProgramLstFacade.studyProgramsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<StudyProgram4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<StudyProgram4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(StudyProgram4Public entry) throws PersistenceException {
    	if (entry != null) {
      		StudyProgramList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theStudyProgramLstFacade
        	               	.studyProgramsAdd(owner.getId(), entry);
      		}
      		list.add((StudyProgram4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theStudyProgramLstFacade.studyProgramsRem(entry.getListEntryId());
    	}
    	
  	}
  	public StudyProgramLst_StudyProgramsProxi copy(StudyProgramLst owner) throws PersistenceException {
  		StudyProgramLst_StudyProgramsProxi result = new StudyProgramLst_StudyProgramsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<StudyProgram4Public> entries = (this.list == null ? new java.util.Vector<StudyProgram4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			StudyProgram4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theStudyProgramLstFacade
            	           .studyProgramsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
