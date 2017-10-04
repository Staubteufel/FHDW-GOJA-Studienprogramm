
package model;

import persistence.*;
import common.Fraction;
import java.math.BigInteger;
import java.util.Iterator;

import model.visitor.*;


/* Additional import section end */

public class ModuleGroup extends model.Appr implements PersistentModuleGroup{
    
    
    public static ModuleGroup4Public createModuleGroup(String name,common.Fraction creditPoints) throws PersistenceException{
        return createModuleGroup(name,creditPoints,false);
    }
    
    public static ModuleGroup4Public createModuleGroup(String name,common.Fraction creditPoints,boolean delayed$Persistence) throws PersistenceException {
        PersistentModuleGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleGroupFacade
                .newDelayedModuleGroup(name,creditPoints);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleGroupFacade
                .newModuleGroup(name,creditPoints,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("creditPoints", creditPoints);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ModuleGroup4Public createModuleGroup(String name,common.Fraction creditPoints,boolean delayed$Persistence,ModuleGroup4Public This) throws PersistenceException {
        PersistentModuleGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleGroupFacade
                .newDelayedModuleGroup(name,creditPoints);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleGroupFacade
                .newModuleGroup(name,creditPoints,-1);
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
            result.put("moduleGroups", this.getModuleGroups().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
            result.put("moduleWithUnits", this.getModuleWithUnits().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
            result.put("moduleWithoutUnits", this.getModuleWithoutUnits().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
        }
        return result;
    }
    
    public ModuleGroup provideCopy() throws PersistenceException{
        ModuleGroup result = this;
        result = new ModuleGroup(this.prototypeObservee, 
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
    protected ModuleGroup_ModuleGroupsProxi moduleGroups;
    protected ModuleGroup_ModuleWithUnitsProxi moduleWithUnits;
    protected ModuleGroup_ModuleWithoutUnitsProxi moduleWithoutUnits;
    
    public ModuleGroup(PersistentPrototype prototypeObservee,PersistentPrototype This,String name,common.Fraction creditPoints,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentPrototype)prototypeObservee,(PersistentPrototype)This,(String)name,(common.Fraction)creditPoints,id);
        this.moduleGroups = new ModuleGroup_ModuleGroupsProxi(this);
        this.moduleWithUnits = new ModuleGroup_ModuleWithUnitsProxi(this);
        this.moduleWithoutUnits = new ModuleGroup_ModuleWithoutUnitsProxi(this);        
    }
    
    static public long getTypeId() {
        return 105;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 105) ConnectionHandler.getTheConnectionHandler().theModuleGroupFacade
            .newModuleGroup(name,creditPoints,this.getId());
        super.store();
        this.getModuleGroups().store();
        this.getModuleWithUnits().store();
        this.getModuleWithoutUnits().store();
        
    }
    
    public ModuleGroup_ModuleGroupsProxi getModuleGroups() throws PersistenceException {
        return this.moduleGroups;
    }
    public ModuleGroup_ModuleWithUnitsProxi getModuleWithUnits() throws PersistenceException {
        return this.moduleWithUnits;
    }
    public ModuleGroup_ModuleWithoutUnitsProxi getModuleWithoutUnits() throws PersistenceException {
        return this.moduleWithoutUnits;
    }
    public PersistentModuleGroup getThis() throws PersistenceException {
        if(this.This == null){
            PersistentModuleGroup result = (PersistentModuleGroup)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentModuleGroup)this.This;
    }
    
    public void accept(ApprVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroup(this);
    }
    public <R> R accept(ApprReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroup(this);
    }
    public <E extends model.UserException>  void accept(ApprExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroup(this);
    }
    public <R, E extends model.UserException> R accept(ApprReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroup(this);
    }
    public void accept(PrototypeVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroup(this);
    }
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroup(this);
    }
    public <E extends model.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroup(this);
    }
    public <R, E extends model.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroup(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroup(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroup(this);
    }
    public void accept(ModuleGroupsHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroup(this);
    }
    public <R> R accept(ModuleGroupsHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroup(this);
    }
    public <E extends model.UserException>  void accept(ModuleGroupsHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroup(this);
    }
    public <R, E extends model.UserException> R accept(ModuleGroupsHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroup(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getMarkHistory().getLength() > 0) return 1;
        if (this.getModuleGroups().getLength() > 0) return 1;
        if (this.getModuleWithUnits().getLength() > 0) return 1;
        if (this.getModuleWithoutUnits().getLength() > 0) return 1;
        return 0;
    }
    
    
    public boolean containsModuleGroups(final ModuleGroupsHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		java.util.Iterator<ModuleGroup4Public> iterator0 = getThis().getModuleGroups().iterator();
		while(iterator0.hasNext())
			if(((ModuleGroupsHIERARCHY)iterator0.next()).containsModuleGroups(part)) return true; 
		java.util.Iterator<ModuleWithUnits4Public> iterator1 = getThis().getModuleWithUnits().iterator();
		while(iterator1.hasNext())
			if(((ModuleGroupsHIERARCHY)iterator1.next()).containsModuleGroups(part)) return true; 
		java.util.Iterator<ModuleWithoutUnits4Public> iterator2 = getThis().getModuleWithoutUnits().iterator();
		while(iterator2.hasNext())
			if(((ModuleGroupsHIERARCHY)iterator2.next()).containsModuleGroups(part)) return true; 
		return false;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentModuleGroup)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
			this.setCreditPoints((common.Fraction)final$$Fields.get("creditPoints"));
		}
    }
    public <T> T strategyModuleGroups(final ModuleGroupsHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$moduleGroups$$ModuleGroup = strategy.ModuleGroup$$moduleGroups$$$initialize(getThis());
		java.util.Iterator<?> iterator$$ = getThis().getModuleGroups().iterator();
		while (iterator$$.hasNext()){
			ModuleGroup4Public current$$Field = (ModuleGroup4Public)iterator$$.next();
			T current$$ = current$$Field.strategyModuleGroups(strategy);
			result$$moduleGroups$$ModuleGroup = strategy.ModuleGroup$$moduleGroups$$consolidate(getThis(), result$$moduleGroups$$ModuleGroup, current$$);
		}
		T result$$moduleWithUnits$$ModuleGroup = strategy.ModuleGroup$$moduleWithUnits$$$initialize(getThis());
		iterator$$ = getThis().getModuleWithUnits().iterator();
		while (iterator$$.hasNext()){
			ModuleWithUnits4Public current$$Field = (ModuleWithUnits4Public)iterator$$.next();
			T current$$ = current$$Field.strategyModuleGroups(strategy);
			result$$moduleWithUnits$$ModuleGroup = strategy.ModuleGroup$$moduleWithUnits$$consolidate(getThis(), result$$moduleWithUnits$$ModuleGroup, current$$);
		}
		T result$$moduleWithoutUnits$$ModuleGroup = strategy.ModuleGroup$$moduleWithoutUnits$$$initialize(getThis());
		iterator$$ = getThis().getModuleWithoutUnits().iterator();
		while (iterator$$.hasNext()){
			ModuleWithoutUnits4Public current$$Field = (ModuleWithoutUnits4Public)iterator$$.next();
			T current$$ = current$$Field.strategyModuleGroups(strategy);
			result$$moduleWithoutUnits$$ModuleGroup = strategy.ModuleGroup$$moduleWithoutUnits$$consolidate(getThis(), result$$moduleWithoutUnits$$ModuleGroup, current$$);
		}
		T result = strategy.ModuleGroup$$finalize(getThis() ,result$$moduleGroups$$ModuleGroup,result$$moduleWithUnits$$ModuleGroup,result$$moduleWithoutUnits$$ModuleGroup);
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addModuleGroup(final ModuleGroup4Public moduleGroup) 
				throws model.CycleException, PersistenceException{
    	Iterator<ModuleGroup4Public> modIta = getThis().getModuleGroups().iterator();
    	while(modIta.hasNext()){
    		ModuleGroup4Public cur = modIta.next();
    		if(cur.equals(moduleGroup)){
    			return;
    		}
    	}
    	getThis().getModuleGroups().add(moduleGroup);
    	
        
    }
    public void addModuleWithUnits(final ModuleWithUnits4Public moduleWithUnits) 
				throws model.CycleException, PersistenceException{
    	Iterator<ModuleWithUnits4Public> modulIta = getThis().getModuleWithUnits().iterator();
    	while(modulIta.hasNext()){
    		ModuleWithUnits4Public cur = modulIta.next();
    		if(cur.equals(moduleWithUnits)){
    			return;
    		}
    	}
    	getThis().getModuleWithUnits().add(moduleWithUnits);
    }
    public void addModuleWithoutUnits(final ModuleWithoutUnits4Public moduleWithoutUnits) 
				throws model.CycleException, PersistenceException{
    	Iterator<ModuleWithoutUnits4Public> modulIta = getThis().getModuleWithoutUnits().iterator();
    	while(modulIta.hasNext()){
    		ModuleWithoutUnits4Public cur = modulIta.next();
    		if(cur.equals(moduleWithoutUnits)){
    			return;
    		}
    	}
    	getThis().getModuleWithoutUnits().add(moduleWithoutUnits);
    }
    public Prototype4Public clonePrototype() 
				throws PersistenceException{
    	ModuleGroup4Public mg = ModuleGroup.createModuleGroup(getThis().getName()+"(C)", getThis().getCreditPoints());
    	getThis().registerProtypeObserver(mg);
    	
    	// ModuleWithUnits
    	{
    		Iterator<ModuleWithUnits4Public> i = getThis().getModuleWithUnits().iterator();
    		while (i.hasNext()) {
    			ModuleWithUnits4Public n = (ModuleWithUnits4Public) i.next().clonePrototype();
    			try {
					mg.getModuleWithUnits().add(n);
				} catch (CycleException e) {
					e.printStackTrace();
				}
    		}
    	}

    	// ModuleWithoutUnits
    	{
    		Iterator<ModuleWithoutUnits4Public> i = getThis().getModuleWithoutUnits().iterator();
    		while (i.hasNext()) {
    			ModuleWithoutUnits4Public n = (ModuleWithoutUnits4Public) i.next().clonePrototype();
    			try {
					mg.getModuleWithoutUnits().add(n);
				} catch (CycleException e) {
					e.printStackTrace();
				}
    		}
    	}

    	// ModuleWithUnits
    	{
    		Iterator<ModuleGroup4Public> i = getThis().getModuleGroups().iterator();
    		while (i.hasNext()) {
    			ModuleGroup4Public n = (ModuleGroup4Public) i.next().clonePrototype();
    			try {
					mg.getModuleGroups().add(n);
				} catch (CycleException e) {
					e.printStackTrace();
				}
    		}
    	}
    	
    	return mg;
    }
    public Boolean containsModulGroup(final ModuleGroup4Public moduleGroup) 
				throws PersistenceException{
    	Iterator<ModuleGroup4Public> modulIta = getThis().getModuleGroups().iterator();
    	while(modulIta.hasNext()){
    		ModuleGroup4Public cur = modulIta.next();
    		if(cur.equals(moduleGroup)){
    			return true;
    		}
    	}
    	return false;
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
    	
    	for(ModuleWithoutUnits4Public u:  getThis().getModuleWithoutUnits().getList()) {
        	cpCounter = cpCounter.add(u.getCreditPoints());
        }
    	
    	for(ModuleWithUnits4Public u:  getThis().getModuleWithUnits().getList()) {
        	if(u.isConsistent()) {
        		cpCounter = cpCounter.add(u.getCreditPoints());
        	}
        	else {
        		return false;
        	}
        }
    	
    	for(ModuleGroup4Public u:  getThis().getModuleGroups().getList()) {
        	if(u.isConsistent()) {
        		cpCounter = cpCounter.add(u.getCreditPoints());
        	}
        	else {
        		return false;
        	}
        }
        
        return cpCounter.equals(getThis().getCreditPoints());
    }
    public void removeModuleGroup(final ModuleGroup4Public moduleGroup) 
				throws PersistenceException{
		getThis().getModuleGroups().removeAll(moduleGroup);
	}
    public void removeModuleWithUnits(final ModuleWithUnits4Public moduleWithUnits) 
				throws PersistenceException{
		getThis().getModuleWithUnits().removeAll(moduleWithUnits);
	}
    public void removeModuleWithoutUnits(final ModuleWithoutUnits4Public moduleWithoutUnits) 
				throws PersistenceException{
		getThis().getModuleWithoutUnits().removeAll(moduleWithoutUnits);
	}
    public void updatePrototypeObserver() 
				throws PersistenceException{

	}
    
    
    // Start of section that contains overridden operations only.
    
    public Mark fetchMark() 
				throws PersistenceException{
		Fraction returnFraction = new Fraction(BigInteger.ZERO, BigInteger.ONE);
		BigInteger countDivide = BigInteger.ZERO;
		
		// ModuleWithUnits
		{
			Iterator<ModuleWithUnits4Public> i = getThis().getModuleWithUnits().iterator();
			Fraction f = new Fraction(BigInteger.ZERO, BigInteger.ONE);
			BigInteger c = BigInteger.ZERO;
			while (i.hasNext()) {
				Mark mark = i.next().fetchMark();
				
				if(mark.fetchIsCalculable()) {
					f = f.add(mark.fetchMarkValue());
					c = c.add(BigInteger.ONE);
				}
			}
			if(c.longValue() != 0) {
				f = f.mul(new Fraction(BigInteger.ONE, c));
				returnFraction = returnFraction.add(f);
				countDivide = countDivide.add(BigInteger.ONE);
			}
		}
	
		// ModuleWithoutUnits
		{
			Iterator<ModuleWithoutUnits4Public> i = getThis().getModuleWithoutUnits().iterator();
			Fraction f = new Fraction(BigInteger.ZERO, BigInteger.ONE);
			BigInteger c = BigInteger.ZERO;
			while (i.hasNext()) {
				Mark mark = i.next().fetchMark();
				
				if(mark.fetchIsCalculable()) {
					f = f.add(mark.fetchMarkValue());
					c = c.add(BigInteger.ONE);
				}
			}
			if(c.longValue() != 0) {
				f = f.mul(new Fraction(BigInteger.ONE, c));
				returnFraction = returnFraction.add(f);
				countDivide = countDivide.add(BigInteger.ONE);
			}
		}
	
		// ModuleGroups
		{
			Iterator<ModuleGroup4Public> i = getThis().getModuleGroups().iterator();
			Fraction f = new Fraction(BigInteger.ZERO, BigInteger.ONE);
			BigInteger c = BigInteger.ZERO;
			while (i.hasNext()) {
				Mark mark = i.next().fetchMark();
				
				if(mark.fetchIsCalculable()) {
					f = f.add(mark.fetchMarkValue());
					c = c.add(BigInteger.ONE);
				}
			}
			if(c.longValue() != 0) {
				f = f.mul(new Fraction(BigInteger.ONE, c));
				returnFraction = returnFraction.add(f);
				countDivide = countDivide.add(BigInteger.ONE);
			}
		}
	
		if(returnFraction.smaller(Fraction.parse("1"))) {
			return NoneMark.createNoneMark();
		}
		else {
			if(countDivide.longValue() != 0) {		
				returnFraction = returnFraction.mul(new Fraction(BigInteger.ONE, countDivide));
			}
			return TenthMark.createTenthMark(returnFraction);
		}
		
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
