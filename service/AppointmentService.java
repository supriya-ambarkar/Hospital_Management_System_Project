package com.hospital.service;

import java.sql.Date;
import java.util.List;

import com.hospital.entities.Appointment;

public interface AppointmentService {

	Appointment saveAppointment(Appointment appointment);

	Appointment getAppointmentById(int appointmentId);

	List<Appointment> getAllAppointments();

	List<Appointment> getAppointmentsByPatientId(int patientId);

	List<Appointment> getAppointmentsByDoctor(int doctorId);

	void updateAppointment(Appointment appointment);

	void deleteAppointment(int appointmentId);
}
