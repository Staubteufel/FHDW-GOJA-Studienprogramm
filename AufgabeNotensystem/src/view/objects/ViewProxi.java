package view.objects;


import view.ModelException;

import viewClient.ExceptionAndEventHandler;
import viewClient.ConnectionMaster;
import viewClient.ConnectionIndex;

import common.RPCConstantsAndServices;
import common.ProxiInformation;

import java.util.Vector;
import java.util.Iterator;

import javax.swing.event.TableModelListener;
import javax.swing.tree.TreePath;

abstract class ProxiFactory {
	  abstract ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey);
}

public abstract class ViewProxi extends ViewRoot {

  @SuppressWarnings("unchecked")
  public static <T> Vector<T> getProxiVector(Vector<String> hashtableVector, ExceptionAndEventHandler connectionKey) throws ModelException {
	Vector<T> result = new Vector<T>();
    Iterator<String> entries = hashtableVector.iterator();
    while (entries.hasNext()){
      String current = (String)entries.next();
      ProxiInformation currentProxiInformation = RPCConstantsAndServices.createProxiInformation(current);
      ViewProxi currentProxi = ViewProxi.createProxi(currentProxiInformation, connectionKey);
      currentProxi.setToString(currentProxiInformation.getToString());
      currentProxi.setIconInfo(currentProxiInformation.getIconInfo());
      currentProxi.setLeafInfo(currentProxiInformation.getLeafInfo());
      
      result.add((T) currentProxi);
    }
    return result;
  }
    
  public static ViewProxi createProxi(ProxiInformation proxi, ExceptionAndEventHandler connectionKey) throws ModelException{
	  ViewProxi result = createProxi(proxi.getObjectId(), proxi.getClassId(), connectionKey);
	  if (proxi.isDecorator()){
		  ViewDecoratorProxi resultAsDecorator = (ViewDecoratorProxi) result;
		  resultAsDecorator.setDecorateeId(proxi.getDecorateeObjectId());
		  resultAsDecorator.setDecorateeClassId(proxi.getDecorateeClassId());
	  }
	  result.setIconInfo(proxi.getIconInfo());
	  result.setLeafInfo(proxi.getLeafInfo());
	  return result;
  }

  private static ProxiFactory [] proxiFactories;
	
  private static ProxiFactory [] getTheProxiFactories(){
	if (proxiFactories == null){
		proxiFactories = new ProxiFactory [149];
        proxiFactories[125] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new PassedProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[40] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ServerProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[146] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new MarkFactoryProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[128] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ThirdMarkLstProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[3] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ErrorDisplayProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[103] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new StudyGroupLstProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[104] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ModuleGroupLstProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[4] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ModuleGroupProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[5] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new UnitProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[114] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new FiveZeroProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[99] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new StudentServerProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[10] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new StudyGroupProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[11] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new TenthMarkProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[115] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new TwoZeroProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[14] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new NoneMarkProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[15] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new StudyProgramProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[126] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new FailedProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[102] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new UnitLstProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[116] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ThreeSevenProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[105] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ModuleWithUnitsLstProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[20] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new MarkHistoryEntryProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[127] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new StudentServerLstProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[23] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ThirdMarkProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[100] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new AdminServerProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[7] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ModuleWithoutUnitsProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[117] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ThreeZeroProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[118] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new TwoSevenProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[13] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ModuleWithUnitsProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[119] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new OneSevenProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[120] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ThreeThreeProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[121] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new OneThreeProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[122] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new TwoThreeProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[18] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new BooleanMarkProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[123] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new FourZeroProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[124] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new OneZeroProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[106] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new StudyProgramLstProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[108] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ModuleWithoutUnitsLstProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[132] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new BooleanMarkLstProxi(objectId, classId, connectionKey);
            }
        };
	}
	return proxiFactories;
  }
	
  public static ViewProxi createProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) throws ModelException {
	if (classId == 0) return null;
    int index = (int) classId;
	if (index < 0) index = index * -1;
    index = index - 101;
    if (index > getTheProxiFactories().length) throw new ModelException("Unknown class :" + Long.toString(classId),0);
    ProxiFactory factory = getTheProxiFactories()[index];
    if (factory == null)  throw new ModelException("Unknown class :" + Long.toString(classId),0);
    ViewProxi result =  factory.create(objectId, classId, connectionKey);
    return result;
  }


	protected ViewObject object;

	private ExceptionAndEventHandler connectionKey;

	private boolean expanded;
	

	protected ViewProxi(long id, long classId, ExceptionAndEventHandler connectionKey) {
		super(id, classId);
		this.connectionKey = connectionKey;
		this.expanded = false;
	}
	public void setExpanded(boolean b) {
		this.expanded = true;
	}

	public boolean expand(){
		if (!expanded){
			try {
				this.getRemote(new java.util.Vector<ViewRoot>(), true);
				this.expanded = true;
			} catch (ModelException e) {
				if (e.getErrorNumber() == RPCConstantsAndServices.ObjectNotAvailableErrorNo && this.object != null){
					this.expanded = true;
					return true;
				} else {
					this.setToString(e.getMessage());
					return false;
				}
			}
		}
		return true;
	}

	public ViewObject getTheObject() throws ModelException {
		if (this.object == null)
			getRemote(new java.util.Vector<ViewRoot>(), false);
		return this.object;
	}

	public void setObject(ViewObject object) {
		this.object = object;
	}

	protected ConnectionMaster getConnection() {
		return ConnectionIndex.getTheConnectionIndex().getConnection(this.connectionKey);
	}


	@SuppressWarnings("unchecked")
	public void getRemote(java.util.Vector<ViewRoot> context, boolean forTreeView) throws ModelException {
        ConnectionMaster connection = this.getConnection();
        java.util.HashMap<Object,Object> table = connection.getObject(getRemoteDepth(), context, forTreeView, this);
        if(((Boolean)table.get("?OK?")).booleanValue()) {
            java.util.HashMap<String,Object> resultTable = (java.util.HashMap<String,Object>)table.get(RPCConstantsAndServices.ResultFieldName);
            ViewProxi.resolveReferences(resultTable, this.connectionKey);
            this.setObject((ViewObject) resultTable.get(RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId())));
        }else{
            throw new ModelException((String)table.get("?Message?"), ((Integer)table.get("?ExceptionNumber?")).intValue());
        }
    }
	@SuppressWarnings("unchecked")
	public static void resolveReferences(java.util.HashMap<String, Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        for (String current : resultTable.keySet()) {
			ProxiInformation info = RPCConstantsAndServices.createProxiInformation(current);
			ViewProxi proxi = ViewProxi.createProxi(info, connectionKey);
			resultTable.put(current, proxi.getRemoteObject((java.util.HashMap<String,Object>) resultTable.get(current), connectionKey));
		}
        for (String current : resultTable.keySet()) {
			ViewObject currentEntry = (ViewObject) resultTable.get(current);
			if (currentEntry != null)currentEntry.resolveProxies(resultTable);
		}    	
        for (String current : resultTable.keySet()) {
			ViewObject currentEntry = (ViewObject) resultTable.get(current);
			if (currentEntry != null)currentEntry.sortSetValuedFields();
		}    	
    }

	abstract protected AbstractViewRoot getRemoteObject(java.util.HashMap<String, Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException;

	public String toString() {
		try {
			return this.object == null ? this.toString : this.getTheObject().toString();
		} catch (ModelException me) {
			return me.getMessage();
		}
	}

	public void valueForPathChanged(TreePath path, Object newValue) {
		try {
			this.getTheObject().valueForPathChanged(path, newValue);
		} catch (ModelException e) {
			return;
		}		
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public int getRowCount() {
		try {
			return this.getTheObject().getRowCount();
		} catch (ModelException e) {
			return 0;
		}
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			return this.getTheObject().getValueAt(rowIndex, columnIndex);
		} catch (ModelException e) {
			return e.getMessage();
		}
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		try {
			return this.getTheObject().isCellEditable(rowIndex, columnIndex);
		} catch (ModelException e) {
			return false;
		}
	}

	public boolean isRowEditable(int index) {
		try {
			return this.getTheObject().isRowEditable(index);
		} catch (ModelException e) {
			return false;
		}
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		try {
			this.getTheObject().setValueAt(aValue, rowIndex, columnIndex);
		} catch (ModelException e) {
			return;
		}
	}

	public void addTableModelListener(TableModelListener l) {
		try {
			this.getTheObject().addTableModelListener(l);
		} catch (ModelException e) {
			throw new Error(e.getMessage());
		}
	}

	public void removeTableModelListener(TableModelListener l) {
		try {
			this.getTheObject().removeTableModelListener(l);
		} catch (ModelException e) {
			throw new Error(e.getMessage());
		}
	}
	public String createProxiInformation() {
		return RPCConstantsAndServices.createFromClientProxiRepresentation(this.getClassId(), this.getId(), this.getRemoteDepth());
	}

}
