package viewClient;

import view.*;
import java.net.MalformedURLException;

import java.io.IOException;
import java.util.Vector;
import org.apache.xmlrpc.XmlRpcException;

public class AdminServerConnection extends ServiceConnection {

	public AdminServerConnection (String url, ExceptionAndEventHandler handler, ClientReporter reporter) throws MalformedURLException {
		super(url, handler, reporter);
	}

	public AdminServerView getAdminServerView(){
		return (AdminServerView)super.getServer();
	}

    public synchronized String adminServer_Menu_Filter(Anything anything) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (anything == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)anything).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "adminServer_Menu_Filter", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                return (String)success.get(common.RPCConstantsAndServices.ResultFieldName);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized ModuleGroupLstView mG_Path_In_AddMGToMG() throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "mG_Path_In_AddMGToMG", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw UnitIsAlreadyPartOfAModuleWithUnitsException.fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -143)
                    throw NotInStudyGroupException.fromHashtableToNotInStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -144)
                    throw StudyGroupAlreadyInStudyProgramException.fromHashtableToStudyGroupAlreadyInStudyProgramException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -145)
                    throw ThereIsAlreadyAStudyGroupException.fromHashtableToThereIsAlreadyAStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -248)
                    throw CreditPointInformationIsNotConsistent.fromHashtableToCreditPointInformationIsNotConsistent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -246)
                    throw MatricalNumberAlreadyUsed.fromHashtableToMatricalNumberAlreadyUsed((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -137)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
                    throw OtherTypeThanSettedException.fromHashtableToOtherTypeThanSettedException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                java.util.HashMap<String,Object> allResults = (java.util.HashMap<String,Object>) success.get(common.RPCConstantsAndServices.ResultFieldName);
                view.objects.ViewProxi.resolveReferences(allResults, getHandler());
                common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success.get(common.RPCConstantsAndServices.RootFieldName));
                ModuleGroupLstView result = (ModuleGroupLstView) view.objects.ViewProxi.createProxi(proxiInformation, getHandler());
                if (result != null) ((view.objects.ViewRoot)result).setToString(proxiInformation.getToString());
                view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
                if (root != null) ((view.objects.ViewProxi)result).setObject(root);
                return result;
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized java.util.Vector<?> mG_Path_In_RemMGFromMG(ModuleGroupView moduleGroup) throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (moduleGroup == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleGroup).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "mG_Path_In_RemMGFromMG", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw UnitIsAlreadyPartOfAModuleWithUnitsException.fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -143)
                    throw NotInStudyGroupException.fromHashtableToNotInStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -144)
                    throw StudyGroupAlreadyInStudyProgramException.fromHashtableToStudyGroupAlreadyInStudyProgramException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -145)
                    throw ThereIsAlreadyAStudyGroupException.fromHashtableToThereIsAlreadyAStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -248)
                    throw CreditPointInformationIsNotConsistent.fromHashtableToCreditPointInformationIsNotConsistent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -246)
                    throw MatricalNumberAlreadyUsed.fromHashtableToMatricalNumberAlreadyUsed((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -137)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
                    throw OtherTypeThanSettedException.fromHashtableToOtherTypeThanSettedException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                return view.objects.ViewProxi.getProxiVector((Vector<String>)success.get(common.RPCConstantsAndServices.ResultListFieldName),getHandler());
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized java.util.Vector<?> markType_Path_In_CreateMWWU() throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "markType_Path_In_CreateMWWU", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw UnitIsAlreadyPartOfAModuleWithUnitsException.fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -143)
                    throw NotInStudyGroupException.fromHashtableToNotInStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -144)
                    throw StudyGroupAlreadyInStudyProgramException.fromHashtableToStudyGroupAlreadyInStudyProgramException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -145)
                    throw ThereIsAlreadyAStudyGroupException.fromHashtableToThereIsAlreadyAStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -248)
                    throw CreditPointInformationIsNotConsistent.fromHashtableToCreditPointInformationIsNotConsistent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -246)
                    throw MatricalNumberAlreadyUsed.fromHashtableToMatricalNumberAlreadyUsed((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -137)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
                    throw OtherTypeThanSettedException.fromHashtableToOtherTypeThanSettedException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                return view.objects.ViewProxi.getProxiVector((Vector<String>)success.get(common.RPCConstantsAndServices.ResultListFieldName),getHandler());
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized java.util.Vector<?> mark_Path_In_SorcMTSWiMWuU() throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "mark_Path_In_SorcMTSWiMWuU", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw UnitIsAlreadyPartOfAModuleWithUnitsException.fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -143)
                    throw NotInStudyGroupException.fromHashtableToNotInStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -144)
                    throw StudyGroupAlreadyInStudyProgramException.fromHashtableToStudyGroupAlreadyInStudyProgramException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -145)
                    throw ThereIsAlreadyAStudyGroupException.fromHashtableToThereIsAlreadyAStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -248)
                    throw CreditPointInformationIsNotConsistent.fromHashtableToCreditPointInformationIsNotConsistent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -246)
                    throw MatricalNumberAlreadyUsed.fromHashtableToMatricalNumberAlreadyUsed((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -137)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
                    throw OtherTypeThanSettedException.fromHashtableToOtherTypeThanSettedException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                return view.objects.ViewProxi.getProxiVector((Vector<String>)success.get(common.RPCConstantsAndServices.ResultListFieldName),getHandler());
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized ThirdMarkLstView mark_Path_In_SorcMTSWiU() throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "mark_Path_In_SorcMTSWiU", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw UnitIsAlreadyPartOfAModuleWithUnitsException.fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -143)
                    throw NotInStudyGroupException.fromHashtableToNotInStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -144)
                    throw StudyGroupAlreadyInStudyProgramException.fromHashtableToStudyGroupAlreadyInStudyProgramException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -145)
                    throw ThereIsAlreadyAStudyGroupException.fromHashtableToThereIsAlreadyAStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -248)
                    throw CreditPointInformationIsNotConsistent.fromHashtableToCreditPointInformationIsNotConsistent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -246)
                    throw MatricalNumberAlreadyUsed.fromHashtableToMatricalNumberAlreadyUsed((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -137)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
                    throw OtherTypeThanSettedException.fromHashtableToOtherTypeThanSettedException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                java.util.HashMap<String,Object> allResults = (java.util.HashMap<String,Object>) success.get(common.RPCConstantsAndServices.ResultFieldName);
                view.objects.ViewProxi.resolveReferences(allResults, getHandler());
                common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success.get(common.RPCConstantsAndServices.RootFieldName));
                ThirdMarkLstView result = (ThirdMarkLstView) view.objects.ViewProxi.createProxi(proxiInformation, getHandler());
                if (result != null) ((view.objects.ViewRoot)result).setToString(proxiInformation.getToString());
                view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
                if (root != null) ((view.objects.ViewProxi)result).setObject(root);
                return result;
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized ModuleGroupLstView moduleGroup_Path_In_AddMGToSP() throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "moduleGroup_Path_In_AddMGToSP", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw UnitIsAlreadyPartOfAModuleWithUnitsException.fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -143)
                    throw NotInStudyGroupException.fromHashtableToNotInStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -144)
                    throw StudyGroupAlreadyInStudyProgramException.fromHashtableToStudyGroupAlreadyInStudyProgramException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -145)
                    throw ThereIsAlreadyAStudyGroupException.fromHashtableToThereIsAlreadyAStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -248)
                    throw CreditPointInformationIsNotConsistent.fromHashtableToCreditPointInformationIsNotConsistent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -246)
                    throw MatricalNumberAlreadyUsed.fromHashtableToMatricalNumberAlreadyUsed((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -137)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
                    throw OtherTypeThanSettedException.fromHashtableToOtherTypeThanSettedException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                java.util.HashMap<String,Object> allResults = (java.util.HashMap<String,Object>) success.get(common.RPCConstantsAndServices.ResultFieldName);
                view.objects.ViewProxi.resolveReferences(allResults, getHandler());
                common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success.get(common.RPCConstantsAndServices.RootFieldName));
                ModuleGroupLstView result = (ModuleGroupLstView) view.objects.ViewProxi.createProxi(proxiInformation, getHandler());
                if (result != null) ((view.objects.ViewRoot)result).setToString(proxiInformation.getToString());
                view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
                if (root != null) ((view.objects.ViewProxi)result).setObject(root);
                return result;
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized java.util.Vector<?> moduleGroup_Path_In_RemMGFromSP(StudyProgramView studyProgram) throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (studyProgram == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)studyProgram).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "moduleGroup_Path_In_RemMGFromSP", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw UnitIsAlreadyPartOfAModuleWithUnitsException.fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -143)
                    throw NotInStudyGroupException.fromHashtableToNotInStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -144)
                    throw StudyGroupAlreadyInStudyProgramException.fromHashtableToStudyGroupAlreadyInStudyProgramException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -145)
                    throw ThereIsAlreadyAStudyGroupException.fromHashtableToThereIsAlreadyAStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -248)
                    throw CreditPointInformationIsNotConsistent.fromHashtableToCreditPointInformationIsNotConsistent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -246)
                    throw MatricalNumberAlreadyUsed.fromHashtableToMatricalNumberAlreadyUsed((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -137)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
                    throw OtherTypeThanSettedException.fromHashtableToOtherTypeThanSettedException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                return view.objects.ViewProxi.getProxiVector((Vector<String>)success.get(common.RPCConstantsAndServices.ResultListFieldName),getHandler());
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized ModuleWithUnitsLstView moduleWithUnits_Path_In_AddMWUToMG() throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "moduleWithUnits_Path_In_AddMWUToMG", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw UnitIsAlreadyPartOfAModuleWithUnitsException.fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -143)
                    throw NotInStudyGroupException.fromHashtableToNotInStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -144)
                    throw StudyGroupAlreadyInStudyProgramException.fromHashtableToStudyGroupAlreadyInStudyProgramException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -145)
                    throw ThereIsAlreadyAStudyGroupException.fromHashtableToThereIsAlreadyAStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -248)
                    throw CreditPointInformationIsNotConsistent.fromHashtableToCreditPointInformationIsNotConsistent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -246)
                    throw MatricalNumberAlreadyUsed.fromHashtableToMatricalNumberAlreadyUsed((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -137)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
                    throw OtherTypeThanSettedException.fromHashtableToOtherTypeThanSettedException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                java.util.HashMap<String,Object> allResults = (java.util.HashMap<String,Object>) success.get(common.RPCConstantsAndServices.ResultFieldName);
                view.objects.ViewProxi.resolveReferences(allResults, getHandler());
                common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success.get(common.RPCConstantsAndServices.RootFieldName));
                ModuleWithUnitsLstView result = (ModuleWithUnitsLstView) view.objects.ViewProxi.createProxi(proxiInformation, getHandler());
                if (result != null) ((view.objects.ViewRoot)result).setToString(proxiInformation.getToString());
                view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
                if (root != null) ((view.objects.ViewProxi)result).setObject(root);
                return result;
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized java.util.Vector<?> moduleWithUnits_Path_In_RemMWUFromMG(ModuleGroupView moduleGroup) throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (moduleGroup == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleGroup).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "moduleWithUnits_Path_In_RemMWUFromMG", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw UnitIsAlreadyPartOfAModuleWithUnitsException.fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -143)
                    throw NotInStudyGroupException.fromHashtableToNotInStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -144)
                    throw StudyGroupAlreadyInStudyProgramException.fromHashtableToStudyGroupAlreadyInStudyProgramException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -145)
                    throw ThereIsAlreadyAStudyGroupException.fromHashtableToThereIsAlreadyAStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -248)
                    throw CreditPointInformationIsNotConsistent.fromHashtableToCreditPointInformationIsNotConsistent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -246)
                    throw MatricalNumberAlreadyUsed.fromHashtableToMatricalNumberAlreadyUsed((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -137)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
                    throw OtherTypeThanSettedException.fromHashtableToOtherTypeThanSettedException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                return view.objects.ViewProxi.getProxiVector((Vector<String>)success.get(common.RPCConstantsAndServices.ResultListFieldName),getHandler());
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized ModuleWithoutUnitsLstView moduleWithoutUnits_Path_In_AddMWWUToMG() throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "moduleWithoutUnits_Path_In_AddMWWUToMG", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw UnitIsAlreadyPartOfAModuleWithUnitsException.fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -143)
                    throw NotInStudyGroupException.fromHashtableToNotInStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -144)
                    throw StudyGroupAlreadyInStudyProgramException.fromHashtableToStudyGroupAlreadyInStudyProgramException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -145)
                    throw ThereIsAlreadyAStudyGroupException.fromHashtableToThereIsAlreadyAStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -248)
                    throw CreditPointInformationIsNotConsistent.fromHashtableToCreditPointInformationIsNotConsistent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -246)
                    throw MatricalNumberAlreadyUsed.fromHashtableToMatricalNumberAlreadyUsed((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -137)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
                    throw OtherTypeThanSettedException.fromHashtableToOtherTypeThanSettedException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                java.util.HashMap<String,Object> allResults = (java.util.HashMap<String,Object>) success.get(common.RPCConstantsAndServices.ResultFieldName);
                view.objects.ViewProxi.resolveReferences(allResults, getHandler());
                common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success.get(common.RPCConstantsAndServices.RootFieldName));
                ModuleWithoutUnitsLstView result = (ModuleWithoutUnitsLstView) view.objects.ViewProxi.createProxi(proxiInformation, getHandler());
                if (result != null) ((view.objects.ViewRoot)result).setToString(proxiInformation.getToString());
                view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
                if (root != null) ((view.objects.ViewProxi)result).setObject(root);
                return result;
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized java.util.Vector<?> moduleWithoutUnits_Path_In_RemMWWUFromMG(ModuleGroupView moduleGroup) throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (moduleGroup == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleGroup).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "moduleWithoutUnits_Path_In_RemMWWUFromMG", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw UnitIsAlreadyPartOfAModuleWithUnitsException.fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -143)
                    throw NotInStudyGroupException.fromHashtableToNotInStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -144)
                    throw StudyGroupAlreadyInStudyProgramException.fromHashtableToStudyGroupAlreadyInStudyProgramException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -145)
                    throw ThereIsAlreadyAStudyGroupException.fromHashtableToThereIsAlreadyAStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -248)
                    throw CreditPointInformationIsNotConsistent.fromHashtableToCreditPointInformationIsNotConsistent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -246)
                    throw MatricalNumberAlreadyUsed.fromHashtableToMatricalNumberAlreadyUsed((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -137)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
                    throw OtherTypeThanSettedException.fromHashtableToOtherTypeThanSettedException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                return view.objects.ViewProxi.getProxiVector((Vector<String>)success.get(common.RPCConstantsAndServices.ResultListFieldName),getHandler());
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized ModuleWithoutUnitsLstView moduleWithoutUnits_Path_In_SorcMTSWiMWuU() throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "moduleWithoutUnits_Path_In_SorcMTSWiMWuU", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw UnitIsAlreadyPartOfAModuleWithUnitsException.fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -143)
                    throw NotInStudyGroupException.fromHashtableToNotInStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -144)
                    throw StudyGroupAlreadyInStudyProgramException.fromHashtableToStudyGroupAlreadyInStudyProgramException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -145)
                    throw ThereIsAlreadyAStudyGroupException.fromHashtableToThereIsAlreadyAStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -248)
                    throw CreditPointInformationIsNotConsistent.fromHashtableToCreditPointInformationIsNotConsistent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -246)
                    throw MatricalNumberAlreadyUsed.fromHashtableToMatricalNumberAlreadyUsed((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -137)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
                    throw OtherTypeThanSettedException.fromHashtableToOtherTypeThanSettedException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                java.util.HashMap<String,Object> allResults = (java.util.HashMap<String,Object>) success.get(common.RPCConstantsAndServices.ResultFieldName);
                view.objects.ViewProxi.resolveReferences(allResults, getHandler());
                common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success.get(common.RPCConstantsAndServices.RootFieldName));
                ModuleWithoutUnitsLstView result = (ModuleWithoutUnitsLstView) view.objects.ViewProxi.createProxi(proxiInformation, getHandler());
                if (result != null) ((view.objects.ViewRoot)result).setToString(proxiInformation.getToString());
                view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
                if (root != null) ((view.objects.ViewProxi)result).setObject(root);
                return result;
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized StudentServerLstView student_Path_In_AddSToSG() throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "student_Path_In_AddSToSG", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw UnitIsAlreadyPartOfAModuleWithUnitsException.fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -143)
                    throw NotInStudyGroupException.fromHashtableToNotInStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -144)
                    throw StudyGroupAlreadyInStudyProgramException.fromHashtableToStudyGroupAlreadyInStudyProgramException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -145)
                    throw ThereIsAlreadyAStudyGroupException.fromHashtableToThereIsAlreadyAStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -248)
                    throw CreditPointInformationIsNotConsistent.fromHashtableToCreditPointInformationIsNotConsistent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -246)
                    throw MatricalNumberAlreadyUsed.fromHashtableToMatricalNumberAlreadyUsed((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -137)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
                    throw OtherTypeThanSettedException.fromHashtableToOtherTypeThanSettedException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                java.util.HashMap<String,Object> allResults = (java.util.HashMap<String,Object>) success.get(common.RPCConstantsAndServices.ResultFieldName);
                view.objects.ViewProxi.resolveReferences(allResults, getHandler());
                common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success.get(common.RPCConstantsAndServices.RootFieldName));
                StudentServerLstView result = (StudentServerLstView) view.objects.ViewProxi.createProxi(proxiInformation, getHandler());
                if (result != null) ((view.objects.ViewRoot)result).setToString(proxiInformation.getToString());
                view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
                if (root != null) ((view.objects.ViewProxi)result).setObject(root);
                return result;
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized StudyGroupLstView studyGroup_Path_In_CreateStudent() throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "studyGroup_Path_In_CreateStudent", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw UnitIsAlreadyPartOfAModuleWithUnitsException.fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -143)
                    throw NotInStudyGroupException.fromHashtableToNotInStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -144)
                    throw StudyGroupAlreadyInStudyProgramException.fromHashtableToStudyGroupAlreadyInStudyProgramException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -145)
                    throw ThereIsAlreadyAStudyGroupException.fromHashtableToThereIsAlreadyAStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -248)
                    throw CreditPointInformationIsNotConsistent.fromHashtableToCreditPointInformationIsNotConsistent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -246)
                    throw MatricalNumberAlreadyUsed.fromHashtableToMatricalNumberAlreadyUsed((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -137)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
                    throw OtherTypeThanSettedException.fromHashtableToOtherTypeThanSettedException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                java.util.HashMap<String,Object> allResults = (java.util.HashMap<String,Object>) success.get(common.RPCConstantsAndServices.ResultFieldName);
                view.objects.ViewProxi.resolveReferences(allResults, getHandler());
                common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success.get(common.RPCConstantsAndServices.RootFieldName));
                StudyGroupLstView result = (StudyGroupLstView) view.objects.ViewProxi.createProxi(proxiInformation, getHandler());
                if (result != null) ((view.objects.ViewRoot)result).setToString(proxiInformation.getToString());
                view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
                if (root != null) ((view.objects.ViewProxi)result).setObject(root);
                return result;
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized java.util.Vector<?> studyGroup_Path_In_SetActiveSG(StudentServerView student) throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (student == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)student).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "studyGroup_Path_In_SetActiveSG", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw UnitIsAlreadyPartOfAModuleWithUnitsException.fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -143)
                    throw NotInStudyGroupException.fromHashtableToNotInStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -144)
                    throw StudyGroupAlreadyInStudyProgramException.fromHashtableToStudyGroupAlreadyInStudyProgramException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -145)
                    throw ThereIsAlreadyAStudyGroupException.fromHashtableToThereIsAlreadyAStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -248)
                    throw CreditPointInformationIsNotConsistent.fromHashtableToCreditPointInformationIsNotConsistent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -246)
                    throw MatricalNumberAlreadyUsed.fromHashtableToMatricalNumberAlreadyUsed((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -137)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
                    throw OtherTypeThanSettedException.fromHashtableToOtherTypeThanSettedException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                return view.objects.ViewProxi.getProxiVector((Vector<String>)success.get(common.RPCConstantsAndServices.ResultListFieldName),getHandler());
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized StudyProgramLstView studyProgram_Path_In_CreateStudyGroup() throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "studyProgram_Path_In_CreateStudyGroup", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw UnitIsAlreadyPartOfAModuleWithUnitsException.fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -143)
                    throw NotInStudyGroupException.fromHashtableToNotInStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -144)
                    throw StudyGroupAlreadyInStudyProgramException.fromHashtableToStudyGroupAlreadyInStudyProgramException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -145)
                    throw ThereIsAlreadyAStudyGroupException.fromHashtableToThereIsAlreadyAStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -248)
                    throw CreditPointInformationIsNotConsistent.fromHashtableToCreditPointInformationIsNotConsistent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -246)
                    throw MatricalNumberAlreadyUsed.fromHashtableToMatricalNumberAlreadyUsed((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -137)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
                    throw OtherTypeThanSettedException.fromHashtableToOtherTypeThanSettedException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                java.util.HashMap<String,Object> allResults = (java.util.HashMap<String,Object>) success.get(common.RPCConstantsAndServices.ResultFieldName);
                view.objects.ViewProxi.resolveReferences(allResults, getHandler());
                common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success.get(common.RPCConstantsAndServices.RootFieldName));
                StudyProgramLstView result = (StudyProgramLstView) view.objects.ViewProxi.createProxi(proxiInformation, getHandler());
                if (result != null) ((view.objects.ViewRoot)result).setToString(proxiInformation.getToString());
                view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
                if (root != null) ((view.objects.ViewProxi)result).setObject(root);
                return result;
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized UnitLstView unit_Path_In_AddUToMWU() throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "unit_Path_In_AddUToMWU", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw UnitIsAlreadyPartOfAModuleWithUnitsException.fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -143)
                    throw NotInStudyGroupException.fromHashtableToNotInStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -144)
                    throw StudyGroupAlreadyInStudyProgramException.fromHashtableToStudyGroupAlreadyInStudyProgramException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -145)
                    throw ThereIsAlreadyAStudyGroupException.fromHashtableToThereIsAlreadyAStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -248)
                    throw CreditPointInformationIsNotConsistent.fromHashtableToCreditPointInformationIsNotConsistent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -246)
                    throw MatricalNumberAlreadyUsed.fromHashtableToMatricalNumberAlreadyUsed((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -137)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
                    throw OtherTypeThanSettedException.fromHashtableToOtherTypeThanSettedException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                java.util.HashMap<String,Object> allResults = (java.util.HashMap<String,Object>) success.get(common.RPCConstantsAndServices.ResultFieldName);
                view.objects.ViewProxi.resolveReferences(allResults, getHandler());
                common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success.get(common.RPCConstantsAndServices.RootFieldName));
                UnitLstView result = (UnitLstView) view.objects.ViewProxi.createProxi(proxiInformation, getHandler());
                if (result != null) ((view.objects.ViewRoot)result).setToString(proxiInformation.getToString());
                view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
                if (root != null) ((view.objects.ViewProxi)result).setObject(root);
                return result;
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized java.util.Vector<?> unit_Path_In_RemUFromMWU(ModuleWithUnitsView moduleWithUnits) throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (moduleWithUnits == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleWithUnits).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "unit_Path_In_RemUFromMWU", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw UnitIsAlreadyPartOfAModuleWithUnitsException.fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -143)
                    throw NotInStudyGroupException.fromHashtableToNotInStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -144)
                    throw StudyGroupAlreadyInStudyProgramException.fromHashtableToStudyGroupAlreadyInStudyProgramException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -145)
                    throw ThereIsAlreadyAStudyGroupException.fromHashtableToThereIsAlreadyAStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -248)
                    throw CreditPointInformationIsNotConsistent.fromHashtableToCreditPointInformationIsNotConsistent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -246)
                    throw MatricalNumberAlreadyUsed.fromHashtableToMatricalNumberAlreadyUsed((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -137)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
                    throw OtherTypeThanSettedException.fromHashtableToOtherTypeThanSettedException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                return view.objects.ViewProxi.getProxiVector((Vector<String>)success.get(common.RPCConstantsAndServices.ResultListFieldName),getHandler());
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized UnitLstView unit_Path_In_SorcMTSWiU() throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "unit_Path_In_SorcMTSWiU", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw UnitIsAlreadyPartOfAModuleWithUnitsException.fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -143)
                    throw NotInStudyGroupException.fromHashtableToNotInStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -144)
                    throw StudyGroupAlreadyInStudyProgramException.fromHashtableToStudyGroupAlreadyInStudyProgramException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -145)
                    throw ThereIsAlreadyAStudyGroupException.fromHashtableToThereIsAlreadyAStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -248)
                    throw CreditPointInformationIsNotConsistent.fromHashtableToCreditPointInformationIsNotConsistent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -246)
                    throw MatricalNumberAlreadyUsed.fromHashtableToMatricalNumberAlreadyUsed((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -137)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
                    throw OtherTypeThanSettedException.fromHashtableToOtherTypeThanSettedException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                java.util.HashMap<String,Object> allResults = (java.util.HashMap<String,Object>) success.get(common.RPCConstantsAndServices.ResultFieldName);
                view.objects.ViewProxi.resolveReferences(allResults, getHandler());
                common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success.get(common.RPCConstantsAndServices.RootFieldName));
                UnitLstView result = (UnitLstView) view.objects.ViewProxi.createProxi(proxiInformation, getHandler());
                if (result != null) ((view.objects.ViewRoot)result).setToString(proxiInformation.getToString());
                view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
                if (root != null) ((view.objects.ViewProxi)result).setObject(root);
                return result;
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void addMGToMG(ModuleGroupView moduleGroup, ModuleGroupView mG) throws ModelException, CycleException, AlreadyInUseException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (moduleGroup == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleGroup).createProxiInformation());
            }
            if (mG == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)mG).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "addMGToMG", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void addMGToSP(StudyProgramView studyProgram, ModuleGroupView moduleGroup) throws ModelException, AlreadyInUseException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (studyProgram == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)studyProgram).createProxiInformation());
            }
            if (moduleGroup == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleGroup).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "addMGToSP", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void addMWUToMG(ModuleGroupView moduleGroup, ModuleWithUnitsView moduleWithUnits) throws ModelException, CycleException, AlreadyInUseException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (moduleGroup == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleGroup).createProxiInformation());
            }
            if (moduleWithUnits == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleWithUnits).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "addMWUToMG", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void addMWWUToMG(ModuleGroupView moduleGroup, ModuleWithoutUnitsView moduleWithoutUnits) throws ModelException, CycleException, AlreadyInUseException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (moduleGroup == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleGroup).createProxiInformation());
            }
            if (moduleWithoutUnits == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleWithoutUnits).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "addMWWUToMG", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -135)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void addSToSG(StudyGroupView studyGroup, StudentServerView student) throws ModelException, AlreadyInUseException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (studyGroup == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)studyGroup).createProxiInformation());
            }
            if (student == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)student).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "addSToSG", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void addUToMWU(ModuleWithUnitsView moduleWithUnits, UnitView unit) throws ModelException, ThereIsAlreadyAStudyGroupException, UnitIsAlreadyPartOfAModuleWithUnitsException, AlreadyInUseException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (moduleWithUnits == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleWithUnits).createProxiInformation());
            }
            if (unit == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)unit).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "addUToMWU", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -145)
                    throw ThereIsAlreadyAStudyGroupException.fromHashtableToThereIsAlreadyAStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw UnitIsAlreadyPartOfAModuleWithUnitsException.fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void changeCP(ApprView appr, common.Fraction creditPoints) throws ModelException, AlreadyInUseException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (appr == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)appr).createProxiInformation());
            }
            parameters.add(creditPoints.toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "changeCP", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void createMWU(String name, common.Fraction creditPoints) throws ModelException, NameAlreadyExistsException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(name);
            parameters.add(creditPoints.toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "createMWU", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void createMWWU(String name, common.Fraction creditPoints, Mark markType) throws ModelException, NameAlreadyExistsException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(name);
            parameters.add(creditPoints.toString());
            if (markType == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)markType).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "createMWWU", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void createModuleGroup(String name, common.Fraction creditPoints) throws ModelException, NameAlreadyExistsException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(name);
            parameters.add(creditPoints.toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "createModuleGroup", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void createStudent(String matricalNumber, String password, String forename, String surname, java.util.Date dateOfBirth, StudyGroupView studyGroup) throws ModelException, MatricalNumberAlreadyUsed, CreditPointInformationIsNotConsistent{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(matricalNumber);
            parameters.add(password);
            parameters.add(forename);
            parameters.add(surname);
            parameters.add(dateOfBirth);
            if (studyGroup == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)studyGroup).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "createStudent", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -246)
                    throw MatricalNumberAlreadyUsed.fromHashtableToMatricalNumberAlreadyUsed((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -248)
                    throw CreditPointInformationIsNotConsistent.fromHashtableToCreditPointInformationIsNotConsistent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void createStudyGroup(String name, StudyProgramView studyProgram) throws ModelException, NameAlreadyExistsException, CreditPointInformationIsNotConsistent{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(name);
            if (studyProgram == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)studyProgram).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "createStudyGroup", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -248)
                    throw CreditPointInformationIsNotConsistent.fromHashtableToCreditPointInformationIsNotConsistent((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void createStudyProgram(String name, common.Fraction creditPoints) throws ModelException, NameAlreadyExistsException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(name);
            parameters.add(creditPoints.toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "createStudyProgram", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void createUnit(String name, common.Fraction creditPoints) throws ModelException, NameAlreadyExistsException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(name);
            parameters.add(creditPoints.toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "createUnit", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -146)
                    throw NameAlreadyExistsException.fromHashtableToNameAlreadyExistsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized Mark fetchM(ApprView appr) throws ModelException, NotAllowedOperationOnPrototypeException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (appr == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)appr).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "fetchM", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                java.util.HashMap<String,Object> allResults = (java.util.HashMap<String,Object>) success.get(common.RPCConstantsAndServices.ResultFieldName);
                view.objects.ViewProxi.resolveReferences(allResults, getHandler());
                common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success.get(common.RPCConstantsAndServices.RootFieldName));
                Mark result = (Mark) view.objects.ViewProxi.createProxi(proxiInformation, getHandler());
                if (result != null) ((view.objects.ViewRoot)result).setToString(proxiInformation.getToString());
                view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
                if (root != null) ((view.objects.ViewProxi)result).setObject(root);
                return result;
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void remMGFromMG(ModuleGroupView moduleGroup, ModuleGroupView mG) throws ModelException, AlreadyInUseException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (moduleGroup == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleGroup).createProxiInformation());
            }
            if (mG == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)mG).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "remMGFromMG", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void remMGFromSP(StudyProgramView studyProgram, ModuleGroupView moduleGroup) throws ModelException, AlreadyInUseException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (studyProgram == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)studyProgram).createProxiInformation());
            }
            if (moduleGroup == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleGroup).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "remMGFromSP", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void remMWUFromMG(ModuleGroupView moduleGroup, ModuleWithUnitsView moduleWithUnits) throws ModelException, AlreadyInUseException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (moduleGroup == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleGroup).createProxiInformation());
            }
            if (moduleWithUnits == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleWithUnits).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "remMWUFromMG", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void remMWWUFromMG(ModuleGroupView moduleGroup, ModuleWithoutUnitsView moduleWithoutUnits) throws ModelException, AlreadyInUseException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (moduleGroup == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleGroup).createProxiInformation());
            }
            if (moduleWithoutUnits == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleWithoutUnits).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "remMWWUFromMG", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void remUFromMWU(ModuleWithUnitsView moduleWithUnits, UnitView unit) throws ModelException, AlreadyInUseException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (moduleWithUnits == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleWithUnits).createProxiInformation());
            }
            if (unit == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)unit).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "remUFromMWU", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void removeModuleGroup(ModuleGroupView moduleGroup) throws ModelException, AlreadyInUseException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (moduleGroup == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleGroup).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "removeModuleGroup", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void removeStudyGroup(StudyGroupView studyGroup) throws ModelException, AlreadyInUseException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (studyGroup == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)studyGroup).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "removeStudyGroup", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void removeStudyProgram(StudyProgramView studyProgram) throws ModelException, AlreadyInUseException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (studyProgram == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)studyProgram).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "removeStudyProgram", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void removeUnit(UnitView unit) throws ModelException, UnitIsAlreadyPartOfAModuleWithUnitsException, AlreadyInUseException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (unit == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)unit).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "removeUnit", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
                    throw UnitIsAlreadyPartOfAModuleWithUnitsException.fromHashtableToUnitIsAlreadyPartOfAModuleWithUnitsException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void rmvMWOU(ModuleWithoutUnitsView moduleWithoutUnits) throws ModelException, AlreadyInUseException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (moduleWithoutUnits == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleWithoutUnits).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "rmvMWOU", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void rmvMWU(ModuleWithUnitsView moduleWithUnits) throws ModelException, AlreadyInUseException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (moduleWithUnits == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleWithUnits).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "rmvMWU", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -236)
                    throw AlreadyInUseException.fromHashtableToAlreadyInUseException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void setActiveSG(StudentServerView student, StudyGroupView studyGroup) throws ModelException, NotInStudyGroupException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (student == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)student).createProxiInformation());
            }
            if (studyGroup == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)studyGroup).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "setActiveSG", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -143)
                    throw NotInStudyGroupException.fromHashtableToNotInStudyGroupException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void sorcMTSWiMWuU(ModuleWithoutUnitsView moduleWithoutUnits, Mark mark, String comment) throws ModelException, OtherTypeThanSettedException, NotAllowedOperationOnPrototypeException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (moduleWithoutUnits == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)moduleWithoutUnits).createProxiInformation());
            }
            if (mark == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)mark).createProxiInformation());
            }
            parameters.add(comment);
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "sorcMTSWiMWuU", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
                    throw OtherTypeThanSettedException.fromHashtableToOtherTypeThanSettedException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public synchronized void sorcMTSWiU(UnitView unit, ThirdMarkView mark, String comment) throws ModelException, NotAllowedOperationOnPrototypeException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (unit == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)unit).createProxiInformation());
            }
            if (mark == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)mark).createProxiInformation());
            }
            parameters.add(comment);
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "sorcMTSWiU", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
                    throw NotAllowedOperationOnPrototypeException.fromHashtableToNotAllowedOperationOnPrototypeException((java.util.HashMap<String,Object>)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    

}
