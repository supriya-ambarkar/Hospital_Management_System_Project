package com.hospital.dao;

import java.util.List;

import com.hospital.entities.Appointment;
import com.hospital.entities.Doctor;
import com.hospital.entities.Patient;

public interface AppointmentDAO {

	boolean saveAppointment(Appointment appointment);

	Appointment getAppointmentById(int appointmentId);

	List<Appointment> getAllAppointments();

	List<Appointment> getAppointmentsByPatientId(int patientId);

	List<Appointment> getAppointmentsByDoctor(int doctorId);

	boolean updateAppointment(int appointment_id, String appointmentDate, String reason, Doctor doctor, Patient patient);

	boolean deleteAppointment(int appointmentId);

}
