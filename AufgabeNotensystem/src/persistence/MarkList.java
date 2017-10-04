package persistence;

import java.util.*;

public class MarkList  extends MarkSearchList{

	protected MarkList() {
		super();
	}
	public Iterator<Mark> iterator(PersistentListProxi<Mark> listProxi) {
		return new PersistentListIterator<Mark>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (Mark entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public MarkList copy() {
		MarkList result = new MarkList();
		result.data = (Vector<Mark>)this.data.clone();
		return result;
	}


}


