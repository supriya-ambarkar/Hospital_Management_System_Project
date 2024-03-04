package com.example.dao;

import java.util.List;

import com.example.entities.Patient;

public interface PatientDAO {

    void savePatient(Patient patient);

    Patient getPatientById(int patientId);

    List<Patient> getAllPatients();

    Patient updatePatient(int patientId, String newName, String newGender, int newAge, int newContact);

    void deletePatient(int patientId);

}