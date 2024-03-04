package com.example.daoImpl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.dao.PatientDAO;
import com.example.entities.Patient;

public class PatientDAOImpl implements PatientDAO {
	Session session;

	public PatientDAOImpl(Session session) {
		this.session = session;
	}

	// 1. save patient details
	@Override
	public void savePatient(Patient patient) {
		//Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			session.beginTransaction();
			session.save(patient);
			// commit
			session.getTransaction().commit();
			System.out.println("Patient details saved successfully.");

		} catch (HibernateException e) {
			System.out.println("Hibernate Exception : " + e);
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			// Close the session
			session.close();
		}
	}

	// 2. get patient by id
	@Override
	public Patient getPatientById(int patientId) {
		//Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {

			transaction = session.beginTransaction();
			Patient patient = session.get(Patient.class, patientId);
			transaction.commit();
			System.out.println("Patient details retrieved successfully.");
			return patient;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			// Close the session
			session.close();
		}
		return null;
	}

	// 3. get all patients
	@Override
	public  List<Patient> getAllPatients() {
		Transaction transaction = null;
		List<Patient> patients = null;
		//Session session = sessionFactory.openSession();
		try {
			transaction = session.beginTransaction();
			List<Patient> patients2 = session.createQuery("FROM Patient", Patient.class).getResultList();
			transaction.commit();
			System.out.println("All patients retrieved successfully.");
			return patients;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			// Close the session
			session.close();
		}
		return null;

	}

	// 4. update patient
	@Override
	public Patient updatePatient(int patientId, String newName, String newGender, int newAge, int newContact) {
		//Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			// Retrieve the patient by ID
			Patient patient = session.load(Patient.class, patientId);

			// Check if patient exists
			if (patient != null) {
				// Modify patient attributes
				patient.setName(newName);
				patient.setAge(newAge);
				patient.setGender(newGender);
				patient.setContact_no(newContact);

				// Update the patient
				session.update(patient);
				transaction.commit();
				System.out.println("Patient with ID " + patientId + " updated successfully.");
			} else {
				System.out.println("Patient with ID " + patientId + " does not exist.");
			}
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			// Close the session
			session.close();
		}
		return null;
	}

	// 5. delete the patient
	@Override
	public void deletePatient(int patientid) {
		//Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			// Get the patient by ID
			int patientIdToDelete = 1; // patient ID to delete
			Patient patientToDelete = session.get(Patient.class, patientIdToDelete);

			// Check if patient exists before deleting
			if (patientToDelete != null) {
				// Delete the patient
				session.delete(patientToDelete);
				transaction.commit();
				System.out.println("Patient deleted successfully.");
			} else {
				System.out.println("Patient with ID " + patientIdToDelete + " does not exist.");
			}
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			// Close the session
			session.close();
		}
	}
}
