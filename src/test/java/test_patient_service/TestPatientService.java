package test_patient_service;

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
import com.hospital.service.DoctorService;
import com.hospital.service.PatientService;
import com.hospital.service_impl.DoctorServiceImpl;
import com.hospital.service_impl.PatientServiceImpl;

class TestPatientService {
	static SessionFactory sessionFactory;
	static Session session;
	static PatientService patientService;
	static DoctorService doctorService;
	
	@BeforeAll
	static void setUp() {
		sessionFactory = HibernateUtil.getSessionFactory();
		patientService = new PatientServiceImpl();
		doctorService = new DoctorServiceImpl();
	}
	
	/*	
	@Test
	void testSavePatient() {
		Doctor doctor = doctorService.findDoctorById(101);
		Patient patient = new Patient(102, "lavanya", "female", 21, 678976, 'A', doctor);
		assertTrue(patientService.savePatient(patient));
	}
	


	@Test
	void testGetPatientById() {
		Patient patient = patientService.getPatientById(101);
		assertNotNull(patient);
		assertTrue(patient.getPatient_id() == 101);
	}

	@Test
	void testGetAllPatients() {
		List<Patient> patients = patientService.getAllPatients();
		assertTrue(patients != null && !patients.isEmpty());
	}
	

	
	@Test
	void testUpdatePatient() {
		Patient patient = patientService.getPatientById(101);
		assertTrue(patientService.updatePatient(101, "Supriya", "female",21 , 67890876));
	}
*/	
	
	@Test
	void testDeletePatient() {
		Patient patient = patientService.getPatientById(102);
		assertTrue(patientService.deletePatient(102));
	}
	
	@AfterAll
	static void tearDown() {
		sessionFactory.close();
	}

}
