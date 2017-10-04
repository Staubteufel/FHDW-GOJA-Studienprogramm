
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class BooleanMarkLst extends PersistentObject implements PersistentBooleanMarkLst{
    
    private static BooleanMarkLst4Public theBooleanMarkLst = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static BooleanMarkLst4Public getTheBooleanMarkLst() throws PersistenceException{
        if (theBooleanMarkLst == null || reset$For$Test){
            if (reset$For$Test) theBooleanMarkLst = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            BooleanMarkLst4Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theBooleanMarkLstFacade.getTheBooleanMarkLst();
                            theBooleanMarkLst = proxi;
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
                BooleanMarkLst4Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theBooleanMarkLst== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theBooleanMarkLst;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theBooleanMarkLst;
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
            result.put("booleanMarks", this.getBooleanMarks().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
        }
        return result;
    }
    
    public BooleanMarkLst provideCopy() throws PersistenceException{
        BooleanMarkLst result = this;
        result = new BooleanMarkLst(this.This, 
                                    this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected BooleanMarkLst_BooleanMarksProxi booleanMarks;
    protected PersistentBooleanMarkLst This;
    
    public BooleanMarkLst(PersistentBooleanMarkLst This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.booleanMarks = new BooleanMarkLst_BooleanMarksProxi(this);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 233;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public BooleanMarkLst_BooleanMarksProxi getBooleanMarks() throws PersistenceException {
        return this.booleanMarks;
    }
    protected void setThis(PersistentBooleanMarkLst newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentBooleanMarkLst)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theBooleanMarkLstFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentBooleanMarkLst getThis() throws PersistenceException {
        if(this.This == null){
            PersistentBooleanMarkLst result = (PersistentBooleanMarkLst)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentBooleanMarkLst)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBooleanMarkLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBooleanMarkLst(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBooleanMarkLst(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBooleanMarkLst(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getBooleanMarks().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentBooleanMarkLst)This);
		if(this.isTheSameAs(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{

    }
    public void initializeOnCreation() 
				throws PersistenceException{
    	getThis().getBooleanMarks().add(Passed.getThePassed());
        getThis().getBooleanMarks().add(Failed.getTheFailed());
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{

    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
