
package model;

import persistence.*;

import java.sql.Timestamp;
import java.util.Iterator;

import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class ModuleWithoutUnits extends model.Appr implements PersistentModuleWithoutUnits{
    
    
    public static ModuleWithoutUnits4Public createModuleWithoutUnits(String name,common.Fraction creditPoints,Mark markType) throws PersistenceException{
        return createModuleWithoutUnits(name,creditPoints,markType,false);
    }
    
    public static ModuleWithoutUnits4Public createModuleWithoutUnits(String name,common.Fraction creditPoints,Mark markType,boolean delayed$Persistence) throws PersistenceException {
        PersistentModuleWithoutUnits result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithoutUnitsFacade
                .newDelayedModuleWithoutUnits(name,creditPoints);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithoutUnitsFacade
                .newModuleWithoutUnits(name,creditPoints,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("creditPoints", creditPoints);
        final$$Fields.put("markType", markType);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ModuleWithoutUnits4Public createModuleWithoutUnits(String name,common.Fraction creditPoints,Mark markType,boolean delayed$Persistence,ModuleWithoutUnits4Public This) throws PersistenceException {
        PersistentModuleWithoutUnits result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithoutUnitsFacade
                .newDelayedModuleWithoutUnits(name,creditPoints);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithoutUnitsFacade
                .newModuleWithoutUnits(name,creditPoints,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("creditPoints", creditPoints);
        final$$Fields.put("markType", markType);
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
    
    public ModuleWithoutUnits provideCopy() throws PersistenceException{
        ModuleWithoutUnits result = this;
        result = new ModuleWithoutUnits(this.prototypeObservee, 
                                        this.This, 
                                        this.name, 
                                        this.creditPoints, 
                                        this.markType, 
                                        this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected Mark markType;
    
    public ModuleWithoutUnits(PersistentPrototype prototypeObservee,PersistentPrototype This,String name,common.Fraction creditPoints,Mark markType,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentPrototype)prototypeObservee,(PersistentPrototype)This,(String)name,(common.Fraction)creditPoints,id);
        this.markType = markType;        
    }
    
    static public long getTypeId() {
        return 108;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 108) ConnectionHandler.getTheConnectionHandler().theModuleWithoutUnitsFacade
            .newModuleWithoutUnits(name,creditPoints,this.getId());
        super.store();
        if(this.getMarkType() != null){
            this.getMarkType().store();
            ConnectionHandler.getTheConnectionHandler().theModuleWithoutUnitsFacade.markTypeSet(this.getId(), getMarkType());
        }
        
    }
    
    public Mark getMarkType() throws PersistenceException {
        return this.markType;
    }
    public void setMarkType(Mark newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.markType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.markType = (Mark)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theModuleWithoutUnitsFacade.markTypeSet(this.getId(), newValue);
        }
    }
    public PersistentModuleWithoutUnits getThis() throws PersistenceException {
        if(this.This == null){
            PersistentModuleWithoutUnits result = (PersistentModuleWithoutUnits)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentModuleWithoutUnits)this.This;
    }
    
    public void accept(ApprVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithoutUnits(this);
    }
    public <R> R accept(ApprReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithoutUnits(this);
    }
    public <E extends model.UserException>  void accept(ApprExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithoutUnits(this);
    }
    public <R, E extends model.UserException> R accept(ApprReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithoutUnits(this);
    }
    public void accept(PrototypeVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithoutUnits(this);
    }
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithoutUnits(this);
    }
    public <E extends model.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithoutUnits(this);
    }
    public <R, E extends model.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithoutUnits(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithoutUnits(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithoutUnits(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithoutUnits(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithoutUnits(this);
    }
    public void accept(ModuleGroupsHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithoutUnits(this);
    }
    public <R> R accept(ModuleGroupsHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithoutUnits(this);
    }
    public <E extends model.UserException>  void accept(ModuleGroupsHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithoutUnits(this);
    }
    public <R, E extends model.UserException> R accept(ModuleGroupsHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithoutUnits(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getMarkHistory().getLength() > 0) return 1;
        return 0;
    }
    
    
    public boolean containsModuleGroups(final ModuleGroupsHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		return false;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentModuleWithoutUnits)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
			this.setCreditPoints((common.Fraction)final$$Fields.get("creditPoints"));
			this.setMarkType((Mark)final$$Fields.get("markType"));
		}
    }
    public <T> T strategyModuleGroups(final ModuleGroupsHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result = strategy.ModuleWithoutUnits$$finalize(getThis() );
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public Prototype4Public clonePrototype() 
				throws PersistenceException{
    	ModuleWithoutUnits4Public mwou = ModuleWithoutUnits.createModuleWithoutUnits(getThis().getName()+"(C)", getThis().getCreditPoints(), getThis().getMarkType());
    	getThis().registerProtypeObserver(mwou);
    	return mwou;
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
    public void setMark(final Mark mark, final String comment) 
				throws model.OtherTypeThanSettedException, PersistenceException{
    	if(getThis().getMarkType().fetchTypeAsString() == mark.fetchTypeAsString()) {
		    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		    MarkHistoryEntry4Public mhe = MarkHistoryEntry.createMarkHistoryEntry(mark, comment, timestamp);
		    getThis().getMarkHistory().add(mhe);
    	}
    	else {
    		throw new OtherTypeThanSettedException("OtherTypeThanSettedException");
    	}
    }
    public void updatePrototypeObserver() 
				throws PersistenceException{
    	ModuleWithoutUnits4Public u = (ModuleWithoutUnits4Public) getThis().getPrototypeObserver();
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
