package persistence;



import model.visitor.*;

public class MarkHistoryEntryProxi extends PersistentProxi implements PersistentMarkHistoryEntry{
    
    public MarkHistoryEntryProxi(long objectId) {
        super(objectId);
    }
    public MarkHistoryEntryProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 121;
    }
    
    public Mark getMark() throws PersistenceException {
        return ((PersistentMarkHistoryEntry)this.getTheObject()).getMark();
    }
    public void setMark(Mark newValue) throws PersistenceException {
        ((PersistentMarkHistoryEntry)this.getTheObject()).setMark(newValue);
    }
    public String getComment() throws PersistenceException {
        return ((PersistentMarkHistoryEntry)this.getTheObject()).getComment();
    }
    public void setComment(String newValue) throws PersistenceException {
        ((PersistentMarkHistoryEntry)this.getTheObject()).setComment(newValue);
    }
    public java.sql.Timestamp getTimestamp() throws PersistenceException {
        return ((PersistentMarkHistoryEntry)this.getTheObject()).getTimestamp();
    }
    public void setTimestamp(java.sql.Timestamp newValue) throws PersistenceException {
        ((PersistentMarkHistoryEntry)this.getTheObject()).setTimestamp(newValue);
    }
    public PersistentMarkHistoryEntry getThis() throws PersistenceException {
        return ((PersistentMarkHistoryEntry)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMarkHistoryEntry(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMarkHistoryEntry(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMarkHistoryEntry(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMarkHistoryEntry(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMarkHistoryEntry)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMarkHistoryEntry)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMarkHistoryEntry)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMarkHistoryEntry)this.getTheObject()).initializeOnInstantiation();
    }

    
}
