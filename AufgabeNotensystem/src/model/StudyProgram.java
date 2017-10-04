
package model;

import persistence.*;

import java.math.BigInteger;
import java.util.Iterator;
import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class StudyProgram extends model.Appr implements PersistentStudyProgram{
    
    
    public static StudyProgram4Public createStudyProgram(String name,common.Fraction creditPoints) throws PersistenceException{
        return createStudyProgram(name,creditPoints,false);
    }
    
    public static StudyProgram4Public createStudyProgram(String name,common.Fraction creditPoints,boolean delayed$Persistence) throws PersistenceException {
        PersistentStudyProgram result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudyProgramFacade
                .newDelayedStudyProgram(name,creditPoints);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudyProgramFacade
                .newStudyProgram(name,creditPoints,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        final$$Fields.put("creditPoints", creditPoints);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static StudyProgram4Public createStudyProgram(String name,common.Fraction creditPoints,boolean delayed$Persistence,StudyProgram4Public This) throws PersistenceException {
        PersistentStudyProgram result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudyProgramFacade
                .newDelayedStudyProgram(name,creditPoints);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudyProgramFacade
                .newStudyProgram(name,creditPoints,-1);
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
        }
        return result;
    }
    
    public StudyProgram provideCopy() throws PersistenceException{
        StudyProgram result = this;
        result = new StudyProgram(this.prototypeObservee, 
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
    protected StudyProgram_ModuleGroupsProxi moduleGroups;
    
    public StudyProgram(PersistentPrototype prototypeObservee,PersistentPrototype This,String name,common.Fraction creditPoints,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentPrototype)prototypeObservee,(PersistentPrototype)This,(String)name,(common.Fraction)creditPoints,id);
        this.moduleGroups = new StudyProgram_ModuleGroupsProxi(this);        
    }
    
    static public long getTypeId() {
        return 116;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 116) ConnectionHandler.getTheConnectionHandler().theStudyProgramFacade
            .newStudyProgram(name,creditPoints,this.getId());
        super.store();
        this.getModuleGroups().store();
        
    }
    
    public StudyProgram_ModuleGroupsProxi getModuleGroups() throws PersistenceException {
        return this.moduleGroups;
    }
    public PersistentStudyProgram getThis() throws PersistenceException {
        if(this.This == null){
            PersistentStudyProgram result = (PersistentStudyProgram)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentStudyProgram)this.This;
    }
    
    public void accept(ApprVisitor visitor) throws PersistenceException {
        visitor.handleStudyProgram(this);
    }
    public <R> R accept(ApprReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyProgram(this);
    }
    public <E extends model.UserException>  void accept(ApprExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyProgram(this);
    }
    public <R, E extends model.UserException> R accept(ApprReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyProgram(this);
    }
    public void accept(PrototypeVisitor visitor) throws PersistenceException {
        visitor.handleStudyProgram(this);
    }
    public <R> R accept(PrototypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyProgram(this);
    }
    public <E extends model.UserException>  void accept(PrototypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyProgram(this);
    }
    public <R, E extends model.UserException> R accept(PrototypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyProgram(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudyProgram(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyProgram(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyProgram(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyProgram(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getMarkHistory().getLength() > 0) return 1;
        if (this.getModuleGroups().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentStudyProgram)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
			this.setCreditPoints((common.Fraction)final$$Fields.get("creditPoints"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addModuleGroup(final ModuleGroup4Public moduleGroup) 
				throws PersistenceException{
        Iterator<ModuleGroup4Public> modIta = getThis().getModuleGroups().iterator();
        while (modIta.hasNext()) {
			ModuleGroup4Public cur = modIta.next();
			if(cur.equals(moduleGroup))return;
		}
        getThis().getModuleGroups().add(moduleGroup);
        
    }
    public Prototype4Public clonePrototype() 
				throws PersistenceException{
    	StudyProgram4Public sp = StudyProgram.createStudyProgram(getThis().getName()+"(C)", getThis().getCreditPoints());
    	getThis().registerProtypeObserver(sp);
    	Iterator<ModuleGroup4Public> i = getThis().getModuleGroups().iterator();
		while (i.hasNext()) {
			ModuleGroup4Public n = (ModuleGroup4Public) i.next().clonePrototype();
			sp.getModuleGroups().add(n);
		}
		return sp;
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
    public void updatePrototypeObserver() 
				throws PersistenceException{
        
    }
    
    
    // Start of section that contains overridden operations only.
    
    public Mark fetchMark() 
				throws PersistenceException{
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
		
		if(f.smaller(Fraction.parse("1"))) {
			return NoneMark.createNoneMark();
		}
		else {
			f = f.mul(new Fraction(BigInteger.ONE, c));
			return TenthMark.createTenthMark(f);
		}
		
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
