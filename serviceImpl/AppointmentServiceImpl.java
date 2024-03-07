package com.hospital.serviceImpl;

import java.util.List;

import javax.persistence.OrderBy;

import com.hospital.dao.AppointmentDAO;
import com.hospital.daoImpl.AppointmentDAOImpl;
import com.hospital.entities.Appointment;
import com.hospital.service.AppointmentService;

public class AppointmentServiceImpl implements AppointmentService {
	AppointmentDAO appointmentDAO = new AppointmentDAOImpl();

	@Override
	public Appointment saveAppointment(Appointment appointment) {
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
	public void updateAppointment(Appointment appointment) {
		appointmentDAO.updateAppointment(appointment);
	}
	
	@Override 
	public void deleteAppointment(int appointmentId) {
		appointmentDAO.deleteAppointment(appointmentId);
	}
}