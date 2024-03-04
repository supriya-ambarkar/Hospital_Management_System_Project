package com.example.dao;

import java.util.List;

import com.example.entities.Appointment;
import com.example.entities.Doctor;
import com.example.entities.Patient;

public interface AppointmentDAO {

    void saveAppointment(Appointment appointment);

    Appointment getAppointmentById(int appointmentId);

    List<Appointment> getAllAppointments();

    List<Appointment> getAppointmentsByPatientId(int patientId);

    List<Appointment> getAppointmentsByDoctor(int doctorId);

    void updateAppointment(Appointment appointment);

    void deleteAppointment(int appointmentId);
}
