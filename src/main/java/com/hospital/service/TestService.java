package com.hospital.service;

import java.util.List;

import com.hospital.entities.TestsInHospital;

public interface TestService {

	boolean saveTest(TestsInHospital testsInHospital);

	TestsInHospital getTestById(int id);

	List<TestsInHospital> getAllTests();

	boolean updateTest(int test_id, String testName, String results);

	boolean deleteTest(int id);
}
