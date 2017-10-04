package test;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import common.Fraction;

import static junit.framework.Assert.*;

import model.AdminServer;
import model.BooleanMark;
import model.CreditPointInformationIsNotConsistent;
import model.CycleException;
import model.MatricalNumberAlreadyUsed;
import model.ModuleGroupLst;
import model.ModuleWithUnitsLst;
import model.ModuleWithoutUnitsLst;
import model.NameAlreadyExistsException;
import model.StudentServer;
import model.StudentServerLst;
import model.StudyGroupLst;
import model.StudyProgramLst;
import model.ThirdMark;
import model.UnitIsAlreadyPartOfAModuleWithUnitsException;
import model.UnitLst;
import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.InvokerExceptionVisitor;
import model.visitor.InvokerReturnExceptionVisitor;
import model.visitor.InvokerReturnVisitor;
import model.visitor.InvokerVisitor;
import model.visitor.RemoteExceptionVisitor;
import model.visitor.RemoteReturnExceptionVisitor;
import model.visitor.RemoteReturnVisitor;
import model.visitor.RemoteVisitor;
import model.visitor.ServiceExceptionVisitor;
import model.visitor.ServiceReturnExceptionVisitor;
import model.visitor.ServiceReturnVisitor;
import model.visitor.ServiceVisitor;
import persistence.AdminServer4Public;
import persistence.Anything;
import persistence.Appr4Public;
import persistence.Cache;
import persistence.Command;
import persistence.Invoker;
import persistence.Mark;
import persistence.ModuleGroup4Public;
import persistence.ModuleWithUnits4Public;
import persistence.ModuleWithoutUnits4Public;
import persistence.PersistenceException;
import persistence.PersistentRoot;
import persistence.StudentServer4Public;
import persistence.StudentServer_StudyGroupsAttendedProxi;
import persistence.StudyGroup4Public;
import persistence.StudyProgram4Public;
import persistence.Unit4Public;

public class Test_Students {
	
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
	public void setupBeforeTest() throws NameAlreadyExistsException, UnitIsAlreadyPartOfAModuleWithUnitsException, ParseException, MatricalNumberAlreadyUsed, CreditPointInformationIsNotConsistent, CycleException {
		System.out.println("setupBeforeTest");
		try {
			TestSupport.clearDatabase();
			Cache.getTheCache().reset$For$Test();
			TestSupport.prepareSingletons();
			this.setupStructure();
		} catch (SQLException | PersistenceException e) {
			throw new Error();
		}
	}
	
	
	private void setupStructure() throws PersistenceException, NameAlreadyExistsException, ParseException, UnitIsAlreadyPartOfAModuleWithUnitsException, MatricalNumberAlreadyUsed, CreditPointInformationIsNotConsistent, CycleException {
		try {
			AdminServ = AdminServer.createAdminServer();
			
			
//			AdminServ.createMWWU("MWOU", Fraction.parse("15"), ThirdMark.createThirdMark(Fraction.parse("1")));
//			AdminServ.createModuleGroup("MG", Fraction.parse("15"));
//			ModuleGroup4Public mg = ModuleGroupLst.getTheModuleGroupLst().getModuleGroups().iterator().next();
//			mg.addModuleWithoutUnits(ModuleWithoutUnitsLst.getTheModuleWithoutUnitsLst().getModuleWithoutUnits().iterator().next());
//			long count = StudyGroupLst.getTheStudyGroupLst().getStudyGroups().getLength();
//			AdminServ.createStudyProgram("SP1", new Fraction(BigInteger.valueOf(15),BigInteger.ONE));
//			
			
			AdminServ.createStudyProgram("IT", new Fraction(BigInteger.valueOf(0),BigInteger.ONE));
			AdminServ.createStudyProgram("BWL",new Fraction(BigInteger.valueOf(0),BigInteger.ONE));
			Iterator<StudyProgram4Public> studyIterator = StudyProgramLst.getTheStudyProgramLst().getStudyPrograms().iterator();
			SP1 = studyIterator.next();
//			SP1.addModuleGroup(mg);
			SP2 = studyIterator.next();
//			SP2.addModuleGroup(mg);
			
			AdminServ.createStudyGroup("sg1", SP1);
			AdminServ.createStudyGroup("sg2", SP2);
			Iterator<StudyGroup4Public> groupIterator = StudyGroupLst.getTheStudyGroupLst().getStudyGroups().iterator();
			sg1 = groupIterator.next();
			sg2 = groupIterator.next();
			
			AdminServ.createStudent("123", "Test", "Julian", "Fleper", new java.sql.Date(sdf.parse("21.07.1992").getTime()), sg2);
			AdminServ.createStudent("12345", "test", "Julien", "Bartels", new java.sql.Date(sdf.parse("21.07.1992").getTime()), sg2);
			AdminServ.createStudent("1234", "test", "JP", "Lutze", new java.sql.Date(sdf.parse("21.07.1992").getTime()), sg2);
			AdminServ.createStudent("123456", "test", "Mara", "Beye", new java.sql.Date(sdf.parse("21.07.1992").getTime()), sg2);
			AdminServ.createStudent("123457", "test", "Sebastian", "Steinhoff", new java.sql.Date(sdf.parse("21.07.1992").getTime()), sg2);
			Iterator<StudentServer4Public> si = StudentServerLst.getTheStudentServerLst().getStudentServers().iterator();
			s1 = si.next();
			s2 = si.next();
			s3 = si.next();
			s4  = si.next();
			s5 = si.next();
			
			AdminServ.createModuleGroup("Proggen",new Fraction(BigInteger.valueOf(10),BigInteger.ONE));
			AdminServ.createModuleGroup("Mathe", new Fraction(BigInteger.valueOf(10),BigInteger.ONE));
			AdminServ.createModuleGroup("SOKO", new Fraction(BigInteger.valueOf(10),BigInteger.ONE));
			AdminServ.createModuleGroup("BWL", new Fraction(BigInteger.valueOf(20),BigInteger.ONE));
			Iterator<ModuleGroup4Public> mi = ModuleGroupLst.getTheModuleGroupLst().getModuleGroups().iterator();
			MG1 = mi.next();
			MG2 = mi.next();
			MG3 = mi.next();
			MG4 = mi.next();
			
			 AdminServ.createUnit("Java1", new Fraction(BigInteger.valueOf(5),BigInteger.ONE));
			 AdminServ.createUnit("Java2", new Fraction(BigInteger.valueOf(5),BigInteger.valueOf(2)));
			 AdminServ.createUnit("Java3", new Fraction(BigInteger.valueOf(5),BigInteger.valueOf(2)));
			 AdminServ.createUnit("Mathe1", new Fraction(BigInteger.valueOf(5),BigInteger.ONE));
			 AdminServ.createUnit("mathe2", new Fraction(BigInteger.valueOf(5),BigInteger.ONE));
			 AdminServ.createUnit("Soko", new Fraction(BigInteger.valueOf(5),BigInteger.ONE));
			 AdminServ.createUnit("Soko2", new Fraction(BigInteger.valueOf(5),BigInteger.ONE));
			 AdminServ.createUnit("Englisch", new Fraction(BigInteger.valueOf(5),BigInteger.ONE));
			 AdminServ.createUnit("Englisch2", new Fraction(BigInteger.valueOf(5),BigInteger.ONE));
			 AdminServ.createUnit("BWL", new Fraction(BigInteger.valueOf(10),BigInteger.ONE));
			Iterator<Unit4Public> i = UnitLst.getTheUnitLst().getUnits().iterator();
			u1 = i.next();
			u2 =  i.next();
			u3 = i.next();
			u4 = i.next();
			u5 = i.next();
			u6 = i.next();
			u7 =  i.next();
			u8 = i.next();
			u9 = i.next();
			u10 = i.next();
			
			AdminServ.createMWU("Programmieren", new Fraction(BigInteger.valueOf(10),BigInteger.ONE));
			AdminServ.createMWU("Mathe", new Fraction(BigInteger.valueOf(10),BigInteger.ONE));
			AdminServ.createMWU("ENG", new Fraction(BigInteger.valueOf(10),BigInteger.ONE));
			Iterator<ModuleWithUnits4Public> wuIterator = ModuleWithUnitsLst.getTheModuleWithUnitsLst().getModuleWithUnits().iterator();
			mwu1 = wuIterator.next();
			mwu2 = wuIterator.next();
			mwu3 =  wuIterator.next();
			
			try {
				AdminServ.createMWWU("DB", new Fraction(BigInteger.valueOf(15),BigInteger.ONE), BooleanMark.createBooleanMark());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AdminServ.createMWWU("ES", new Fraction(BigInteger.valueOf(12),BigInteger.ONE), BooleanMark.createBooleanMark());
			Iterator<ModuleWithoutUnits4Public> woIterator = ModuleWithoutUnitsLst.getTheModuleWithoutUnitsLst().getModuleWithoutUnits().iterator();
			mwo1 = woIterator.next();
			mwo2 = woIterator.next();
			
			mwu1.addUnit(u1);
			mwu1.addUnit(u2);
			mwu1.addUnit(u3);
			mwu2.addUnit(u4);
			mwu2.addUnit(u5);
			mwu3.addUnit(u8);
			mwu3.addUnit(u9);
			
			MG1.addModuleWithUnits(mwu1);
			MG2.addModuleWithUnits(mwu2);
			MG4.addModuleWithUnits(mwu3);
			
			SP1.addModuleGroup(MG1);
			SP1.addModuleGroup(MG2);
			SP1.addModuleGroup(MG3);
//			SP1.addStudyGroup(sg1);
			
			SP2.addModuleGroup(MG3);
			SP2.addModuleGroup(MG4);
			
		
		}catch(PersistenceException | NameAlreadyExistsException | ParseException | UnitIsAlreadyPartOfAModuleWithUnitsException  e){
			System.out.println(e);
		}
		finally {}
		
		
	}
	
	
	@Test
	public void test_Useradd() throws PersistenceException {
		
		long numberofStudents = sg1.getStudents().getLength();
		System.out.println("Number of Students: "+ numberofStudents);
		try {
			sg1.addStudent(StudentServer.createStudentServer("99", "Paul", "Panzer", new java.sql.Date(sdf.parse("09.07.2000").getTime()), sg1));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("New Number of Students: "+sg1.getStudents().getLength());
		assertEquals(numberofStudents+1, sg1.getStudents().getLength());
		
	}
	
//	@Test
//	public void test_deleteUser() throws PersistenceException, StudentMustBeAtLeastMemberOfOneStudyGroupException, NameAlreadyExistsException, ParseException, UnitIsAlreadyPartOfAModuleWithUnitsException{
//		AdminServ = AdminServer.createAdminServer();
//		
//		AdminServ.createStudyProgram("IT", new Fraction(BigInteger.valueOf(15),BigInteger.ONE));
//		AdminServ.createStudyProgram("BWL",new Fraction(BigInteger.valueOf(15),BigInteger.ONE));
//		Iterator<StudyProgram4Public> studyIterator = StudyProgramLst.getTheStudyProgramLst().getStudyPrograms().iterator();
//		SP1 = studyIterator.next();
//		SP2 = studyIterator.next();
//		
//		AdminServ.createStudyGroup("sg1", SP1);
//		AdminServ.createStudyGroup("sg2", SP2);
//		Iterator<StudyGroup4Public> groupIterator = StudyGroupLst.getTheStudyGroupLst().getStudyGroups().iterator();
//		sg1 = groupIterator.next();
//		sg2 = groupIterator.next();
//		
//		AdminServ.createStudent("123", "Test", "Julian", "Fleper", new java.sql.Date(sdf.parse("21.07.1992").getTime()), sg2);
//		AdminServ.createStudent("12345", "test", "Julien", "Bartels", new java.sql.Date(sdf.parse("21.07.1992").getTime()), sg2);
//		AdminServ.createStudent("1234", "test", "JP", "Lutze", new java.sql.Date(sdf.parse("21.07.1992").getTime()), sg2);
//		AdminServ.createStudent("123456", "test", "Mara", "Beye", new java.sql.Date(sdf.parse("21.07.1992").getTime()), sg2);
//		AdminServ.createStudent("123457", "test", "Sebastian", "Steinhoff", new java.sql.Date(sdf.parse("21.07.1992").getTime()), sg2);
//		Iterator<StudentServer4Public> si = StudentServerLst.getTheStudentServerLst().getStudentServers().iterator();
//		s1 = si.next();
//		s2 = si.next();
//		s3 = si.next();
//		s4  = si.next();
//		s5 = si.next();
//		
//		AdminServ.createModuleGroup("Proggen",new Fraction(BigInteger.valueOf(10),BigInteger.ONE));
//		AdminServ.createModuleGroup("Mathe", new Fraction(BigInteger.valueOf(10),BigInteger.ONE));
//		AdminServ.createModuleGroup("SOKO", new Fraction(BigInteger.valueOf(10),BigInteger.ONE));
//		AdminServ.createModuleGroup("BWL", new Fraction(BigInteger.valueOf(20),BigInteger.ONE));
//		Iterator<ModuleGroup4Public> mi = ModuleGroupLst.getTheModuleGroupLst().getModuleGroups().iterator();
//		MG1 = mi.next();
//		MG2 = mi.next();
//		MG3 = mi.next();
//		MG4 = mi.next();
//		
//		 AdminServ.createUnit("Java1", new Fraction(BigInteger.valueOf(5),BigInteger.ONE));
//		 AdminServ.createUnit("Java2", new Fraction(BigInteger.valueOf(5),BigInteger.valueOf(2)));
//		 AdminServ.createUnit("Java3", new Fraction(BigInteger.valueOf(5),BigInteger.valueOf(2)));
//		 AdminServ.createUnit("Mathe1", new Fraction(BigInteger.valueOf(5),BigInteger.ONE));
//		 AdminServ.createUnit("mathe2", new Fraction(BigInteger.valueOf(5),BigInteger.ONE));
//		 AdminServ.createUnit("Soko", new Fraction(BigInteger.valueOf(5),BigInteger.ONE));
//		 AdminServ.createUnit("Soko2", new Fraction(BigInteger.valueOf(5),BigInteger.ONE));
//		 AdminServ.createUnit("Englisch", new Fraction(BigInteger.valueOf(5),BigInteger.ONE));
//		 AdminServ.createUnit("Englisch2", new Fraction(BigInteger.valueOf(5),BigInteger.ONE));
//		 AdminServ.createUnit("BWL", new Fraction(BigInteger.valueOf(10),BigInteger.ONE));
//		Iterator<Unit4Public> i = UnitLst.getTheUnitLst().getUnits().iterator();
//		u1 = i.next();
//		u2 =  i.next();
//		u3 = i.next();
//		u4 = i.next();
//		u5 = i.next();
//		u6 = i.next();
//		u7 =  i.next();
//		u8 = i.next();
//		u9 = i.next();
//		u10 = i.next();
//		
//		AdminServ.createMWU("Programmieren", new Fraction(BigInteger.valueOf(10),BigInteger.ONE));
//		AdminServ.createMWU("Mathe", new Fraction(BigInteger.valueOf(10),BigInteger.ONE));
//		AdminServ.createMWU("ENG", new Fraction(BigInteger.valueOf(10),BigInteger.ONE));
//		Iterator<ModuleWithUnits4Public> wuIterator = ModuleWithUnitsLst.getTheModuleWithUnitsLst().getModuleWithUnits().iterator();
//		mwu1 = wuIterator.next();
//		mwu2 = wuIterator.next();
//		mwu3 =  wuIterator.next();
//		
//		try {
//			AdminServ.createMWWU("DB", new Fraction(BigInteger.valueOf(15),BigInteger.ONE), BooleanMark.createBooleanMark());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		AdminServ.createMWWU("ES", new Fraction(BigInteger.valueOf(12),BigInteger.ONE), BooleanMark.createBooleanMark());
//		Iterator<ModuleWithoutUnits4Public> woIterator = ModuleWithoutUnitsLst.getTheModuleWithoutUnitsLst().getModuleWithoutUnits().iterator();
//		mwo1 = woIterator.next();
//		mwo2 = woIterator.next();
//		
//		mwu1.addUnit(u1);
//		mwu1.addUnit(u2);
//		mwu1.addUnit(u3);
//		mwu2.addUnit(u4);
//		mwu2.addUnit(u5);
//		mwu3.addUnit(u8);
//		mwu3.addUnit(u9);
//		
////		MG1.addModuleWithUnits(mwu1);
////		MG2.addModuleWithUnits(mwu2);
////		MG4.addModuleWithUnits(mwu3);
//		
//		SP1.addModuleGroup(MG1);
//		SP1.addModuleGroup(MG2);
//		SP1.addModuleGroup(MG3);
////		SP1.addStudyGroup(sg1);
//		
//		SP2.addModuleGroup(MG3);
//		SP2.addModuleGroup(MG4);
//		
//	
//		long numberofStudents = sg1.getStudents().getLength();
//		System.out.println("Number of Students before deletion: "+ numberofStudents);
//		sg1.removeStudent(s1);
//		System.out.println("Number of Students after deletion:" + sg1.getStudents().getLength());
//		assertEquals(numberofStudents-1, sg1.getStudents().getLength());
//	}

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
