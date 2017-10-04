package persistence;

import java.util.*;

public class ModuleWithoutUnitsList  extends ModuleWithoutUnitsSearchList{

	protected ModuleWithoutUnitsList() {
		super();
	}
	public Iterator<ModuleWithoutUnits4Public> iterator(PersistentListProxi<ModuleWithoutUnits4Public> listProxi) {
		return new PersistentListIterator<ModuleWithoutUnits4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (ModuleWithoutUnits4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public ModuleWithoutUnitsList copy() {
		ModuleWithoutUnitsList result = new ModuleWithoutUnitsList();
		result.data = (Vector<ModuleWithoutUnits4Public>)this.data.clone();
		return result;
	}


}


