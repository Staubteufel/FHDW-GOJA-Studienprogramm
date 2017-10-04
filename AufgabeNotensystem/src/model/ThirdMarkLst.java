
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class ThirdMarkLst extends PersistentObject implements PersistentThirdMarkLst{
    
    private static ThirdMarkLst4Public theThirdMarkLst = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static ThirdMarkLst4Public getTheThirdMarkLst() throws PersistenceException{
        if (theThirdMarkLst == null || reset$For$Test){
            if (reset$For$Test) theThirdMarkLst = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            ThirdMarkLst4Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theThirdMarkLstFacade.getTheThirdMarkLst();
                            theThirdMarkLst = proxi;
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
                ThirdMarkLst4Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theThirdMarkLst== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theThirdMarkLst;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theThirdMarkLst;
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
            result.put("thirdMarks", this.getThirdMarks().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
        }
        return result;
    }
    
    public ThirdMarkLst provideCopy() throws PersistenceException{
        ThirdMarkLst result = this;
        result = new ThirdMarkLst(this.This, 
                                  this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ThirdMarkLst_ThirdMarksProxi thirdMarks;
    protected PersistentThirdMarkLst This;
    
    public ThirdMarkLst(PersistentThirdMarkLst This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.thirdMarks = new ThirdMarkLst_ThirdMarksProxi(this);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 229;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public ThirdMarkLst_ThirdMarksProxi getThirdMarks() throws PersistenceException {
        return this.thirdMarks;
    }
    protected void setThis(PersistentThirdMarkLst newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentThirdMarkLst)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theThirdMarkLstFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentThirdMarkLst getThis() throws PersistenceException {
        if(this.This == null){
            PersistentThirdMarkLst result = (PersistentThirdMarkLst)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentThirdMarkLst)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleThirdMarkLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleThirdMarkLst(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleThirdMarkLst(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleThirdMarkLst(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getThirdMarks().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentThirdMarkLst)This);
		if(this.isTheSameAs(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{

        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        getThis().getThirdMarks().add(OneZero.getTheOneZero());
        getThis().getThirdMarks().add(OneThree.getTheOneThree());
        getThis().getThirdMarks().add(OneSeven.getTheOneSeven());
        getThis().getThirdMarks().add(TwoZero.getTheTwoZero());
        getThis().getThirdMarks().add(TwoThree.getTheTwoThree());
        getThis().getThirdMarks().add(TwoSeven.getTheTwoSeven());
        getThis().getThirdMarks().add(ThreeZero.getTheThreeZero());
        getThis().getThirdMarks().add(ThreeThree.getTheThreeThree());
        getThis().getThirdMarks().add(ThreeSeven.getTheThreeSeven());
        getThis().getThirdMarks().add(FourZero.getTheFourZero());
        getThis().getThirdMarks().add(FiveZero.getTheFiveZero());
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
