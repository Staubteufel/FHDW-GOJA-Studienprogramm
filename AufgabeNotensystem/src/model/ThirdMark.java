
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class ThirdMark extends model.MarkCalculable implements PersistentThirdMark{
    
    
    public static ThirdMark4Public createThirdMark(common.Fraction value) throws PersistenceException{
        return createThirdMark(value,false);
    }
    
    public static ThirdMark4Public createThirdMark(common.Fraction value,boolean delayed$Persistence) throws PersistenceException {
        PersistentThirdMark result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theThirdMarkFacade
                .newDelayedThirdMark(value);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theThirdMarkFacade
                .newThirdMark(value,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("value", value);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ThirdMark4Public createThirdMark(common.Fraction value,boolean delayed$Persistence,ThirdMark4Public This) throws PersistenceException {
        PersistentThirdMark result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theThirdMarkFacade
                .newDelayedThirdMark(value);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theThirdMarkFacade
                .newThirdMark(value,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("value", value);
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
    
    public ThirdMark provideCopy() throws PersistenceException{
        ThirdMark result = this;
        result = new ThirdMark(this.value, 
                               this.This, 
                               this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public ThirdMark(common.Fraction value,PersistentMarkCalculable This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((common.Fraction)value,(PersistentMarkCalculable)This,id);        
    }
    
    static public long getTypeId() {
        return 124;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 124) ConnectionHandler.getTheConnectionHandler().theThirdMarkFacade
            .newThirdMark(value,this.getId());
        super.store();
        
    }
    
    public PersistentThirdMark getThis() throws PersistenceException {
        if(this.This == null){
            PersistentThirdMark result = (PersistentThirdMark)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentThirdMark)this.This;
    }
    
    public void accept(ThirdMarkVisitor visitor) throws PersistenceException {
        visitor.handleThirdMark(this);
    }
    public <R> R accept(ThirdMarkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleThirdMark(this);
    }
    public <E extends model.UserException>  void accept(ThirdMarkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleThirdMark(this);
    }
    public <R, E extends model.UserException> R accept(ThirdMarkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleThirdMark(this);
    }
    public void accept(MarkCalculableVisitor visitor) throws PersistenceException {
        visitor.handleThirdMark(this);
    }
    public <R> R accept(MarkCalculableReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleThirdMark(this);
    }
    public <E extends model.UserException>  void accept(MarkCalculableExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleThirdMark(this);
    }
    public <R, E extends model.UserException> R accept(MarkCalculableReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleThirdMark(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleThirdMark(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleThirdMark(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleThirdMark(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleThirdMark(this);
    }
    public void accept(MarkVisitor visitor) throws PersistenceException {
        visitor.handleThirdMark(this);
    }
    public <R> R accept(MarkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleThirdMark(this);
    }
    public <E extends model.UserException>  void accept(MarkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleThirdMark(this);
    }
    public <R, E extends model.UserException> R accept(MarkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleThirdMark(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentThirdMark)This);
		if(this.isTheSameAs(This)){
			this.setValue((common.Fraction)final$$Fields.get("value"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public common.Fraction fetchMarkValue() 
				throws PersistenceException{
        return getThis().getValue();
    }
    public String fetchTypeAsString() 
				throws PersistenceException{
        return "ThirdMark";
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
