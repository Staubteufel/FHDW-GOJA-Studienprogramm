
package model;

import persistence.*;

import java.math.BigInteger;

import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class TwoZero extends model.ThirdMark implements PersistentTwoZero{
    
    private static TwoZero4Public theTwoZero = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static TwoZero4Public getTheTwoZero() throws PersistenceException{
        if (theTwoZero == null || reset$For$Test){
            if (reset$For$Test) theTwoZero = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            TwoZero4Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theTwoZeroFacade.getTheTwoZero();
                            theTwoZero = proxi;
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
                TwoZero4Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theTwoZero== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theTwoZero;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theTwoZero;
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
    
    public TwoZero provideCopy() throws PersistenceException{
        TwoZero result = this;
        result = new TwoZero(this.value, 
                             this.This, 
                             this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public TwoZero(common.Fraction value,PersistentMarkCalculable This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((common.Fraction)value,(PersistentMarkCalculable)This,id);        
    }
    
    static public long getTypeId() {
        return 216;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentTwoZero getThis() throws PersistenceException {
        if(this.This == null){
            PersistentTwoZero result = (PersistentTwoZero)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentTwoZero)this.This;
    }
    
    public void accept(ThirdMarkVisitor visitor) throws PersistenceException {
        visitor.handleTwoZero(this);
    }
    public <R> R accept(ThirdMarkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTwoZero(this);
    }
    public <E extends model.UserException>  void accept(ThirdMarkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTwoZero(this);
    }
    public <R, E extends model.UserException> R accept(ThirdMarkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTwoZero(this);
    }
    public void accept(MarkCalculableVisitor visitor) throws PersistenceException {
        visitor.handleTwoZero(this);
    }
    public <R> R accept(MarkCalculableReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTwoZero(this);
    }
    public <E extends model.UserException>  void accept(MarkCalculableExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTwoZero(this);
    }
    public <R, E extends model.UserException> R accept(MarkCalculableReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTwoZero(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTwoZero(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTwoZero(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTwoZero(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTwoZero(this);
    }
    public void accept(MarkVisitor visitor) throws PersistenceException {
        visitor.handleTwoZero(this);
    }
    public <R> R accept(MarkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTwoZero(this);
    }
    public <E extends model.UserException>  void accept(MarkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTwoZero(this);
    }
    public <R, E extends model.UserException> R accept(MarkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTwoZero(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentTwoZero)This);
		if(this.isTheSameAs(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
        getThis().setValue(new Fraction(BigInteger.valueOf(2), BigInteger.valueOf(1)));
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();

    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
