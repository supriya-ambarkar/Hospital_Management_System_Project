package com.example.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.dao.AppointmentDAO;
import com.example.entities.Appointment;
import com.example.entities.Doctor;
import com.example.entities.Patient;

public class AppointmentDAOImpl implements AppointmentDAO {
	Session session;

	public AppointmentDAOImpl(Session session) {
		this.session = session;
	}

	// 1. save appointment

	@Override
	public void saveAppointment(Appointment appointment) {

		try {
			session.beginTransaction();
			session.save(appointment);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		}
	}

	// 2. find appointment by id
	@Override
	public Appointment getAppointmentById(int appointmentId) {

		try {
			session.beginTransaction();
			Appointment appointment = session.get(Appointment.class, appointmentId);
			session.getTransaction().commit();
			return appointment;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
			return null;
		}
	}

	// 3. get all appointments

	@Override
	public List<Appointment> getAllAppointments() {

		try {
			List<Appointment> appointments = session.createQuery("FROM Appointment", Appointment.class).getResultList();
			System.out.println("Appointment details retrieved successfully.");
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);

		}
		return null;
	}

	// 4. update appointment
	@Override
	public void updateAppointment(Appointment appointment) {

		try {
			session.beginTransaction();
			session.update(appointment);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);

		}
	}

	// 5. delete

	@Override
	public void deleteAppointment(int appointmentId) {

		Transaction transaction = session.beginTransaction();
		try {
			// Get the patient by ID
			int appointmentIdToDelete = 1; // patient ID to delete
			Appointment appointmentToDelete = session.get(Appointment.class, appointmentIdToDelete);

			// Check if patient exists before deleting
			if (appointmentToDelete != null) {
				// Delete the patient
				session.delete(appointmentToDelete);
				transaction.commit();
				System.out.println("Appointment deleted successfully.");
			} else {
				System.out.println("Appointment with ID " + appointmentIdToDelete + " does not exist.");
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

	// 6. get appointment by patient id
	@Override
	public List<Appointment> getAppointmentsByPatientId(int patientId) {

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			List<Appointment> appointments = session
					.createQuery("from Appointment a where a.patient.patientId = :patientId")
					.setParameter("patientId", patientId).list();

			transaction.commit();
			return appointments;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		} finally {

			session.close();

		}
	}

	// 7. get appointment by doctor id
	@Override
	public List<Appointment> getAppointmentsByDoctor(int doctorId) {
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			List<Appointment> appointments = session
					.createQuery("from Appointment a where a.doctor.doctorId = :doctorId")
					.setParameter("doctorId", doctorId).list();

			transaction.commit();
			return appointments;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		} finally {

			session.close();

		}
	}
}