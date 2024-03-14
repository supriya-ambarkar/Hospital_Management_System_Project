package test_operations_service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hibernate_util.HibernateUtil;
import com.hospital.entities.Operations;
import com.hospital.entities.Patient;
import com.hospital.service.OperationsService;
import com.hospital.service.PatientService;
import com.hospital.service_impl.OperationsServiceImpl;
import com.hospital.service_impl.PatientServiceImpl;

class TestOperationsService {
	static SessionFactory sessionFactory;
	static Session session;
	static OperationsService operationsService;
	static PatientService patientService;
	
	@BeforeAll
	static void setUp() {
		sessionFactory = HibernateUtil.getSessionFactory();
		operationsService = new OperationsServiceImpl();
		patientService = new PatientServiceImpl();
	}

	/*
	@Test
	void testSaveOperation() {
		Patient patient = patientService.getPatientById(101);
		Operations operations = new Operations(1, "2024-1-1", 2, "dehydration", "2024-1-10",patient , 'A');
		assertTrue(operationsService.saveOperation(operations));
	}
	
	
	@Test
	void testGetOperationById() {
		Operations operations = operationsService.getOperationById(1);
		assertNotNull(operations);
		assertTrue(operations.getAdmission_id() == 1);
	}
	
	
	@Test
	void testGetAllOperations() {
		List<Operations> operations = operationsService.getAllOperations();
		assertTrue(operations != null && !operations.isEmpty());
	}
	
	
	
	@Test
	void testUpdateOperation() {
		Operations operations = operationsService.getOperationById(1);
		assertTrue(operationsService.updateOperation(1, 10, "high bp", "2024-1-9"));
	}
	*/
	
	@Test
	void testDeleteOperation() {
		Operations operations = operationsService.getOperationById(1);
		assertTrue(operationsService.deleteOperation(1));
	}
	
	@AfterAll
	static void tearDown() {
		sessionFactory.close();
	}
}
