package com.hospital.dao_impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate_util.HibernateUtil;
import com.hospital.dao.TestDAO;
import com.hospital.entities.Operations;
import com.hospital.entities.TestsInHospital;

public class TestDAOImpl implements TestDAO {
	// 1. save
	@Override
	public boolean saveTest(TestsInHospital testsInHospital) {

		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(testsInHospital);
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
	public TestsInHospital getTestById(int id) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			TestsInHospital testsInHospital = session.get(TestsInHospital.class, id);
			session.getTransaction().commit();
			System.out.println("Test details retrieved successfully.");
			return testsInHospital;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception is : " + e);
		} catch (Exception e) {
			System.out.println("Exception is : " + e);
		}
		return null;
	}

	// 3. get all
	@Override
	public List<TestsInHospital> getAllTests() {
		List<TestsInHospital> testsInHospitals = null;
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			testsInHospitals = session.createQuery("FROM TestsInHospital", TestsInHospital.class).getResultList();
			session.getTransaction().commit();
			System.out.println("All Tests retrieved successfully.");
			return testsInHospitals;
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
			TestsInHospital testsInHospital = session.load(TestsInHospital.class, test_id);
			session.beginTransaction();

			if (testsInHospital != null) {
				testsInHospital.setTestName(testName);
				testsInHospital.setResults(results);

				session.update(testsInHospital);
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
			
			TestsInHospital testsInHospital = session.get(TestsInHospital.class, id);
			session.beginTransaction();
			// Check if patient exists before deleting
			if (testsInHospital != null) {
				// Delete the patient
				testsInHospital.setStatus('I');
				session.saveOrUpdate(testsInHospital);
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
