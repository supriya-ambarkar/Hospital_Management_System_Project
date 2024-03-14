package com.hospital.dao;

import java.util.List;

import com.hospital.entities.Operations;
import com.hospital.entities.Patient;

public interface PatientDAO {

	boolean savePatient(Patient patient);

	Patient getPatientById(int patientId);

	List<Patient> getAllPatients();

	boolean updatePatient(int patient_id, String name, String gender, int age, int contact_no);

	boolean deletePatient(int patientId);

}
