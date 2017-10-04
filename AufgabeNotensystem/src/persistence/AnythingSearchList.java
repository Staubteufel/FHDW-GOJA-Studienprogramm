package persistence;

public class AnythingSearchList extends DefaultSearchListRoot<Anything> implements Iterable<Anything> {

	public AnythingSearchList(SearchListRoot<Anything> list){
		super(list);
	}
	public AnythingSearchList(){
		super();
	}
	
	public void add (Anything entry) {
		this.getData().add(entry);
	}
	
	public void add(AnythingSearchList list) throws PersistenceException{
		java.util.Iterator<Anything> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<Anything> iterator() {
		return this.getData().iterator();
	}
  	public AnythingSearchList copy() throws PersistenceException {
  		AnythingSearchList result = new AnythingSearchList();
  		result.add(this);
  		return result;
  	}
}


