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
import model.MatricalNumberAlreadyUsed;
import model.NameAlreadyExistsException;
import model.StudentServerLst;
import model.StudyGroupLst;
import model.StudyProgramLst;
import model.UnitIsAlreadyPartOfAModuleWithUnitsException;
import persistence.AdminServer4Public;
import persistence.Cache;
import persistence.ModuleGroup4Public;
import persistence.ModuleWithUnits4Public;
import persistence.ModuleWithoutUnits4Public;
import persistence.PersistenceException;
import persistence.StudentServer4Public;
import persistence.StudyGroup4Public;
import persistence.StudyProgram4Public;
import persistence.Unit4Public;

public class Student_testing {
	
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
	StudentServer4Public s1;
	StudentServer4Public s2;
	StudentServer4Public s3;
	StudentServer4Public s4;
	StudentServer4Public s5;
	
	ModuleGroup4Public MG1;
	ModuleGroup4Public MG2;
	ModuleGroup4Public MG3;
	ModuleGroup4Public MG4;
	
	ModuleWithUnits4Public mwu1;
	ModuleWithUnits4Public mwu2;
	ModuleWithUnits4Public mwu3;
	
	ModuleWithoutUnits4Public mwo1;
	ModuleWithoutUnits4Public mwo2;
	ModuleWithoutUnits4Public mwo3;
	
	Unit4Public u1;
	Unit4Public u2;
	Unit4Public u3;
	Unit4Public u4;
	Unit4Public u5;
	Unit4Public u6;
	Unit4Public u7;
	Unit4Public u8;
	Unit4Public u9;
	Unit4Public u10;
	Unit4Public u11;
	
	StudyGroup4Public sg1;
	StudyGroup4Public sg2;
	
	StudyProgram4Public SP1;
	StudyProgram4Public SP2;
	Long value2 = (long) 2.5;
	
	AdminServer4Public AdminServ;
	
	
	@Before
	public void setupBeforeTest() throws NameAlreadyExistsException, UnitIsAlreadyPartOfAModuleWithUnitsException, ParseException, MatricalNumberAlreadyUsed, CreditPointInformationIsNotConsistent {
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

	

	
	private void setupStructure() throws PersistenceException, NameAlreadyExistsException, ParseException, MatricalNumberAlreadyUsed, CreditPointInformationIsNotConsistent {
		AdminServ = AdminServer.createAdminServer();
		
		
		AdminServ.createStudyProgram("BWL",new Fraction(BigInteger.valueOf(0),BigInteger.ONE));
		Iterator<StudyProgram4Public> studyIterator = StudyProgramLst.getTheStudyProgramLst().getStudyPrograms().iterator();
		SP1 = studyIterator.next();
		AdminServ.createStudyGroup("sg2", SP1);
		Iterator<StudyGroup4Public> groupIterator = StudyGroupLst.getTheStudyGroupLst().getStudyGroups().iterator();
		sg1 = groupIterator.next();
		AdminServ.createStudent("123457", "test", "Sebastian", "Steinhoff", new java.sql.Date(sdf.parse("21.07.1992").getTime()), sg1);
		AdminServ.createStudent("123", "Test", "Julian", "Fleper", new java.sql.Date(sdf.parse("21.07.1992").getTime()), sg1);
		AdminServ.createStudent("12345", "test", "Julien", "Bartels", new java.sql.Date(sdf.parse("21.07.1992").getTime()), sg1);
		Iterator<StudentServer4Public> si = StudentServerLst.getTheStudentServerLst().getStudentServers().iterator();
		s1 = si.next();
		s2 = si.next();
		s3 = si.next();
		
	}

@Test
	public void test_adding() throws PersistenceException, ParseException, MatricalNumberAlreadyUsed, CreditPointInformationIsNotConsistent{
	long numberofStudents = StudentServerLst.getTheStudentServerLst().getStudentServers().getLength();
	System.out.println("Number of Students before adding: "+ numberofStudents);
	AdminServ.createStudent("1235", "Test", "Julian", "Fleper", new java.sql.Date(sdf.parse("21.07.1992").getTime()), sg1);
	AdminServ.createStudent("123456", "test", "Julien", "Bartels", new java.sql.Date(sdf.parse("21.07.1992").getTime()), sg1);
	long newNumberOfStudents =  StudentServerLst.getTheStudentServerLst().getStudentServers().getLength();
	System.out.println("Number of Students after adding "+newNumberOfStudents);
	assertEquals(numberofStudents+2, newNumberOfStudents);
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
