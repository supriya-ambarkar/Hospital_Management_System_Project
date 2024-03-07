package com.hospital.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.HibernateUtil.HibernateUtil;
import com.hospital.dao.TestDAO;
import com.hospital.entities.Operations;
import com.hospital.entities.Test;

public class TestDAOImpl implements TestDAO {
	// 1. save
	@Override
	public Test saveTest(Test test) {

		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(test);
			session.getTransaction().commit();
			return test;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return null;
	}

	// 2. get by id
	@Override
	public Test getTestById(int id) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			Test test = session.get(Test.class, id);
			session.getTransaction().commit();
			System.out.println("Test details retrieved successfully.");
			return test;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return null;
	}

	// 3. get all
	@Override
	public List<Test> getAllTests() {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			List<Test> tests = session.createQuery("FROM Test", Test.class).getResultList();
			session.getTransaction().commit();
			System.out.println("All Tests retrieved successfully.");
			return tests;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return null;

	}

	// 4. update

	@Override
	public void updateTest(Test test) {

		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.update(test);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// 5. delete
	@Override
	public void deleteTest(int id) {

		try (Session session = HibernateUtil.getSession()) {
			// Get the patient by ID
			int testIdToDelete = 1; // test ID to delete
			Test testToDelete = session.get(Test.class, testIdToDelete);

			// Check if patient exists before deleting
			if (testToDelete != null) {
				// Delete the patient
				session.delete(testIdToDelete);
				session.getTransaction().commit();
				System.out.println("test id  deleted successfully.");
			} else {
				System.out.println("test with ID " + testIdToDelete + " does not exist.");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
	}

}
