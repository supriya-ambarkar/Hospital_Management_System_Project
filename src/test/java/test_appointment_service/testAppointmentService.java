package test_appointment_service;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.hospital.dao.AppointmentDAO;
import com.hospital.dao_impl.AppointmentDAOImpl;
import com.hospital.entities.Appointment;
import com.hospital.entities.Doctor;
import com.hospital.entities.Patient;
import com.hospital.service.AppointmentService;
import com.hospital.service_impl.AppointmentServiceImpl;

public class testAppointmentService {

	static SessionFactory factory;
	static Session session;
	AppointmentService appointmentService = new AppointmentServiceImpl();


	@Test
	public void testsaveAppointment() {
		Appointment testAppointment = new Appointment();
		
		int appointment_id = 101;
		String appointmentDate = "2023-9-9";
		String reason = "general checkup";
		char status = 'A';
		Doctor doctor = new Doctor(101,"Raj","2am-8pm","ENT",98765,3,'A');
		Patient patient = new Patient(101,"Sita","Female",23,123432);
		
		Appointment appointment = new Appointment(appointment_id, appointmentDate, reason, status, doctor, patient);
		
		boolean res = appointmentService.saveAppointment(appointment);
		assertTrue(res);
		
		//appointmentService.saveAppointment(testAppointment);
		//List<Appointment> appointments = appointmentService.getAllAppointments();
		//assertTrue(appointments.contains(testAppointment));
		//Appointment appointment = new Appointment(101, 101, 101, "2023-9-9", "fever");
		//assertEquals(testAppointment, appointmentDAO.saveAppointment(appointment));
	}
	

}
