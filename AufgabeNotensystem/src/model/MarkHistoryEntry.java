
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class MarkHistoryEntry extends PersistentObject implements PersistentMarkHistoryEntry{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static MarkHistoryEntry4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theMarkHistoryEntryFacade.getClass(objectId);
        return (MarkHistoryEntry4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static MarkHistoryEntry4Public createMarkHistoryEntry(Mark mark,String comment,java.sql.Timestamp timestamp) throws PersistenceException{
        return createMarkHistoryEntry(mark,comment,timestamp,false);
    }
    
    public static MarkHistoryEntry4Public createMarkHistoryEntry(Mark mark,String comment,java.sql.Timestamp timestamp,boolean delayed$Persistence) throws PersistenceException {
        if (comment == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentMarkHistoryEntry result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMarkHistoryEntryFacade
                .newDelayedMarkHistoryEntry(comment,timestamp);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMarkHistoryEntryFacade
                .newMarkHistoryEntry(comment,timestamp,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("mark", mark);
        final$$Fields.put("comment", comment);
        final$$Fields.put("timestamp", timestamp);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static MarkHistoryEntry4Public createMarkHistoryEntry(Mark mark,String comment,java.sql.Timestamp timestamp,boolean delayed$Persistence,MarkHistoryEntry4Public This) throws PersistenceException {
        if (comment == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentMarkHistoryEntry result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMarkHistoryEntryFacade
                .newDelayedMarkHistoryEntry(comment,timestamp);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMarkHistoryEntryFacade
                .newMarkHistoryEntry(comment,timestamp,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("mark", mark);
        final$$Fields.put("comment", comment);
        final$$Fields.put("timestamp", timestamp);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    @SuppressWarnings("unchecked")
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, boolean inDerived) throws PersistenceException {
        java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf){
                result = (java.util.HashMap<String,Object>)allResults.get(uniqueKey);
                if (result != null) return result;
            }
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, inDerived);
            if (leaf) allResults.put(uniqueKey, result);
            AbstractPersistentRoot mark = (AbstractPersistentRoot)this.getMark();
            if (mark != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    mark, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("mark", proxiInformation);
                
            }
            result.put("comment", this.getComment());
            result.put("timestamp", this.getTimestamp());
        }
        return result;
    }
    
    public MarkHistoryEntry provideCopy() throws PersistenceException{
        MarkHistoryEntry result = this;
        result = new MarkHistoryEntry(this.mark, 
                                      this.comment, 
                                      this.timestamp, 
                                      this.This, 
                                      this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected Mark mark;
    protected String comment;
    protected java.sql.Timestamp timestamp;
    protected PersistentMarkHistoryEntry This;
    
    public MarkHistoryEntry(Mark mark,String comment,java.sql.Timestamp timestamp,PersistentMarkHistoryEntry This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.mark = mark;
        this.comment = comment;
        this.timestamp = timestamp;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 121;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 121) ConnectionHandler.getTheConnectionHandler().theMarkHistoryEntryFacade
            .newMarkHistoryEntry(comment,timestamp,this.getId());
        super.store();
        if(this.getMark() != null){
            this.getMark().store();
            ConnectionHandler.getTheConnectionHandler().theMarkHistoryEntryFacade.markSet(this.getId(), getMark());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theMarkHistoryEntryFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public Mark getMark() throws PersistenceException {
        return this.mark;
    }
    public void setMark(Mark newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.mark)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.mark = (Mark)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMarkHistoryEntryFacade.markSet(this.getId(), newValue);
        }
    }
    public String getComment() throws PersistenceException {
        return this.comment;
    }
    public void setComment(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theMarkHistoryEntryFacade.commentSet(this.getId(), newValue);
        this.comment = newValue;
    }
    public java.sql.Timestamp getTimestamp() throws PersistenceException {
        return this.timestamp;
    }
    public void setTimestamp(java.sql.Timestamp newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theMarkHistoryEntryFacade.timestampSet(this.getId(), newValue);
        this.timestamp = newValue;
    }
    protected void setThis(PersistentMarkHistoryEntry newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentMarkHistoryEntry)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMarkHistoryEntryFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentMarkHistoryEntry getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMarkHistoryEntry result = (PersistentMarkHistoryEntry)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentMarkHistoryEntry)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getMark() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMarkHistoryEntry)This);
		if(this.isTheSameAs(This)){
			this.setMark((Mark)final$$Fields.get("mark"));
			this.setComment((String)final$$Fields.get("comment"));
			this.setTimestamp((java.sql.Timestamp)final$$Fields.get("timestamp"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
