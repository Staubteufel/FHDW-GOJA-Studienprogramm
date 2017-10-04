package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import common.Fraction;
import model.AdminServer;
import model.CreditPointInformationIsNotConsistent;
import model.ModuleWithUnitsLst;
import model.ModuleWithoutUnitsLst;
import model.NameAlreadyExistsException;
import model.StudyGroupLst;
import model.StudyProgramLst;
import model.ThirdMark;
import model.UnitIsAlreadyPartOfAModuleWithUnitsException;
import model.UnitLst;
import persistence.AdminServer4Public;
import persistence.Cache;
import persistence.ModuleWithUnits4Public;
import persistence.ModuleWithoutUnits4Public;
import persistence.ModuleWithoutUnitsLst_ModuleWithoutUnitsProxi;
import persistence.PersistenceException;
import persistence.StudyGroup4Public;
import persistence.StudyProgram4Public;
import persistence.Unit4Public;

public class changes {
	
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
	public void changeCPinUnits() throws PersistenceException {
		long countUnits = UnitLst.getTheUnitLst().getUnits().getLength();
		System.out.println("Aktuelle sind :" + countUnits + " in der List");
		try {
			AdminServ.createUnit("Unit1", new Fraction(BigInteger.valueOf(10), BigInteger.ONE));
		} catch (NameAlreadyExistsException e) {
			e.printStackTrace();
		}
		long countUnitsNew = UnitLst.getTheUnitLst().getUnits().getLength();
		System.out.println("Aktuelle sind :" + countUnitsNew + " in der List");
		Unit4Public u1 = UnitLst.getTheUnitLst().getUnits().iterator().next();
		System.out.println("Unit u1 hat"+ u1.getCreditPoints() +"CreditPoints");
		u1.setCreditPoints(new Fraction(BigInteger.valueOf(40), BigInteger.ONE));
		System.out.println("U1 hat nach ändern"+u1.getCreditPoints() +"CPs");
	}
	
	@Test
	public void changeCPinModule () throws PersistenceException, NameAlreadyExistsException {
		long count = ModuleWithoutUnitsLst.getTheModuleWithoutUnitsLst().getModuleWithoutUnits().getLength();
		System.out.println("Aktuelle sind :" + count + " in der List");
		AdminServ.createMWWU("Test", new Fraction(BigInteger.valueOf(10), BigInteger.ONE), ThirdMark.createThirdMark(new Fraction(BigInteger.valueOf(3), BigInteger.ONE)));
		long countNew = ModuleWithoutUnitsLst.getTheModuleWithoutUnitsLst().getModuleWithoutUnits().getLength();
		System.out.println("Aktuelle sind :" + countNew + " in der List");
		ModuleWithoutUnits4Public mwo1 = ModuleWithoutUnitsLst.getTheModuleWithoutUnitsLst().getModuleWithoutUnits().iterator().next();
		System.out.println("MWO1 hat "+ mwo1.getCreditPoints() +"CreditPoints");
		mwo1.setCreditPoints(new Fraction(BigInteger.valueOf(50), BigInteger.ONE));
		System.out.println("MWO1 hat nach der Änderung "+ mwo1.getCreditPoints() +"CreditPoints");
	}
	
	@Test
	public void changeCPinMWU () throws NameAlreadyExistsException, PersistenceException {
		AdminServ.createMWU("mwu1", new Fraction(BigInteger.valueOf(50), BigInteger.ONE));
		ModuleWithUnits4Public mwu1 = ModuleWithUnitsLst.getTheModuleWithUnitsLst().getModuleWithUnits().iterator().next();
		System.out.println("MWU1 hat derzeit: "+ mwu1.getCreditPoints() +"CPs.");
		//mwu1.
		
	}
	
	@Test
	public void changeStudyGroupsStudyProgram () throws NameAlreadyExistsException, PersistenceException, CreditPointInformationIsNotConsistent {
		AdminServ.createStudyProgram("BWL", new Fraction(BigInteger.valueOf(100), BigInteger.ONE));
		StudyProgram4Public sp1 = StudyProgramLst.getTheStudyProgramLst().getStudyPrograms().iterator().next();
		AdminServ.createStudyProgram("IT", new Fraction(BigInteger.valueOf(100), BigInteger.ONE));
		StudyProgram4Public sp2  = StudyProgramLst.getTheStudyProgramLst().getStudyPrograms().iterator().next();
		AdminServ.createStudyProgram("Opfer", new Fraction(BigInteger.valueOf(100), BigInteger.ONE));
		StudyProgram4Public sp3  = StudyProgramLst.getTheStudyProgramLst().getStudyPrograms().iterator().next();
		AdminServ.createStudyGroup("sg1", sp1);
		StudyGroup4Public sg1 = StudyGroupLst.getTheStudyGroupLst().getStudyGroups().iterator().next();
		System.out.println("SG1 is assigned to StudyProgram: "+ sp1.getName());
		System.out.println("SG1 is assigned to StudyProgram: "+ sp2.getName() );
		System.out.println("SG1 is assigned to StudyProgram: "+ sp3.getName() );
		System.out.println("SG1 is assigned to StudyProgram: "+ sg1.getAssignedTo().getName() );
		sg1.setAssignedTo(sp2);
		System.out.println("SG1 is assigned to StudyProgram: "+ sg1.getAssignedTo().getName() );
		sg1.setAssignedTo(sp3);
		System.out.println("SG1 is assigned to StudyProgram: "+ sg1.getAssignedTo().getName() );
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
