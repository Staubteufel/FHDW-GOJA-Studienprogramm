
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class ModuleWithUnitsLst extends PersistentObject implements PersistentModuleWithUnitsLst{
    
    private static ModuleWithUnitsLst4Public theModuleWithUnitsLst = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static ModuleWithUnitsLst4Public getTheModuleWithUnitsLst() throws PersistenceException{
        if (theModuleWithUnitsLst == null || reset$For$Test){
            if (reset$For$Test) theModuleWithUnitsLst = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            ModuleWithUnitsLst4Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsLstFacade.getTheModuleWithUnitsLst();
                            theModuleWithUnitsLst = proxi;
                            if(proxi.getId() < 0) {
                                ((AbstractPersistentRoot)proxi).setId(proxi.getId() * -1);
                                proxi.initialize(proxi, new java.util.HashMap<String,Object>());
                                proxi.initializeOnCreation();
                            }
                        } catch (PersistenceException e){
                            exception = e;
                        } finally {
                            $$lock.notify();
                        }
                        
                    }
                }
                ModuleWithUnitsLst4Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theModuleWithUnitsLst== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theModuleWithUnitsLst;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theModuleWithUnitsLst;
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
            result.put("moduleWithUnits", this.getModuleWithUnits().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
        }
        return result;
    }
    
    public ModuleWithUnitsLst provideCopy() throws PersistenceException{
        ModuleWithUnitsLst result = this;
        result = new ModuleWithUnitsLst(this.This, 
                                        this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ModuleWithUnitsLst_ModuleWithUnitsProxi moduleWithUnits;
    protected PersistentModuleWithUnitsLst This;
    
    public ModuleWithUnitsLst(PersistentModuleWithUnitsLst This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.moduleWithUnits = new ModuleWithUnitsLst_ModuleWithUnitsProxi(this);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 206;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public ModuleWithUnitsLst_ModuleWithUnitsProxi getModuleWithUnits() throws PersistenceException {
        return this.moduleWithUnits;
    }
    protected void setThis(PersistentModuleWithUnitsLst newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentModuleWithUnitsLst)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsLstFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentModuleWithUnitsLst getThis() throws PersistenceException {
        if(this.This == null){
            PersistentModuleWithUnitsLst result = (PersistentModuleWithUnitsLst)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentModuleWithUnitsLst)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnitsLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnitsLst(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnitsLst(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnitsLst(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getModuleWithUnits().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentModuleWithUnitsLst)This);
		if(this.isTheSameAs(This)){
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
