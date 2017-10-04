package persistence;

import java.util.*;

public class MarkHistoryEntryList {

	protected Vector<MarkHistoryEntry4Public> data; //List of proxies
	protected MarkHistoryEntryList() {
		this.data = new Vector<MarkHistoryEntry4Public>();
	}
	public Iterator<MarkHistoryEntry4Public> iterator(PersistentListProxi<MarkHistoryEntry4Public> listProxi) {
		return new PersistentListIterator<MarkHistoryEntry4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (MarkHistoryEntry4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public MarkHistoryEntryList copy() {
		MarkHistoryEntryList result = new MarkHistoryEntryList();
		result.data = (Vector<MarkHistoryEntry4Public>)this.data.clone();
		return result;
	}


}


