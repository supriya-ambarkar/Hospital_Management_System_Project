package com.hospital.serviceImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hospital.dao.PatientDAO;
import com.hospital.daoImpl.PatientDAOImpl;
import com.hospital.entities.Appointment;
import com.hospital.entities.Patient;
import com.hospital.service.PatientService;

public class PatientServiceImpl implements PatientService {

	PatientDAO patientDAO = new PatientDAOImpl();

	// creating new patient and saving
	@Override
	public Patient savePatient(Patient patient) {
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
	public Patient updatePatient(int patientId, String newName, String newGender, int newAge, int newContact) {
		return patientDAO.updatePatient(patientId, newName, newGender, newAge, newContact);

	}

	@Override
	public void deletePatient(int patientId) {
		patientDAO.deletePatient(patientId);

	}

}
