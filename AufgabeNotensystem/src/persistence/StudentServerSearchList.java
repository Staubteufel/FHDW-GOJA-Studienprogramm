package persistence;

public class StudentServerSearchList extends DefaultSearchListRoot<StudentServer4Public> implements Iterable<StudentServer4Public> {

	public StudentServerSearchList(SearchListRoot<StudentServer4Public> list){
		super(list);
	}
	public StudentServerSearchList(){
		super();
	}
	
	public void add (StudentServer4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(StudentServerSearchList list) throws PersistenceException{
		java.util.Iterator<StudentServer4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<StudentServer4Public> iterator() {
		return this.getData().iterator();
	}
  	public StudentServerSearchList copy() throws PersistenceException {
  		StudentServerSearchList result = new StudentServerSearchList();
  		result.add(this);
  		return result;
  	}
}


