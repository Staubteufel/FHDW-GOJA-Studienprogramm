
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class BooleanMark extends model.MarkNotCalculable implements PersistentBooleanMark{
    
    
    public static BooleanMark4Public createBooleanMark() throws PersistenceException{
        return createBooleanMark(false);
    }
    
    public static BooleanMark4Public createBooleanMark(boolean delayed$Persistence) throws PersistenceException {
        PersistentBooleanMark result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theBooleanMarkFacade
                .newDelayedBooleanMark();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theBooleanMarkFacade
                .newBooleanMark(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static BooleanMark4Public createBooleanMark(boolean delayed$Persistence,BooleanMark4Public This) throws PersistenceException {
        PersistentBooleanMark result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theBooleanMarkFacade
                .newDelayedBooleanMark();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theBooleanMarkFacade
                .newBooleanMark(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
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
    
    public BooleanMark provideCopy() throws PersistenceException{
        BooleanMark result = this;
        result = new BooleanMark(this.This, 
                                 this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public BooleanMark(PersistentMarkNotCalculable This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMarkNotCalculable)This,id);        
    }
    
    static public long getTypeId() {
        return 119;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 119) ConnectionHandler.getTheConnectionHandler().theBooleanMarkFacade
            .newBooleanMark(this.getId());
        super.store();
        
    }
    
    public PersistentBooleanMark getThis() throws PersistenceException {
        if(this.This == null){
            PersistentBooleanMark result = (PersistentBooleanMark)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentBooleanMark)this.This;
    }
    
    public void accept(BooleanMarkVisitor visitor) throws PersistenceException {
        visitor.handleBooleanMark(this);
    }
    public <R> R accept(BooleanMarkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBooleanMark(this);
    }
    public <E extends model.UserException>  void accept(BooleanMarkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBooleanMark(this);
    }
    public <R, E extends model.UserException> R accept(BooleanMarkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBooleanMark(this);
    }
    public void accept(MarkNotCalculableVisitor visitor) throws PersistenceException {
        visitor.handleBooleanMark(this);
    }
    public <R> R accept(MarkNotCalculableReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBooleanMark(this);
    }
    public <E extends model.UserException>  void accept(MarkNotCalculableExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBooleanMark(this);
    }
    public <R, E extends model.UserException> R accept(MarkNotCalculableReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBooleanMark(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBooleanMark(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBooleanMark(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBooleanMark(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBooleanMark(this);
    }
    public void accept(MarkVisitor visitor) throws PersistenceException {
        visitor.handleBooleanMark(this);
    }
    public <R> R accept(MarkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBooleanMark(this);
    }
    public <E extends model.UserException>  void accept(MarkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBooleanMark(this);
    }
    public <R, E extends model.UserException> R accept(MarkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBooleanMark(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentBooleanMark)This);
		if(this.isTheSameAs(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{       
    }
    public Boolean fetchIsCalculable() 
				throws PersistenceException{
        return false;
    }
    public common.Fraction fetchMarkValue() 
				throws PersistenceException{
        try{
            throw new java.lang.UnsupportedOperationException("Method \"fetchMarkValue\" implemented yet.");
        } catch (java.lang.UnsupportedOperationException uoe){
            uoe.printStackTrace();
            throw uoe;
        }
    }
    public String fetchTypeAsString() 
				throws PersistenceException{
        return "BooleanMark";
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
