package com.hospital.dao;

import java.util.List;

import com.hospital.entities.Appointment;
import com.hospital.entities.Doctor;
import com.hospital.entities.Patient;

public interface AppointmentDAO {

    Appointment saveAppointment(Appointment appointment);

    Appointment getAppointmentById(int appointmentId);

    List<Appointment> getAllAppointments();

    List<Appointment> getAppointmentsByPatientId(int patientId);

    List<Appointment> getAppointmentsByDoctor(int doctorId);

    void updateAppointment(Appointment appointment);

    void deleteAppointment(int appointmentId);
}
