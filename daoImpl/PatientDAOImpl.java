package com.hospital.daoImpl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.HibernateUtil.HibernateUtil;
import com.hospital.dao.PatientDAO;
import com.hospital.entities.Patient;

public class PatientDAOImpl implements PatientDAO {
	// 1. save patient details
	@Override
	public Patient savePatient(Patient patient) {
		// Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(patient);
			// commit
			session.getTransaction().commit();
			System.out.println("Patient details saved successfully.");

		} catch (HibernateException e) {
			System.out.println("Hibernate Exception : " + e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return patient;
	}

	// 2. get patient by id
	@Override
	public Patient getPatientById(int patientId) {
		try (Session session = HibernateUtil.getSession()) {

			session.beginTransaction();
			Patient patient = session.get(Patient.class, patientId);
			session.getTransaction().commit();
			System.out.println("Patient details retrieved successfully.");
			return patient;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}

		return null;
	}

	// 3. get all patients
	@Override
	public List<Patient> getAllPatients() {
		List<Patient> patients = null;
		// Session session = sessionFactory.openSession();
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			List<Patient> patients2 = session.createQuery("FROM Patient", Patient.class).getResultList();
			session.getTransaction().commit();
			System.out.println("All patients retrieved successfully.");
			return patients;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}

		return null;

	}

	// 4. update patient
	@Override
	public Patient updatePatient(int patientId, String newName, String newGender, int newAge, int newContact) {
		
		try(Session session = HibernateUtil.getSession()) {
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
				session.getTransaction().commit();
				System.out.println("Patient with ID " + patientId + " updated successfully.");
			} else {
				System.out.println("Patient with ID " + patientId + " does not exist.");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return null;
	}

	// 5. delete the patient
	@Override
	public void deletePatient(int patientid) {
		try(Session session = HibernateUtil.getSession()) {
			// Get the patient by ID
			int patientIdToDelete = 1; // patient ID to delete
			Patient patientToDelete = session.get(Patient.class, patientIdToDelete);

			// Check if patient exists before deleting
			if (patientToDelete != null) {
				// Delete the patient
				session.delete(patientToDelete);
				session.getTransaction().commit();
				System.out.println("Patient deleted successfully.");
			} else {
				System.out.println("Patient with ID " + patientIdToDelete + " does not exist.");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
	}
}
