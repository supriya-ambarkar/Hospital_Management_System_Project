package test_doctor_service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.Query;
import javax.validation.constraints.AssertTrue;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hibernate_util.HibernateUtil;
import com.hospital.entities.Doctor;
import com.hospital.service.DoctorService;
import com.hospital.service_impl.DoctorServiceImpl;

class TestDoctorService {

	static SessionFactory sessionFactory;
	static Session session;
	static DoctorService doctorService;

	@BeforeAll
	static void setUp() {
		sessionFactory = HibernateUtil.getSessionFactory();
		doctorService = new DoctorServiceImpl();
	}

	@Test
	public void testSaveDoctor() {
		Doctor doctor = new Doctor(104, "Ravi", "5am-9am", "Dentist", 89678, 3, 'A');
		assertTrue(doctorService.saveDoctor(doctor));
	}

/*	@Test
	public void testDoctorById() {
		Doctor doctor = doctorService.findDoctorById(101);
		assertNotNull(doctor);
		assertTrue(doctor.getDoctor_id() == 101);
	}
	
	
	@Test
	public void testGetAllDoctors() {
		List<Doctor> doctors = doctorService.getAllDoctors();
		assertTrue(doctors != null && !doctors.isEmpty());
	}
	
	
	 @Test
	 void testUpdateDoctorById() {
	 Doctor doctor = doctorService.findDoctorById(102);
	 assertTrue(doctorService.updateDoctorById(102, "Suppy", "5am-1pm", "Cardialogist", 5678987, 6));
	 
	 }
	
	/*
	@Test
	public void testDeleteDoctor() {
	Doctor doctor = doctorService.findDoctorById(101);
	assertTrue(doctorService.deleteDoctor(101));
	
	}
	*/
	
	
	@AfterAll
	static void tearDown() {
		sessionFactory.close();
	}

}
