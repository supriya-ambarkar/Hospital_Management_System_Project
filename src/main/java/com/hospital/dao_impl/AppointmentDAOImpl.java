package com.hospital.dao_impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate_util.HibernateUtil;
import com.hospital.dao.AppointmentDAO;
import com.hospital.entities.Appointment;
import com.hospital.entities.Doctor;
import com.hospital.entities.Patient;
import com.mysql.cj.Query;

public class AppointmentDAOImpl implements AppointmentDAO {

	// 1. save appointment

	@Override
	public boolean saveAppointment(Appointment appointment) {

		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(appointment);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}
		return false;
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
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}
		return null;
	}

	// 3. get all appointments

	@Override
	public List<Appointment> getAllAppointments() {
		List<Appointment> appointments = null;
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			appointments = session.createQuery("FROM Appointment", Appointment.class).getResultList();
			session.getTransaction().commit();
			System.out.println("Appointment details retrieved successfully.");
			return appointments;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);

		}
		return appointments;
	}

	// 6. get appointment by patient id
	/*
	 * @Override public List<Appointment> getAppointmentsByPatientId(int patientId)
	 * {
	 * 
	 * try (Session session = HibernateUtil.getSession()) {
	 * session.beginTransaction(); List<Appointment> appointments1 = session
	 * .createQuery("select d.name as doctorName, t.testName as testName " +
	 * "from Appointment a " + "join a.doctor d " + "left join a.tests t " +
	 * "order by a.appointmentDate desc") .list(); // LEFT JOIN is used to include
	 * appointments without tests
	 * 
	 * session.getTransaction().commit(); return appointments1; } catch
	 * (HibernateException e) { System.out.println(e); } catch (Exception e) {
	 * System.out.println(e); } return null; }
	 */

	@Override
	public List<Appointment> getAppointmentsByPatientId(int patientId) {

		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();

			// Create a native SQL query
			String sqlQuery = "SELECT * FROM Appointment WHERE patient_id = :patientId ORDER BY appointmentDate DESC";

			List<Appointment> appointments = session.createNativeQuery(sqlQuery, Appointment.class)
					.setParameter("patientId", patientId).getResultList();

			session.getTransaction().commit();

			return appointments;
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 7. get appointment by doctor id
	@Override
	public List<Appointment> getAppointmentsByDoctor(int doctorId) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSession()) {
			transaction = session.beginTransaction();

			String hqlQuery = "Select * from Appointment where doctor_id = :doctorId order by appointmentDate DESC";

			List<Appointment> appointments = session.createNativeQuery(hqlQuery, Appointment.class)
					.setParameter("doctorId", doctorId).getResultList();

			transaction.commit();
			return appointments;
		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// 4. update appointment
	@Override
	public boolean updateAppointment(int appointment_id, String appointmentDate, String reason, Doctor doctor,
			Patient patient) {
		Appointment existAppointment = null;
		// Doctor doctor2 = null;
		// Patient patient2 = null;

		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();

			existAppointment = session.load(Appointment.class, appointment_id);
			// update
			if (existAppointment != null) {

				existAppointment.setAppointmentDate(appointmentDate);
				existAppointment.setReason(reason);

				existAppointment.setDoctor(doctor);
				existAppointment.setPatient(patient);

				session.update(existAppointment);
				session.getTransaction().commit();
				System.out.println("Appointment with ID " + appointment_id + " updated successfully.");
				return true;
			} else {
				System.out.println("Appointment with ID " + appointment_id + " does not exist.");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);

		}
		return false;
	}

	// 5. delete

	@Override
	public boolean deleteAppointment(int appointmentId) {

		try (Session session = HibernateUtil.getSession()) {

			Appointment appointment = session.get(Appointment.class, appointmentId);

			session.beginTransaction();
			if (appointment != null) {
				appointment.setStatus('I');
				session.saveOrUpdate(appointment);
				session.getTransaction().commit();

				System.out.println("Appointment deleted successfully.");

				return true;
			}
		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);

		}
		return false;

	}

}
