package test_Test_Service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hibernate_util.HibernateUtil;
import com.hospital.entities.Doctor;
import com.hospital.entities.Patient;
import com.hospital.entities.TestsInHospital;
import com.hospital.service.DoctorService;
import com.hospital.service.PatientService;
import com.hospital.service.TestService;
import com.hospital.service_impl.DoctorServiceImpl;
import com.hospital.service_impl.PatientServiceImpl;
import com.hospital.service_impl.TestServiceImpl;

class testTestService {

	static SessionFactory sessionFactory;
	static Session session;
	static TestService testService;
	static DoctorService doctorService;
	static PatientService patientService;

	@BeforeAll
	static void setUp() {
		sessionFactory = HibernateUtil.getSessionFactory();
		testService = new TestServiceImpl();
		doctorService = new DoctorServiceImpl();
		patientService = new PatientServiceImpl();
	}

	/*@Test
	public void testSaveTest() {

		Doctor doctor = doctorService.findDoctorById(101);
		Patient patient = patientService.getPatientById(101);
		Tests tests = new Tests(1, "blood test", "completed", 'A', patient, doctor);
		assertTrue(testService.saveTest(tests));
	}*/
	
	
/*	@Test
	public void testGetTestById() {
		TestsInHospital tests = testService.getTestById(101);
		assertNotNull(tests);
		assertTrue(tests.getTest_id() == 101);
	}
*/
	
/*	@Test
	public void testGetAllTests() {
		List<TestsInHospital> tests = testService.getAllTests();
		assertTrue(tests != null && !tests.isEmpty());
	}
*/
	
/*	@Test
	public void testUpdateTest() {
		TestsInHospital tests = testService.getTestById(101);
		assertTrue(testService.updateTest(101, "blood test", "pending"));
	}
*/
	
	@Test
	public void testDeleteTest() {
		TestsInHospital test = testService.getTestById(101);
		assertTrue(testService.deleteTest(101));
	}
	
	
	@AfterAll
	static void tearDown() {
		sessionFactory.close();
	}

}
