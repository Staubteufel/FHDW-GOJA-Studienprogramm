
package model;

import persistence.*;
import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class MarkFactory extends PersistentObject implements PersistentMarkFactory{
    
    private static MarkFactory4Public theMarkFactory = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static MarkFactory4Public getTheMarkFactory() throws PersistenceException{
        if (theMarkFactory == null || reset$For$Test){
            if (reset$For$Test) theMarkFactory = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            MarkFactory4Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theMarkFactoryFacade.getTheMarkFactory();
                            theMarkFactory = proxi;
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
                MarkFactory4Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theMarkFactory== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theMarkFactory;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theMarkFactory;
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
    
    public MarkFactory provideCopy() throws PersistenceException{
        MarkFactory result = this;
        result = new MarkFactory(this.This, 
                                 this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentMarkFactory This;
    
    public MarkFactory(PersistentMarkFactory This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 247;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    protected void setThis(PersistentMarkFactory newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentMarkFactory)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMarkFactoryFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentMarkFactory getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMarkFactory result = (PersistentMarkFactory)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentMarkFactory)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMarkFactory(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMarkFactory(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMarkFactory(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMarkFactory(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMarkFactory)This);
		if(this.isTheSameAs(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public TenthMark4Public createTenthMark(final common.Fraction f) 
				throws PersistenceException{
    	if(f.smaller(Fraction.parse("1.1")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("1.0"));
        }
        if(f.smaller(Fraction.parse("1.2")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("1.1"));
        }
        if(f.smaller(Fraction.parse("1.3")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("1.2"));
        }
        if(f.smaller(Fraction.parse("1.4")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("1.3"));
        }
        if(f.smaller(Fraction.parse("1.5")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("1.4"));
        }
        if(f.smaller(Fraction.parse("1.6")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("1.5"));
        }
        if(f.smaller(Fraction.parse("1.7")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("1.6"));
        }
        if(f.smaller(Fraction.parse("1.8")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("1.7"));
        }
        if(f.smaller(Fraction.parse("1.9")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("1.8"));
        }
        if(f.smaller(Fraction.parse("2.0")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("1.9"));
        }
        if(f.smaller(Fraction.parse("2.1")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("2.0"));
        }
        if(f.smaller(Fraction.parse("2.2")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("2.1"));
        }
        if(f.smaller(Fraction.parse("2.3")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("2.2"));
        }
        if(f.smaller(Fraction.parse("2.4")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("2.3"));
        }
        if(f.smaller(Fraction.parse("2.5")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("2.4"));
        }
        if(f.smaller(Fraction.parse("2.6")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("2.5"));
        }
        if(f.smaller(Fraction.parse("2.7")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("2.6"));
        }
        
        if(f.smaller(Fraction.parse("2.8")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("2.7"));
        }

        if(f.smaller(Fraction.parse("2.9")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("2.8"));
        }
        if(f.smaller(Fraction.parse("3.0")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("2.9"));
        }
        if(f.smaller(Fraction.parse("3.1")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("3.0"));
        }        
        if(f.smaller(Fraction.parse("3.2")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("3.1"));
        }
        if(f.smaller(Fraction.parse("3.3")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("3.2"));
        }
        if(f.smaller(Fraction.parse("3.4")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("3.3"));
        }
        if(f.smaller(Fraction.parse("3.5")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("3.4"));
        }
        if(f.smaller(Fraction.parse("3.6")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("3.5"));
        }
        if(f.smaller(Fraction.parse("3.7")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("3.6"));
        }
        if(f.smaller(Fraction.parse("3.8")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("3.7"));
        }
        if(f.smaller(Fraction.parse("3.9")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("3.8"));
        }
        if(f.smaller(Fraction.parse("4.0")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("3.9"));
        }
        if(f.smaller(Fraction.parse("5.0")))
        {
        	return TenthMark.createTenthMark(Fraction.parse("4.0"));
        }
        
        return TenthMark.createTenthMark(Fraction.parse("5.0"));
    }
    public ThirdMark4Public createThirdMark(final common.Fraction f) 
				throws PersistenceException{
    	if(f.smaller(Fraction.parse("1.3")))
        {
        	return OneZero.getTheOneZero();
        }    	
    	if(f.smaller(Fraction.parse("1.7")))
        {
        	return OneThree.getTheOneThree();
        }
    	if(f.smaller(Fraction.parse("2.0")))
        {
        	return OneSeven.getTheOneSeven();
        }
    	if(f.smaller(Fraction.parse("2.3")))
        {
        	return TwoZero.getTheTwoZero();
        }
    	if(f.smaller(Fraction.parse("2.7")))
        {
        	return TwoThree.getTheTwoThree();
        }
    	if(f.smaller(Fraction.parse("3.0")))
        {
        	return TwoSeven.getTheTwoSeven();
        }
    	if(f.smaller(Fraction.parse("3.3")))
        {
        	return ThreeZero.getTheThreeZero();
        }
    	if(f.smaller(Fraction.parse("3.7")))
        {
        	return ThreeThree.getTheThreeThree();
        }
    	if(f.smaller(Fraction.parse("4.0")))
        {
        	return ThreeSeven.getTheThreeSeven();
        }
    	if(f.smaller(Fraction.parse("5.0")))
        {
        	return FourZero.getTheFourZero();
        }
    	
    	return FiveZero.getTheFiveZero();
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
