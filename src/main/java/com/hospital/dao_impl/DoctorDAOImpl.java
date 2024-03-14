package com.hospital.dao_impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate_util.HibernateUtil;
import com.hospital.dao.DoctorDAO;
import com.hospital.entities.Doctor;

public class DoctorDAOImpl implements DoctorDAO {

	// 1. saving doctor details
	@Override
	public boolean saveDoctor(Doctor doctor) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(doctor);
			session.getTransaction().commit();
			// commit
			session.close();
			return true;

		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return false;
	}

	// 2. find all doctors
	@Override
	public List<Doctor> getAllDoctors() {
		try (Session session = HibernateUtil.getSession()) {
			List<Doctor> doctors = session.createQuery("from Doctor", Doctor.class).getResultList();
			System.out.println("Doctor details retrieved successfully.");
			return doctors;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// 3. find doctor by id
	@Override
	public Doctor findDoctorById(int id) {

		try (Session session = HibernateUtil.getSession()) {
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
	public boolean updateDoctorById(int doctor_id, String name, String working_hours, String specialization,
			int contact_no, int experience_yrs) {

		try (Session session = HibernateUtil.getSession()) {
			Doctor existDoctor = session.load(Doctor.class, doctor_id);

			// update
			if (existDoctor != null) {

				existDoctor.setName(name);
				existDoctor.setWorking_hours(working_hours);
				existDoctor.setSpecialization(specialization);
				existDoctor.setContact_no(contact_no);
				existDoctor.setExperience_yrs(experience_yrs);

				session.beginTransaction();

				session.update(existDoctor);
				session.getTransaction().commit();

				System.out.println("Doctor with ID " + doctor_id + " updated successfully.");

				return true;
			} else {
				System.out.println("Doctor with ID " + doctor_id + " does not exist.");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is :" + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return false;
	}

	// 5. remove doctor by id
	@Override
	public boolean deleteDoctor(int doctorId) {

		try (Session session = HibernateUtil.getSession()) {
			Doctor doctor = session.get(Doctor.class, doctorId);

			session.beginTransaction();
			if (doctor != null) {
				doctor.setStatus('I');
				session.saveOrUpdate(doctor);
				session.getTransaction().commit();
				System.out.println("Doctor deleted successfully.");
				return true;
			} else {
				System.out.println("Doctor details not found");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is :" + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return false;
	}
}
