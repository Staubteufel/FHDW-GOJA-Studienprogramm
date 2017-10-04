package persistence;

import java.util.HashMap;

import common.ProxiInformation;
import common.RPCConstantsAndServices;

abstract class ProxiFactory {
	  abstract AbstractPersistentRoot create(long objectId);
}
abstract class ListProxiFactory {
	  abstract AbstractPersistentRoot create(long objectId, long entryId);
}

public abstract class PersistentProxi extends PersistentRoot implements PersistentProxiInterface {

  private static ProxiFactory [] proxiFactories;
  private static ListProxiFactory [] listProxiFactories;
	
  private static ListProxiFactory [] getTheListProxiFactories(){
	if (listProxiFactories == null){
		listProxiFactories = new ListProxiFactory[149];
        listProxiFactories[125] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new PassedListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[59] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AddMGToMGCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[40] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ServerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[60] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CreateUnitCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[146] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new MarkFactoryListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[128] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ThirdMarkLstListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[3] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ErrorDisplayListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[103] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new StudyGroupLstListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[104] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ModuleGroupLstListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[4] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ModuleGroupListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[5] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new UnitListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[114] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new FiveZeroListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[56] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new FetchMCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[61] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new RemUFromMWUCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[9] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CommandCoordinatorListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[62] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new RemMGFromMGCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[99] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new StudentServerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[10] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new StudyGroupListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[11] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new TenthMarkListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[115] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new TwoZeroListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[137] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new RmvMWUCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[64] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CreateMWWUCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[14] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new NoneMarkListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[138] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new RemoveUnitCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[15] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new StudyProgramListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[126] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new FailedListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[65] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CreateStudentCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[110] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new FetchStudentMCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[102] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new UnitLstListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[116] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ThreeSevenListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[105] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ModuleWithUnitsLstListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[66] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new RemMGFromSPCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[20] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new MarkHistoryEntryListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[127] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new StudentServerLstListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[21] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CommonDateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[23] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ThirdMarkListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[67] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CreateMWUCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[140] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new RemoveStudyProgramCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[100] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AdminServerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[7] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ModuleWithoutUnitsListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[117] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ThreeZeroListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[118] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new TwoSevenListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[141] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new RemoveModuleGroupCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[69] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new RemMWWUFromMGCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[70] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AddMWUToMGCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[13] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ModuleWithUnitsListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[142] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new RemoveStudyGroupCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[119] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new OneSevenListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[72] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new SorcMTSWiMWuUCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[73] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AddMGToSPCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[74] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AddMWWUToMGCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[75] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new SetActiveSGCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[76] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new SorcMTSWiUCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[148] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ChangeCPCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[120] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ThreeThreeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[121] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new OneThreeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[77] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CreateStudyProgramCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[78] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AddSToSGCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[79] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CreateStudyGroupCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[122] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new TwoThreeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[18] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new BooleanMarkListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[123] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new FourZeroListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[124] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new OneZeroListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[139] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new RmvMWOUCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[106] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new StudyProgramLstListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[80] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new RemMWUFromMGCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[81] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CreateModuleGroupCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[108] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ModuleWithoutUnitsLstListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[82] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AddUToMWUCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[22] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CommandExecuterListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[132] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new BooleanMarkLstListEntryProxi(objectId, entryId);
            }
        };
	}
	return listProxiFactories;
  }
  private static ProxiFactory [] getTheProxiFactories(){
	if (proxiFactories == null){
		proxiFactories = new ProxiFactory [149];
        proxiFactories[125] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new PassedProxi(objectId);
            }
        };
        proxiFactories[59] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AddMGToMGCommandProxi(objectId);
            }
        };
        proxiFactories[40] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ServerProxi(objectId);
            }
        };
        proxiFactories[60] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CreateUnitCommandProxi(objectId);
            }
        };
        proxiFactories[146] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new MarkFactoryProxi(objectId);
            }
        };
        proxiFactories[128] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ThirdMarkLstProxi(objectId);
            }
        };
        proxiFactories[3] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ErrorDisplayProxi(objectId);
            }
        };
        proxiFactories[103] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new StudyGroupLstProxi(objectId);
            }
        };
        proxiFactories[104] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ModuleGroupLstProxi(objectId);
            }
        };
        proxiFactories[4] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ModuleGroupProxi(objectId);
            }
        };
        proxiFactories[5] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new UnitProxi(objectId);
            }
        };
        proxiFactories[114] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new FiveZeroProxi(objectId);
            }
        };
        proxiFactories[56] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new FetchMCommandProxi(objectId);
            }
        };
        proxiFactories[61] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new RemUFromMWUCommandProxi(objectId);
            }
        };
        proxiFactories[9] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CommandCoordinatorProxi(objectId);
            }
        };
        proxiFactories[62] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new RemMGFromMGCommandProxi(objectId);
            }
        };
        proxiFactories[99] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new StudentServerProxi(objectId);
            }
        };
        proxiFactories[10] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new StudyGroupProxi(objectId);
            }
        };
        proxiFactories[11] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new TenthMarkProxi(objectId);
            }
        };
        proxiFactories[115] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new TwoZeroProxi(objectId);
            }
        };
        proxiFactories[137] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new RmvMWUCommandProxi(objectId);
            }
        };
        proxiFactories[64] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CreateMWWUCommandProxi(objectId);
            }
        };
        proxiFactories[14] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new NoneMarkProxi(objectId);
            }
        };
        proxiFactories[138] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new RemoveUnitCommandProxi(objectId);
            }
        };
        proxiFactories[15] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new StudyProgramProxi(objectId);
            }
        };
        proxiFactories[126] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new FailedProxi(objectId);
            }
        };
        proxiFactories[65] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CreateStudentCommandProxi(objectId);
            }
        };
        proxiFactories[110] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new FetchStudentMCommandProxi(objectId);
            }
        };
        proxiFactories[102] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new UnitLstProxi(objectId);
            }
        };
        proxiFactories[116] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ThreeSevenProxi(objectId);
            }
        };
        proxiFactories[105] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ModuleWithUnitsLstProxi(objectId);
            }
        };
        proxiFactories[66] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new RemMGFromSPCommandProxi(objectId);
            }
        };
        proxiFactories[20] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new MarkHistoryEntryProxi(objectId);
            }
        };
        proxiFactories[127] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new StudentServerLstProxi(objectId);
            }
        };
        proxiFactories[21] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CommonDateProxi(objectId);
            }
        };
        proxiFactories[23] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ThirdMarkProxi(objectId);
            }
        };
        proxiFactories[67] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CreateMWUCommandProxi(objectId);
            }
        };
        proxiFactories[140] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new RemoveStudyProgramCommandProxi(objectId);
            }
        };
        proxiFactories[100] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AdminServerProxi(objectId);
            }
        };
        proxiFactories[7] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ModuleWithoutUnitsProxi(objectId);
            }
        };
        proxiFactories[117] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ThreeZeroProxi(objectId);
            }
        };
        proxiFactories[118] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new TwoSevenProxi(objectId);
            }
        };
        proxiFactories[141] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new RemoveModuleGroupCommandProxi(objectId);
            }
        };
        proxiFactories[69] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new RemMWWUFromMGCommandProxi(objectId);
            }
        };
        proxiFactories[70] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AddMWUToMGCommandProxi(objectId);
            }
        };
        proxiFactories[13] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ModuleWithUnitsProxi(objectId);
            }
        };
        proxiFactories[142] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new RemoveStudyGroupCommandProxi(objectId);
            }
        };
        proxiFactories[119] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new OneSevenProxi(objectId);
            }
        };
        proxiFactories[72] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new SorcMTSWiMWuUCommandProxi(objectId);
            }
        };
        proxiFactories[73] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AddMGToSPCommandProxi(objectId);
            }
        };
        proxiFactories[74] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AddMWWUToMGCommandProxi(objectId);
            }
        };
        proxiFactories[75] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new SetActiveSGCommandProxi(objectId);
            }
        };
        proxiFactories[76] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new SorcMTSWiUCommandProxi(objectId);
            }
        };
        proxiFactories[148] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ChangeCPCommandProxi(objectId);
            }
        };
        proxiFactories[120] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ThreeThreeProxi(objectId);
            }
        };
        proxiFactories[121] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new OneThreeProxi(objectId);
            }
        };
        proxiFactories[77] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CreateStudyProgramCommandProxi(objectId);
            }
        };
        proxiFactories[78] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AddSToSGCommandProxi(objectId);
            }
        };
        proxiFactories[79] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CreateStudyGroupCommandProxi(objectId);
            }
        };
        proxiFactories[122] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new TwoThreeProxi(objectId);
            }
        };
        proxiFactories[18] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new BooleanMarkProxi(objectId);
            }
        };
        proxiFactories[123] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new FourZeroProxi(objectId);
            }
        };
        proxiFactories[124] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new OneZeroProxi(objectId);
            }
        };
        proxiFactories[139] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new RmvMWOUCommandProxi(objectId);
            }
        };
        proxiFactories[106] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new StudyProgramLstProxi(objectId);
            }
        };
        proxiFactories[80] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new RemMWUFromMGCommandProxi(objectId);
            }
        };
        proxiFactories[81] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CreateModuleGroupCommandProxi(objectId);
            }
        };
        proxiFactories[108] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ModuleWithoutUnitsLstProxi(objectId);
            }
        };
        proxiFactories[82] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AddUToMWUCommandProxi(objectId);
            }
        };
        proxiFactories[22] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CommandExecuterProxi(objectId);
            }
        };
        proxiFactories[132] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new BooleanMarkLstProxi(objectId);
            }
        };
	}
	return proxiFactories;
  }

  public static PersistentProxiInterface createProxi(ProxiInformation proxi) throws PersistenceException{
	  if (proxi.isDecorator()){
		  Decoratees resultDecoratee = (Decoratees) createProxi(proxi.getDecorateeObjectId(), proxi.getDecorateeClassId());
		  PersistentProxiInterface resultDecorator = (PersistentProxiInterface) resultDecoratee.createDecorator();
		  resultDecorator.setId(proxi.getObjectId());
		  return resultDecorator;
	  } else {
		  return createProxi(proxi.getObjectId(), proxi.getClassId());
	  }
  }

  public static PersistentProxiInterface createProxi(long objectId, long classId) throws PersistenceException {
    int index = (int) classId;
    if (classId == RPCConstantsAndServices.NullClassID) return null; 
	if (index < 0) index = index * -1;
    index = index - 101;
    if (index > getTheProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    ProxiFactory factory = getTheProxiFactories()[index];
    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    PersistentProxiInterface result =  (PersistentProxiInterface)factory.create(objectId);
    result.getTheObject();
    return result;
  }
  public static PersistentListEntryProxi createListEntryProxi(long objectId, long classId, long entryId) throws PersistenceException {
    int index = (int) classId;
	if (index < 0) index = index * -1;
    index = index - 101;
    if (index > getTheListProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    ListProxiFactory factory = getTheListProxiFactories()[index];
    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    PersistentListEntryProxi result =  (PersistentListEntryProxi)factory.create(objectId,entryId);
    result.getTheObject();
    return result;
  }

	private PersistentInCacheProxi object;

	protected PersistentProxi(long id) {
		super(id);
		this.object = null;
	}

	protected PersistentProxi(PersistentInCacheProxi object) {
		//TODO (GOJA) Still needed for Decorator???
		super(object.getId());
		this.object = object;
		this.object.incrementUserCount();
	}
	public boolean isDelayed$Persistence() throws PersistenceException {
		return this.getTheObject().isDelayed$Persistence();
	}

	public void setDelayed$Persistence(boolean b) throws PersistenceException {
		this.getTheObject().setDelayed$Persistence(b);
	}
	public void store() throws PersistenceException{
		this.getTheObject().store();
	}
	public void setId(long id) {
		super.setId(id);
		try {
			this.getTheObject().setId(id);
		} catch (PersistenceException e) {
			throw new PersistenceError(e);
		}
	}

	public void setObject(PersistentRoot object) {
		if (this.object == null)
			this.object = (PersistentInCacheProxi)object;
	}

	public HashMap<String,Object> toHashtable(int depth, int essentialLevel, boolean forGUI) throws PersistenceException {
		PersistentRoot iCRroxi = this.getTheObject();
		if (iCRroxi == null) return null;
		return iCRroxi.toHashtable(depth, essentialLevel, forGUI);
	}
	public HashMap<String, Object> toHashtable(HashMap<String, Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, boolean inDerived) throws PersistenceException {
		PersistentRoot iCRroxi = this.getTheObject();
		if (iCRroxi == null) return null;
		return iCRroxi.toHashtable(allResults, depth, essentialLevel, forGUI, leaf, inDerived);
	}

	public PersistentRoot getTheObject() throws PersistenceException {
		if (this.object == null) {
			this.object = Cache.getTheCache().get(this);
			this.object.incrementUserCount();
		}
		return this.object;
	}
	public boolean hasEssentialFields() throws PersistenceException{
		return this.getTheObject().hasEssentialFields();
	}
	public int getIconInfo() throws PersistenceException {
		return this.getTheObject().getIconInfo();
	}
	public int getLeafInfo() throws PersistenceException {
		return this.getTheObject().getLeafInfo();
	}
	
	public String toString() {
		try {
			return this.getTheObject().toString();
		} catch (PersistenceException pe) {
			throw new PersistenceError(pe);
		}
	}
	public String toString(boolean inner)throws PersistenceException{
		try {
			return this.getTheObject().toString(inner);
		} catch (PersistenceException pe) {
			throw new PersistenceError(pe);
		}		
	}
	public void delete$Me() throws PersistenceException {
		this.getTheObject().delete$Me();
	}
	public Anything getThis() throws PersistenceException {
		return this.getTheObject().getThis();
	}
	
	
    	
	
	public void finalize(){
		if (this.object != null)this.object.decrementUserCount();
	}
}
