package com.hospital.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.HibernateUtil.HibernateUtil;
import com.hospital.dao.OperationsDAO;
import com.hospital.entities.Operations;
import com.hospital.entities.Patient;

public class OperationsDAOImpl implements OperationsDAO {

	// 1. save
	@Override
	public Operations saveOperation(Operations Operations) {
		try (Session session = HibernateUtil.getSession()) {
			session.save(Operations);
			session.getTransaction().commit();
			return Operations;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
			return null;
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return null;
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
	public void updateOperation(Operations operations) {

		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.update(operations);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
	}

	// 5. delete
	@Override
	public void deleteOperation(int id) {

		try (Session session = HibernateUtil.getSession()) {
			// Get the patient by ID
			int admissionIdToDelete = 1; // admission ID to delete
			Operations admissionToDelete = session.get(Operations.class, admissionIdToDelete);

			// Check if patient exists before deleting
			if (admissionToDelete != null) {
				// Delete the patient
				session.delete(admissionToDelete);
				session.getTransaction().commit();
				System.out.println("Admision id  deleted successfully.");
			} else {
				System.out.println("Admisison with ID " + admissionIdToDelete + " does not exist.");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
	}
}
