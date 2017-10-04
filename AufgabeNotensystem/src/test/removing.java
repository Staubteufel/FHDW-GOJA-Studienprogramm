package test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import common.Fraction;
import model.AdminServer;
import model.CycleException;
import model.ModuleGroupLst;
import model.ModuleWithUnitsLst;
import model.NameAlreadyExistsException;
import model.StudentServerLst;
import model.StudyGroupLst;
import model.StudyProgramLst;
import model.UnitIsAlreadyPartOfAModuleWithUnitsException;
import model.UnitLst;
import persistence.AdminServer4Public;
import persistence.Cache;
import persistence.ModuleGroup4Public;
import persistence.ModuleWithUnits4Public;
import persistence.ModuleWithoutUnits4Public;
import persistence.PersistenceException;
import persistence.StudentServer4Public;
import persistence.StudyGroup4Public;
import persistence.StudyProgram4Public;
import persistence.ThirdMark4Public;
import persistence.Unit4Public;

public class removing {
	
	@BeforeClass
	public static void setupBeforeTestClass() {
		System.out.println("setupBeforeTestClass");
		try {
			TestSupport.prepareDatabase();
		} catch (PersistenceException | SQLException | IOException e) {
			System.out.println(e.getMessage());
			throw new Error();
		}
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	AdminServer4Public AdminServ;
	
	@Before
	public void setupBeforeTest() throws NameAlreadyExistsException, UnitIsAlreadyPartOfAModuleWithUnitsException, ParseException {
		System.out.println("setupBeforeTest");
		try {
			TestSupport.clearDatabase();
			Cache.getTheCache().reset$For$Test();
			TestSupport.prepareSingletons();
			this.setupStructure();
		} catch (SQLException | PersistenceException e) {
			System.out.println(e.getMessage());
			throw new Error();
		}
	}

	private void setupStructure() throws PersistenceException, NameAlreadyExistsException, ParseException {
		AdminServ = AdminServer.createAdminServer();
	}

	@Test
	public void testremovingMWfromMG() throws PersistenceException, NameAlreadyExistsException, CycleException {
		ThirdMark4Public tm1 = AdminServ.getThirdMarks().getThirdMarks().iterator().next();
		AdminServ.createMWU("mwu1", new Fraction(BigInteger.valueOf(100), BigInteger.ONE));
		ModuleWithUnits4Public mwu1 = ModuleWithUnitsLst.getTheModuleWithUnitsLst().getModuleWithUnits().iterator().next();
		AdminServ.createMWWU("mwo1",  new Fraction(BigInteger.valueOf(100), BigInteger.ONE), tm1);
		ModuleWithoutUnits4Public mwo1 = AdminServ.getModuleWithoutUnits().getModuleWithoutUnits().iterator().next();
		AdminServ.createModuleGroup("mg1", new Fraction(BigInteger.valueOf(100), BigInteger.ONE));
		ModuleGroup4Public mg1 = ModuleGroupLst.getTheModuleGroupLst().getModuleGroups().iterator().next();
		long count = mg1.getModuleWithUnits().getLength();
		long count2 = mg1.getModuleWithoutUnits().getLength();
		System.out.println("MWUs in MG before adding" + count);
		System.out.println("MWWUs in MG before adding" + count2);
		mg1.addModuleWithoutUnits(mwo1);
		mg1.addModuleWithUnits(mwu1);
		System.out.println("MWUs in MG after adding:" + mg1.getModuleWithUnits().getLength());
		System.out.println("MWWUs in MG after addin"+ mg1.getModuleWithoutUnits().getLength());
		mg1.removeModuleWithoutUnits(mwo1);
		mg1.removeModuleWithUnits(mwu1);
		System.out.println("MWUs in MG after adding and deleting:" + mg1.getModuleWithUnits().getLength());
		System.out.println("MWWUs in MG after adding and deleting:"+ mg1.getModuleWithoutUnits().getLength());	
	}
	
	@Test
	public void removeUnitfromMWU () throws NameAlreadyExistsException, PersistenceException, UnitIsAlreadyPartOfAModuleWithUnitsException {
		AdminServ.createMWU("mwu1", new Fraction(BigInteger.valueOf(10), BigInteger.ONE));
		ModuleWithUnits4Public mwu1 = ModuleWithUnitsLst.getTheModuleWithUnitsLst().getModuleWithUnits().iterator().next();
		System.out.println("Numer of Units in MWU1 before adding"+mwu1.getConsistsOf().getLength());
		long count = mwu1.getConsistsOf().getLength();
		AdminServ.createUnit("u1", new Fraction(BigInteger.valueOf(5), BigInteger.ONE));
		Unit4Public u1 = UnitLst.getTheUnitLst().getUnits().iterator().next();
		mwu1.addUnit(u1);
		System.out.println("Units in MWU1 after adding:"+ mwu1.getConsistsOf().getLength());
		assertEquals(count+1, mwu1.getConsistsOf().getLength());
		mwu1.removeUnit(u1);
		System.out.println("Units left in MWU1 after adding and deleting u1:" + mwu1.getConsistsOf().getLength());
		assertEquals(count, mwu1.getConsistsOf().getLength());
	}
	
//	@Test
//	public void removeStudentfromSG () throws PersistenceException, NameAlreadyExistsException, ParseException, StudentMustBeAtLeastMemberOfOneStudyGroupException{
//		long count = StudentServerLst.getTheStudentServerLst().getStudentServers().getLength();
//		System.out.println("Aktuelle sind :" + count + " in der List");
//		AdminServ.createStudyProgram("BWL",new Fraction(BigInteger.valueOf(15),BigInteger.ONE));
//		AdminServ.createStudyGroup("HFI", StudyProgramLst.getTheStudyProgramLst().getStudyPrograms().iterator().next());
//		StudyGroup4Public sg1 = StudyGroupLst.getTheStudyGroupLst().getStudyGroups().iterator().next();
//		AdminServ.createStudent("123457", "test", "Sebastian", "Steinhoff", new java.sql.Date(sdf.parse("21.07.1992").getTime()), sg1);
//		StudentServer4Public s1 = StudentServerLst.getTheStudentServerLst().getStudentServers().iterator().next();
//		long countNew = StudentServerLst.getTheStudentServerLst().getStudentServers().getLength();
//		System.out.println("Aktuelle sind :" + countNew + " in der List");
//		assertEquals(countNew, 1);	
//		sg1.removeStudent(s1);
//		System.out.println("Students left in SG1 after removal" + sg1.getStudents().getLength());
//		
//	}

	
	@Test
	public void removeSGfromSP () throws NameAlreadyExistsException, PersistenceException {
		AdminServ.createStudyProgram("BWL", new Fraction(BigInteger.valueOf(100), BigInteger.ONE));
		StudyProgram4Public sp1 = StudyProgramLst.getTheStudyProgramLst().getStudyPrograms().iterator().next();
		AdminServ.createModuleGroup("JAVA", new Fraction(BigInteger.valueOf(25), BigInteger.ONE));
		ModuleGroup4Public mg1 = ModuleGroupLst.getTheModuleGroupLst().getModuleGroups().iterator().next();
		long count = sp1.getModuleGroups().getLength();
		System.out.println("Modulgrou acount in SP1 ."+ count);
		sp1.addModuleGroup(mg1);
		System.out.println("Modulgroups in Programms after adding mg1" + sp1.getModuleGroups().getLength());
		assertEquals(+1, sp1.getModuleGroups().getLength());
		sp1.removeModuleGroup(mg1);
		assertEquals(count, 0);
	}
}
