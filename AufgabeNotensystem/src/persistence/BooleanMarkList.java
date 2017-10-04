package persistence;

import java.util.*;

public class BooleanMarkList {

	protected Vector<BooleanMark4Public> data; //List of proxies
	protected BooleanMarkList() {
		this.data = new Vector<BooleanMark4Public>();
	}
	public Iterator<BooleanMark4Public> iterator(PersistentListProxi<BooleanMark4Public> listProxi) {
		return new PersistentListIterator<BooleanMark4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (BooleanMark4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public BooleanMarkList copy() {
		BooleanMarkList result = new BooleanMarkList();
		result.data = (Vector<BooleanMark4Public>)this.data.clone();
		return result;
	}


}


