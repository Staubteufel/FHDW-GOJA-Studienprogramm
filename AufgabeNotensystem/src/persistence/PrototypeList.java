package persistence;

import java.util.*;

public class PrototypeList {

	protected Vector<Prototype4Public> data; //List of proxies
	protected PrototypeList() {
		this.data = new Vector<Prototype4Public>();
	}
	public Iterator<Prototype4Public> iterator(PersistentListProxi<Prototype4Public> listProxi) {
		return new PersistentListIterator<Prototype4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (Prototype4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public PrototypeList copy() {
		PrototypeList result = new PrototypeList();
		result.data = (Vector<Prototype4Public>)this.data.clone();
		return result;
	}


}


