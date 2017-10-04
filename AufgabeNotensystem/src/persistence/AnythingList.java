package persistence;

import java.util.*;

public class AnythingList  extends AnythingSearchList{

	protected AnythingList() {
		super();
	}
	public Iterator<Anything> iterator(PersistentListProxi<Anything> listProxi) {
		return new PersistentListIterator<Anything>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (Anything entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public AnythingList copy() {
		AnythingList result = new AnythingList();
		result.data = (Vector<Anything>)this.data.clone();
		return result;
	}


}


