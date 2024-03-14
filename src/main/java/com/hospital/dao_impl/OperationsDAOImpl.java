package com.hospital.dao_impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate_util.HibernateUtil;
import com.hospital.dao.OperationsDAO;
import com.hospital.entities.Doctor;
import com.hospital.entities.Operations;
import com.hospital.entities.Patient;

public class OperationsDAOImpl implements OperationsDAO {

	// 1. save
	@Override
	public boolean saveOperation(Operations Operations) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(Operations);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);

		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return false;
	}

	// 2. get by id
	@Override
	public Operations getOperationById(int id) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			Operations operations = session.get(Operations.class, id);
			session.getTransaction().commit();
			System.out.println("Operations details retrieved successfully.");
			return operations;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
			return null;
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return null;
	}

	// 3. get all
	@Override
	public List<Operations> getAllOperations() {

		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			List<Operations> operations2 = session.createQuery("FROM Operations", Operations.class).getResultList();
			session.getTransaction().commit();
			System.out.println("All Operations retrieved successfully.");
			return operations2;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
			return null;
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return null;

	}

	// 4. update

	@Override
	public boolean updateOperation(int admission_id, int alloted_room, String admission_reason, String discharge_date) {
		Operations existOperations = null;
		try (Session session = HibernateUtil.getSession()) {
			existOperations = session.load(Operations.class, admission_id);

			// update
			if (existOperations != null) {
				
				existOperations.setAlloted_room(alloted_room);
				existOperations.setAdmission_reason(admission_reason);
				existOperations.setDischarge_date(discharge_date);

				session.beginTransaction();
				session.save(existOperations);
				session.getTransaction().commit();
				System.out.println("Admission with ID " + admission_id + " updated successfully.");
				return true;
			} else {
				System.out.println("Admission with ID " + admission_id + " does not exist.");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return false;
	}

	// 5. delete
	@Override
	public boolean deleteOperation(int id) {

		try (Session session = HibernateUtil.getSession()) {
			// Get the patient by ID
			
			Operations operations = session.get(Operations.class, id);
			session.beginTransaction();

			// Check if patient exists before deleting
			if (operations != null) {
				// Delete the patient
				operations.setStatus('I');
				session.saveOrUpdate(operations);
				session.getTransaction().commit();
				System.out.println("Admision id  deleted successfully.");
				return true;
			} else {
				System.out.println("Admisison with ID " + id + " does not exist.");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return false;
	}
}
