
package model;

import persistence.*;
import common.Fraction;
import java.math.BigInteger;
import java.util.Iterator;

import model.visitor.*;


/* Additional import section end */

public class ModuleWithUnits extends model.Appr implements PersistentModuleWithUnits{
    
    
    public static ModuleWithUnits4Public createModuleWithUnits(String name,common.Fraction creditPoints) throws PersistenceException{
        return createModuleWithUnits(name,creditPoints,false);
    }
    
    public static ModuleWithUnits4Public createModuleWithUnits(String name,common.Fraction creditPoints,boolean delayed$Persistence) throws PersistenceException {
        PersistentModuleWithUnits result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsFacade
                .newDelayedModuleWithUnits(name,creditPoints);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsFacade
                .newModuleWithUnits(name,creditPoints,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("creditPoints", creditPoints);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ModuleWithUnits4Public createModuleWithUnits(String name,common.Fraction creditPoints,boolean delayed$Persistence,ModuleWithUnits4Public This) throws PersistenceException {
        PersistentModuleWithUnits result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsFacade
                .newDelayedModuleWithUnits(name,creditPoints);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsFacade
                .newModuleWithUnits(name,creditPoints,-1);
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
            result.put("consistsOf", this.getConsistsOf().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
        }
        return result;
    }
    
    public ModuleWithUnits provideCopy() throws PersistenceException{
        ModuleWithUnits result = this;
        result = new ModuleWithUnits(this.prototypeObservee, 
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
    protected ModuleWithUnits_ConsistsOfProxi consistsOf;
    
    public ModuleWithUnits(PersistentPrototype prototypeObservee,PersistentPrototype This,String name,common.Fraction creditPoints,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentPrototype)prototypeObservee,(PersistentPrototype)This,(String)name,(common.Fraction)creditPoints,id);
        this.consistsOf = new ModuleWithUnits_ConsistsOfProxi(this);        
    }
    
    static public long getTypeId() {
        return 114;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 114) ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsFacade
            .newModuleWithUnits(name,creditPoints,this.getId());
        super.store();
        this.getConsistsOf().store();
        
    }
    
    public ModuleWithUnits_ConsistsOfProxi getConsistsOf() throws PersistenceException {
        return this.consistsOf;
    }
    public PersistentModuleWithUnits getThis() throws PersistenceException {
        if(this.This == null){
            PersistentModuleWithUnits result = (PersistentModuleWithUnits)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentModuleWithUnits)this.This;
    }
    
    public void accept(ApprVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnits(this);
    }
    public <R> R accept(ApprReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnits(this);
    }
    public <E extends model.UserException>  void accept(ApprExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnits(this);
    }
    public <R, E extends model.UserException> R accept(ApprReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnits(this);
    }
    public void accept(PrototypeVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnits(this);
    }
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnits(this);
    }
    public <E extends model.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnits(this);
    }
    public <R, E extends model.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnits(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnits(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnits(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnits(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnits(this);
    }
    public void accept(ModuleGroupsHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnits(this);
    }
    public <R> R accept(ModuleGroupsHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnits(this);
    }
    public <E extends model.UserException>  void accept(ModuleGroupsHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnits(this);
    }
    public <R, E extends model.UserException> R accept(ModuleGroupsHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnits(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getMarkHistory().getLength() > 0) return 1;
        if (this.getConsistsOf().getLength() > 0) return 1;
        return 0;
    }
    
    
    public boolean containsModuleGroups(final ModuleGroupsHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		return false;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentModuleWithUnits)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
			this.setCreditPoints((common.Fraction)final$$Fields.get("creditPoints"));
		}
    }
    public <T> T strategyModuleGroups(final ModuleGroupsHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result = strategy.ModuleWithUnits$$finalize(getThis() );
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addUnit(final Unit4Public unit) 
				throws model.UnitIsAlreadyPartOfAModuleWithUnitsException, PersistenceException{
    	Iterator<ModuleWithUnits4Public> mi = ModuleWithUnitsLst.getTheModuleWithUnitsLst().getModuleWithUnits().iterator();
    	while(mi.hasNext()) {
    		Iterator<Unit4Public> ui = mi.next().getConsistsOf().iterator();
    		while(ui.hasNext()) {
    			if(ui.next().equals(unit)) {
    				throw new UnitIsAlreadyPartOfAModuleWithUnitsException("UnitIsAlreadyPartOfAModuleWithUnitsException");
    			}
    		}
    	}
    	
		getThis().getConsistsOf().add(unit);
    }
    public Prototype4Public clonePrototype() 
				throws PersistenceException{
        ModuleWithUnits4Public mwu = ModuleWithUnits.createModuleWithUnits(getThis().getName()+"(C)", getThis().getCreditPoints());
        getThis().registerProtypeObserver(mwu);
        Iterator<Unit4Public> units = getThis().getConsistsOf().iterator();
        while(units.hasNext()) {
        	Unit4Public newUnit = (Unit4Public) units.next().clonePrototype();
        	mwu.getConsistsOf().add(newUnit);
        }
        return mwu;
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{

        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
    }
    public Boolean isConsistent() 
				throws PersistenceException{
        Fraction cpCounter = new Fraction(BigInteger.ZERO, BigInteger.ONE);
        
        for(Unit4Public u:  getThis().getConsistsOf().getList()) {
        	cpCounter = cpCounter.add(u.getCreditPoints());
        }
        
        return cpCounter.equals(getThis().getCreditPoints());
    }
    public void removeUnit(final Unit4Public unit) 
				throws PersistenceException{
		getThis().getConsistsOf().removeAll(unit);
	}
    public void updatePrototypeObserver() 
				throws PersistenceException{

	}
    
    
    // Start of section that contains overridden operations only.
    
    public Mark fetchMark() 
				throws PersistenceException{
		Iterator<Unit4Public> i = getThis().getConsistsOf().iterator();
		Fraction f = new Fraction(BigInteger.ZERO, BigInteger.ONE);
		BigInteger c = BigInteger.ZERO;
		while (i.hasNext()) {
			Mark mark = i.next().fetchMark();
			
			if(mark.fetchIsCalculable()) {
				f = f.add(mark.fetchMarkValue());
				c = c.add(BigInteger.ONE);
			}
		}
		
		if(f.smaller(Fraction.parse("1"))) {
			return NoneMark.createNoneMark();
		}
		else {
			f = f.mul(new Fraction(BigInteger.ONE, c));
			return ThirdMark.createThirdMark(f);
		}
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
