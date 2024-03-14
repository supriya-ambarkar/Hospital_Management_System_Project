package com.hospital.service_impl;

import java.util.List;

import javax.persistence.OrderBy;

import com.hospital.dao.AppointmentDAO;
import com.hospital.dao_impl.AppointmentDAOImpl;
import com.hospital.entities.Appointment;
import com.hospital.entities.Doctor;
import com.hospital.entities.Patient;
import com.hospital.service.AppointmentService;

public class AppointmentServiceImpl implements AppointmentService {
	AppointmentDAO appointmentDAO = new AppointmentDAOImpl();

	@Override
	public boolean saveAppointment(Appointment appointment) {
		return appointmentDAO.saveAppointment(appointment);
	}

	@Override
	public Appointment getAppointmentById(int appointmentId) {
		return appointmentDAO.getAppointmentById(appointmentId);
	}

	@Override
	public List<Appointment> getAllAppointments() {
		return appointmentDAO.getAllAppointments();
	}

	@Override
	public List<Appointment> getAppointmentsByPatientId(int patientId) {
		return appointmentDAO.getAppointmentsByPatientId(patientId);
	}

	@Override
	public List<Appointment> getAppointmentsByDoctor(int doctorId) {
		return appointmentDAO.getAppointmentsByDoctor(doctorId);
	}

	@Override
	public boolean updateAppointment(int appointment_id, String appointmentDate, String reason, Doctor doctor,
			Patient patient) {
		return appointmentDAO.updateAppointment(appointment_id, appointmentDate, reason, doctor, patient);
	}

	@Override
	public boolean deleteAppointment(int appointmentId) {
		return appointmentDAO.deleteAppointment(appointmentId);
	}
}