package model;

import common.Fraction;
import persistence.*;

public class ToString$Visitor extends model.visitor.ToString$Visitor {

	private String result;
	
	public ToString$Visitor() {
	}
	public synchronized String toString(Anything anything) throws PersistenceException {
		try {
			result = null;
			anything.accept(this);
			if (result == null) {
				this.standardHandling(anything);
			} else {
				if (common.RPCConstantsAndServices.test) 
					result = " " + anything.getClassId() + " , " + anything.getId() + "::  " + result; 
			}
		} catch (Exception ex){
			System.out.println("During toString of " + anything.getClass() + " happened " + ex);
			this.standardHandling(anything);
		}
		return result;
	}
	
	protected void standardHandling(Anything anything) {
		result = anything.getClassId() + ";" + anything.getId();
	}
	@Override
	public void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException {
		this.result = moduleGroup.getName();
	}
	@Override
	public void handleUnit(Unit4Public unit) throws PersistenceException {
		this.result = unit.getName();
	}
	@Override
	public void handleModuleWithoutUnits(ModuleWithoutUnits4Public moduleWithoutUnits) throws PersistenceException {
		this.result = moduleWithoutUnits.getName();
	}

	@Override
	public void handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException {
		this.result = studyGroup.getName();
	}
	@Override
	public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException {
		this.result = moduleWithUnits.getName();
	}
	@Override
	public void handleNoneMark(NoneMark4Public noneMark) throws PersistenceException {
		this.result = "None Mark";
	}
	@Override
	public void handleStudyProgram(StudyProgram4Public studyProgram) throws PersistenceException {
		this.result = studyProgram.getName();
	}
	@Override
	public void handleAdminServer(AdminServer4Public adminServer) throws PersistenceException {
		this.result = "Admin";
	}
	@Override
	public void handleStudentServer(StudentServer4Public studentServer) throws PersistenceException {
		this.result = studentServer.getMatriculationNumber();
	}
	@Override
	public void handleUnitLst(UnitLst4Public unitLst) throws PersistenceException {
		this.result = "Unit List";
	}
	@Override
	public void handleServer(Server4Public server) throws PersistenceException {
		result += "Server";
	}
	@Override
	public void handleStudyGroupLst(StudyGroupLst4Public studyGroupLst) throws PersistenceException {
		this.result = "StudyGroup List";
	}
	@Override
	public void handleModuleGroupLst(ModuleGroupLst4Public moduleGroupLst) throws PersistenceException {
		this.result = "ModuleGroup List";
	}
	@Override
	public void handleModuleWithUnitsLst(ModuleWithUnitsLst4Public moduleWithUnitsLst) throws PersistenceException {
		this.result = "ModuleWithUnits List";
	}
	@Override
	public void handleMarkHistoryEntry(MarkHistoryEntry4Public markHistoryEntry) throws PersistenceException {
		this.result = "MarkHistoryEntry";
	}
	@Override
	public void handleStudyProgramLst(StudyProgramLst4Public studyProgramLst) throws PersistenceException {
		this.result = "StudyProgram List";
	}
	@Override
	public void handleModuleWithoutUnitsLst(ModuleWithoutUnitsLst4Public moduleWithoutUnitsLst)
			throws PersistenceException {
		this.result = "ModuleWithoutUnits List";
	}
	@Override
	public void handlePassed(Passed4Public passed) throws PersistenceException {
		result = "Passed";
	}
	@Override
	public void handleFiveZero(FiveZero4Public fiveZero) throws PersistenceException {
		result = "5.0";
	}
	@Override
	public void handleTenthMark(TenthMark4Public tenthMark) throws PersistenceException {
		Fraction f = tenthMark.getValue();
		TenthMark4Public t = MarkFactory.getTheMarkFactory().createTenthMark(f);
		result = t.getValue() + " [Tenth Mark]";
//		result = tenthMark.getValue().toString() + " [Tenth Mark]";
	}
	@Override
	public void handleTwoZero(TwoZero4Public twoZero) throws PersistenceException {
		result = "2.0";
	}
	@Override
	public void handleFailed(Failed4Public failed) throws PersistenceException {
		result = "Failed";
	}
	@Override
	public void handleThreeSeven(ThreeSeven4Public threeSeven) throws PersistenceException {
		result = "3.7";
	}
	@Override
	public void handleThirdMark(ThirdMark4Public thirdMark) throws PersistenceException {
		result = MarkFactory.getTheMarkFactory().createThirdMark(thirdMark.getValue()).getValue().toString() + " [Third Mark]";
//		result = thirdMark.getValue().toString() + " [Third Mark]";
	}
	@Override
	public void handleThreeZero(ThreeZero4Public threeZero) throws PersistenceException {
		result = "3.0";
	}
	@Override
	public void handleTwoSeven(TwoSeven4Public twoSeven) throws PersistenceException {
		result = "2.7";
	}
	@Override
	public void handleOneSeven(OneSeven4Public oneSeven) throws PersistenceException {
		result = "1.7";
	}
	@Override
	public void handleThreeThree(ThreeThree4Public threeThree) throws PersistenceException {
		result = "3.3";
	}
	@Override
	public void handleOneThree(OneThree4Public oneThree) throws PersistenceException {
		result = "1.3";
	}
	@Override
	public void handleTwoThree(TwoThree4Public twoThree) throws PersistenceException {
		result = "2.3";
	}
	@Override
	public void handleFourZero(FourZero4Public fourZero) throws PersistenceException {
		result = "4.0";
	}
	@Override
	public void handleOneZero(OneZero4Public oneZero) throws PersistenceException {
		result = "1.0";
	}
	@Override
	public void handleStudentServerLst(StudentServerLst4Public studentServerLst) throws PersistenceException {
		result = "Student List";
	}
	@Override
	public void handleThirdMarkLst(ThirdMarkLst4Public thirdMarkLst) throws PersistenceException {
		result = "ThirdMark List";
	}
	@Override
	public void handleBooleanMark(BooleanMark4Public booleanMark) throws PersistenceException {
		result = "Boolean Mark";
	}
	@Override
	public void handleBooleanMarkLst(BooleanMarkLst4Public booleanMarkLst) throws PersistenceException {
		result = "Boolean Mark List";		
	}
	@Override
	public void handleMarkFactory(MarkFactory4Public markFactory) throws PersistenceException {
		result = "MarkFactory";
	}

}
