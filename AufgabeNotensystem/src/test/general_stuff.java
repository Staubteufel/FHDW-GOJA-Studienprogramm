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
import model.CreditPointInformationIsNotConsistent;
import model.MatricalNumberAlreadyUsed;
import model.NameAlreadyExistsException;
import model.StudentServerLst;
import model.StudyGroupLst;
import model.StudyProgramLst;
import model.UnitIsAlreadyPartOfAModuleWithUnitsException;
import persistence.AdminServer4Public;
import persistence.Cache;
import persistence.PersistenceException;
import persistence.StudentServer4Public;
import persistence.StudyGroup4Public;
import persistence.StudyProgram4Public;

public class general_stuff {

	
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
	public void set_student_active() throws PersistenceException, NameAlreadyExistsException, ParseException, MatricalNumberAlreadyUsed, CreditPointInformationIsNotConsistent {
		long count = StudentServerLst.getTheStudentServerLst().getStudentServers().getLength();
		System.out.println("Aktuelle sind :" + count + " in der List");
		AdminServ.createStudyProgram("BWL",new Fraction(BigInteger.valueOf(0),BigInteger.ONE));
		AdminServ.createStudyGroup("HFI", StudyProgramLst.getTheStudyProgramLst().getStudyPrograms().iterator().next());
		StudyGroup4Public sg1 = StudyGroupLst.getTheStudyGroupLst().getStudyGroups().iterator().next();
		AdminServ.createStudyProgram("SP2", new Fraction(BigInteger.valueOf(15),BigInteger.ONE));
		StudyProgram4Public sp2 = StudyProgramLst.getTheStudyProgramLst().getStudyPrograms().iterator().next();
		AdminServ.createStudyGroup("sg", sp2);
		StudyGroup4Public sg2 = StudyGroupLst.getTheStudyGroupLst().getStudyGroups().iterator().next();
		AdminServ.createStudent("123457", "test", "Sebastian", "Steinhoff", new java.sql.Date(sdf.parse("21.07.1992").getTime()), sg1);
		StudentServer4Public s1 = StudentServerLst.getTheStudentServerLst().getStudentServers().iterator().next();
		long countNew = StudentServerLst.getTheStudentServerLst().getStudentServers().getLength();
		System.out.println("Aktuelle sind :" + countNew + " in der List");
		assertEquals(countNew, 1);
		s1.setActiveStudyGroup(sg2);
		System.out.println("Aktive SG des S1 nach änderung" + s1.getActiveStudyGroup().getName());
	}

}
