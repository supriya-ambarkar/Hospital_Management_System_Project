package com.hospital.service_impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hospital.dao.PatientDAO;
import com.hospital.dao_impl.PatientDAOImpl;
import com.hospital.entities.Appointment;
import com.hospital.entities.Patient;
import com.hospital.service.PatientService;

public class PatientServiceImpl implements PatientService {

	PatientDAO patientDAO = new PatientDAOImpl();

	// creating new patient and saving
	@Override
	public boolean savePatient(Patient patient) {
		return patientDAO.savePatient(patient);
	}

	@Override
	public Patient getPatientById(int patientId) {
		return patientDAO.getPatientById(patientId);
	}

	@Override
	public List<Patient> getAllPatients() {
		return patientDAO.getAllPatients();
	}

	@Override
	public boolean updatePatient(int patient_id, String name, String gender, int age, int contact_no) {
		return patientDAO.updatePatient(patient_id, name, gender, age, contact_no);

	}

	@Override
	public boolean deletePatient(int patientId) {
		return patientDAO.deletePatient(patientId);

	}

}
