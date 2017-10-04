package persistence;

import java.util.*;

public class ThirdMarkList {

	protected Vector<ThirdMark4Public> data; //List of proxies
	protected ThirdMarkList() {
		this.data = new Vector<ThirdMark4Public>();
	}
	public Iterator<ThirdMark4Public> iterator(PersistentListProxi<ThirdMark4Public> listProxi) {
		return new PersistentListIterator<ThirdMark4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (ThirdMark4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public ThirdMarkList copy() {
		ThirdMarkList result = new ThirdMarkList();
		result.data = (Vector<ThirdMark4Public>)this.data.clone();
		return result;
	}


}


