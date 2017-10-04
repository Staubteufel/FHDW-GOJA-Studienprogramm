
package model;

import persistence.*;

import java.sql.Timestamp;
import java.util.Iterator;

import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class Unit extends model.Appr implements PersistentUnit{
    
    
    public static Unit4Public createUnit(String name,common.Fraction creditPoints) throws PersistenceException{
        return createUnit(name,creditPoints,false);
    }
    
    public static Unit4Public createUnit(String name,common.Fraction creditPoints,boolean delayed$Persistence) throws PersistenceException {
        PersistentUnit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theUnitFacade
                .newDelayedUnit(name,creditPoints);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theUnitFacade
                .newUnit(name,creditPoints,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("creditPoints", creditPoints);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Unit4Public createUnit(String name,common.Fraction creditPoints,boolean delayed$Persistence,Unit4Public This) throws PersistenceException {
        PersistentUnit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theUnitFacade
                .newDelayedUnit(name,creditPoints);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theUnitFacade
                .newUnit(name,creditPoints,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("creditPoints", creditPoints);
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
        }
        return result;
    }
    
    public Unit provideCopy() throws PersistenceException{
        Unit result = this;
        result = new Unit(this.prototypeObservee, 
                          this.This, 
                          this.name, 
                          this.creditPoints, 
                          this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Unit(PersistentPrototype prototypeObservee,PersistentPrototype This,String name,common.Fraction creditPoints,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentPrototype)prototypeObservee,(PersistentPrototype)This,(String)name,(common.Fraction)creditPoints,id);        
    }
    
    static public long getTypeId() {
        return 106;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 106) ConnectionHandler.getTheConnectionHandler().theUnitFacade
            .newUnit(name,creditPoints,this.getId());
        super.store();
        
    }
    
    public PersistentUnit getThis() throws PersistenceException {
        if(this.This == null){
            PersistentUnit result = (PersistentUnit)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentUnit)this.This;
    }
    
    public void accept(ApprVisitor visitor) throws PersistenceException {
        visitor.handleUnit(this);
    }
    public <R> R accept(ApprReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnit(this);
    }
    public <E extends model.UserException>  void accept(ApprExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends model.UserException> R accept(ApprReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnit(this);
    }
    public void accept(PrototypeVisitor visitor) throws PersistenceException {
        visitor.handleUnit(this);
    }
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnit(this);
    }
    public <E extends model.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends model.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnit(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnit(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnit(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getMarkHistory().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentUnit)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
			this.setCreditPoints((common.Fraction)final$$Fields.get("creditPoints"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public Prototype4Public clonePrototype() 
				throws PersistenceException{
        Unit4Public u = Unit.createUnit(getThis().getName(), getThis().getCreditPoints());
        getThis().registerProtypeObserver(u);
        return u;
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{

        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	MarkHistoryEntry4Public mhe = MarkHistoryEntry.createMarkHistoryEntry(NoneMark.createNoneMark(), "INIT", timestamp);
        getThis().getMarkHistory().add(mhe);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
    }
    public void setMark(final ThirdMark4Public mark, final String comment) 
				throws PersistenceException{
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	MarkHistoryEntry4Public mhe = MarkHistoryEntry.createMarkHistoryEntry(mark, comment, timestamp);
        getThis().getMarkHistory().add(mhe);
    }
    public void updatePrototypeObserver() 
				throws PersistenceException{
        Unit4Public u = (Unit4Public) getThis().getPrototypeObserver();
        getThis().setCreditPoints(u.getCreditPoints());
    }
    
    
    // Start of section that contains overridden operations only.
    
    public Mark fetchMark() 
				throws PersistenceException{
    	Iterator<MarkHistoryEntry4Public> i = getThis().getMarkHistory().iterator();
    	MarkHistoryEntry4Public lastMark = i.next();
    	while(i.hasNext()) {
    		lastMark = i.next();
    	}
    	
    	return lastMark.getMark();
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
