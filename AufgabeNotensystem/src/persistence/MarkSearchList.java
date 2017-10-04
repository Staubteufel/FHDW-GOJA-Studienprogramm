package persistence;

public class MarkSearchList extends DefaultSearchListRoot<Mark> implements Iterable<Mark> {

	public MarkSearchList(SearchListRoot<Mark> list){
		super(list);
	}
	public MarkSearchList(){
		super();
	}
	
	public void add (Mark entry) {
		this.getData().add(entry);
	}
	
	public void add(MarkSearchList list) throws PersistenceException{
		java.util.Iterator<Mark> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<Mark> iterator() {
		return this.getData().iterator();
	}
  	public MarkSearchList copy() throws PersistenceException {
  		MarkSearchList result = new MarkSearchList();
  		result.add(this);
  		return result;
  	}
}


