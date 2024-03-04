package com.example.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.dao.OperationsDAO;
import com.example.entities.Operations;
import com.example.entities.Patient;

public class OperationsDAOImpl implements OperationsDAO {

	Session session;

	public OperationsDAOImpl(Session session) {
		this.session = session;
	}

	// 1. save
	@Override
	public Operations saveOperation(Operations Operations) {

		session.beginTransaction();
		try {
			session.save(Operations);
			session.getTransaction().commit();
			return Operations;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
			return null;
		} finally {
			// Close the session
			session.close();
		}
	}

	// 2. get by id
	@Override
	public Operations getOperationById(int id) {

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Operations operations = session.get(Operations.class, id);
			transaction.commit();
			System.out.println("Operations details retrieved successfully.");
			return operations;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
			return null;
		} finally {
			// Close the session
			session.close();
		}
	}

	// 3. get all
	@Override
	public List<Operations> getAllOperations() {

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List<Operations> operations2 = session.createQuery("FROM Operations", Operations.class).getResultList();
			transaction.commit();
			System.out.println("All Operations retrieved successfully.");
			return operations2;
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

	// 4. update

	@Override
	public void updateOperation(Operations operations) {

		try {
			session.beginTransaction();
			session.update(operations);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		}
	}

	// 5. delete
	@Override
	public void deleteOperation(int id) {

		Transaction transaction = session.beginTransaction();
		try {
			// Get the patient by ID
			int admissionIdToDelete = 1; // admission ID to delete
			Operations admissionToDelete = session.get(Operations.class, admissionIdToDelete);

			// Check if patient exists before deleting
			if (admissionToDelete != null) {
				// Delete the patient
				session.delete(admissionToDelete);
				transaction.commit();
				System.out.println("Admision id  deleted successfully.");
			} else {
				System.out.println("Admisison with ID " + admissionIdToDelete + " does not exist.");
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
