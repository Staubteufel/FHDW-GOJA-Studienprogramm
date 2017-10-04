
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class NoneMark extends model.MarkNotCalculable implements PersistentNoneMark{
    
    
    public static NoneMark4Public createNoneMark() throws PersistenceException{
        return createNoneMark(false);
    }
    
    public static NoneMark4Public createNoneMark(boolean delayed$Persistence) throws PersistenceException {
        PersistentNoneMark result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theNoneMarkFacade
                .newDelayedNoneMark();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theNoneMarkFacade
                .newNoneMark(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static NoneMark4Public createNoneMark(boolean delayed$Persistence,NoneMark4Public This) throws PersistenceException {
        PersistentNoneMark result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theNoneMarkFacade
                .newDelayedNoneMark();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theNoneMarkFacade
                .newNoneMark(-1);
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
    
    public NoneMark provideCopy() throws PersistenceException{
        NoneMark result = this;
        result = new NoneMark(this.This, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public NoneMark(PersistentMarkNotCalculable This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMarkNotCalculable)This,id);        
    }
    
    static public long getTypeId() {
        return 115;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 115) ConnectionHandler.getTheConnectionHandler().theNoneMarkFacade
            .newNoneMark(this.getId());
        super.store();
        
    }
    
    public PersistentNoneMark getThis() throws PersistenceException {
        if(this.This == null){
            PersistentNoneMark result = (PersistentNoneMark)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentNoneMark)this.This;
    }
    
    public void accept(MarkNotCalculableVisitor visitor) throws PersistenceException {
        visitor.handleNoneMark(this);
    }
    public <R> R accept(MarkNotCalculableReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoneMark(this);
    }
    public <E extends model.UserException>  void accept(MarkNotCalculableExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoneMark(this);
    }
    public <R, E extends model.UserException> R accept(MarkNotCalculableReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoneMark(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNoneMark(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoneMark(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoneMark(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoneMark(this);
    }
    public void accept(MarkVisitor visitor) throws PersistenceException {
        visitor.handleNoneMark(this);
    }
    public <R> R accept(MarkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoneMark(this);
    }
    public <E extends model.UserException>  void accept(MarkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoneMark(this);
    }
    public <R, E extends model.UserException> R accept(MarkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoneMark(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentNoneMark)This);
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
            throw new java.lang.UnsupportedOperationException("Method \"fetchMarkValue\" not implemented.");
        } catch (java.lang.UnsupportedOperationException uoe){
            uoe.printStackTrace();
            throw uoe;
        }
    }
    public String fetchTypeAsString() 
				throws PersistenceException{
    	return "NoneMark";
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
