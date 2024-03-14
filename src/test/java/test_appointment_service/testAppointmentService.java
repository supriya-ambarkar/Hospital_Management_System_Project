package test_appointment_service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hibernate_util.HibernateUtil;
import com.hospital.entities.Appointment;
import com.hospital.entities.Doctor;
import com.hospital.entities.Patient;
import com.hospital.service.AppointmentService;
import com.hospital.service.DoctorService;
import com.hospital.service.PatientService;
import com.hospital.service_impl.AppointmentServiceImpl;
import com.hospital.service_impl.DoctorServiceImpl;
import com.hospital.service_impl.PatientServiceImpl;

public class testAppointmentService {

	static SessionFactory sessionFactory;

	static AppointmentService appointmentService;
	static PatientService patientService;
	static DoctorService doctorService;

	@BeforeClass
	public static void setUp() {
		sessionFactory = HibernateUtil.getSessionFactory();

		appointmentService = new AppointmentServiceImpl();
		patientService = new PatientServiceImpl();
		doctorService = new DoctorServiceImpl();
	}

	/*	@Test
	public void testSaveAppointment() {
		Patient patient = patientService.getPatientById(101);
		Doctor doctor = doctorService.findDoctorById(102);

		Appointment appointment = new Appointment(11, "2023-8-8", "fever", 'A', doctor, patient);
		assertTrue(appointmentService.saveAppointment(appointment));
	}
*/

/*	@Test 
	public void testGetAppointmentById() {
		Appointment appointment = appointmentService.getAppointmentById(1);
		assertNotNull(appointment);
		assertTrue(appointment.getAppointment_id() == 1);
	}
	
	*/
	/*	@Test
	public void testGetAllAppointments() {
		List<Appointment> appointments = appointmentService.getAllAppointments();
		assertNotNull(appointments);
	}
*/
	
/*	@Test
	public void testGetAppointmentsByPatientId() {
		List<Appointment> appointment = appointmentService.getAppointmentsByPatientId(101);
		assertNotNull(appointment);
	}
	*/
	
/*	@Test
	public void testGetAppointmentsByDoctor() {
		List<Appointment> appointments = appointmentService.getAppointmentsByDoctor(101);
		assertNotNull(appointments);
	}
	
	*/
	
/*	@Test
	public void testUpdateAppointment() {
		Doctor doctor = doctorService.findDoctorById(101);
		Patient patient = patientService.getPatientById(101);
		boolean appointment = appointmentService.updateAppointment(1, "2023-9-9", "diahera", doctor, patient);
		assertTrue(appointment);
	}
*/
	
	@Test
	public void testDeleteAppointment() {
		boolean appointment = appointmentService.deleteAppointment(1);
		assertTrue(appointment);
	}
	
	
	@AfterClass
	public static void tearDown() {
		sessionFactory.close();
	}
}
