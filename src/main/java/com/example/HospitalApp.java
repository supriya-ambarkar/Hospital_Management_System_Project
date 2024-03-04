package com.example;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.dao.PatientDAO;
import com.example.daoImpl.PatientDAOImpl;
import com.example.entities.Patient;

import net.bytebuddy.agent.builder.AgentBuilder;

public class HospitalApp {
	public static void main(String[] args) {
		SessionFactory factory = null;
		System.out.println("***Welcome to Hospital Management System***");
		try {
			// Session factory for connecting to database
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			// session object for CRUD operations
			Session session = factory.openSession();

			// 1.Adding patients records in database

			Patient patient1 = new Patient(1, "Ram", "M", 20, 91923912);
			Patient patient2 = new Patient(2, "Sita", "F", 12, 78912340);

			PatientDAOImpl patientDAOImpl = new PatientDAOImpl(session);
			// 2.saving the patients records
			patientDAOImpl.savePatient(patient1);
			patientDAOImpl.savePatient(patient2);

			System.out.println("Patient Entity created successfully");
			System.out.println("Data Added successfully");
			System.out.println("**************************************");

			// 3.searching for patient by id
			System.out.println("Patient detail with given id : 1");
			System.out.println();

			Patient patientById = patientDAOImpl.getPatientById(1);
			System.out.println("Patient : " + patientById);
			System.out.println("**************************************");

			// 4.returning all patient details
			System.out.println("All patient details");
			List<Patient> patients = patientDAOImpl.getAllPatients();
			System.out.println("**************************************");

			// 5. find patient id and update
			int id = 1;
			String newName = "Supriya";
			int newAge = 22;
			String newGender = "F";
			int new_Contact = 8892344;

			Patient updatePatient = new Patient(newName, newGender, newAge, new_Contact);
			patientDAOImpl.updatePatient(id, newName, newGender, newAge, new_Contact);
			System.out.println("Updated the records successfully");

			// displaying the updated record
			Patient updatedPatient = patientDAOImpl.getPatientById(1);
			System.out.println("Updated Patient records by id 1 :" + updatedPatient);
			System.out.println("**************************************");

			// 6.removing the patient by id
			System.out.println("Removing one patient id : 2");

			patientDAOImpl.deletePatient(2);
			System.out.println("Patient record with id 2 is removed successfully");
			System.out.println("**************************************");

		} catch (HibernateException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			factory.close();
		}

	}
}
