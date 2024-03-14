package com.hospital.dao_impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate_util.HibernateUtil;
import com.hospital.dao.PatientDAO;
import com.hospital.entities.Patient;

public class PatientDAOImpl implements PatientDAO {
	// 1. save patient details
	@Override
	public boolean savePatient(Patient patient) {
		// Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(patient);
			// commit
			session.getTransaction().commit();
			System.out.println("Patient details saved successfully.");
			return true;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception : " + e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
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
			patients = session.createQuery("FROM Patient", Patient.class).getResultList();
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
	public boolean updatePatient(int patient_id, String name, String gender, int age, int contact_no) {
		Patient patient = null;
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			// Retrieve the patient by ID
			patient = session.load(Patient.class, patient_id);

			// Check if patient exists
			if (patient != null) {
				// Modify patient attributes
				patient.setName(name);
				patient.setGender(gender);
				patient.setAge(age);
				patient.setContact_no(contact_no);
			

				// Update the patient
				session.update(patient);
				session.getTransaction().commit();
				System.out.println("Patient with ID " + patient_id + " updated successfully.");
				return true;
			} else {
				System.out.println("Patient with ID " + patient_id + " does not exist.");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return false;
	}

	// 5. delete the patient
	@Override
	public boolean deletePatient(int patientid) {
		try (Session session = HibernateUtil.getSession()) {

			Patient patient = session.get(Patient.class, patientid);
			session.beginTransaction();
			// Check if patient exists before deleting
			if (patient != null) {
				// Delete the patient
				patient.setStatus('I');
				session.saveOrUpdate(patient);
				session.getTransaction().commit();
				System.out.println("Patient deleted successfully.");
				return true;
			} else {
				System.out.println("Patient with ID " + patientid + " does not exist.");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return false;
	}
}
