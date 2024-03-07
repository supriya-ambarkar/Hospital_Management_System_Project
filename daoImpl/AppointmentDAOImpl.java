package com.hospital.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.HibernateUtil.HibernateUtil;
import com.hospital.dao.AppointmentDAO;
import com.hospital.entities.Appointment;
import com.hospital.entities.Doctor;
import com.hospital.entities.Patient;

public class AppointmentDAOImpl implements AppointmentDAO {
	// 1. save appointment

	@Override
	public Appointment saveAppointment(Appointment appointment) {

		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(appointment);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return appointment;
	}

	// 2. find appointment by id
	@Override
	public Appointment getAppointmentById(int appointmentId) {

		try (Session session = HibernateUtil.getSession()) {
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

		try (Session session = HibernateUtil.getSession()) {
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

		try (Session session = HibernateUtil.getSession()) {
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

		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			// Get the patient by ID
			int appointmentIdToDelete = 1; // patient ID to delete
			Appointment appointmentToDelete = session.get(Appointment.class, appointmentIdToDelete);

			// Check if patient exists before deleting
			if (appointmentToDelete != null) {
				// Delete the patient
				session.delete(appointmentToDelete);
				session.getTransaction().commit();
				System.out.println("Appointment deleted successfully.");
			} else {
				System.out.println("Appointment with ID " + appointmentIdToDelete + " does not exist.");
			}
		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);

		}

	}

	// 6. get appointment by patient id
	@Override
	public List<Appointment> getAppointmentsByPatientId(int patientId) {

		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();

			/*
			 * List<Appointment> appointments = session
			 * .createQuery("from Appointment a where a.patient.patientId = :patientId")
			 * .setParameter("patientId", patientId).list();
			 */
			List<Appointment> appointments = session
					.createQuery("select d.name as doctorName, t.testName as testName " + "from Appointment a "
							+ "join a.doctor d " + "left join a.tests t " + "order by a.appointmentDate desc")
					.list();
// LEFT JOIN is used to include appointments without tests

			session.getTransaction().commit();
			return appointments;
		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// 7. get appointment by doctor id
	@Override
	public List<Appointment> getAppointmentsByDoctor(int doctorId) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSession()) {
			transaction = session.beginTransaction();

			List<Appointment> appointments = session
					.createQuery("from Appointment a where a.doctor.doctorId = :doctorId")
					.setParameter("doctorId", doctorId).list();

			transaction.commit();
			return appointments;
		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}