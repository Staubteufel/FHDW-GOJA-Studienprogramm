
package modelServer;


import persistence.*;

public  class RemoteStudentServer extends RemoteService {

	
	public RemoteStudentServer(String connectionName, String userName, PersistentStudentServer server){
		super (connectionName, userName , server);
	}

	
 

    public synchronized java.util.HashMap<?,?> appr_Path_In_FetchStudentM(){
        try {
            StudyGroupSearchList result = ((PersistentStudentServer)this.server).appr_Path_In_FetchStudentM();
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> studentServer_Menu_Filter(String anythingProxiString){
        try {
            Anything anything = (Anything)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(anythingProxiString));
            String result = ((PersistentStudentServer)this.server).studentServer_Menu_Filter(anything);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> fetchStudentM(String apprProxiString){
        try {
            PersistentAppr appr = (PersistentAppr)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(apprProxiString));
            Mark result = ((PersistentStudentServer)this.server).fetchStudentM(appr);
            return createOKResult(result, 1);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}