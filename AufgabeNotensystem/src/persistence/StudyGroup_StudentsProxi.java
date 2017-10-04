package persistence;

import model.*;
import java.util.Hashtable;

public class StudyGroup_StudentsProxi extends PersistentMapProxi<String,StudentServer4Public>{

	private StudyGroup owner;

	private Hashtable<String, StudentServer4Public> data;
	private boolean inSync;

	public StudyGroup_StudentsProxi(StudyGroup owner) {
		this.owner = owner;
		this.data = new Hashtable<String, StudentServer4Public>();
		this.inSync = false;
	}

	public synchronized StudentServer4Public put(String key, StudentServer4Public entry) throws PersistenceException {
		if (key == null) throw new PersistenceException("Null not allowed for map keys!",0);
		if (entry == null) throw new PersistenceException("Null not allowed for map values!",0);
		StudentServer4Public result = null;
		
		if (!this.owner.isDelayed$Persistence()){
			entry.store();
			result = ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade.studentsAdd(owner.getId(), key, entry);
			if (this.inSync){
				StudentServer4Public mapEntry = this.get(key);
				this.data.put(key,mapEntry);
			} else {
				this.data.put(key,entry);
			}
		} else {
			result = this.data.put(key, entry);
		}
		
		return result;
	}

	public synchronized StudentServer4Public get(String key) throws PersistenceException {
		StudentServer4Public result = this.data.get(key);
		if (result == null && !this.owner.isDelayed$Persistence()) {
			result = ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade.studentsGet(owner.getId(), key);
			if (result != null)
				this.data.put(key, result);
		}
		return result;
	}

	public synchronized StudentServer4Public remove(String key) throws PersistenceException {
		
		StudentServer4Public result = this.data.remove(key);
		if (!this.owner.isDelayed$Persistence()){
			result = ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade.studentsRem(this.owner.getId(), key);
		}
		return result;
	}
	protected void removeEntry(StudentServer4Public entry) throws PersistenceException {
    	
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade.studentsRemEntr(((PersistentListEntryProxi)entry).getListEntryId());
    	}
  	}
	@SuppressWarnings("unchecked")
	public StudyGroup_StudentsProxi copy(StudyGroup owner) throws PersistenceException {
		StudyGroup_StudentsProxi result = new StudyGroup_StudentsProxi(owner);
		result.data = (Hashtable<String, StudentServer4Public>) this.data.clone();
		return result;
	}
	
	public StudentServerSearchList getValues() throws PersistenceException {
		if (!this.owner.isDelayed$Persistence() && !this.inSync) this.synchroniseWithDatabase();
		StudentServerSearchList result = new StudentServerSearchList(); 
		if (this.owner.isDelayed$Persistence()){ 
			for (StudentServer4Public current : this.data.values()) result.add(current);
		} else {
			java.util.TreeSet<PersistentListEntryProxi> sorter 
					= new java.util.TreeSet<PersistentListEntryProxi>(new java.util.Comparator<PersistentListEntryProxi>() {
				public int compare(PersistentListEntryProxi o1,PersistentListEntryProxi o2) {
					return new Long(o1.getListEntryId()).compareTo(o2.getListEntryId());
				}
			});
			for (StudentServer4Public current : this.data.values()) sorter.add((PersistentListEntryProxi) current);
			for (PersistentListEntryProxi current : sorter) result.add((StudentServer4Public) current);
		}
		return result;
	}
	private void synchroniseWithDatabase() throws PersistenceException {
		if(!this.inSync){
			this.data = ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade.studentsGetValues(owner.getId());
			this.inSync = true;
		}
	}
	public java.util.Iterator<StudentServer4Public> iterator() {
		try {
			if (!this.owner.isDelayed$Persistence() && !this.inSync) this.synchroniseWithDatabase();
			return new PersistentMapIterator<String,StudentServer4Public>(this, this.data);
		} catch (PersistenceException e) {
			throw new PersistenceError(e);
		}
	}
	public void store() throws PersistenceException {
		java.util.Iterator<String> keys = this.data.keySet().iterator();
		while (keys.hasNext()){
			String key = keys.next();
			data.get(key).store();
			ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade.studentsAdd(owner.getId(), key, data.get(key));
		}
		this.synchroniseWithDatabase();
	}
}
