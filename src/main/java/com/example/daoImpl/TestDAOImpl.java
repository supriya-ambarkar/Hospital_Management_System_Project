package com.example.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.dao.TestDAO;
import com.example.entities.Operations;
import com.example.entities.Test;

public class TestDAOImpl implements TestDAO {
	Session session;

	public TestDAOImpl(Session session) {
		this.session = session;
	}

	// 1. save
	@Override
	public Test saveTest(Test test) {

		session.beginTransaction();
		try {
			session.save(test);
			session.getTransaction().commit();
			return test;
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
	public Test getTestById(int id) {

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Test test = session.get(Test.class, id);
			transaction.commit();
			System.out.println("Test details retrieved successfully.");
			return test;
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
	public List<Test> getAllTests() {

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List<Test> tests = session.createQuery("FROM Test", Test.class).getResultList();
			transaction.commit();
			System.out.println("All Tests retrieved successfully.");
			return tests;
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
	public void updateTest(Test test) {

		try {
			session.beginTransaction();
			session.update(test);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		}
	}

	// 5. delete
	@Override
	public void deleteTest(int id) {

		Transaction transaction = session.beginTransaction();
		try {
			// Get the patient by ID
			int testIdToDelete = 1; // test ID to delete
			Test testToDelete = session.get(Test.class, testIdToDelete);

			// Check if patient exists before deleting
			if (testToDelete != null) {
				// Delete the patient
				session.delete(testIdToDelete);
				transaction.commit();
				System.out.println("test id  deleted successfully.");
			} else {
				System.out.println("test with ID " + testIdToDelete + " does not exist.");
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
