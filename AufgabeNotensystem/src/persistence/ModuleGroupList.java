package persistence;

import java.util.*;

public class ModuleGroupList  extends ModuleGroupSearchList{

	protected ModuleGroupList() {
		super();
	}
	public Iterator<ModuleGroup4Public> iterator(PersistentListProxi<ModuleGroup4Public> listProxi) {
		return new PersistentListIterator<ModuleGroup4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (ModuleGroup4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public ModuleGroupList copy() {
		ModuleGroupList result = new ModuleGroupList();
		result.data = (Vector<ModuleGroup4Public>)this.data.clone();
		return result;
	}


}


