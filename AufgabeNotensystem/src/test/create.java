package test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import common.Fraction;
import model.AdminServer;
import model.CreditPointInformationIsNotConsistent;
import model.CycleException;
import model.MarkCalculable;
import model.MatricalNumberAlreadyUsed;
import model.ModuleGroupLst;
import model.ModuleWithUnitsLst;
import model.ModuleWithoutUnitsLst;
import model.NameAlreadyExistsException;
import model.StudentServerLst;
import model.StudyGroupLst;
import model.StudyProgram;
import model.StudyProgramLst;
import model.ThirdMark;
import model.UnitIsAlreadyPartOfAModuleWithUnitsException;
import model.UnitLst;
import persistence.AdminServer4Public;
import persistence.Cache;
import persistence.MarkSearchList;
import persistence.ModuleGroup4Public;
import persistence.ModuleWithUnits4Public;
import persistence.ModuleWithoutUnits4Public;
import persistence.PersistenceException;
import persistence.StudentServer4Public;
import persistence.StudyGroup4Public;
import persistence.StudyProgram4Public;
import persistence.Unit4Public;

public class create {

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
	public void createUnit() throws PersistenceException, ParseException{
	long countUnits = UnitLst.getTheUnitLst().getUnits().getLength();
	System.out.println("Aktuelle sind :" + countUnits + " in der List");
	try {
		AdminServ.createUnit("Unit1", new Fraction(BigInteger.valueOf(10), BigInteger.ONE));
	} catch (NameAlreadyExistsException e) {
		e.printStackTrace();
	}
	long countUnitsNew = UnitLst.getTheUnitLst().getUnits().getLength();
	System.out.println("Aktuelle sind :" + countUnitsNew + " in der List");
	assertEquals(countUnitsNew, 1);
}
	@Test
	public void createModuleWithOutUnit() throws PersistenceException, ParseException, NameAlreadyExistsException{
	long count = ModuleWithoutUnitsLst.getTheModuleWithoutUnitsLst().getModuleWithoutUnits().getLength();
	System.out.println("Aktuelle sind :" + count + " in der List");
	AdminServ.createMWWU("Test", new Fraction(BigInteger.valueOf(10), BigInteger.ONE), ThirdMark.createThirdMark(new Fraction(BigInteger.valueOf(3), BigInteger.ONE)));
	long countNew = ModuleWithoutUnitsLst.getTheModuleWithoutUnitsLst().getModuleWithoutUnits().getLength();
	System.out.println("Aktuelle sind :" + countNew + " in der List");
	assertEquals(countNew, 1);
}
	@Test
	public void createModuleWithUnit() throws PersistenceException, ParseException, NameAlreadyExistsException{
		long count = ModuleWithUnitsLst.getTheModuleWithUnitsLst().getModuleWithUnits().getLength();
		System.out.println("Aktuelle sind :" + count + " in der List");
		AdminServ.createMWU("mwu1", new Fraction(BigInteger.valueOf(10), BigInteger.ONE));
		long countNew = ModuleWithUnitsLst.getTheModuleWithUnitsLst().getModuleWithUnits().getLength();
		System.out.println("Aktuelle sind :" + countNew + " in der List");
		assertEquals(countNew, 1);
}
	@Test
	public void createStudent() throws PersistenceException, ParseException, NameAlreadyExistsException, MatricalNumberAlreadyUsed, CreditPointInformationIsNotConsistent{
		long count = StudentServerLst.getTheStudentServerLst().getStudentServers().getLength();
		System.out.println("Aktuelle sind :" + count + " in der List");
		AdminServ.createStudyProgram("BWL",new Fraction(BigInteger.valueOf(0),BigInteger.ONE));
		AdminServ.createStudyGroup("HFI", StudyProgramLst.getTheStudyProgramLst().getStudyPrograms().iterator().next());
		StudyGroup4Public sg1 = StudyGroupLst.getTheStudyGroupLst().getStudyGroups().iterator().next();
		AdminServ.createStudent("123457", "test", "Sebastian", "Steinhoff", new java.sql.Date(sdf.parse("21.07.1992").getTime()), sg1);
		long countNew = StudentServerLst.getTheStudentServerLst().getStudentServers().getLength();
		System.out.println("Aktuelle sind :" + countNew + " in der List");
		assertEquals(countNew, 1);
}
	@Test
	public void createStudienProgramm() throws PersistenceException, NameAlreadyExistsException{
		long count = StudyProgramLst.getTheStudyProgramLst().getStudyPrograms().getLength();
		System.out.println("Aktuelle sind :" + count + " in der List");
		AdminServ.createStudyProgram("SP1", new Fraction(BigInteger.valueOf(150),BigInteger.ONE));
		AdminServ.createStudyProgram("SP2", new Fraction(BigInteger.valueOf(100),BigInteger.ONE));
		long countnew = StudyProgramLst.getTheStudyProgramLst().getStudyPrograms().getLength();
		System.out.println("Nach hinzufügen sind"+countnew+"in der Liste");
		assertEquals(count+2, countnew);
	}
	
	@Test
	public void createStudyGroup () throws PersistenceException, NameAlreadyExistsException, CreditPointInformationIsNotConsistent, CycleException{
		AdminServ.createMWWU("MWOU", Fraction.parse("150"), ThirdMark.createThirdMark(Fraction.parse("1")));
		AdminServ.createModuleGroup("MG", Fraction.parse("150"));
		ModuleGroup4Public mg = ModuleGroupLst.getTheModuleGroupLst().getModuleGroups().iterator().next();
		mg.addModuleWithoutUnits(ModuleWithoutUnitsLst.getTheModuleWithoutUnitsLst().getModuleWithoutUnits().iterator().next());
		long count = StudyGroupLst.getTheStudyGroupLst().getStudyGroups().getLength();
		AdminServ.createStudyProgram("SP1", new Fraction(BigInteger.valueOf(150),BigInteger.ONE));
		StudyProgram4Public sp = StudyProgramLst.getTheStudyProgramLst().getStudyPrograms().iterator().next();
		sp.addModuleGroup(mg);
		System.out.println("Aktuelle sind :" + count + " in der List");
		AdminServ.createStudyGroup("sg1", sp);
		long countnew = StudyGroupLst.getTheStudyGroupLst().getStudyGroups().getLength();
		System.out.println("Neu sind :" + countnew + " in der List");
		assertEquals(count+1, countnew);
	}
	
	@Test
	public void createModulGruppe () throws PersistenceException, NameAlreadyExistsException {
		long count = ModuleGroupLst.getTheModuleGroupLst().getModuleGroups().getLength();
		System.out.println("Aktuelle sind :" + count + " in der List");
		AdminServ.createModuleGroup("Proggen", new Fraction(BigInteger.valueOf(15),BigInteger.ONE));
		long countnew = ModuleGroupLst.getTheModuleGroupLst().getModuleGroups().getLength();
		System.out.println("Nach Erstellung sind :" + countnew + " in der List");
		assertEquals(count+1, countnew);		
	}
	
	

	@AfterClass
	public static void cleanupAfterTestClass() {
		System.out.println("cleanupAfterTestClass");
		try {
			TestSupport.resetDatabase();
		} catch (PersistenceException | SQLException | IOException e) {
			throw new Error();
		}
	}
}
