package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class Prototype_PrototypeObserverProxi extends PersistentListProxi<Prototype4Public> {

  	private PrototypeList list;
  	private Prototype owner;

  	public Prototype_PrototypeObserverProxi(Prototype owner) {
    	this.owner = owner;
  	}
  	public PrototypeList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new PrototypeList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.thePrototypeFacade.prototypeObserverGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<Prototype4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<Prototype4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(Prototype4Public entry) throws PersistenceException {
    	if (entry != null) {
      		PrototypeList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().thePrototypeFacade
        	               	.prototypeObserverAdd(owner.getId(), entry);
      		}
      		list.add((Prototype4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().thePrototypeFacade.prototypeObserverRem(entry.getListEntryId());
    	}
    	
  	}
  	public Prototype_PrototypeObserverProxi copy(Prototype owner) throws PersistenceException {
  		Prototype_PrototypeObserverProxi result = new Prototype_PrototypeObserverProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<Prototype4Public> entries = (this.list == null ? new java.util.Vector<Prototype4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			Prototype4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().thePrototypeFacade
            	           .prototypeObserverAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
