package com.example.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.dao.DoctorDAO;
import com.example.entities.Doctor;

public class DoctorDAOImpl implements DoctorDAO {

	// using session object
	Session session;

	public DoctorDAOImpl(Session session) {
		this.session = session;
	}

	// 1. saving doctor details
	@Override
	public void saveDoctor(Doctor doctor) {
		try {
			session.beginTransaction();
			session.save(doctor);

			// commit
			session.getTransaction().commit();

			// clear the session
			session.clear();

		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
	}

	// 2. find all doctors
	@Override
	public List<Doctor> getAllDoctors() {

		List<Doctor> doctors = session.createQuery("from Doctor", Doctor.class).getResultList();
		System.out.println("Doctor details retrieved successfully.");
		return doctors;
	}

	// 3. find doctor by id
	@Override
	public Doctor findDoctorById(int id) {

		try {
			Doctor doctor = session.get(Doctor.class, id);
			return doctor;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is :" + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return null;
	}

	// 4. update doctor by id
	@Override
	public Doctor updateDoctorById(int id, String newName, String newSpecialization, int newContact,
			String newMedicines, int updateExperience) {

		Transaction transaction = session.beginTransaction();
		try {
			Doctor existDoctor = session.load(Doctor.class, id);

			// update
			if (existDoctor != null) {

				existDoctor.setName(newName);
				existDoctor.setExperience_yrs(updateExperience);
				existDoctor.setContact_no(newContact);
				existDoctor.setPrescribedMedicines(newMedicines);
				existDoctor.setSpecialization(newSpecialization);

				session.beginTransaction();

				session.save(existDoctor);
				session.getTransaction().commit();

				System.out.println("Doctor with ID " + id + " updated successfully.");
			} else {
				System.out.println("Doctor with ID " + id + " does not exist.");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is :" + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return null;
	}

	// 5. remove doctor by id
	@Override
	public void deleteDoctor(int id) {

		try {
			Doctor doctor = session.get(Doctor.class, id);
			session.beginTransaction();
			if (doctor != null) {
				session.delete(doctor);
			} else {
				System.out.println("Doctor details not found");
			}
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is :" + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
	}
}
