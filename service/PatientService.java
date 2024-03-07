package com.hospital.service;

import java.util.List;

import com.hospital.entities.Appointment;
import com.hospital.entities.Patient;

public interface PatientService {

	Patient savePatient(Patient patient);

    Patient getPatientById(int patientId);

    List<Patient> getAllPatients();

    Patient updatePatient(int patientId, String newName, String newGender, int newAge, int newContact);

    void deletePatient(int patientId);
    
    
    
    
}
