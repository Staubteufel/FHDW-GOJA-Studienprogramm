package persistence;

public class ModuleWithoutUnitsSearchList extends DefaultSearchListRoot<ModuleWithoutUnits4Public> implements Iterable<ModuleWithoutUnits4Public> {

	public ModuleWithoutUnitsSearchList(SearchListRoot<ModuleWithoutUnits4Public> list){
		super(list);
	}
	public ModuleWithoutUnitsSearchList(){
		super();
	}
	
	public void add (ModuleWithoutUnits4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(ModuleWithoutUnitsSearchList list) throws PersistenceException{
		java.util.Iterator<ModuleWithoutUnits4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<ModuleWithoutUnits4Public> iterator() {
		return this.getData().iterator();
	}
  	public ModuleWithoutUnitsSearchList copy() throws PersistenceException {
  		ModuleWithoutUnitsSearchList result = new ModuleWithoutUnitsSearchList();
  		result.add(this);
  		return result;
  	}
}


