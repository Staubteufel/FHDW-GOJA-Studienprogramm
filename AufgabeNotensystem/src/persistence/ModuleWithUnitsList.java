package persistence;

import java.util.*;

public class ModuleWithUnitsList  extends ModuleWithUnitsSearchList{

	protected ModuleWithUnitsList() {
		super();
	}
	public Iterator<ModuleWithUnits4Public> iterator(PersistentListProxi<ModuleWithUnits4Public> listProxi) {
		return new PersistentListIterator<ModuleWithUnits4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (ModuleWithUnits4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public ModuleWithUnitsList copy() {
		ModuleWithUnitsList result = new ModuleWithUnitsList();
		result.data = (Vector<ModuleWithUnits4Public>)this.data.clone();
		return result;
	}


}


