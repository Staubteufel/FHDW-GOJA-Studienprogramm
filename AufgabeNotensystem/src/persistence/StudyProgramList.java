package persistence;

import java.util.*;

public class StudyProgramList {

	protected Vector<StudyProgram4Public> data; //List of proxies
	protected StudyProgramList() {
		this.data = new Vector<StudyProgram4Public>();
	}
	public Iterator<StudyProgram4Public> iterator(PersistentListProxi<StudyProgram4Public> listProxi) {
		return new PersistentListIterator<StudyProgram4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (StudyProgram4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public StudyProgramList copy() {
		StudyProgramList result = new StudyProgramList();
		result.data = (Vector<StudyProgram4Public>)this.data.clone();
		return result;
	}


}


