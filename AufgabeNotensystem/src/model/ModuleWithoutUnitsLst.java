
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class ModuleWithoutUnitsLst extends PersistentObject implements PersistentModuleWithoutUnitsLst{
    
    private static ModuleWithoutUnitsLst4Public theModuleWithoutUnitsLst = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static ModuleWithoutUnitsLst4Public getTheModuleWithoutUnitsLst() throws PersistenceException{
        if (theModuleWithoutUnitsLst == null || reset$For$Test){
            if (reset$For$Test) theModuleWithoutUnitsLst = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            ModuleWithoutUnitsLst4Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theModuleWithoutUnitsLstFacade.getTheModuleWithoutUnitsLst();
                            theModuleWithoutUnitsLst = proxi;
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
                ModuleWithoutUnitsLst4Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theModuleWithoutUnitsLst== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theModuleWithoutUnitsLst;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theModuleWithoutUnitsLst;
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
            result.put("moduleWithoutUnits", this.getModuleWithoutUnits().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
        }
        return result;
    }
    
    public ModuleWithoutUnitsLst provideCopy() throws PersistenceException{
        ModuleWithoutUnitsLst result = this;
        result = new ModuleWithoutUnitsLst(this.This, 
                                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ModuleWithoutUnitsLst_ModuleWithoutUnitsProxi moduleWithoutUnits;
    protected PersistentModuleWithoutUnitsLst This;
    
    public ModuleWithoutUnitsLst(PersistentModuleWithoutUnitsLst This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.moduleWithoutUnits = new ModuleWithoutUnitsLst_ModuleWithoutUnitsProxi(this);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 209;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public ModuleWithoutUnitsLst_ModuleWithoutUnitsProxi getModuleWithoutUnits() throws PersistenceException {
        return this.moduleWithoutUnits;
    }
    protected void setThis(PersistentModuleWithoutUnitsLst newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentModuleWithoutUnitsLst)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theModuleWithoutUnitsLstFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentModuleWithoutUnitsLst getThis() throws PersistenceException {
        if(this.This == null){
            PersistentModuleWithoutUnitsLst result = (PersistentModuleWithoutUnitsLst)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentModuleWithoutUnitsLst)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithoutUnitsLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithoutUnitsLst(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithoutUnitsLst(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithoutUnitsLst(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getModuleWithoutUnits().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentModuleWithoutUnitsLst)This);
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
