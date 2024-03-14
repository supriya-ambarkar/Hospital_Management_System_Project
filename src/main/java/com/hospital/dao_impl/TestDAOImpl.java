package com.hospital.dao_impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate_util.HibernateUtil;
import com.hospital.dao.TestDAO;
import com.hospital.entities.Operations;
import com.hospital.entities.Test;

public class TestDAOImpl implements TestDAO {
	// 1. save
	@Override
	public boolean saveTest(Test test) {

		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(test);
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
		List<Test> tests = null;
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			tests = session.createQuery("FROM Test", Test.class).getResultList();
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
	public boolean updateTest(int test_id, String testName, String results) {

		try (Session session = HibernateUtil.getSession()) {
			Test test = session.load(Test.class, test_id);
			session.beginTransaction();

			if (test != null) {
				test.setTestName(testName);
				test.setResults(results);

				session.update(test);
				session.getTransaction().commit();
				System.out.println("Test with ID " + test_id + " updated successfully.");
				return true;
			} else {
				System.out.println("Test with ID " + test_id + " does not exist.");
			}

		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	// 5. delete
	@Override
	public boolean deleteTest(int id) {

		try (Session session = HibernateUtil.getSession()) {
			
			Test test = session.get(Test.class, id);
			session.beginTransaction();
			// Check if patient exists before deleting
			if (test != null) {
				// Delete the patient
				test.setStatus('I');
				session.saveOrUpdate(test);
				session.getTransaction().commit();
				System.out.println("test id "+ id+ " deleted successfully.");
				return true;
			} else {
				System.out.println("test with ID " + id + " does not exist.");
			}
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return false;
	}

}
